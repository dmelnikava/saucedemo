package com.saucedemo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractPage {

    @FindBy(id = "first-name")
    private ExtendedWebElement firstnameInputField;

    @FindBy(id = "last-name")
    private ExtendedWebElement lastnameInputField;

    @FindBy(id = "postal-code")
    private ExtendedWebElement postalcodeInputField;

    @FindBy(id = "continue")
    private ExtendedWebElement continueBtn;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage typeFirstname(String firstname) {
        firstnameInputField.type(firstname);
        return this;
    }

    public CheckoutPage typeLastname(String lastname) {
        lastnameInputField.type(lastname);
        return this;
    }

    public CheckoutPage typePostalcode(String postalcard) {
        postalcodeInputField.type(postalcard);
        return this;
    }

    public OverviewPage clickContinueBtn() {
        continueBtn.click();
        return new OverviewPage(driver);
    }
}