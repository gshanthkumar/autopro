package com.yrszone.automation.ui.field;

import com.yrszone.automation.ui.exception.AutomationElementNotFoundException;
import com.yrszone.automation.ui.utilities.FindBy;
import com.yrszone.automation.ui.webdriver.UIWebDriver;

/**
 * contains  methods related to Button Actions
 *
 */
public class Button extends BaseElement{

    public Button(UIWebDriver webDriver, FindBy findBy, String findByValue) {
        super(webDriver, findBy, findByValue);
    }

    public void click() throws AutomationElementNotFoundException{
        webDriver.click(findBy, findByValue.get());
    }

    @Override
    public Button replaceSubStringOfFindByValue(String subStrToMatch, String subStrToReplaceWith) {
        replaceSubString(subStrToMatch, subStrToReplaceWith);
        return this;

    }
}
