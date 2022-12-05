package com.scraping;


import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : sadunv
 * @created : 31/08/2022 - 10:26 AM
 * @project : WebScrapping
 **/


public class ArpicoSuperController {

    FirefoxDriver firefoxDriver = null;
    HashMap<String, String> urlList = new HashMap<>();
    JSONArray array = new JSONArray();

  //  Gson gson = new Gson();


    public ResponseEntity<String> newEndpoint() {

        firefoxDriver = new Driver().getFirefoxDriver();
        ResponseEntity<String> scrape = scrape();
        System.out.println(scrape.toString());
        firefoxDriver.close();
        return new ResponseEntity<>(scrape.getBody(), HttpStatus.OK);
    }

    private ResponseEntity<String> scrape() {

        ResponseEntity<String> responseEntity = null;
        urlList.clear();
        urlList.put("Milk", "https://arpicosupercentre.com/catalog/category/view/id/552/?cat=553#cat=milk");

        for (Map.Entry<String, String> s : urlList.entrySet()) {
//            int pageNo = getPageNo(s.getValue());
//            for (int i = 1; i <= pageNo; i++) {
                responseEntity = scrape_start(s.getValue()+"&p="+2, s.getKey());
//            }

        }
        return new ResponseEntity<String>(responseEntity.getBody(), HttpStatus.OK);
    }

    private ResponseEntity<String> scrape_start(String url, String key) {

        firefoxDriver.get(url);
        System.out.println(url);
        ResponseEntity<String> data = getData(url, key);
        return new ResponseEntity<String>(data.getBody(), HttpStatus.OK);

    }

    private ResponseEntity<String> getData(String url, String key) {

        List<WebElement> elements = firefoxDriver.findElements(By.className("product-item-link"));
        List<WebElement> imageElement = firefoxDriver.findElements(By.className("main-image"));
        List<WebElement> elements1 = firefoxDriver.findElements(By.className("price-box"));

        try {
            for (int i = 0; i < elements.size(); i++) {

                String urlI = elements.get(i).getAttribute("href");
                String name = elements.get(i).getText();
                WebElement img = imageElement.get(i).findElement(By.tagName("img"));
                String imgUrl = img.getAttribute("src");

                String price = "";
                List<WebElement> specPrice = elements1.get(i).findElements(By.className("special-price"));
                List<WebElement> normalPrice = elements1.get(i).findElements(By.className("price-final_price"));
                if (specPrice.size() == 1) {
                    System.out.println("A");
                    price = specPrice.get(0).findElement(By.className("price")).getText();
                } else {
                    System.out.println("B");
                    price = normalPrice.get(0).findElement(By.className("price")).getText();
                }

                JSONObject object = new JSONObject();
                object.put("company_name", "Arpico Super Center");
                object.put("item_name", name);
                object.put("item_price", price);
                object.put("product_url", urlI);
                object.put("item_img_url", imgUrl);
                object.put("category", key);

                array.add(object);
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return new ResponseEntity<String>(null);

    }

    public int getPageNo(String url) {
        firefoxDriver = new Driver().getFirefoxDriver();
        firefoxDriver.get(url);
        int pageNo = 0;

        try {
            List<WebElement> element = firefoxDriver.findElements(By.className("toolbar-number"));
            String text = element.get(0).getText();
            System.out.println(text);
            double page = Double.parseDouble(text);
            double a = page / 16;
            pageNo = (int) Math.round(a + 0.5);
        } catch (Exception e) {
            e.getMessage();
        }
        return pageNo;
    }

}
