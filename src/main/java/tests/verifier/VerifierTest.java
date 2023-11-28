package tests.verifier;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test_flows.global.FooterTestFlow;
import tests.BaseTest;
import tests.utils.Verifier;

public class VerifierTest extends BaseTest {

    @Test
    public void testHardAssertion() {
        driver.get("https://demowebshop.tricentis.com/");
       // Verifier.assertEquals("Teo", "Ti");

        Assert.assertEquals("Teo", "Ti", "Username is incorrect!");
        Assert.assertTrue(true);
        Assert.assertFalse(false);
        Assert.fail();
    }

    @Test
    public void testSoftAssertion(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(1, 2);
        softAssert.assertTrue(false);
        softAssert.assertFalse(true);
        softAssert.fail("I want to");
        softAssert.assertAll();
    }
}
