package com.scraping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Kapruka {
    public void start() {
        String productName="";
        String brandName="";
        String deliveryTime="";
        String price="";
        String isInStock="";
        String imgUrl="";



        FirefoxDriver firefoxDriver = new Driver().getFirefoxDriver();


        firefoxDriver.get("https://www.kapruka.com/buyonline/luvesence-wild-strawberry-bo/kid/cosmetics00903");

try {
    WebElement element = firefoxDriver.findElement(By.id("view-product"));
    imgUrl = element.findElement(By.tagName("img")).getAttribute("src");
}catch (Exception e){

}


        WebElement elements = firefoxDriver.findElement(By.className("product-information"));
        try {
            productName = elements.getText().split("\n")[0];
        }catch (Exception e){

        }
         try {
             price = elements.findElement(By.className("price")).getText();
         }catch (Exception e){

         }
         try {
             brandName = elements.findElement(By.className("ex")).getText();
         }catch (Exception e){

         }

        String[] greentxts = elements.findElement(By.className("greentxt")).getText().split("\n");
        if(greentxts.length==2){
             deliveryTime=greentxts[0];
             isInStock=greentxts[1];

        }
        if(greentxts.length==3){
             deliveryTime=greentxts[0];
             isInStock=greentxts[2];

        }

        System.out.println("Product Name : "+productName );
        System.out.println("Price : "+price );
        System.out.println("Delivery Time : "+deliveryTime );
        System.out.println("InStock : "+isInStock );
        System.out.println("Brand Name : "+brandName );
        System.out.println("URL : "+imgUrl );

    }

}

