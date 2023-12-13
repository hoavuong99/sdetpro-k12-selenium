package tests.oder.computer;

import models.order.CheapComputerComponent;
import models.order.StandardComputerComponent;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_data.ComputerData;
import test_data.DataObjectBuilder;
import test_flows.computer.OrderComputerFlow;
import tests.BaseTest;

public class BuyingStandardComputerTest extends BaseTest {
    @Test(dataProvider = "computerData")
    public void testStandardComputerBuying(ComputerData computerData){
        driver.get("https://demowebshop.tricentis.com/build-your-own-computer");
        OrderComputerFlow<StandardComputerComponent> orderComputerFlow = new OrderComputerFlow<>(driver, StandardComputerComponent.class, computerData);
        orderComputerFlow.buildComputerSpec();
        orderComputerFlow.addItemToCart();
        orderComputerFlow.verifyShoppingCartPage();
    }

    @DataProvider()
    public ComputerData[] computerData() {
        String relativeDataFileLocation = "/src/main/java/test_data/StandardComputerDataList.json";
        return DataObjectBuilder.builDataObjectFrom(relativeDataFileLocation, ComputerData[].class);
    }
}
