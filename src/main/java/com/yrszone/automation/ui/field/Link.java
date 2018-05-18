package com.yrszone.automation.ui.field;

import com.yrszone.automation.ui.exception.AutomationElementNotFoundException;
import com.yrszone.automation.ui.utilities.FindBy;
import com.yrszone.automation.ui.webdriver.UIWebDriver;
/**
 * contains  methods related to Links of a web Page
 *
 */
public class Link extends BaseElement{
    public Link(final UIWebDriver webDriver, final FindBy findBy, final String findByValue){
        super(webDriver, findBy, findByValue);
    }

    public void click() throws AutomationElementNotFoundException{
        webDriver.click(findBy, findByValue.get());
    }  

    public String getHREF() throws AutomationElementNotFoundException{
        return getAttribute("href");
    }

    public String getName() throws AutomationElementNotFoundException{
        return getAttribute("name");
    }

    public String getOnClickScript() throws AutomationElementNotFoundException{
        return getAttribute("onclick");
    }
  

    @Override
    public Link replaceSubStringOfFindByValue(String subStrToMatch, String subStrToReplaceWith) {
        replaceSubString(subStrToMatch, subStrToReplaceWith);
        return this;

    }

}
