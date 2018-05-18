package com.yrszone.automation.ui.field;

import com.yrszone.automation.ui.exception.AutomationElementNotFoundException;
import com.yrszone.automation.ui.utilities.FindBy;
import com.yrszone.automation.ui.webdriver.UIWebDriver;

/**
 * contains  methods related to Radio Button Actions
 *
 */
public class RadioButton extends BaseElement{
    public RadioButton(final UIWebDriver webDriver, final FindBy findBy, final String findByValue) {
        super(webDriver, findBy, findByValue);
    }

    public boolean isChecked() throws AutomationElementNotFoundException {
        return webDriver.isElementChecked(findBy, findByValue.get());
    }

    public void select() throws AutomationElementNotFoundException{
        webDriver.click(findBy, findByValue.get());

    }

    @Override
    public RadioButton replaceSubStringOfFindByValue(String subStrToMatch, String subStrToReplaceWith) {
        replaceSubString(subStrToMatch, subStrToReplaceWith);
        return this;
    }

}
