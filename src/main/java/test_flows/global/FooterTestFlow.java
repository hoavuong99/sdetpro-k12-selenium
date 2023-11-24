package test_flows.global;

import models.components.global.footer.*;
import models.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterTestFlow {

    private final WebDriver driver;

    public FooterTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyFooterComponent() {
        BasePage basePage = new BasePage(this.driver);
        InformationColumnComponent informationColumnComp = basePage.footerComponent().informationColumnComponent();
        verifyInformationColumn(informationColumnComp);

        CustomerServiceColumnComponent customerServiceColumnComp = basePage.footerComponent().customerServiceComponent();
        verifyCustomerServiceColumn(customerServiceColumnComp);

        MyAccountColumnComponent myAccountColumnComp = basePage.footerComponent().myAccountColumnComponent();
        verifyMyAccountColumn(myAccountColumnComp);

        FollowUsColumnComponent followUsColumnComponent = basePage.footerComponent().followUsColumnComponent();
        verifyFollowUsColumn(followUsColumnComponent);
    }

    private void verifyFollowUsColumn(FooterColumnComponent followUsColumnComponent) {
        testFooterColumn(followUsColumnComponent);
    }

    private void verifyMyAccountColumn(FooterColumnComponent myAccountColumnComp) {
        testFooterColumn(myAccountColumnComp);
    }

    private void verifyCustomerServiceColumn(FooterColumnComponent customerServiceColumnComp) {
        testFooterColumn(customerServiceColumnComp);
    }

    private void verifyInformationColumn(FooterColumnComponent informationColumnComp) {
        testFooterColumn(informationColumnComp);
    }

    private void testFooterColumn(FooterColumnComponent footerColumnComponent) {
        System.out.println(footerColumnComponent.headerEle().getText());
        for (WebElement linkEle : footerColumnComponent.linksEle()) {
            System.out.println(linkEle.getText() + ": " + linkEle.getAttribute("href"));
        }
        System.out.println("=======");
    }
}
