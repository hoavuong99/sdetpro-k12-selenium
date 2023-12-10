package models.order;

import models.components.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseItemComponent extends Component {

    private static final By PRODUCT_PRICE_SEL = By.cssSelector(".product-price");
    private static final By ADD_TO_CART_BTN = By.cssSelector("input[id^='add-to-cart-button']");

    public BaseItemComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
    public double productPrice(){
        String productPriceStr = findElement(PRODUCT_PRICE_SEL).getText().trim();
        return Double.parseDouble(productPriceStr);
    }
    public void clickOnAddCartBtn(){
        findElement(ADD_TO_CART_BTN).click();
    }
}
