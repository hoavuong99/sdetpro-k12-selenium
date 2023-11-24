package tests;

import driver.DriverFactory;
import models.pages.LoginPageModel02;
import org.openqa.selenium.WebDriver;

public class POMModel02Test {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get("url");
        LoginPageModel02 loginPageModel02 = new LoginPageModel02(driver);
        loginPageModel02.inputUsername("Hoavuong");
        loginPageModel02.inputPassword("111111");
        loginPageModel02.clickOnLoginBtn();
    }
}
