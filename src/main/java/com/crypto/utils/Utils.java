package com.crypto.utils;

import com.crypto.pages.DashboardPage;
import com.crypto.steps.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class Utils extends TestBase {


    public static void clickWebElementByJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public static String getInnerTextByJS(){
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        return js.executeScript("return document.documentElement.innerText;").toString();
    }


    public static WebElement fluentWait(WebElement element){
       return new WebDriverWait(getDriver(), Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOf(element));
    }
    public static void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        //Vertical scroll - down by 150  pixels
        js.executeScript("window.scrollBy(0,150)");

    }
    public static void scrollToDownEnd(){
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        //Vertical scroll - down by 150  pixels
        js.executeScript("window.scrollBy(0,350)");

    }
    public static void scrollToUpEnd(){
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        //Vertical scroll - down by 150  pixels
        js.executeScript("window.scrollBy(0,-350)");

    }

    public static WebElement scrollIntoView(WebElement element){

        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        return element;
    }



    public static WebElement continueslyScrool(By by){
        WebElement element = getDriver().findElement(by);
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("window.scrollBy(0,0)");
        while (element==null) {

            scrollDown();
        }
        return element;
    }

    public static void scrollInTable(WebElement tableElement){


        WebElement element = tableElement.findElement(By.tagName("tbody"));

        AtomicInteger counter = new AtomicInteger();
        List<WebElement> rows = element.findElements(By.tagName("tr"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();

        counter.getAndIncrement();
        rows.forEach( row -> {
            counter.getAndIncrement();

            executor.executeScript("arguments[0].scrollIntoView()", row);


            String xpath = "//tbody/tr[@data-qa='table__row-props'][";
            xpath += counter.toString();
             xpath += "]//td[6]/div[1]/div[2]";

            row.findElement(By.xpath(xpath)).click();

            try {
               new WebDriverWait(getDriver(),10).until(ExpectedConditions.visibilityOf(row));
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });
    }

    public static void cleanFavarites(List<WebElement> elements){

       DashboardPage dashboardPage = new DashboardPage();

        while(elements.size()>0) {

            getDriver().navigate().refresh();
            elements.iterator().next().click();

        }
    }

    public static void addFavarites(List<WebElement> elements){

        int counter = 5;
        Iterator<WebElement> iterator = elements.iterator();


            getDriver().navigate().refresh();
            iterator.next();
         iterator.next().click();


    }



    public static WebDriverWait waitFor(){
       return new WebDriverWait(getDriver(),10);
    }







}
