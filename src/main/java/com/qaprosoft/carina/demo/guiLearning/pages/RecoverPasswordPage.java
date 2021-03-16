package com.qaprosoft.carina.demo.guiLearning.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RecoverPasswordPage extends AbstractPage {
    @FindBy(xpath = "//input[@placeholder='Ник, e-mail или номер телефона']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//button[@type='submit']")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//div[@class='auth-form__title auth-form__title_big auth-form__title_condensed-default']")
    private ExtendedWebElement infoMessage;

    public RecoverPasswordPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://profile.onliner.by/recover-password");
    }

    public RecoverPasswordPage recoverByUsingEmail(String email){
        emailField.type(email);
        submitButton.click();
        return new RecoverPasswordPage(driver);
    }

    public ExtendedWebElement findInfoMessage(){

        return infoMessage;
    }
}
