package com.qaprosoft.carina.demo.guiLearning.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class YoutubePage extends AbstractPage {

    public YoutubePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.youtube.com/channel/UClUWvdPvq2Vj7MIkQ9XxVqA");
            }

    public String readTitle(){
        return driver.getTitle();
    }
}
