package com.qaprosoft.carina.demo.guiLearning.pages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.bouncycastle.jce.exception.ExtCertificateEncodingException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.Iterator;
import java.util.Set;

public class TwitterPage extends AbstractPage {

//    @FindBy(xpath="//*[contains(text(), 'Onliner (@OnlinerBY) / Twitter')]")
//    private ExtendedWebElement pageTitle;


    public TwitterPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://twitter.com/OnlinerBY");
    }

    public String readTitle(){
        return driver.getTitle();
    }






}
