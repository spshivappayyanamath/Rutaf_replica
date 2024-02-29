package org.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CtoolsHomePO {
    WebDriver driver;
    public CtoolsHomePO(){
        this.driver=driver;
    }
    @FindBy(xpath="//h1") public WebElement homeheader;
    @FindBy(className ="dropdown-toggle") public WebElement userbutton;
    @FindBy(xpath = "//a[contains(text(),'Log Out')]") public WebElement logout;
}
