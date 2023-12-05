package tests;

import driver.DriverFactory;
import models.components.global.footer.CustomerServiceColumnComponent;
import models.components.global.footer.FooterColumnComponent;
import models.components.global.footer.FooterComponent;
import models.components.global.footer.InformationColumnComponent;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterComponentTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get("https://demowebshop.tricentis.com/");

       try {
            HomePage homePage = new HomePage(driver);
            FooterComponent footerComponent = homePage.footerComponent();
            InformationColumnComponent informationColumnComponent = footerComponent.informationColumnComponent();
            CustomerServiceColumnComponent customerServiceComponent = footerComponent.customerServiceComponent();
            testFooterComponent(informationColumnComponent);
            testFooterComponent(customerServiceComponent);
        } catch (Exception ignored){

       } finally {
           driver.quit();
       }
    }

    private static void testFooterComponent(FooterColumnComponent footerColumnComponent){
        System.out.println(footerColumnComponent.headerEle().getText());
        for (WebElement linkEle : footerColumnComponent.linksEle()) {
            System.out.println(linkEle.getText() + ": " + linkEle.getAttribute("href"));
        }
        System.out.println("=======");
    }
}