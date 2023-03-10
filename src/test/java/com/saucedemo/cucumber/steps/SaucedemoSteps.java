package com.saucedemo.cucumber.steps;

import com.qaprosoft.carina.core.foundation.cucumber.CucumberRunner;
import com.saucedemo.db.domain.Item;
import com.saucedemo.db.domain.Order;
import com.saucedemo.db.domain.User;
import com.saucedemo.db.persistence.ConnectionPool;
import com.saucedemo.db.service.OrderService;
import com.saucedemo.db.service.UserService;
import com.saucedemo.db.service.impl.OrderServiceImpl;
import com.saucedemo.db.service.impl.UserServiceImpl;
import com.saucedemo.gui.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.sql.Connection;
import java.util.List;

public class SaucedemoSteps extends CucumberRunner {

    LoginPage loginPage = null;
    HomePage homePage = null;
    CartPage cartPage = null;
    CheckoutPage checkoutPage = null;
    OverviewPage overviewPage = null;
    CompletePage completePage = null;
    UserService userService = null;
    OrderService orderService = null;
    User user = null;
    List<Order> orders;
    Connection connection;

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    private static final Logger LOGGER = (Logger) LogManager.getLogger(SaucedemoSteps.class);

    @Given("^I am on the site Login page$")
    public void iAmOnTheSiteLoginPage() {
        loginPage = new LoginPage(getDriver());
        loginPage.open();
    }

    @When("^I login as a standard_user$")
    public void iLoginAsAStandard_user() {
        connection = CONNECTION_POOL.getConnection();

        userService = new UserServiceImpl();
        user = userService.read(1L);

        homePage = loginPage.enterUsername(user.getUsername())
                .enterPassword(user.getPassword())
                .clickLoginBtn();
    }

    @And("^I add needed items to the shopping cart on the Home page$")
    public void iAddNeededItemsToTheShoppingCartOnTheHomePage() {
        orderService = new OrderServiceImpl();

        orders = orderService.read(1L);
        user.setOrders(orders);
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
        CONNECTION_POOL.releaseConnection(connection);
    }
}
