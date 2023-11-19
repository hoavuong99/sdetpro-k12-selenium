package tests;

import driver.DriverFactory;
import models.pages.LoginPageModel03;
import org.openqa.selenium.WebDriver;

public class POMModel03Test {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get("url");
        LoginPageModel03 loginPageModel03 = new LoginPageModel03(driver);
        loginPageModel03
                .inputUsername("Hoavuong")
                .inputPassword("111111")
                .clicklOnLoginBtn();
    }
}
