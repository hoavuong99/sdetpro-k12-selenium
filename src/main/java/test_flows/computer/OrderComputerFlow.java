package test_flows.computer;

import models.components.cart.TotalComponent;
import models.order.ComputerEssentialComponent;
import models.pages.ComputerItemDetailsPage;
import models.pages.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import test_data.ComputerData;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderComputerFlow<T extends ComputerEssentialComponent> {
    private Class<T> computerEssentialCompClass;
    private WebDriver driver;
    private ComputerData computerData;
    private double itemTotalPrice;
    private int quantity;

    public OrderComputerFlow(WebDriver driver, Class<T> computerEssentialCompClass, ComputerData computerData) {
        this.computerEssentialCompClass = computerEssentialCompClass;
        this.driver = driver;
        this.computerData = computerData;
        this.quantity = 1;
    }

    public OrderComputerFlow(WebDriver driver, Class<T> computerEssentialCompClass, ComputerData computerData, int quantity) {
        this.computerEssentialCompClass = computerEssentialCompClass;
        this.driver = driver;
        this.computerData = computerData;
        this.quantity = quantity;
    }

    public void buildComputerSpec() {
        ComputerEssentialComponent computerEssentialComp = new ComputerItemDetailsPage(driver).computerEssentialComponent(computerEssentialCompClass);
        computerEssentialComp.unselectDefaultOptions();
        String processorFullStr = computerEssentialComp.selectProcessor(this.computerData.getProcessor());
        double processorAdditionalPrice = extractAdditionalPrice(processorFullStr);
        String ramFullStr = computerEssentialComp.selectRAM(this.computerData.getRam());
        double ramAdditionalPrice = extractAdditionalPrice(ramFullStr);
        String hddFullStr = computerEssentialComp.selectHDD(this.computerData.getHdd());
        double hddAdditionalPrice = extractAdditionalPrice(hddFullStr);
        String softwareFullStr = computerEssentialComp.selectSoftware(this.computerData.getSoftware());
        double softwareAdditionalPrice = extractAdditionalPrice(softwareFullStr);

        double osAdditionalPrice = 0;
        String osDataOption = this.computerData.getOs();
        if (osDataOption != null) {
            String osFullStr = computerEssentialComp.selectOS(this.computerData.getOs());
            osAdditionalPrice = extractAdditionalPrice(osFullStr);
        }

        double additionalPrice = processorAdditionalPrice + ramAdditionalPrice + hddAdditionalPrice + softwareAdditionalPrice + osAdditionalPrice;

        // Set item quantity
        computerEssentialComp.setProductQuantity(this.quantity);

        // Calculate item price = Base price + Additional price
        this.itemTotalPrice = (computerEssentialComp.productPrice() + additionalPrice) * this.quantity;
    }

    public void addItemToCart() {
        ComputerItemDetailsPage computerItemDetailsPage = new ComputerItemDetailsPage(driver);
        ComputerEssentialComponent computerEssentialComp = computerItemDetailsPage.computerEssentialComponent(computerEssentialCompClass);
        computerEssentialComp.clickOnAddCartBtn();
        computerEssentialComp.waitUntilItemAddedToCart();
        computerEssentialComp.waitUntilBarNotiDisable();
        computerItemDetailsPage.headerComponent().clickOnShoppingCartLink();
    }

    public void verifyShoppingCartPage() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        TotalComponent totalComp = shoppingCartPage.totalComp();
        Map<String, Double> priceCategories = totalComp.priceCategories();
        for (String priceType : priceCategories.keySet()) {
            System.out.printf("%s: %f\n", priceType, priceCategories.get(priceType));
        }
    }

    private double extractAdditionalPrice(String optionStr) {
        // Medium [+15.00]
        double price = 0;
        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(optionStr);
        if (matcher.find()) {
            price = Double.parseDouble(matcher.group(1).replaceAll("[+-]", ""));
        }
        return price;
    }
}
