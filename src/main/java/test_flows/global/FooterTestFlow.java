package test_flows.global;

import models.components.global.footer.*;
import models.components.global.header.CategoryItemComponent;

import models.pages.BasePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        FollowUsColumnComponent followUsColumnComp = basePage.footerComponent().followUsColumnComponent();
        verifyFollowUsColumn(followUsColumnComp);
    }

    public void verifyProductCategoryFooterComponent() {
        // Randomly pickup MainItems from Category menu
        BasePage basePage = new BasePage(driver);
        List<CategoryItemComponent> categoryItemComponents = basePage.categoryItemComponents();
        Assert.assertTrue(!categoryItemComponents.isEmpty(), "There is no item on top menu");
        int randomCategoryComponentIndex = new SecureRandom().nextInt(categoryItemComponents.size());
        CategoryItemComponent randomCategoryComponent = categoryItemComponents.get(1);
        String randomCategoryHref = randomCategoryComponent.categoryItemLinkEle().getAttribute("href");

        // Get sublist (if any) then click on a random sub-item / MainItem (if has no sublist)eiow
        List<WebElement> subListItems = randomCategoryComponent.subListItems();
        if (subListItems.isEmpty()) {
            randomCategoryComponent.categoryItemLinkEle().click();
        } else {
            int randomSubItemIndex = new SecureRandom().nextInt(subListItems.size());
            WebElement randomSubItems = subListItems.get(randomSubItemIndex);
            randomCategoryHref = randomSubItems.getAttribute("href");
            randomSubItems.click();
        }

        // Make sure we are on the right page | Wait until navigation is done
        try {
            WebDriverWait wait = randomCategoryComponent.componentWait();
            wait.until(ExpectedConditions.urlContains(randomCategoryHref));
        } catch (TimeoutException ignored) {
            Assert.fail("[ERR] Target page is not matched");
        }

        // Call common verify method
        verifyFooterComponent();
    }

    private void verifyFollowUsColumn(FooterColumnComponent followUsColumnComponent) {
        List<String> expectedLinkTexts = Arrays.asList("Facebook", "Twitter", "RSS", "YouTube", "Google+");
        List<String> expectedHrefs = Arrays.asList("http://www.facebook.com/nopCommerce",
                "https://twitter.com/nopCommerce",
                "https://demowebshop.tricentis.com/news/rss/1",
                "http://www.youtube.com/user/nopCommerce",
                "https://plus.google.com/+nopcommerce");
        testFooterColumn(followUsColumnComponent, expectedLinkTexts, expectedHrefs);
    }

    private void verifyMyAccountColumn(FooterColumnComponent myAccountColumnComp) {
        List<String> expectedLinkTexts = Arrays.asList("My account", "Orders", "Addresses", "Shopping cart", "Wishlist");
        List<String> expectedHrefs = Arrays.asList("/customer/info", "/customer/orders", "/customer/addresses", "/cart", "/wishlist");
        expectedHrefs.replaceAll(originHref -> "https://demowebshop.tricentis.com" + originHref);
        testFooterColumn(myAccountColumnComp, expectedLinkTexts, expectedHrefs);
    }

    private void verifyCustomerServiceColumn(FooterColumnComponent customerServiceColumnComp) {
        List<String> expectedLinkTexts = Arrays.asList("Search", "News", "Blog", "Recently viewed products", "Compare products list", "New products");
        List<String> expectedHrefs = Arrays.asList("/search", "/news", "/blog", "/recentlyviewedproducts", "/compareproducts", "/newproducts");
        expectedHrefs.replaceAll(originHref -> "https://demowebshop.tricentis.com" + originHref);
        testFooterColumn(customerServiceColumnComp, expectedLinkTexts, expectedHrefs);
    }

    private void verifyInformationColumn(FooterColumnComponent informationColumnComp) {
        List<String> expectedLinkTexts = Arrays.asList("Sitemap", "Shipping & Returns", "Privacy Notice", "Conditions of Use", "About us", "Contact us");
        List<String> expectedHrefs = Arrays.asList("/sitemap", "/shipping-returns", "/privacy-policy", "/conditions-of-use", "/about-us", "/contactus");
        expectedHrefs.replaceAll(originHref -> "https://demowebshop.tricentis.com" + originHref);
        testFooterColumn(informationColumnComp, expectedLinkTexts, expectedHrefs);
    }

    private void testFooterColumn(FooterColumnComponent footerColumnComponent, List<String> expectedLinkTexts, List<String> expectedHrefs) {
        List<String> actualLinkTexts = new ArrayList<>();
        List<String> actualHrefs = new ArrayList<>();

        footerColumnComponent.linksEle().forEach(columnItem -> {
            actualLinkTexts.add(columnItem.getText());
            actualHrefs.add(columnItem.getAttribute("href"));
        });

        if (actualLinkTexts.isEmpty() || actualHrefs.isEmpty()) {
            Assert.fail("Footer column text or hyperlink is empty");
        }

        Assert.assertEquals(actualLinkTexts, expectedLinkTexts, "[ERR] Footer column link texts are different");
        Assert.assertEquals(actualHrefs, expectedHrefs, "[ERR] Footer column hrefs are different");

        System.out.println(footerColumnComponent.headerEle().getText());
        for (WebElement linkEle : footerColumnComponent.linksEle()) {
            System.out.println(linkEle.getText() + ": " + linkEle.getAttribute("href"));
        }
        System.out.println("=======");
    }

}
