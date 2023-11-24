package tests;

import models.components.FindComponent;
import models.components.FooterComponent;

public class AnnotationTest {
    public static void main(String[] args) {
       String footerComSel =  new FindComponent().getComponentCssSelector(FooterComponent.class);
        System.out.println(footerComSel);
    }
}
