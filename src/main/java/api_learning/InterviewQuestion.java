package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InterviewQuestion {
        private static final By USERNAME_SEL = (By.id("username"));

        public static void main(String[] args) {

        WebDriver driver = DriverFactory.getWebDriver();

       //cach 1
        Exception exception = null;
        try {
            WebElement usernameEle = driver.findElement(USERNAME_SEL);
        } catch (Exception e) {
            exception = e;
        }
        if (exception ==  null){
            //Assert.fail("The element is not on the page!");
        }

        //Cach 2
            List<WebElement> usernameEles = driver.findElements(USERNAME_SEL);
        if (!usernameEles.isEmpty()){
            //Assert.fail("The element is not on the page!");
        }

    }
}
