package models.order;

import models.components.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BaseItemComponent extends Component {
    private static final By BAR_NOTI_SEL = By.cssSelector("#bar-notification");
    private static final By PRODUCT_PRICE_SEL = By.cssSelector(".product-price");
    private static final By PRODUCT_QUANTITY_SEL = By.cssSelector(".add-to-cart input[class='qty-input']");
    private static final By ADD_TO_CART_BTN = By.cssSelector("input[id^='add-to-cart-button']");


    public BaseItemComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public double productPrice() {
        String productPriceStr = findElement(PRODUCT_PRICE_SEL).getText().trim();
        return Double.parseDouble(productPriceStr);
    }

    public void setProductQuantity(int quantity) {
        findElement(PRODUCT_QUANTITY_SEL).clear();
        findElement(PRODUCT_QUANTITY_SEL).sendKeys(String.valueOf(quantity));
    }

    public void clickOnAddCartBtn() {
        findElement(ADD_TO_CART_BTN).click();
    }

    public void waitUntilItemAddedToCart() {
        String successMsg = "The product has been added to your shopping cart";
        wait.until(ExpectedConditions.textToBePresentInElementLocated(BAR_NOTI_SEL, successMsg));
    }

    public void waitUntilBarNotiDisable(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(BAR_NOTI_SEL));
    }
}
