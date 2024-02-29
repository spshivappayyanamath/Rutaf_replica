package org.example.utils;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class HelperClass {

    private static HelperClass helperClass;

    private static WebDriver driver;
    private static JavascriptExecutor executor;
    private static WebDriverWait wait;
    public final static int TIMEOUT = 15;

    private HelperClass() {
//        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\lib\\"+"chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));

        executor = (JavascriptExecutor) driver;
    }

    public static void openPage(String url) {
        driver.get(url);
    }


    public static WebDriver getDriver() {
        return driver;
    }
    public static JavascriptExecutor getJavascriptExecutor() {
        return executor;
    }

    public static void setUpDriver() {

        if (helperClass==null) {
            helperClass = new HelperClass();
        }
    }

    public static void tearDown() {

        if(driver!=null) {
            driver.close();
            driver.quit();
        }

        helperClass = null;
    }

    public static void webDriverImplicitWait() {
        HelperClass.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public static void setExplicitWait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
//        wait.until(ExpectedCondition);
    }
}