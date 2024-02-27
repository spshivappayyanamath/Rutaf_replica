package org.example.pageActions;

import org.example.constants.LocatorFileConst;
import org.example.pageObjects.CTLoginPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//import static org.example.pageObjects.CTLoginPO.LOCATOR_FILES;

public class CTLoginPage {
    private final WebDriver driver;
//    private final CTLoginPO ctLoginPO;
    private static final String[] LOCATOR_FILES={LocatorFileConst.CT_LOGIN};
    public CTLoginPage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(this.driver, LOCATOR_FILES);
    }
//    ctLoginPO.
}
