package com.saucedemo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CompletePage extends AbstractPage {

    @FindBy(css = ".title")
    private ExtendedWebElement title;

    @FindBy(css = ".complete-header")
    private ExtendedWebElement completeMsg;

    public CompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return title.isPresent();
    }

    public String getCompleteMsg() {
        return completeMsg.getText();
    }
}