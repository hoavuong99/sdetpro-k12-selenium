package models.components.cart;

import models.components.Component;
import models.components.ComponentCSSSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCSSSelector("cart-item-row")
public class CartItemRowComponent extends Component {
    private static final By UNIT_PRICE_SEL = By.cssSelector(".product-unit-price");
    private static final By ITEM_QUANTITY_SEL = By.cssSelector(".qty-input");
    private static final By SUB_TOTAL_SEL = By.cssSelector(".product-subtotal");

    public CartItemRowComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
    public double getUnitPrice(){
        return Double.parseDouble(findElement(UNIT_PRICE_SEL).getText().trim());
    }
    public double getQuantity(){
        return Double.parseDouble(findElement(ITEM_QUANTITY_SEL).getAttribute("value").trim());
    }
    public double getSubTotal(){
        return Double.parseDouble(findElement(SUB_TOTAL_SEL).getText().trim());
    }
}
