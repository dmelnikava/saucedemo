package com.saucedemo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage {

    @FindBy(id = "checkout")
    private ExtendedWebElement checkoutBtn;

    @FindBy(xpath = "//*[contains(@id, 'remove')]")
    private List<ExtendedWebElement> removeBtns;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage clickRemoveBtns() {
        removeBtns.forEach(ExtendedWebElement::click);
        return this;
    }

    public boolean checkRemoveBtns() {
        return removeBtns.isEmpty();
    }

    public CheckoutPage clickCheckoutBtn() {
        checkoutBtn.click();
        return new CheckoutPage(driver);
    }
}