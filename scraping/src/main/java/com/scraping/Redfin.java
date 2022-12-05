package com.scraping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class Redfin {
    FirefoxDriver firefoxDriver = null;
    FileWriter fileWriter = null;

    public void start_scrape() throws Exception {
        fileWriter = new FileWriter("C:/Users/Hash/Desktop/Final.csv",true);
        firefoxDriver = new Driver().getFirefoxDriver();

        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Hash/Desktop/Data_sheet2.csv"))) {
            String line = "";
            int i=0;
            while ((line = br.readLine()) != null) {
                i++;
                System.out.println(i + "===========================================================");
                scrape(line.split(",")[2], line);
            }
        }
    }

    private void scrape(String address, String line) {
        firefoxDriver.get("https://www.redfin.com/TX/San-Antonio/510-Dawnview-Ln-78213/home/48924553");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            firefoxDriver.findElementById("search-box-input").sendKeys(address);
        }catch (Exception e){
            try {
                Thread.sleep(1500);
                firefoxDriver.findElementById("search-box-input").sendKeys(address);
            } catch (Exception e1) {
                System.out.println(e);
            }

        }
        try {
            Thread.sleep(6000);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            firefoxDriver.findElements(By.className("item-title")).get(0).click();
            Thread.sleep(1500);
        } catch (Exception e) {
            try {
                firefoxDriver.findElementByClassName("SearchButton ").click();
            }catch (Exception r){}
        }
        String beds = "";
        String status = "";
        int bed = 0;
        try {
            WebElement homeMainStats = firefoxDriver.findElementByClassName("HomeMainStats");
            List<WebElement> elements = homeMainStats.findElements(By.className("info-block"));
            for (WebElement data : elements) {
                if (data.getText().replaceAll("\n", " ").contains("Beds")) {
                    beds = data.getText().replaceAll("\n", " ").replaceAll("Beds", "").trim();
                }
            }
        } catch (Exception e) {
            System.out.println("beds error " + e);
        }
        try {
            WebElement elementByClassName = firefoxDriver.findElementByClassName("photo-selected");
            status = elementByClassName.findElement(By.className("HomeSash")).getText();

        } catch (Exception e) {
            System.out.println("status error" + e);
        }

        try {
            if (beds.contains("2") || beds.contains("3") || beds.contains("4") && status.contains("MARKET") || status.contains("SALE") && !status.contains("SOLD")) {
                fileWriter.write(line + "," + beds + "," + status + "\n");
                fileWriter.flush();
                System.out.println("Beds    : " + beds);
                System.out.println("Status  : " + status);
            }else{
                System.err.println("Beds    : " + beds);
                System.err.println("Status  : " + status);
            }

        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
