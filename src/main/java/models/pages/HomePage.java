package models.pages;

import models.components.FooterComponent;
import models.components.product.ProductItemComponent;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public List<ProductItemComponent> productItemComponentList(){
        return findComponents(ProductItemComponent.class);
    }
}
