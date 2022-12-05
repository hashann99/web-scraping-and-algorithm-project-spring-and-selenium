package com.scraping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileWriter;
import java.util.List;

public class Ebay {


    public void start() {
        FileWriter fileWriter=null;
        String name="";
        String price;
        try {
             fileWriter= new FileWriter("ebay.csv");
        }catch (Exception r){}
        FirefoxDriver firefoxDriver = new Driver().getFirefoxDriver();
        for (int i = 1; i < 10; i++) {

            firefoxDriver.get("https://www.ebay.com/sch/i.html?_from=R40&_nkw=laptop&_sacat=0&_pgn="+i);

            List<WebElement> elements = firefoxDriver.findElements(By.className("s-item__title"));
            for (WebElement data : elements) {
                name=data.getText();
                System.out.println(name);
            }

            List<WebElement> elements1 = firefoxDriver.findElements(By.className("s-item__price"));
            for (WebElement data : elements1) {
                System.out.println(data.getText());
            }
            try{
                fileWriter.write(name.replaceAll("/"," ")+"\n");
                fileWriter.flush();

            }catch (Exception e){}
            System.out.println("_______________________________________________");
        }
    }
}
