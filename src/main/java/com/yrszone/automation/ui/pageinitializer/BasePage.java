package com.yrszone.automation.ui.pageinitializer;

import com.yrszone.automation.ui.exception.AutomationDriverException;
import com.yrszone.automation.ui.webdriver.UIWebDriver;

/**
 *
 * All Page class should extend this base page class for initialization
 *
 */
public class BasePage {
    protected UIWebDriver driver;

    public BasePage(UIWebDriver driver) throws AutomationDriverException  {
        PageInitializer.initialize(this, driver);
        this.driver=driver;
    }



    public UIWebDriver getDriver() {
        return driver;
    }

    public void setDriver(UIWebDriver driver) {
        this.driver = driver;
    }
}
