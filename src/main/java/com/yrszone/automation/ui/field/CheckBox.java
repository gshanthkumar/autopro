package com.yrszone.automation.ui.field;

import com.yrszone.automation.ui.exception.AutomationElementNotFoundException;
import com.yrszone.automation.ui.utilities.FindBy;
import com.yrszone.automation.ui.webdriver.UIWebDriver;

/**
 * contains  methods related to CheckBox Actions
 *
 */
public class CheckBox extends BaseElement{
    public CheckBox(final UIWebDriver webDriver, final FindBy findBy, final String findByValue){
        super(webDriver, findBy, findByValue);
    }

    public void click() throws AutomationElementNotFoundException{
        webDriver.click(findBy, findByValue.get());
    }

    public boolean isChecked() throws AutomationElementNotFoundException {
        return webDriver.isElementChecked(findBy, findByValue.get());
    }

    public void check() throws AutomationElementNotFoundException{
        webDriver.changeCheckBoxSelection(findBy, findByValue.get(), true);
    }

    public void uncheck() throws AutomationElementNotFoundException{
        webDriver.changeCheckBoxSelection(findBy, findByValue.get(), false);
    }

    @Override
    public CheckBox replaceSubStringOfFindByValue(String subStrToMatch, String subStrToReplaceWith) {
        replaceSubString(subStrToMatch, subStrToReplaceWith);
        return this;
    }      

}
