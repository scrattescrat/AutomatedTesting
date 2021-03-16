package com.qaprosoft.carina.demo.guiLearning.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import javassist.bytecode.ExceptionTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {
    @FindBy(xpath = "//*[@data-shop-id='256']")
    private ExtendedWebElement buttonAddToCart;

    public ProductPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://catalog.onliner.by/mobile/apple/iphone1164b");
            }

     public CartPage addProductToCart(){
        buttonAddToCart.doubleClick();
        return new CartPage(driver);
     }


}
