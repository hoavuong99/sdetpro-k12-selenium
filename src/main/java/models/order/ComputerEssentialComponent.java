package models.order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class ComputerEssentialComponent extends BaseItemComponent {
    private static final By ALL_OPTIONS_SEL = By.cssSelector(".option-list input");

    public ComputerEssentialComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public abstract String selectProcessor(String type);

    public abstract String selectRAM(String type);

    public String selectHDD(String type) {
        return selectComputerOption(type);
    }

    public String selectOS(String type) {
        return selectComputerOption(type);
    }

    public String selectSoftware(String type) {
        return selectComputerOption(type);
    }

    public void unselectDefaultOptions() {
        component.findElements(ALL_OPTIONS_SEL).forEach(option -> {
            if (option.getAttribute("check") != null) {
                option.click();
            }
        });
    }

    protected String selectComputerOption(String type) {
        String selectorStr = "//label[contains(text()," + "\"" + type + "\"" + ")]";
        By optionSelector = By.xpath(selectorStr);
        WebElement optionElement = null;

        // if we don't find that element we throw an exception to tell that the option value is not existing on the page
        try {
            optionElement = component.findElement(optionSelector);
        } catch (Exception ignored) {
        }

        if (optionElement == null) {
            throw new RuntimeException("[ERR] The option " + type + " is not existing to select!");
        }
        optionElement.click();
        return optionElement.getText().trim();
    }

    // another way, we can use List<WebElement> and get size of list

}

