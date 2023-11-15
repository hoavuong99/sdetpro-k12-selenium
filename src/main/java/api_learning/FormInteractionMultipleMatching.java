package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class FormInteractionMultipleMatching {
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/login";
    private static final By LOGIN_INPUT_FIELDS_SEL = (By.tagName("input"));
    private static final By LOGIN_BTN_SEL = (By.cssSelector("#login [type='submit']"));

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getWebDriver();
        driver.get(TARGET_URL);

        try {
           List<WebElement> loginBtnEles = driver.findElements(LOGIN_INPUT_FIELDS_SEL);
           if (!loginBtnEles.isEmpty()){
               final int USERNAME_INDEX = 0;
               final int PASSWORD_INDEX = 1;
               loginBtnEles.get(USERNAME_INDEX).sendKeys("hoa@gmail.com");
               loginBtnEles.get(PASSWORD_INDEX).sendKeys("123123");
           } else {
               throw new NoSuchElementException("No login fields found!");
           }

           driver.findElement(LOGIN_BTN_SEL).click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
