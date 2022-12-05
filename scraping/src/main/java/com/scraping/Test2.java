package com.scraping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test2 {
    void start(){
        FileWriter fileWriter=null;
        List<String>list=new ArrayList<>();
        try {
             fileWriter = new FileWriter("C:/Users/Hash/Desktop/Sample_Data_Sheet.csv",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Driver driver = new Driver();
        FirefoxDriver firefoxDriver = driver.getFirefoxDriver();

        firefoxDriver.get("https://www.enfsolar.com/directory/installer/Austria");
        WebElement element1 = firefoxDriver.findElement(By.className("enf-list-table"));
        List<WebElement> trs = element1.findElements(By.tagName("tr"));
        for (WebElement tr:trs){
            try{
                WebElement td = tr.findElement(By.tagName("td"));
                String attribute = td.findElement(By.tagName("a")).getAttribute("href");
                System.out.println(attribute);
                list.add(attribute);
            }catch (Exception e){}

        }


        for (String data:list){

            firefoxDriver.get(data);


            WebElement element = firefoxDriver.findElement(By.className("enf-company-profile-info-main"));

            String text = element.getText();
            String[] split = text.split("\n");

            if(split.length==4){
                System.out.println(split[0]);
                System.out.println(split[1]);
                System.out.println(split[2]);
                System.out.println(split[3]);
            }

            if(split.length==5){
                System.out.println(split[0]);
                System.out.println(split[1]);
                System.out.println(split[2]);
                System.out.println(split[3]);
                System.out.println(split[4]);
            }

            if(split.length==6){
                System.out.println(split[0]);
                System.out.println(split[1]);
                System.out.println(split[2]);
                System.out.println(split[3]);
                System.out.println(split[4]);
                System.out.println(split[5]);
            }
            System.out.println("---------------------------------------------");

        }

    }
}
