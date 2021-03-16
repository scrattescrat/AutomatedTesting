package com.qaprosoft.carina.demo.guiLearning.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class FacebookPage extends AbstractPage {

    public FacebookPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.facebook.com/onlinerby");
    }

    public String readTitle(){
       return driver.getTitle();
    }
}
