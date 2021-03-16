package com.qaprosoft.carina.demo.guiLearning.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage extends AbstractPage {

    @FindBy(xpath = "//input[@placeholder='Ник или e-mail']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Пароль']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//*[@class='auth-button auth-button_primary auth-button_middle auth-form__button auth-form__button_width_full']")
    private ExtendedWebElement submitAuthorizationButton;

    @FindBy(xpath = "//div[@class='auth-form__description auth-form__description_error auth-form__description_base auth-form__description_extended-other']")
    private ExtendedWebElement warningMessage;

    @FindBy(xpath = "//*[contains(text(), 'Зарегистрироваться на Onliner')]")
    private ExtendedWebElement registrationButton;

    @FindBy(xpath = "//*[contains(text(), 'Я не помню пароль')]")
    private ExtendedWebElement recoverPasswordButton;

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    public HomePageOnliner authorizeValid(String email, String password){
        emailField.type(email);
        passwordField.type(password);
        submitAuthorizationButton.click();
        return new HomePageOnliner(driver);
    }

    public AuthorizationPage authorizeInValid(String email, String password){
        emailField.type(email);
        passwordField.type(password);
        submitAuthorizationButton.click();
        return new AuthorizationPage(driver);
    }

//    public ExtendedWebElement findWarningMessage(){
//        String warningMessageText = warningMessage.getText();
//        driver.findElement(By.xpath("//*[contains((text(), '" + warningMessageText + "')]"));
//        return warningMessage;
//    }

    public ExtendedWebElement findWarningMessage(){

        return warningMessage;
    }

    public RegistrationPage openRegistration(){
        registrationButton.click();
        return new RegistrationPage(driver);
    }

    public RecoverPasswordPage openRecoverPassword(){
        recoverPasswordButton.click();
        return new RecoverPasswordPage(driver);
    }
}
