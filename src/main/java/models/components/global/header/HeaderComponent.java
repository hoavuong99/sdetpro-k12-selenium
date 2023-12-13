package models.components.global.header;

import models.components.Component;
import models.components.ComponentCSSSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCSSSelector(value = ".header")
public class HeaderComponent extends Component {
    private static final By SHOPPING_CART_LINK_SEL = By.cssSelector("li#topcartlink");

    public HeaderComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public void clickOnShoppingCartLink() {
        findElement(SHOPPING_CART_LINK_SEL).click();
    }

}
