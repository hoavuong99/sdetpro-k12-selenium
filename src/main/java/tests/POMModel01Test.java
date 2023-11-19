package tests;

import driver.DriverFactory;
import models.pages.LoginPageModel01;
import org.openqa.selenium.WebDriver;

public class POMModel01Test {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get("url");
        LoginPageModel01 loginPageModel01 = new LoginPageModel01(driver);
        loginPageModel01.username().sendKeys("Hoavuong");
        loginPageModel01.password().sendKeys("111111");
        loginPageModel01.loginBtn().click();
    }
}
