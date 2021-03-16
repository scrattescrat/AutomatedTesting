package com.qaprosoft.carina.demo.guiLearning.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.guiLearning.pages.components.SearchItem;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class HomePageOnliner extends AbstractPage {
    private static final Logger LOGGER = Logger.getLogger(HomePageOnliner.class);

    @FindBy(xpath = "//*[text()='Вход']")
    private ExtendedWebElement buttonEnter;

    @FindBy(xpath = "//*[@class='b-top-profile__image js-header-user-avatar']")
    private ExtendedWebElement profileAvatar;

    @FindBy(xpath = "//*[contains(text(), 'Барахолка')]")
    private ExtendedWebElement baraholkaButton;

    @FindBy(xpath = "//input[@name='query']")
    private ExtendedWebElement searchingField;

    @FindBy(xpath = "//div[@class='result__item result__item_product']")
    private List<SearchItem> items;


    @FindBy(xpath = "//*[@class='footer-style__social-button footer-style__social-button_tw']")
    private ExtendedWebElement iconTwitter;

    @FindBy(xpath = "//*[@class='footer-style__social-button footer-style__social-button_fb']")
    private ExtendedWebElement iconFacebook;

    @FindBy(xpath = "//*[@class='footer-style__social-button footer-style__social-button_yt']")
    private ExtendedWebElement iconYoutube;

    @FindBy(xpath = "//a[contains(text(), 'Смартфон Apple iPhone 11 64GB (черный)')]")
    private ExtendedWebElement product;

    @FindBy(xpath = "//a[contains(text(), 'Форум')]")
    private ExtendedWebElement forumLink;

    public HomePageOnliner(WebDriver driver) {
        super(driver);
    }

    public List<SearchItem> searchItem(String item){
    searchingField.type(item);
    pause(1);
    return items;
    }

    public ForumPage clickForumLink(){
        forumLink.click();
        return new ForumPage(driver);
    }



    public TwitterPage clickLinkToTwitter() {
        iconTwitter.click();
        TwitterPage twitterPage = new TwitterPage(driver);

        for (String winHandle : getDriver().getWindowHandles()) {
            if (!winHandle.equals(twitterPage)) {
                getDriver().switchTo().window(winHandle);
            }
        }
            return twitterPage;
        }


    public FacebookPage clickLinkToFacebook() {
        iconFacebook.click();
        FacebookPage facebookPage = new FacebookPage(driver);
        for (String winHandle : getDriver().getWindowHandles()) {
            if (!winHandle.equals(facebookPage)) {
                getDriver().switchTo().window(winHandle);
            }
        }
        return facebookPage;
    }

    public YoutubePage clickLinkToYouTube() {
        iconYoutube.click();
        YoutubePage youtubePage = new YoutubePage(driver);
        for (String winHandle : getDriver().getWindowHandles()) {
            if (!winHandle.equals(youtubePage)) {
                getDriver().switchTo().window(winHandle);
            }
        }
        return youtubePage;
    }

    public AuthorizationPage openAuthorizationPage(){
        buttonEnter.click();
        return new AuthorizationPage(driver);
    }

    public ExtendedWebElement findProfileAvatar(){
        String profileAvatarClass = profileAvatar.getAttribute("class");
        driver.findElement(By.xpath("//*[@class='" + profileAvatarClass + "']"));
        return profileAvatar;
    }

    public HomePageOnliner searchItemByFullName(String fullNameItem){
        searchingField.type(fullNameItem);
        return new HomePageOnliner(driver);
    }

    public ProductPage openItemInfo(){
        product.click();
        return new ProductPage(driver);
    }




}







//    @Override
//    public String getWebPage() {
//        return null;
//    }
//
//    @Override
//    protected void prepareReport() {
//
//    }
//}
