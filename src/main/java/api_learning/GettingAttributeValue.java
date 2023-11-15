package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GettingAttributeValue {
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/login";

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getWebDriver();
        driver.get(TARGET_URL);

        try {
            By powerByLinkTextSel = By.linkText("Elemental Selenium");
            driver.findElement(powerByLinkTextSel).click();

            By powerByPartialLinkTextSel = By.partialLinkText("Elemental");
            driver.findElement(powerByPartialLinkTextSel).click();

            System.out.println(driver.findElement(powerByPartialLinkTextSel).getAttribute("target"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
