package org.example.pageObjects;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.ss.formula.functions.T;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class BasePO {
    private static WebDriver driver=null;
    private String locatorFile;
    private List<String> locatorFiles;
    private static String[] BASE_LOCATORS;
    public BasePO(WebDriver driver, String locatorFile){
        List<String> baseLocators = Arrays.asList(BASE_LOCATORS);
        this.driver =driver;
        this.locatorFile= locatorFile;
    }

    public BasePO(WebDriver driver, String... locatorFiles){
        this.driver =driver;
        this.locatorFiles= Arrays.asList(locatorFiles);
    }

    public BasePO(WebDriver driver){
        this.driver =driver;
    }

    private static synchronized <T> T instatiatPage(WebDriver driver, Class<T> pageClassToProxy) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<T> constructor =pageClassToProxy.getConstructor(WebDriver.class);
        return constructor.newInstance(driver);
    }
//    protected synchronized static Object initPage(Class<?> pageClass, String... locatorFiles) {
//        String[] allLocatorFiles = (String[]) ArrayUtils.addAll(locatorFiles, BASE_LOCATORS);
////        T t=instatiatPage(driver,WebDriver.class);
//        return initPage(driver, (Object) pageClass, allLocatorFiles);
//    }
}
