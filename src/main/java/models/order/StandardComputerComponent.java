package models.order;

import models.components.ComponentCSSSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.ui.SelectExtension;

import java.util.List;

@ComponentCSSSelector(".product-essential")
public class StandardComputerComponent extends ComputerEssentialComponent {

    private static final By PRODUCT_ATTRIBUTE_SEL = By.cssSelector("select[name^='product_attribute']");
    public StandardComputerComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Override
    public String selectProcessor(String type) {
        final int PROCESSOR_DROPDOWN_INDEX = 0;
        WebElement processorDropdownEle = component.findElements(PRODUCT_ATTRIBUTE_SEL).get(PROCESSOR_DROPDOWN_INDEX);
        return selectOption(processorDropdownEle, type);
    }

    @Override
    public String selectRAM(String type) {
        final int RAM_DROPDOWN_INDEX = 1;
        WebElement ramDropdownEle = component.findElements(PRODUCT_ATTRIBUTE_SEL).get(RAM_DROPDOWN_INDEX);
        return selectOption(ramDropdownEle, type);
    }

    public String selectOption(WebElement dropdownEle, String type) {
        SelectExtension select = new SelectExtension(dropdownEle);
        List<WebElement> allOptionElements = select.getOptions();
        String fullStrOption = null;

        for (WebElement optionEle : allOptionElements) {
            String currentOptionText = optionEle.getText();
            String optionTextWithoutSpace = currentOptionText.trim().replace(" ", "");
            if (optionTextWithoutSpace.startsWith(type)) {
                fullStrOption = currentOptionText;
                break;
            }
        }

        if (fullStrOption == null) {
            throw new RuntimeException("[ERR] The option " + type + " is not existing to select");
        }

        select.selectByVisibleText(fullStrOption);
        return fullStrOption;
    }
}
