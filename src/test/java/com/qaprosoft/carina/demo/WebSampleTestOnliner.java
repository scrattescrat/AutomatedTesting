package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.guiLearning.pages.*;
import com.qaprosoft.carina.demo.guiLearning.pages.components.SearchItem;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebSampleTestOnliner extends AbstractTest {

    @Test
    @MethodOwner(owner = "tminchuk")
    public void verifySearchItem(){
        HomePageOnliner homePageOnliner = new HomePageOnliner(getDriver());
        homePageOnliner.open();
        Assert.assertTrue(homePageOnliner.isPageOpened(), "Home Page is not opened!");

        final String item = "Redmond";
        List<SearchItem> items = homePageOnliner.searchItem(item);

        Assert.assertTrue(items.size()>0, "No items found");

    }

    @Test
    @MethodOwner(owner = "tminchuk")
    public void verifyForumLink(){
        HomePageOnliner homePageOnliner = new HomePageOnliner(getDriver());
        homePageOnliner.open();
        Assert.assertTrue(homePageOnliner.isPageOpened(), "Home Page is not opened!");

        ForumPage forumPage = homePageOnliner.clickForumLink();
        Assert.assertTrue(forumPage.isPageOpened(), "Forum Page is not opened!");

    }



    @Test
    @MethodOwner(owner = "tminchuk")
    public void verifyTwitterLink(){
        HomePageOnliner homePageOnliner = new HomePageOnliner(getDriver());
        homePageOnliner.open();
        Assert.assertTrue(homePageOnliner.isPageOpened(), "Home Page is not opened!");

        TwitterPage twitterPage = homePageOnliner.clickLinkToTwitter();
        Assert.assertTrue(twitterPage.isPageOpened(), "Twitter page is not opened");
        pause(2);

        String title = twitterPage.readTitle();
        Assert.assertEquals(title, "Onliner (@OnlinerBY) / Twitter");
    }

    @Test
    @MethodOwner(owner = "tminchuk")
    public void verifyFacebookLink(){
        HomePageOnliner homePageOnliner = new HomePageOnliner(getDriver());
        homePageOnliner.open();
        Assert.assertTrue(homePageOnliner.isPageOpened(), "Home Page is not opened!");

        FacebookPage facebookPage = homePageOnliner.clickLinkToFacebook();
        Assert.assertTrue(facebookPage.isPageOpened(), "Facebook Page is not opened!");

        String title = facebookPage.readTitle();
        System.out.println(title);

        Assert.assertEquals(title, "Onliner - Home | Facebook");

           }

    @Test
    @MethodOwner(owner = "tminchuk")
    public void verifyYouTubeLink(){
        HomePageOnliner homePageOnliner = new HomePageOnliner(getDriver());
        homePageOnliner.open();
        Assert.assertTrue(homePageOnliner.isPageOpened(), "Home Page is not opened!");

        YoutubePage youTubePage = homePageOnliner.clickLinkToYouTube();
        Assert.assertTrue(youTubePage.isPageOpened(), "Facebook Page is not opened!");

        String title = youTubePage.readTitle();
        System.out.println(title);

        Assert.assertEquals(title, "Onliner - YouTube");

    }

    @Test
    @MethodOwner(owner = "tminchuk")
    public void verifyAuthorizationWithValid(){
        HomePageOnliner homePageOnliner = new HomePageOnliner(getDriver());
        homePageOnliner.open();
        Assert.assertTrue(homePageOnliner.isPageOpened(), "Home Page is not opened!");

        AuthorizationPage authorizationPage = homePageOnliner.openAuthorizationPage();
        final String email = "newqa111@gmail.com";
        final String password = "qwerty123";
        HomePageOnliner homePageProfile = authorizationPage.authorizeValid(email,password);
        Assert.assertNotNull(homePageProfile.findProfileAvatar(), "User is not authorized");
    }

    @Test
    @MethodOwner(owner = "tminchuk")
    public void verifyAuthorizationWithInValid(){
        HomePageOnliner homePageOnliner = new HomePageOnliner(getDriver());
        homePageOnliner.open();
        Assert.assertTrue(homePageOnliner.isPageOpened(), "Home Page is not opened!");

        AuthorizationPage authorizationPage = homePageOnliner.openAuthorizationPage();
        final String email = "newqa111_gmail.com";
        final String password = "qwerty123";
        AuthorizationPage updatedAuthorizationPage = authorizationPage.authorizeInValid(email, password);
        Assert.assertEquals(updatedAuthorizationPage.findWarningMessage().getText(), "Неверный логин или пароль");
    }

    @Test
    @MethodOwner(owner = "tminchuk")
    public void verifyRegistrationWrongConfirm(){
        HomePageOnliner homePageOnliner = new HomePageOnliner(getDriver());
        homePageOnliner.open();
        Assert.assertTrue(homePageOnliner.isPageOpened(), "Home Page is not opened!");

        RegistrationPage registrationPage = homePageOnliner.openAuthorizationPage().openRegistration();
        final String email = "newqa111@gmail.com";
        final String password = "qwerty123";
        final String confirmPassword = "qwerty";
        RegistrationPage updatedRegistrationPage = registrationPage.registerNewAccountInvalid(email, password, confirmPassword);
        Assert.assertEquals(updatedRegistrationPage.findWarningMessage().getText(), "Пароли не совпадают");

    }

    @Test
    @MethodOwner(owner = "tminchuk")
    public void verifyRegistrationInvalidEmail(){
        HomePageOnliner homePageOnliner = new HomePageOnliner(getDriver());
        homePageOnliner.open();
        Assert.assertTrue(homePageOnliner.isPageOpened(), "Home Page is not opened!");

        RegistrationPage registrationPage = homePageOnliner.openAuthorizationPage().openRegistration();
        final String email = "@gmail.com";
        final String password = "qwerty123";
        final String confirmPassword = "qwerty123";
        RegistrationPage updatedRegistrationPage = registrationPage.registerNewAccountInvalid(email, password, confirmPassword);
        Assert.assertEquals(updatedRegistrationPage.findWrongEmailMessage().getText(), "Некорректный e-mail");

    }

    @Test
    @MethodOwner(owner = "tminchuk")
    public void verifyPasswordRecovery(){
        HomePageOnliner homePageOnliner = new HomePageOnliner(getDriver());
        homePageOnliner.open();
        Assert.assertTrue(homePageOnliner.isPageOpened(), "Home Page is not opened!");

        RecoverPasswordPage recoverPasswordPage = homePageOnliner.openAuthorizationPage().openRecoverPassword();
        final String email = "newqa111@gmail.com";
        RecoverPasswordPage newpage = recoverPasswordPage.recoverByUsingEmail(email);
        Assert.assertEquals(newpage.findInfoMessage().getText(), "Проверьте ваш e-mail");
    }

//    @Test
//    @MethodOwner(owner = "tminchuk")
//    public void verifyAddToCart(){
//        HomePageOnliner homePageOnliner = new HomePageOnliner(getDriver());
//        homePageOnliner.open();
//        Assert.assertTrue(homePageOnliner.isPageOpened(), "Home Page is not opened!");
//
//        final String fullNameItem = "Смартфон Apple iPhone 11 64GB (черный)";
//        ProductPage productPage = homePageOnliner.searchItemByFullName(fullNameItem).openItemInfo();
//        CartPage cartPage = productPage.addProductToCart();
//
//        Assert.assertTrue(cartPage.getProductInCart().isElementPresent(), "No items in cart");
//
//    }



}
