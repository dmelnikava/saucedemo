package com.saucedemo.cucumber.steps;

import com.qaprosoft.carina.core.foundation.cucumber.CucumberRunner;
import com.saucedemo.db.domain.Item;
import com.saucedemo.db.domain.User;
import com.saucedemo.db.service.UserService;
import com.saucedemo.db.service.impl.UserServiceImpl;
import com.saucedemo.gui.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SaucedemoUserSteps extends CucumberRunner {

    LoginPage loginPage = null;
    HomePage homePage = null;
    CartPage cartPage = null;
    CheckoutPage checkoutPage = null;
    OverviewPage overviewPage = null;
    CompletePage completePage = null;
    UserService userService = null;
    User user = null;

    @Given("^I am on the Saucedemo site Login page$")
    public void iAmOnTheSaucedemoSiteLoginPage() {
        loginPage = new LoginPage(getDriver());
        loginPage.open();
    }

    @When("^I login as a standard_user")
    public void iLoginAsAStandardUser() {
        userService = new UserServiceImpl();
        user = userService.read(1L, 1L);

        homePage = loginPage.enterUsername(user.getUsername())
                .enterPassword(user.getPassword())
                .clickLoginBtn();
    }

    @And("^I add standard_user items to the shopping cart on the Home page$")
    public void iAddStandardUserItemsToTheShoppingCartOnTheHomePage() {
        user.getOrders().stream()
                .flatMap(order -> order.getItems().stream())
                        .map(Item::getName)
                        .forEach(itemName -> homePage.clickAddToCartBtn(itemName));

        cartPage = homePage.clickShoppingCart();
    }

    @And("^I checkout added items on the Cart page$")
    public void iCheckoutAddedItemsOnTheCartPage() {
        checkoutPage = cartPage.clickCheckoutBtn();
    }

    @And("^I enter my personal information on the Checkout page$")
    public void iEnterMyPersonalInformationOnTheCheckoutPage() {
        overviewPage = checkoutPage.typeFirstname(user.getFirstName())
                .typeLastname(user.getLastName())
                .typePostalcode(user.getPostalCode())
                .clickContinueBtn();
    }

    @And("^I finish ordering items on the Overview page$")
    public void iFinishOrderingItemsOnTheOverviewPage() {
        completePage = overviewPage.clickContinueBtn();
    }

    @Then("^the Complete page should be displayed$")
    public void theCompletePageShouldBeDisplayed() {
        Assert.assertTrue(completePage.isPageOpened());
    }

    @And("the {string} message should be displayed")
    public void theMessageShouldBeDisplayed(String msg) {
        Assert.assertEquals(completePage.getCompleteMsg(), msg);
    }

    @When("^I login as a performance_glitch_user$")
    public void iLoginAsAPerformanceGlitchUser() {
        userService = new UserServiceImpl();
        user = userService.read(2L, 2L);

        homePage = loginPage.enterUsername(user.getUsername())
                .enterPassword(user.getPassword())
                .clickLoginBtn();
    }

    @And("^I add performance_glitch_user items to the shopping cart on the Home page$")
    public void iAddPerformanceGlitchUserItemsToTheShoppingCartOnTheHomePage() {
        user.getOrders().stream()
                .flatMap(order -> order.getItems().stream())
                .map(Item::getName)
                .forEach(itemName -> homePage.clickAddToCartBtn(itemName));

        cartPage = homePage.clickShoppingCart();
    }

    @And("^I remove all added items from the Cart page$")
    public void iRemoveAllAddedItemsFromTheCartPage() {
        cartPage.clickRemoveBtns();
    }

    @Then("^the Cart page doesn't contain any item$")
    public void theCartPageNotContainAnyItem() {
        Assert.assertTrue(cartPage.checkRemoveBtns());
    }
}
