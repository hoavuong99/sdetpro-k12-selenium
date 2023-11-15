package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import support.ui.SelectExtension;

public class DropdownInteraction {
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/dropdown";
    private static final By DROPDOWN_SEL = By.id("dropdown");

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get(TARGET_URL);

        try {
            WebElement dropdownEle = driver.findElement(DROPDOWN_SEL);
            SelectExtension select = new SelectExtension(dropdownEle);

            select.selectOption1();
            debugWait();

            select.selectByIndex(2);
            debugWait();

            select.selectByValue("1");
            debugWait();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static void debugWait() {
        try {
            Thread.sleep(1500);
        } catch (Exception ignored) {

        }
    }
}
