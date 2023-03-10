package com.saucedemo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends AbstractPage {

    @FindBy(id = "finish")
    private ExtendedWebElement finishBtn;

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public CompletePage clickContinueBtn() {
        finishBtn.click();
        return new CompletePage(driver);
    }
}
