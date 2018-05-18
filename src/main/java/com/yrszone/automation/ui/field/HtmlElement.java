package com.yrszone.automation.ui.field;


import com.yrszone.automation.ui.utilities.FindBy;
import com.yrszone.automation.ui.webdriver.UIWebDriver;

public class HtmlElement extends BaseElement{

    public HtmlElement(UIWebDriver webDriver, FindBy findBy, String findByValue) {
        super(webDriver, findBy, findByValue);
    }


    @Override
    public HtmlElement replaceSubStringOfFindByValue(String subStrToMatch, String subStrToReplaceWith) {
        replaceSubString(subStrToMatch, subStrToReplaceWith);
        return this;

    }
}