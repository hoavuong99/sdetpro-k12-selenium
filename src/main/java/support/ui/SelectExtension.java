package support.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectExtension extends Select {

    private static final String OPTION_1 = "Option 1";
    public SelectExtension(WebElement element) {
        super(element);
    }
    public void selectOption1(){
        selectByVisibleText(OPTION_1);
    }
}
