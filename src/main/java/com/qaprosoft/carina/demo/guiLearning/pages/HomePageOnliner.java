//package com.qaprosoft.carina.demo.guiLearning.pages;
//
//import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
//import com.qaprosoft.carina.demo.gui.components.FooterMenu;
//import com.qaprosoft.carina.demo.gui.components.NewsItem;
//import com.qaprosoft.carina.demo.guiLearning.pages.components.SearchItem;
//import net.masterthought.cucumber.generators.AbstractPage;
//import org.apache.log4j.Logger;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.FindBy;
//
//
//import java.util.List;
//
//public class HomePageOnliner extends AbstractPage {
//    private static final Logger LOGGER = Logger.getLogger(HomePageOnliner.class);
//
//    @FindBy(xpath = "//*[text()='Вход']")
//    private ExtendedWebElement buttonEnter;
//
//    @FindBy(xpath = "//*[contains (text(), 'Барахолка')]")
//    private ExtendedWebElement baraholkaButton;
//
//    @FindBy(xpath = "//input[@name='query']")
//    private ExtendedWebElement searchingField;
//
//    @FindBy(xpath = "//*[@class='footer-style__social-button footer-style__social-button_tw']")
//    private ExtendedWebElement iconTwitter;
//
//    @FindBy(xpath = "//*[@class='footer-style__social-button footer-style__social-button_fb']")
//    private ExtendedWebElement iconFacebook;
//
//    @FindBy(xpath = "//*[@class='search__result']")
//    private List<SearchItem> items;
//
//
//    public HomePageOnliner(WebDriver driver) {
//        super(driver);
//    }
//
//    public List<SearchItem> searchItems(String q) {
//        searchingField.type(q);
//        searchingField.sendKeys(Keys.ENTER);
//        return items;
//    }
//
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
