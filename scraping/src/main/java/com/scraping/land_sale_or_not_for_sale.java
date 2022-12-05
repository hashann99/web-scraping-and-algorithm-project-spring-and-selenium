package com.scraping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class land_sale_or_not_for_sale {
    FirefoxDriver firefoxDriver = null;
    String owner_Name="";
    String Sqft="";
    String date="";
    String type="";
    String salary="";
    String sold="";
    String description="";
    FileWriter fileReader=null;
    FileWriter fileReader2=null;


    public void start_scrape() throws Exception {
        //   fileReader = new FileWriter("/home/hashan/Desktop/Demo2/last_8.csv", true);
        //  fileReader2 = new FileWriter("/home/hashan/Desktop/Demo2/last_7.csv", true);
        firefoxDriver = new Driver().getFirefoxDriver();

        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Hash/Desktop/DataFile.csv"))) {
            String line;
            while ((line = br.readLine()) != null){
                owner_Name="";
                Sqft="";
                date="";
                salary="";
                type="";
                description="";
                //   create_last_file(line.split(",")[5],line);
                // set_names(line.split(",")[5],line);
                site_one(line.split(",")[1],line);
                //   clear_data(line);
            }
        }
    }

    // clear empty rows on excel sheet
    private void clear_data(String line){
        String[] split = line.split(",");
        try{
            String data=split[7];
            if(data.equalsIgnoreCase("Deed")){
                System.out.println(line);
            }else{
                fileReader.write(line+"\n");
                fileReader.flush();
                System.err.println(line);
            }

        }catch (Exception e){
            try {
                fileReader2.write(line+"\n");
                fileReader2.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            System.out.println(line);
        }

    }
    // get all detail into excel sheet
    private void site_one(String address,String line) throws ParseException, IOException, InterruptedException {
        try {
            firefoxDriver.get("http://www.bcad.org/clientdb/?cid=1");
            firefoxDriver.findElement(By.xpath("//*[@id=\"propertySearchOptions_searchText\"]")).sendKeys(address);
            firefoxDriver.findElement(By.xpath("//*[@id=\"propertySearchOptions_search\"]")).click();
            salary = firefoxDriver.findElement(By.xpath("/html/body/form/div[3]/div[2]/table/tbody/tr[2]/td[9]")).getText().replaceAll(",",".");
            firefoxDriver.findElement(By.xpath("/html/body/form/div[3]/div[2]/table/tbody/tr[2]/td[10]/a")).click();
            firefoxDriver.findElement(By.id("land")).click();
            firefoxDriver.findElement(By.id("deedHistory")).click();
//            WebElement propertyDetails = firefoxDriver.findElement(By.id("propertyDetails"));
//            List<WebElement> tr = propertyDetails.findElements(By.tagName("tr"));
//            for (WebElement data:tr){
//                if (data.getText().contains("Name")){
//                    owner_Name= data.getText().split("Owner")[0].replaceAll("Name:","");
//                }
//            }
            WebElement landDetails = firefoxDriver.findElement(By.id("landDetails"));
            List<WebElement> tr1 = landDetails.findElements(By.tagName("tr"));
            for (WebElement data:tr1){
                if(! data.getText().contains("# Type")){
                    Sqft=data.getText().split("\n")[0].split("Single")[1].split(" ")[2];
                }
            }

            WebElement historyDetails = firefoxDriver.findElement(By.id("deedHistoryDetails_deedHistoryTable"));
            List<WebElement> tr2 = historyDetails.findElements(By.tagName("tr"));
            for (int i=0;i<tr2.size();i++){
                if(i==1){
                    String text = tr2.get(i).getText();
                    text=text.split("\n")[0];
                    String[] s = text.split(" ");
                    date=s[1];
                    type=s[2];
                    for (int u=3;u<s.length;u++){
                        description +=s[u]+" ";
                    }
                }
            }
        }catch (Exception e){ }


        System.out.println(line+","+owner_Name +","+salary+","+date +  ","+Sqft +  ","+type +  ","+description);
        fileReader.write(line+","+owner_Name +","+salary+","+date +  ","+Sqft +  ","+type +  ","+description+","+sold.split("\n")[0].replaceAll(",","")+"\n");
        fileReader.flush();
        // System.out.println(owner_Name +  " :  "+Sqft +  " :  "+date +  " :  "+type +  " :  "+description);

    }

    private void get_data() throws InterruptedException {
        FirefoxDriver firefoxDriver = new Driver().getFirefoxDriver();
        firefoxDriver.get("https://www.tobacco1.com/cigar-importers");
        Thread.sleep(6000);
        List<WebElement> list = firefoxDriver.findElements(By.tagName("a"));
        for (WebElement link : list) {
            System.out.println(link.getAttribute("href"));
        }

        //   francescosaverio.canepa@gmail.com
        //    g4YY5CSb64YuMXt

    }

    // there is & on names
    private void create_last_file(String s, String line){
        try {
            String[] split = s.split("&");
            System.out.println(split.length + "   : " + s);
            if (split.length == 2) {
                fileReader.write(split[0] + "," + line + "\n");
                fileReader.flush();
                fileReader.write(split[1] + "," + line + "\n");
                fileReader.flush();
            } else {
                fileReader2.write(line + "\n");
                fileReader2.flush();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private void set_names(String s, String line) throws IOException {
        String[] s1 = s.split(" ");

        System.out.println(s1.length+ "  :  "+s);
//
        if (s1.length==3 && ! s.contains("&")) {
            fileReader.write(s1[2].replaceAll(",", " ") + " " + s1[1].replaceAll(",", " ") + "," + line + "\n");
            fileReader.flush();
        }else if(s1.length==4 && ! s.contains("&")){
            fileReader.write(s1[2]+" "+s1[3]+" "+s1[1]+"," + line + "\n");
            fileReader.flush();
            //       LAST, FIRST, MIDDLE
        }else{
            fileReader2.write(line+"\n");
            fileReader2.flush();
        }
    }


    private void clear_data_with_date() {
        try {
            fileReader = new FileWriter("/home/hashan/Desktop/Demo2/last_4.csv");
            fileReader2 = new FileWriter("/home/hashan/Desktop/empty.csv");
        }catch (Exception e){}

        try {
            //   firefoxDriver = new Driver().getFirefoxDriver();
            try (BufferedReader br = new BufferedReader(new FileReader("/home/hashan/Desktop/Demo2/empty.csv"))) {
                String line;
                int i=1;
                while ((line = br.readLine()) != null) {
                    try {
                        //  line.split(",")[6];
                        int y=Integer.parseInt(line.split(",")[7].split("/")[2]);

                        if(y<2010){
                            System.out.println(i++);
                            System.out.println(line.split(",")[7].split("/")[2]);
                            fileReader.write(line+"\n");
                            fileReader.flush();
                        }
                    }catch (IndexOutOfBoundsException e){
                        fileReader2.write(line+"\n");
                        fileReader2.flush();
                    }

                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private void site_three(String s,String line)  {
        WebElement search_box=null;
        try {
            firefoxDriver.get("https://www.redfin.com/");
            search_box = firefoxDriver.findElement(By.id("tabContentId0"));
        }catch (Exception e){}
        try {
            search_box.findElement(By.id("search-box-input")).sendKeys(s);
        }catch (Exception e){
            try {
                firefoxDriver.findElement(By.xpath("//*[@id=\"search-box-input\"]")).sendKeys(s);

            }catch (Exception e1){}

        }
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            sold = firefoxDriver.findElement(By.className("PhotoArea")).getText();
            fileReader.write(line+","+sold.replaceAll(",","")+"\n");
            fileReader.flush();
        }catch (Exception e){
            try {
                Thread.sleep(4000);
            } catch (Exception e1) {
                e.printStackTrace();
            }
        }
    }

/*
    private void site_two(String address) throws InterruptedException {
        firefoxDriver.get("https://bexar.acttax.com/act_webdev/bexar/index.jsp");
        firefoxDriver.findElement(By.xpath("/html/body/div/table/tbody/tr[1]/td/table/tbody/tr/td/center/form/table/tbody/tr[3]/td[2]/div[2]/select")).sendKeys("Property Address");
        firefoxDriver.findElement(By.xpath("//*[@id=\"criteria\"]")).sendKeys(address);
        firefoxDriver.findElement(By.xpath("//*[@id=\"criteria\"]")).sendKeys(Keys.RETURN);
    }
*/


}
