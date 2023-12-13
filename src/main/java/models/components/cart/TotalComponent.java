package models.components.cart;

import models.components.Component;
import models.components.ComponentCSSSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ComponentCSSSelector(".cart-footer .totals")
public class TotalComponent extends Component {

    private static final By PRICE_TABLE_ROW_SEL = By.cssSelector("table tr");
    private static final By PRICE_TYPE_ROW_SEL = By.cssSelector(".cart-total-left");
    private static final By PRICE_VALUE_ROW_SEL = By.cssSelector(".cart-total-right");

    public TotalComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public Map<String, Double> priceCategories() {
        Map<String, Double> priceCategories = new HashMap<>();
        List<WebElement> priceTableRowEls = findElements(PRICE_TABLE_ROW_SEL);
        Assert.assertFalse(priceTableRowEls.isEmpty(), "[ERR] Price table is empty");
        for (WebElement tableRowEle : priceTableRowEls) {
            WebElement priceTypeEle = tableRowEle.findElement(PRICE_TYPE_ROW_SEL);
            WebElement priceValueEle = tableRowEle.findElement(PRICE_VALUE_ROW_SEL);

            String priceType = priceTypeEle.getText().replace(":", "").trim();
            double priceValue = Double.parseDouble(priceValueEle.getText().trim());

            priceCategories.put(priceType, priceValue);
        }
        return priceCategories;
    }
}
