package com.qaprosoft.carina.demo.regression.dataprovider;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;

import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;
//import com.qaprosoft.carina.demo.guiLearning.pages.HomePageOnliner;
//import com.qaprosoft.carina.demo.guiLearning.pages.components.SearchItem;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.List;

public class WebSampleTestOnliner extends AbstractTest {

    @Test
    @MethodOwner(owner = "tminchuk")
    public void testRegistrationWithValid() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        WebElement buttonEnter = getDriver().findElement(By.xpath("//*[text()='Вход']"));
        buttonEnter.click();

        WebElement buttonRegistration = getDriver().findElement(By.xpath("//*[contains (text(), 'Зарегистрироваться на Onliner')]"));
        buttonRegistration.click();

        WebElement emailField = getDriver().findElement(By.xpath("//input[@placeholder='Ваш e-mail']"));
        emailField.sendKeys("newqa111@gmail.com");

        WebElement passwordField = getDriver().findElement(By.xpath("//input[@placeholder='Придумайте пароль']"));
        passwordField.sendKeys("qwerty123");

        WebElement confirmPasswordField = getDriver().findElement(By.xpath("//input[@placeholder='Повторите пароль']"));
        confirmPasswordField.sendKeys("qwerty123");
//        System.out.println(buttonRegistration.getText());
    }


    @Test
    @MethodOwner(owner = "tminchuk")
    public void testAuthorizationWithValid() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        WebElement buttonEnter = getDriver().findElement(By.xpath("//*[text()='Вход']"));
        buttonEnter.click();

        WebElement emailField = getDriver().findElement(By.xpath("//input[@placeholder='Ник или e-mail']"));
        emailField.sendKeys("newqa111@gmail.com");

        WebElement passwordField = getDriver().findElement(By.xpath("//input[@placeholder='Пароль']"));
        passwordField.sendKeys("qwerty123");

        String title = getDriver().getTitle();
        Assert.assertEquals(title, "Профиль");

////        WebElement resultId = getDriver().findElement(By.xpath("//*[@class='profile-header__name']"));
//        WebElement resultId = getDriver().findElement(By.xpath("//*[contains(text(), '3252613')]"));
//
//        resultId.getText();


//        System.out.println("//////////// " + resultId.getText());

    }

    @Test
    @MethodOwner(owner = "tminchuk")
    public void testAuthorizationWithInValid() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        WebElement buttonEnter = getDriver().findElement(By.xpath("//*[text()='Вход']"));
        buttonEnter.click();

        WebElement emailField = getDriver().findElement(By.xpath("//input[@placeholder='Ник или e-mail']"));
        emailField.sendKeys("qwerty.com");

        WebElement passwordField = getDriver().findElement(By.xpath("//input[@placeholder='Пароль']"));
        passwordField.sendKeys("qwerty123");
    }

    @Test
    @MethodOwner(owner = "tminchuk")
    public void testPasswordRecovery() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        WebElement buttonEnter = getDriver().findElement(By.xpath("//*[text()='Вход']"));
        buttonEnter.click();

        WebElement remindPasswordButton = getDriver().findElement(By.xpath("//*[contains (text(), 'Я не помню пароль')]"));
        remindPasswordButton.click();

        WebElement emailField = getDriver().findElement(By.xpath("//input[@placeholder='Ник, e-mail или номер телефона']"));
        emailField.sendKeys("newqa111@gmail.com");

        String title = getDriver().getTitle();
        Assert.assertEquals(title, "Профиль");


//        WebElement checkEmail = getDriver().findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div/div[2]/div/div[1]/text()"));


    }

    @Test
    @MethodOwner(owner = "tminchuk")
    public void testSearching(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        WebElement searchingField = getDriver().findElement(By.xpath("//input[@name='query']"));
        searchingField.sendKeys("Redmond", Keys.ENTER);

        WebElement item = getDriver().findElement(By.xpath("//*[contains(text(), 'Робот-пылесос Redmond RV-R500')]"));
        Assert.assertEquals(item.getText(), "Робот-пылесос Redmond RV-R500");

//        final String searchQ = "Redmond";
//        List<SearchItem> items = HomePageOnliner.searchItems(searchQ);
//        Assert.assertFalse(CollectionUtils.isEmpty(items), "Items not found!");
//        for(SearchItem n : items) {
//            System.out.println(n.readTitle());
//            Assert.assertTrue(StringUtils.containsIgnoreCase(n.readTitle(), searchQ), "Invalid search results!");
//
    }

    @Test
    @MethodOwner(owner = "tminchuk")
    public void testFacebookLink(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        WebElement iconFacebook = getDriver().findElement(By.xpath("//*[@class='footer-style__social-button footer-style__social-button_fb']"));
        iconFacebook.click();

//        String title = getDriver().getTitle();
//        Assert.assertEquals(title, "Onliner - Home | Facebook");



    }

    @Test
    @MethodOwner(owner = "tminchuk")
    public void testTwitterLink(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        WebElement iconTwitter = getDriver().findElement(By.xpath("//*[@class='footer-style__social-button footer-style__social-button_tw']"));
        iconTwitter.click();

//        String title = getDriver().getTitle();
//        Assert.assertEquals(title, "Onliner (@OnlinerBY) / Twitter");

    }

    @Test
    @MethodOwner(owner = "tminchuk")
    public void testCreatingaAnAd(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        WebElement buttonEnter = getDriver().findElement(By.xpath("//*[text()='Вход']"));
        buttonEnter.click();

        WebElement emailField = getDriver().findElement(By.xpath("//input[@placeholder='Ник или e-mail']"));
        emailField.sendKeys("newqa111@gmail.com");

        WebElement passwordField = getDriver().findElement(By.xpath("//input[@placeholder='Пароль']"));
        passwordField.sendKeys("qwerty123", Keys.ENTER);

        WebElement baraholkaButton = getDriver().findElement(By.xpath("//*[contains (text(), 'Барахолка')]"));
        baraholkaButton.click();

        WebElement creatingAdButton = getDriver().findElement(By.xpath("//*[contains (text(), 'Разместить объявление')]"));
        creatingAdButton.click();

        WebElement nameField = getDriver().findElement(By.xpath("//input[@name='subject']"));
        nameField.sendKeys("Холодильник Samsung");

        WebElement descriptionFiels = getDriver().findElement(By.xpath("//*[@id='postmessage']"));
        descriptionFiels.sendKeys("Новый холодильник Samsung");

        WebElement addButton = getDriver().findElement(By.xpath("//*[contains (text(), 'Добавить объявление')]"));
        addButton.click();

    }




}
