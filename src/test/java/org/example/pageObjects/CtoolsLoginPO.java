package org.example.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CtoolsLoginPO {
    @FindBy(id="txtEmail") public WebElement email;
    @FindBy(id="txtPassCode") public WebElement password;
    @FindBy(id="btnLogin") public WebElement signin;

}
