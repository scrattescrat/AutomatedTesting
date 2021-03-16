package com.qaprosoft.carina.demo.guiLearning.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class ForumPage extends AbstractPage {

    public ForumPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://forum.onliner.by/");
    }


}
