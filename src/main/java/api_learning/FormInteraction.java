package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormInteraction {

    private static final By USERNAME_SEL = (By.id("username"));
    private static final By PASSWORD_SEL = (By.cssSelector("#password"));
    private static final By LOGIN_BTN_SEL = (By.cssSelector("#login [type='submit']"));
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/login";
    private static final String USER_NAME = "tomsmith";
    private static final String PASSWORD = "SuperSecretPassword!";

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getWebDriver();
        driver.get(TARGET_URL);

        try {
            WebElement usernameEle = driver.findElement(USERNAME_SEL);
            WebElement passwordEle = driver.findElement(PASSWORD_SEL);

            //Refresh page
            //driver.navigate().refresh();

            usernameEle.sendKeys(USER_NAME);
            passwordEle.sendKeys(PASSWORD);
            WebElement loginBtnEle = driver.findElement(LOGIN_BTN_SEL);
            loginBtnEle.click();

            driver.navigate().back();

            // DEBUG PURPOSE EXCEPTION
            try {
                Thread.sleep(2000);
            } catch (Exception ignored) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
