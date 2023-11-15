package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.ui.SelectExtension;

public class IframeInteraction {
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/iframe";
    private static final By IFRAME_SEL = By.cssSelector("iframe[id^='mce']");

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get(TARGET_URL);

        try {
            WebElement iframeEle = driver.findElement(IFRAME_SEL);
            driver.switchTo().frame(iframeEle);

            driver.findElement(By.id("tinymce")).click();
            driver.findElement(By.id("tinymce")).clear();
            driver.findElement(By.id("tinymce")).sendKeys("Hello");
            Thread.sleep(1500);
            driver.switchTo().defaultContent();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

}