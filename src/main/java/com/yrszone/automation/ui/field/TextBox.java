package com.yrszone.automation.ui.field;

import com.yrszone.automation.ui.exception.AutomationElementNotFoundException;
import com.yrszone.automation.ui.utilities.FindBy;
import com.yrszone.automation.ui.webdriver.UIWebDriver;

/**
 * contains  methods related to TextBox Actions
 *
 */
public class TextBox extends BaseElement{
    public TextBox(final UIWebDriver webDriver, final FindBy findBy, final String findByValue){
        super(webDriver, findBy, findByValue);
    }
    public void typeText(final String text) throws AutomationElementNotFoundException{
        webDriver.typeText(findBy, findByValue.get(), text);
    }

    public void clear() throws AutomationElementNotFoundException{
        webDriver.clearText(findBy, findByValue.get());
    }

    public void click() throws AutomationElementNotFoundException{
        webDriver.click(findBy, findByValue.get());
    }


    @Override
    public TextBox replaceSubStringOfFindByValue(String subStrToMatch, String subStrToReplaceWith) {
        replaceSubString(subStrToMatch, subStrToReplaceWith);
        return this;

    }

}