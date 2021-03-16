package com.qaprosoft.carina.demo.guiLearning.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.etsi.uri.x01903.v13.SignerRoleType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends AbstractPage {

    @FindBy(xpath = "//input[@placeholder='Ваш e-mail']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Придумайте пароль']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//input[@placeholder='Повторите пароль']")
    private ExtendedWebElement confirmPasswordField;

    @FindBy(xpath = "//button[@type='submit']")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//div[@class='auth-form__description auth-form__description_error auth-form__description_base auth-form__description_extended-other']")
    private ExtendedWebElement warningMessage;

    @FindBy(xpath = "//div[@class='auth-form__description auth-form__description_error auth-form__description_base auth-form__description_extended-other']")
    private ExtendedWebElement wrongEmailMessage;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://profile.onliner.by/registration");
    }

    public RegistrationPage registerNewAccountInvalid(String email, String password, String confirmPassword){
        emailField.type(email);
        passwordField.type(password);
        confirmPasswordField.type(confirmPassword);
        submitButton.click();
        return new RegistrationPage(driver);
    }

    public ExtendedWebElement findWarningMessage(){
        return warningMessage;
    }

    public ExtendedWebElement findWrongEmailMessage(){
        return wrongEmailMessage;
    }


}
