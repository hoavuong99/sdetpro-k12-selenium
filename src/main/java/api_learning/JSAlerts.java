package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.WaitForElementEnable;

import java.time.Duration;

public class JSAlerts {
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/javascript_alerts";
    private static final By JS_ALERT_SEL = By.cssSelector("[onclick='jsAlert()']");
    private static final By JS_ALERT_CONFIRM_SEL = By.cssSelector("[onclick='jsConfirm()']");
    private static final By JS_ALERT_PROMPT_SEL = By.cssSelector("[onclick='jsPrompt()']");
    private static final By RESULT_SEL = By.id("result");

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getWebDriver();
        driver.get(TARGET_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement resultEle = driver.findElement(RESULT_SEL);
            //JS Alert
            driver.findElement(JS_ALERT_SEL).click();
            Alert jsAlert = wait.until(ExpectedConditions.alertIsPresent());
            jsAlert.accept();
            System.out.println(resultEle.getText());

            //JS Confirm alert
            driver.findElement(JS_ALERT_CONFIRM_SEL).click();
            Alert jsAlertConfirm = wait.until(ExpectedConditions.alertIsPresent());
            jsAlertConfirm.dismiss();
            System.out.println(resultEle.getText());

            //JS prompt
            driver.findElement(JS_ALERT_PROMPT_SEL).click();
            Alert jsAlertPrompt = wait.until(ExpectedConditions.alertIsPresent());
            jsAlertPrompt.sendKeys("Hello");
            jsAlertPrompt.accept();
            System.out.println(resultEle.getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
