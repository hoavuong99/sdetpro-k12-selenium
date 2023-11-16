package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.WaitForElementEnable;

import java.time.Duration;

public class DynamicControl {
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/dynamic_controls";
    private static final By CHECKBOX_FORM_SEL = By.id("checkbox-example");
    private static final By INPUT_FORM_SEL = By.id("input-example");
    private static final By CHECKBOX_INPUT_ELE_SEL = By.cssSelector("#checkbox-example input");
    private static final By INPUT_ELE_SEL = By.cssSelector("#input-example input");
    private static final By BUTTON_ELE_SEL = By.tagName("button");

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get(TARGET_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {

            //checkbox form
            WebElement checkboxFormEle = driver.findElement(CHECKBOX_FORM_SEL);
            WebElement inputFormEle = driver.findElement(INPUT_FORM_SEL);

            WebElement checkboxInputEle = checkboxFormEle.findElement(CHECKBOX_INPUT_ELE_SEL);
            WebElement removeBtnEle = checkboxFormEle.findElement(BUTTON_ELE_SEL);

            System.out.println("Before | is element selected: " + checkboxInputEle.isSelected());
            checkboxInputEle.click();
            System.out.println("After | is element selected: " + checkboxInputEle.isSelected());

            removeBtnEle.click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(CHECKBOX_INPUT_ELE_SEL));

            //input form
            WebElement enableTextFieldBtn = inputFormEle.findElement(BUTTON_ELE_SEL);
            WebElement textFieldEle = inputFormEle.findElement(INPUT_ELE_SEL);
            System.out.println("Before | is element enabled: " + textFieldEle.isEnabled());
            enableTextFieldBtn.click();
            wait.until(new WaitForElementEnable(INPUT_ELE_SEL));
            System.out.println("After | is element enabled: " + textFieldEle.isEnabled());
            textFieldEle.sendKeys("sth");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

}
