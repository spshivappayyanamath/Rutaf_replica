package org.example.pageObjects;

import lombok.Getter;
import org.example.constants.LocatorFileConst;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.invoke.MethodHandles;

@Getter
public class CTLoginPO {
    private static final String[] LOCATOR_FILES={LocatorFileConst.CT_LOGIN};
    private final WebDriver driver;
    public CTLoginPO(WebDriver driver){
        this.driver=driver;
    }

    @FindBy private WebElement email;
    @FindBy private WebElement password;

    @FindBy private WebElement signin;
    @FindBy private WebElement loginheader;

}
