package org.example.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

public class SwitchWindows {
    public static void main(String[] args) throws AWTException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.co.in/");
        driver.findElement(By.name("q")).sendKeys("Kannada news");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        WebElement element= driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/span/a/h3"));

        String currnetW= driver.getWindowHandle();


        Actions actions = new Actions(driver);
        actions.contextClick(element).build().perform();
//                sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        element.sendKeys(Keys.ARROW_DOWN);
//        element.sendKeys(Keys.ARROW_DOWN);
//        element.sendKeys(Keys.ARROW_DOWN);
//        element.sendKeys(Keys.ARROW_DOWN);
//        element.sendKeys(Keys.ARROW_DOWN);
//        element.sendKeys(Keys.ENTER);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
//
//        robot.keyPress(KeyEvent.VK_DOWN);
//        robot.keyRelease(KeyEvent.VK_DOWN);
//
//        robot.keyPress(KeyEvent.VK_DOWN);
//        robot.keyRelease(KeyEvent.VK_DOWN);
//
//        robot.keyPress(KeyEvent.VK_DOWN);
//        robot.keyRelease(KeyEvent.VK_DOWN);
//
//        robot.keyPress(KeyEvent.VK_DOWN);
//        robot.keyRelease(KeyEvent.VK_DOWN);
//
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        Set<String> windows= driver.getWindowHandles();
        Iterator<String> wins= windows.iterator();
        while (wins.hasNext()){
            String chWin= wins.next();
            if(!currnetW.equals(chWin)){
                driver.switchTo().window(chWin);

                System.out.println(windows);
                System.out.println(driver.getTitle());
                actions.doubleClick(driver.findElement(By.xpath("//*[@id=\"__next\"]/section/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/h1"))).build().perform();
                driver.close();
            }
        }
        driver.switchTo().window(currnetW);
        System.out.println(driver.getTitle());


        driver.close();
        driver.quit();

    }
}
