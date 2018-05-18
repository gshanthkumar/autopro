package com.yrszone.automation.ui.testsetup;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yrszone.automation.ui.exception.AutomationDriverException;
import com.yrszone.automation.ui.exception.AutomationElementNotFoundException;
import com.yrszone.automation.ui.field.Button;
import com.yrszone.automation.ui.field.WebElements;
import com.yrszone.automation.ui.pageinitializer.BasePage;
import com.yrszone.automation.ui.utilities.FindElement;
import com.yrszone.automation.ui.webdriver.UIWebDriver;

@Component
public class TestPageClass extends BasePage{
    private Logger log = Logger.getLogger(TestPageClass.class);
    @Autowired
    public TestPageClass(UIWebDriver driver) throws AutomationDriverException {
        super(driver);

    }
    @FindElement(field="loginIcon", page="logon")
    private Button test;
    
    private Button test2;
    
    private WebElements<Button> testButton;
    
    public void test() throws AutomationElementNotFoundException, AutomationDriverException{
        log.info("Testing");
        driver.typeText(test.getFindBy(), test.getFindByValue(), "Text");
       test.click();
       
       
    }
}
