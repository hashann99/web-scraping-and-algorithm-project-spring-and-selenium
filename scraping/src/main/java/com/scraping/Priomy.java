package com.scraping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Priomy {
    FirefoxDriver firefoxDriver = null;

    public void start() throws InterruptedException {
        firefoxDriver = new Driver().getFirefoxDriver();
        scrape();
    }

    void scrape() throws InterruptedException {
        firefoxDriver.get("https://priomy.de/map/");
        Thread.sleep(10000);
        int i=0;
        List<WebElement> elements = firefoxDriver.findElements(By.className("ol-marker"));
        for (WebElement obj : elements) {
            try {
                WebElement img = obj.findElement(By.tagName("img"));
                Thread.sleep(500);
                img.click();
                System.out.println(i++);
                Thread.sleep(1000);
            }catch (Exception e){
                System.err.println(e);
            }
        }


    }

}
