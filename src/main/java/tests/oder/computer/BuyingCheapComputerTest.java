package tests.oder.computer;

import models.order.CheapComputerComponent;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_data.ComputerData;
import test_data.DataObjectBuilder;
import test_flows.computer.OrderComputerFlow;
import tests.BaseTest;

public class BuyingCheapComputerTest extends BaseTest {

    @Test(dataProvider = "computerData")
    public void testCheapComputerBuying(ComputerData computerData) throws InterruptedException {
        driver.get("https://demowebshop.tricentis.com/build-your-cheap-own-computer");
        int quantity = 2;
        OrderComputerFlow<CheapComputerComponent> orderComputerFlow = new OrderComputerFlow<>(driver, CheapComputerComponent.class, computerData, quantity);
        orderComputerFlow.buildComputerSpec();
        orderComputerFlow.addItemToCart();
        orderComputerFlow.verifyShoppingCartPage();
    }

    @DataProvider()
    public ComputerData[] computerData() {
        String relativeDataFileLocation = "/src/main/java/test_data/CheapComputerDataList.json";
        return DataObjectBuilder.builDataObjectFrom(relativeDataFileLocation, ComputerData[].class);
    }
}
