package com.yrszone.automation.ui.field;

import com.yrszone.automation.ui.exception.AutomationElementNotFoundException;
import com.yrszone.automation.ui.utilities.FindBy;
import com.yrszone.automation.ui.webdriver.UIWebDriver;
/**
 * contains  methods related to Selecting/Deselecting Multiple Items Actions
 *
 */
public class MultiSelectListBox extends ListBox{

    public MultiSelectListBox(final UIWebDriver webDriver, final FindBy findBy, final String findByValue){
        super(webDriver, findBy, findByValue);
    }

    public void click() throws AutomationElementNotFoundException{
        webDriver.click(findBy, findByValue.get());
    } 


    public void selectItems(final String[] items) throws AutomationElementNotFoundException {
        for (String comboValue : items) {
            selectItemByVisibleText(comboValue);
        }
    }

    public void deselectItem(final String item) throws AutomationElementNotFoundException {
        webDriver.deselectComboBoxItem(findBy, findByValue.get(), item);
    }

    public void deselectAllItems() throws AutomationElementNotFoundException {
        webDriver.deselectAllComboBoxItems(findBy, findByValue.get());
    }

    @Override
    public MultiSelectListBox replaceSubStringOfFindByValue(String subStrToMatch, String subStrToReplaceWith) {
        replaceSubString(subStrToMatch, subStrToReplaceWith);
        return this;
    } 
}

