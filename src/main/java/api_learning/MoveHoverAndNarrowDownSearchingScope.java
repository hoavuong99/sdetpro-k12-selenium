package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.NoSuchElementException;

public class MoveHoverAndNarrowDownSearchingScope {
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/hovers";
    private static final By FIGURE_SEL = By.className("figure");
    private static final By PROFILE_NAME_SEL = By.cssSelector(".figcaption h5");
    private static final By PROFILE_LINK_SEL = By.cssSelector(".figcaption a");

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get(TARGET_URL);

        try {
            List<WebElement> figureEles = driver.findElements(FIGURE_SEL);
            if (figureEles.isEmpty()){
                throw  new NoSuchElementException();
            }

            Actions actions = new Actions(driver);

            for (WebElement figureEle : figureEles) {
                WebElement profileNameEle = figureEle.findElement(PROFILE_NAME_SEL);
                WebElement profileLinkEle = figureEle.findElement(PROFILE_LINK_SEL);
                boolean isProfileNameDisplayed = profileNameEle.isDisplayed();
                boolean isProfileLinkDisplayed = profileLinkEle.isDisplayed();
                System.out.println("Before | isProfileNameDisplayed: " + isProfileNameDisplayed);
                System.out.println("Before | isProfileLinkDisplayed: " + isProfileLinkDisplayed);

                actions.moveToElement(figureEle).perform();
                isProfileNameDisplayed = profileNameEle.isDisplayed();
                isProfileLinkDisplayed = profileLinkEle.isDisplayed();

                System.out.println(profileNameEle.getText());
                System.out.println(profileLinkEle.getAttribute("href"));
                System.out.println("After | isProfileNameDisplayed: " + isProfileNameDisplayed);
                System.out.println("After | isProfileLinkDisplayed: " + isProfileLinkDisplayed);
                System.out.println("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

}
