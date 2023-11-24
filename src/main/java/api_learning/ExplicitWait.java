package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.WaitForElementEnable;

import java.time.Duration;

public class ExplicitWait {
    private static final By USERNAME_SEL = (By.id("username"));
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/login";

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getWebDriver();
        driver.get(TARGET_URL);

        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("")));

            //customize explicit wait
            webDriverWait.until(new WaitForElementEnable(By.id("")));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
