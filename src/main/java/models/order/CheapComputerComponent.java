package models.order;

import models.components.ComponentCSSSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCSSSelector(".product-essential")
public class CheapComputerComponent extends ComputerEssentialComponent {
    public CheapComputerComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Override
    public String selectProcessor(String type) {
        return selectComputerOption(type);
    }

    @Override
    public String selectRAM(String type) {
        return selectComputerOption(type);
    }
}
