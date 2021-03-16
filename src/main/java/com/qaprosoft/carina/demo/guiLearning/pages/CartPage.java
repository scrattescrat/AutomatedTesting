package com.qaprosoft.carina.demo.guiLearning.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.guiLearning.pages.components.SearchItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='cart-form__offers-unit cart-form__offers-unit_primary']")
    private ExtendedWebElement productInCart;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://cart.onliner.by/");
    }

    public ExtendedWebElement getProductInCart(){
        return productInCart;
    }
}
