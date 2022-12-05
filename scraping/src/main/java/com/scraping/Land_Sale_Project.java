package com.scraping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class Land_Sale_Project {

    FirefoxDriver firefoxDriver = null; FileWriter fileWriter = null; String owner_Name = ""; double sqft = 0; int year_Built = 0; double salary = 0;

    public void start_Scrape()throws Exception {
        fileWriter = new FileWriter("C:/Users/Hash/Desktop/Data_sheet.csv");
        firefoxDriver = new Driver().getFirefoxDriver();


        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Hash/Desktop/DataFile.csv"))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                clear_all_variable();
                scrape(line.split(",")[1], line);
            }
        }
        firefoxDriver.close();
    }

    private void scrape(String address, String line) {

        try {
            firefoxDriver.get("http://www.bcad.org/clientdb/?cid=1");
            firefoxDriver.findElement(By.xpath("//*[@id=\"propertySearchOptions_searchText\"]")).sendKeys(address);
            firefoxDriver.findElement(By.xpath("//*[@id=\"propertySearchOptions_search\"]")).click();
            String temp=firefoxDriver.findElement(By.xpath("/html/body/form/div[3]/div[2]/table/tbody/tr[2]/td[9]")).getText().replaceAll(",",".");
            firefoxDriver.findElement(By.xpath("/html/body/form/div[3]/div[2]/table/tbody/tr[2]/td[10]/a")).click();
            firefoxDriver.findElement(By.xpath("/html/body/form/div/div[5]/div[1]/span/input")).click();
            salary=Double.parseDouble(temp.replaceAll("\\$","").split("\\.")[0]);


            WebElement propertyDetails = firefoxDriver.findElement(By.id("propertyDetails"));
            List<WebElement> tr = propertyDetails.findElements(By.tagName("tr"));
            for (WebElement data : tr) {
                if (data.getText().contains("Name")) {
                    owner_Name = data.getText().split("Owner")[0].replaceAll("Name:", "");

                }
            }

          //  WebElement improvementBuildingDetails = firefoxDriver.findElementById("improvementBuildingDetails");
       //     WebElement improvementDetails = improvementBuildingDetails.findElement(By.className("improvementDetails"));
         //   WebElement tr1 = improvementDetails.findElements(By.tagName("tr")).get(1);
//            sqft = Double.parseDouble(tr1.findElements(By.tagName("td")).get(6).getText());

        } catch (Exception e) {
            System.err.println("error "+line);
            System.out.println(e);
        }


        try {
            owner_Name=remove_Last_index(owner_Name);
            if (sqft >= 900 && year_Built >= 1930 && year_Built <= 2000 && salary < 160 && !owner_Name.contains("LLC") && !owner_Name.contains("TRUST")) {

                String[] split = owner_Name.split("&");
                System.out.println("len "+split.length);
                if (split.length == 1) {
                    String newOwnerName = set_Name(owner_Name.trim());
                    System.out.println(newOwnerName);
                    fileWriter.write(owner_Name + "," + newOwnerName + "," + line + "," +  salary + "," + year_Built + "," + sqft + "\n");
                    fileWriter.flush();
                } else {
                    for (int i = 0; i < split.length; i++) {
                        String newOwnerName = set_Name(split[i].trim());
                        fileWriter.write(owner_Name + "," + newOwnerName + "," + line + "," + salary + "," + year_Built + "," + sqft + "\n");
                        fileWriter.flush();
                    }
                }
                print(1,line);
            } else {
                print(0,line);
            }
        } catch (Exception e) {
            System.out.println("Error csv : " + e);
        }
    }
    public String remove_Last_index(String str) {
        if(str.endsWith("&")){
            str=str.replaceAll("&","");
        }
        return str;
    }

    private String set_Name(String ownerName) {
        //       LAST, FIRST, MIDDLE ----- > FIRST,MIDDLE,LAST
        String[] s1 = ownerName.split(" ");
        String name = "";
        System.out.println(s1.length);
        if(s1.length == 2 && !ownerName.contains("&")){
            name = s1[1] + " " + s1[0];
        } else if(s1.length == 3 && !ownerName.contains("&")) {
            name = s1[1] + " " + s1[2]+ " " + s1[0];
        } else if (s1.length == 4 && !ownerName.contains("&")) {
            name = s1[1] + " " + s1[2] + " " + s1[3]+ " " + s1[0];
        } else {
            name = "Check Please";
        }
        return name.replaceAll(",", " ");
    }


    private void print(int num,String line) {
        if (num == 1) {
            System.out.println("Owner Name     : " + owner_Name);
            System.out.println("Salary         : " + salary);
            System.out.println("Sqft           : " + sqft);
            System.out.println("Year Built     : " + year_Built);
        } else {
            System.out.println(line);
            System.err.println("Owner Name     : " + owner_Name);
            System.err.println("Salary         : " + salary);
            System.err.println("Sqft           : " + sqft);
            System.err.println("Year Built     : " + year_Built);
        }
    }

    private void clear_all_variable() {
        owner_Name = "";
        sqft = 0;
        year_Built = 0;
        salary = 0;
    }
}

//item-title block
