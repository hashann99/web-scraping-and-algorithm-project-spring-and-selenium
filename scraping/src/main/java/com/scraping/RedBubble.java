package com.scraping;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class RedBubble {
    FirefoxDriver firefoxDriver = null;
    public void start() throws InterruptedException {
        firefoxDriver = new Driver().getFirefoxDriver();
        scrape();
        firefoxDriver.close();
    }

    private void scrape() throws InterruptedException {
        firefoxDriver.get("https://www.redbubble.com/auth/login");


       firefoxDriver.findElement(By.xpath("//*[@id=\"RB_React_Component_LoginFormContainer_0\"]/div/form/span/button")).click();
        Thread.sleep(20000);
        System.out.println("login pass");
       for (int x=1;x<=60;x++) {
           try {
               firefoxDriver.get("https://www.redbubble.com/portfolio/images/new?ref=account-nav-dropdown");
               Thread.sleep(15000);

               firefoxDriver.findElementByXPath("//*[@id=\"select-image-single\"]").sendKeys("D:\\POD_Image\\" + x + ".png");
               Thread.sleep(1000*40);


               firefoxDriver.findElement(By.id("work_title_en")).sendKeys("Beautiful Pet World - No #" + x);

               firefoxDriver.findElement(By.id("work_tag_field_en")).sendKeys("dog, cute, puppy, dogs, funny, animal, pet, puppies,love, kawaii, cat, golden retriever, paw, \n" +
                       "fun, pup, memes, pack, trending, labrador retriever, meme, animals, doggo,\n" +
                       "corgi, dog lover, pets, trendy,  labrador, tumblr, shiba inu, pupper");

               firefoxDriver.findElement(By.id("work_description_en")).sendKeys("This is based on art. This is a design of a pet. I believe it is a very good design for a lover of pets");


               JavascriptExecutor jse = (JavascriptExecutor) firefoxDriver;
               jse.executeScript("window.scrollBy(0,5500)");

               List<String>all_disable_product=new ArrayList<>();
               all_disable_product.add("//*[@id=\"add-new-work\"]/section[1]/div/div[7]/div[2]/div[4]/div[2]/div[2]");
               all_disable_product.add("//*[@id=\"add-new-work\"]/section[1]/div/div[14]/div[1]/div[4]/div[2]/div[2]");
               all_disable_product.add("//*[@id=\"add-new-work\"]/section[1]/div/div[21]/div[1]/div[4]/div[2]/div[2]");
               all_disable_product.add("//*[@id=\"add-new-work\"]/section[1]/div/div[34]/div[3]/div[4]/div[2]/div[2]");
               all_disable_product.add("//*[@id=\"add-new-work\"]/section[1]/div/div[34]/div[3]/div[4]/div[2]/div[2]");
               all_disable_product.add("//*[@id=\"add-new-work\"]/section[1]/div/div[34]/div[2]/div[4]/div[2]/div[2]");
               all_disable_product.add("//*[@id=\"add-new-work\"]/section[1]/div/div[34]/div[1]/div[4]/div[2]/div[2]");
               all_disable_product.add("//*[@id=\"add-new-work\"]/section[1]/div/div[41]/div[3]/div[4]/div[2]/div[2]");
               all_disable_product.add("//*[@id=\"add-new-work\"]/section[1]/div/div[59]/div[3]/div[4]/div[2]/div[2]");
               all_disable_product.add("//*[@id=\"add-new-work\"]/section[1]/div/div[66]/div[3]/div[4]/div[2]/div[2]");
               all_disable_product.add("//*[@id=\"add-new-work\"]/section[1]/div/div[66]/div[1]/div[4]/div[2]/div[2]");
               all_disable_product.add("//*[@id=\"add-new-work\"]/section[1]/div/div[73]/div[3]/div[4]/div[2]/div[2]");
               all_disable_product.add("//*[@id=\"add-new-work\"]/section[1]/div/div[80]/div[2]/div[4]/div[2]/div[2]");
               all_disable_product.add("//*[@id=\"add-new-work\"]/section[1]/div/div[87]/div[3]/div[4]/div[2]/div[2]");
               all_disable_product.add("//*[@id=\"add-new-work\"]/section[1]/div/div[87]/div[1]/div[4]/div[2]/div[2]");
               all_disable_product.add("//*[@id=\"add-new-work\"]/section[1]/div/div[95]/div[2]/div[4]/div[2]/div[2]");
               all_disable_product.add("//*[@id=\"add-new-work\"]/section[1]/div/div[95]/div[3]/div[4]/div[2]/div[2]");
               all_disable_product.add("//*[@id=\"add-new-work\"]/section[1]/div/div[102]/div[2]/div[4]/div[2]/div[2]");



               for (int i=0;i<all_disable_product.size();i++){
                   try {
                       firefoxDriver.findElement(By.xpath(all_disable_product.get(i))).click();
                   } catch (Exception e) {
                       System.out.println(e);
                   }
               }
               // enable buttons



               firefoxDriver.findElement(By.id("media_design")).click();
            //   firefoxDriver.findElement(By.id("work_group_ids_2768660")).click();
               firefoxDriver.findElement(By.id("work_safe_for_work_true")).click();
               firefoxDriver.findElement(By.id("rightsDeclaration")).click();
               firefoxDriver.findElement(By.id("submit-work")).click();
               System.out.println(x+ " Uploaded");
           }catch (Exception e){
               System.err.println(x +" Not Uploaded");
               x--;
           }
           Thread.sleep(25000);
       }
    }
}
