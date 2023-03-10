package com.saucedemo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(css = ".shopping_cart_link")
    private ExtendedWebElement shoppingCart;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickAddToCartBtn(String itemName) {
        driver.findElement(By.xpath("//*[text()='" + itemName + "']/../../..//*[contains(@id, 'add-to-cart')]")).click();
        return this;
    }

    public CartPage clickShoppingCart() {
        shoppingCart.click();
        return new CartPage(driver);
    }
}