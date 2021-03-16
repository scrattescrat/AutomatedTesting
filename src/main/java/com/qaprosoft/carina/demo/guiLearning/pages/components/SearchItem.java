package com.qaprosoft.carina.demo.guiLearning.pages.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchItem extends AbstractUIObject {

    @FindBy(xpath = "//*[@class='product__title-link']")
    private ExtendedWebElement titleLink;


    public SearchItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String readTitle(){
        return titleLink.getElement().getText();
    }

//
//    @FindBy(xpath="./a")
//    public ExtendedWebElement titleLink;
//
//    private SearchItem(WebDriver webDriver, SearchContext sc) {
//        super(webDriver, sc);
//    }
//
//    public String readTitle() {
//        return titleLink.getElement().getText();
//    }
//
}
