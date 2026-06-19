package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils
{
    public static WebElement waitForVisible(WebDriver driver, By locater, int sec)
    {
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(sec));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locater));
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element, int sec)
    {
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForLocaterToBeClickable(WebDriver driver, By locater, int sec)
    {
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(sec));
        return wait.until(ExpectedConditions.elementToBeClickable(locater));
    }

    public static void waitForSomeTime(int sec) throws InterruptedException {
        Thread.sleep(sec);
    }
     public static void clickByJs(WebDriver driver, WebElement element)
     {
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("arguments[0].click()", element);
     }
}
