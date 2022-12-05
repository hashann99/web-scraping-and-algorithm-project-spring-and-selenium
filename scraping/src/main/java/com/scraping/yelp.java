package com.scraping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class yelp {

    FirefoxDriver firefoxDriver = null;
    String companyName;
    String address;
    String telephone;
    String typeOfCompanay;
    String state = "Florida";
    String city = "";
    String url;
    String link;
    FileWriter fileWriter = null;
    List<String> nameList = new ArrayList<>();
    HashMap<String, String> urlList = new HashMap<>();

    public void start() throws IOException {
        fileWriter = new FileWriter("DataSheet.csv", true);
        firefoxDriver = new Driver().getFirefoxDriver();
        scrape();
        firefoxDriver.close();
    }

    public void scrape() {

//        urlList.put("Tampa", "https://www.yelp.com/search?find_desc=florida&find_loc=Tampa&start=");
//        urlList.put("Miami", "https://www.yelp.com/search?find_desc=florida&find_loc=Miami&start=");
//        urlList.put("Orlando", "https://www.yelp.com/search?find_desc=florida&find_loc=Orlando&start=");

//        urlList.put("Cocoa", "https://www.yelp.com/search?find_desc=florida&find_loc=Cocoa&start=");
//        urlList.put("Cocoa Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=Cocoa%20Beach&start=");
//        urlList.put("Coconut Creek", "https://www.yelp.com/search?find_desc=florida&find_loc=Coconut%20Creek&start=");
//        urlList.put("Coral Gables", "https://www.yelp.com/search?find_desc=florida&find_loc=Coral%20Gables&start=");
//        urlList.put("Coral Springs", "https://www.yelp.com/search?find_desc=florida&find_loc=Coral%20Springs&start=");
//        urlList.put("Crystal River", "https://www.yelp.com/search?find_desc=florida&find_loc=Crystal%20River&start=");
//        urlList.put("Dania Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=Dania%20Beach&start=");
//        urlList.put("Davie", "https://www.yelp.com/search?find_desc=florida&find_loc=Davie&start=");
//        urlList.put("Daytona Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=Daytona%20Beach&start=");
//        urlList.put("Deerfield Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=Deerfield%20Beach&start=");
//        urlList.put("DeFuniak Springs", "https://www.yelp.com/search?find_desc=florida&find_loc=DeFuniak%20Springs&start=");
//        urlList.put("DeLand", "https://www.yelp.com/search?find_desc=florida&find_loc=DeLand&start=");
//
        urlList.put("Delray Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=Delray%20Beach&start=");
        urlList.put("Deltona", "https://www.yelp.com/search?find_desc=florida&find_loc=Deltona&start=");
        urlList.put("Destin", "https://www.yelp.com/search?find_desc=florida&find_loc=Destin&start=");
        urlList.put("Dunedin", "https://www.yelp.com/search?find_desc=florida&find_loc=Dunedin&start=");
        urlList.put("Eagle Lake", "https://www.yelp.com/search?find_desc=florida&find_loc=Eagle%20Lake&start=");
        urlList.put("Edgewater", "https://www.yelp.com/search?find_desc=florida&find_loc=Edgewater&start=");
        urlList.put("Edgewood", "https://www.yelp.com/search?find_desc=florida&find_loc=Edgewood&start=");
        urlList.put("Eustis", "https://www.yelp.com/search?find_desc=florida&find_loc=Eustis&start=");
        urlList.put("Temple Terrace", "https://www.yelp.com/search?find_desc=florida&find_loc=Temple%20Terrace&start=");
        urlList.put("Titusville", "https://www.yelp.com/search?find_desc=florida&find_loc=Titusville&start=");
//        urlList.put("Treasure Island", "https://www.yelp.com/search?find_desc=florida&find_loc=Treasure%20Island&start=");
//        urlList.put("Valparaiso", "https://www.yelp.com/search?find_desc=florida&find_loc=Valparaiso&start=");
//        urlList.put("Venice", "https://www.yelp.com/search?find_desc=florida&find_loc=Venice&start=");
//        urlList.put("Vero Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=Vero%20Beach&start=");
//        urlList.put("Wellington", "https://www.yelp.com/search?find_desc=florida&find_loc=Wellington&start=");
//        urlList.put("West Melbourne", "https://www.yelp.com/search?find_desc=florida&find_loc=West%20Melbourne&start=");
//        urlList.put("West Palm Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=West%20Palm%20Beach&start=");
//        urlList.put("Weston", "https://www.yelp.com/search?find_desc=florida&find_loc=Weston&start=");
//        urlList.put("Wilton Manors", "https://www.yelp.com/search?find_desc=florida&find_loc=Wilton%20Manors&start=");
//        urlList.put("Winter Garden", "https://www.yelp.com/search?find_desc=florida&find_loc=Winter%20Garden&start=");
//        urlList.put("Winter Haven", "https://www.yelp.com/search?find_desc=florida&find_loc=Winter%20Haven&start=");
//        urlList.put("Winter Park", "https://www.yelp.com/search?find_desc=florida&find_loc=Winter%20Park&start=");
//        urlList.put("Winter Springs", "https://www.yelp.com/search?find_desc=florida&find_loc=Winter%20Springs&start=");
//        urlList.put("Bradenton", "https://www.yelp.com/search?find_desc=florida&find_loc=Bradenton&start=");
//        urlList.put("Brooksville", "https://www.yelp.com/search?find_desc=florida&find_loc=Brooksville&start=");
//        urlList.put("Cape Canaveral", "https://www.yelp.com/search?find_desc=florida&find_loc=Cape%20Canaveral&start=");
//        urlList.put("Cape Coral", "https://www.yelp.com/search?find_desc=florida&find_loc=Cape%20Coral&start=");
//        urlList.put("Casselberry", "https://www.yelp.com/search?find_desc=florida&find_loc=Casselberry&start=");
//        urlList.put("Chipley", "https://www.yelp.com/search?find_desc=florida&find_loc=Chipley&start=");
//        urlList.put("Cinco Bayou", "https://www.yelp.com/search?find_desc=florida&find_loc=Cinco%20Bayou&start=");
//        urlList.put("Clearwater", "https://www.yelp.com/search?find_desc=florida&find_loc=Clearwater&start=");
//        urlList.put("Clermont", "https://www.yelp.com/search?find_desc=florida&find_loc=Clermont&start=");
//        urlList.put("Fort Meade", "https://www.yelp.com/search?find_desc=florida&find_loc=Fort%20Meade&start=");
//        urlList.put("Fort Myers", "https://www.yelp.com/search?find_desc=florida&find_loc=Fort%20Myers&start=");
//        urlList.put("Fort Myers Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=Fort%20Myers%20Beach&start=");
//        urlList.put("Fort Walton Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=Fort%20Walton%20Beach&start=");
//        urlList.put("Fruitland Park", "https://www.yelp.com/search?find_desc=florida&find_loc=Fruitland%20Park&start=");
//        urlList.put("Gainesville", "https://www.yelp.com/search?find_desc=florida&find_loc=Gainesville&start=");
//        urlList.put("Greenacres", "https://www.yelp.com/search?find_desc=florida&find_loc=Greenacres&start=");
//        urlList.put("Green Cove Springs", "https://www.yelp.com/search?find_desc=florida&find_loc=Green%20Cove%20Springs&start=");
//        urlList.put("Gulf Breeze", "https://www.yelp.com/search?find_desc=florida&find_loc=Gulf%20Breeze&start=");
//        urlList.put("Gulfport", "https://www.yelp.com/search?find_desc=florida&find_loc=Gulfport&start=");
//        urlList.put("Hallandale Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=Hallandale%20Beach&start=");
//        urlList.put("Hawthorne", "https://www.yelp.com/search?find_desc=florida&find_loc=Hawthorne&start=");
//        urlList.put("Hialeah", "https://www.yelp.com/search?find_desc=florida&find_loc=Hialeah&start=");
//        urlList.put("Hialeah Gardens", "https://www.yelp.com/search?find_desc=florida&find_loc=Hialeah%20Gardens&start=");
//        urlList.put("Highland Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=Highland%20Beach&start=");
//        urlList.put("Hollywood", "https://www.yelp.com/search?find_desc=florida&find_loc=Hollywood&start=");
//        urlList.put("Holly Hill", "https://www.yelp.com/search?find_desc=florida&find_loc=Holly%20Hill&start=");
//        urlList.put("Holmes Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=Holmes%20Beach&start=");
//        urlList.put("Homestead", "https://www.yelp.com/search?find_desc=florida&find_loc=Homestead&start=");
//        urlList.put("Hypoluxo", "https://www.yelp.com/search?find_desc=florida&find_loc=Hypoluxo&start=");
//        urlList.put("Indialantic", "https://www.yelp.com/search?find_desc=florida&find_loc=Indialantic&start=");
//        urlList.put("Jacksonville", "https://www.yelp.com/search?find_desc=florida&find_loc=Jacksonville&start=");
//        urlList.put("Jupiter", "https://www.yelp.com/search?find_desc=florida&find_loc=Jupiter&start=");
//        urlList.put("Key Biscayne", "https://www.yelp.com/search?find_desc=florida&find_loc=Key%20Biscayne&start=");
//        urlList.put("Key West", "https://www.yelp.com/search?find_desc=florida&find_loc=Key%20West&start=");
//        urlList.put("Kissimmee", "https://www.yelp.com/search?find_desc=florida&find_loc=Kissimmee&start=");
//        urlList.put("LaBelle", "https://www.yelp.com/search?find_desc=florida&find_loc=LaBelle&start=");
//        urlList.put("Lady Lake", "https://www.yelp.com/search?find_desc=florida&find_loc=Lady%20Lake&start=");
//        urlList.put("Lake Alfred", "https://www.yelp.com/search?find_desc=florida&find_loc=Lake%20Alfred&start=");
//        urlList.put("Lakeland", "https://www.yelp.com/search?find_desc=florida&find_loc=Lakeland&start=");
//        urlList.put("Lake Mary", "https://www.yelp.com/search?find_desc=florida&find_loc=Lake%20Mary&start=");
//        urlList.put("Lake Park", "https://www.yelp.com/search?find_desc=florida&find_loc=Lake%20Park&start=");
//        urlList.put("Lake Wales", "https://www.yelp.com/search?find_desc=florida&find_loc=Lake%20Wales&start=70");
//        urlList.put("Lake Worth", "https://www.yelp.com/search?find_desc=florida&find_loc=Lake%20Worth&start=");
//        urlList.put("Lantana", "https://www.yelp.com/search?find_desc=florida&find_loc=Lantana&start=");
//        urlList.put("Largo", "https://www.yelp.com/search?find_desc=florida&find_loc=Largo&start=");
//        urlList.put("Lauderdale By The Sea", "https://www.yelp.com/search?find_desc=florida&find_loc=Lauderdale%20By%20The%20Sea&start=");
//        urlList.put("Lauderhill", "https://www.yelp.com/search?find_desc=florida&find_loc=Lauderhill&start=");
//        urlList.put("Leesburg", "https://www.yelp.com/search?find_desc=florida&find_loc=Lauderhill&start=");
//        urlList.put("Lighthouse Point", "https://www.yelp.com/search?find_desc=florida&find_loc=Lighthouse%20Point&start=");
//
//        urlList.put("Miami Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=Miami%20Beach&start=");
//        urlList.put("Milton", "https://www.yelp.com/search?find_desc=florida&find_loc=Milton&start=");
//        urlList.put("Minneola", "https://www.yelp.com/search?find_desc=florida&find_loc=Minneola&start=");
//        urlList.put("Miramar", "https://www.yelp.com/search?find_desc=florida&find_loc=Miramar&start=");
//        urlList.put("Mount Dora", "https://www.yelp.com/search?find_desc=florida&find_loc=Mount%20Dora&start=");
//        urlList.put("Naples", "https://www.yelp.com/search?find_desc=florida&find_loc=Naples&start=");
//        urlList.put("Neptune Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=Neptune%20Beach&start=");
//        urlList.put("New Port Richey", "https://www.yelp.com/search?find_desc=florida&find_loc=New%20Port%20Richey&start=");
//        urlList.put("New Smyrna Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=New%20Smyrna%20Beach&start=");
//        urlList.put("Niceville", "https://www.yelp.com/search?find_desc=florida&find_loc=Niceville&start=");
//        urlList.put("North Miami", "https://www.yelp.com/search?find_desc=florida&find_loc=North%20Miami&start=");
//        urlList.put("North Miami Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=North%20Miami%20Beach&start=");
//        urlList.put("North Port", "https://www.yelp.com/search?find_desc=florida&find_loc=North%20Port&start=");
//        urlList.put("Oakland Park", "https://www.yelp.com/search?find_desc=florida&find_loc=Oakland%20Park&start=");
//        urlList.put("Ocala", "https://www.yelp.com/search?find_desc=florida&find_loc=Ocala&start=");
//        urlList.put("Ocean Ridge", "https://www.yelp.com/search?find_desc=florida&find_loc=Ocean%20Ridge&start=");
//        urlList.put("Ocoee", "https://www.yelp.com/search?find_desc=florida&find_loc=Ocoee&start=");
//        urlList.put("Okeechobee", "https://www.yelp.com/search?find_desc=florida&find_loc=Okeechobee&start=");
//        urlList.put("Oldsmar", "https://www.yelp.com/search?find_desc=florida&find_loc=Oldsmar&start=");
//        urlList.put("Orange Park", "https://www.yelp.com/search?find_desc=florida&find_loc=Orange%20Park&start=");
//
//        urlList.put("Ormond Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=Ormond%20Beach&start=");
//        urlList.put("Oviedo", "https://www.yelp.com/search?find_desc=florida&find_loc=Oviedo&start=");
//        urlList.put("Palatka", "https://www.yelp.com/search?find_desc=florida&find_loc=Palatka&start=");
//        urlList.put("Palm Bay", "https://www.yelp.com/search?find_desc=florida&find_loc=Palm%20Bay&start=");
//        urlList.put("Palm Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=Palm%20Beach&start=");
//        urlList.put("Palm Beach Gardens", "https://www.yelp.com/search?find_desc=florida&find_loc=Palm%20Beach%20Gardens&start=");
//        urlList.put("Palm Coast", "https://www.yelp.com/search?find_desc=florida&find_loc=Palm%20Coast&start=");
//        urlList.put("Palmetto", "https://www.yelp.com/search?find_desc=florida&find_loc=Palmetto&start=");
//        urlList.put("Panama City", "https://www.yelp.com/search?find_desc=florida&find_loc=Panama%20City&start=");
//        urlList.put("Panama City Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=Panama%20City%20Beach&start=");
//        urlList.put("Pembroke Pines", "https://www.yelp.com/search?find_desc=florida&find_loc=Pembroke%20Pines&start=");
//        urlList.put("Pensacola", "https://www.yelp.com/search?find_desc=florida&find_loc=Pensacola&start=");
//        urlList.put("Pinecrest", "https://www.yelp.com/search?find_desc=florida&find_loc=Pinecrest&start=");
//        urlList.put("Pinellas Park", "https://www.yelp.com/search?find_desc=florida&find_loc=Pinellas%20Park&start=");
//        urlList.put("Plant City", "https://www.yelp.com/search?find_desc=florida&find_loc=Plant%20City&start=");
//        urlList.put("Plantation", "https://www.yelp.com/search?find_desc=florida&find_loc=Plantation&start=");
//        urlList.put("Pompano Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=Pompano%20Beach&start=");
//        urlList.put("Ponce Inlet", "https://www.yelp.com/search?find_desc=florida&find_loc=Ponce%20Inlet&start=");
//        urlList.put("Port Orange", "https://www.yelp.com/search?find_desc=florida&find_loc=Port%20Orange&start=");
//        urlList.put("Longwood", "https://www.yelp.com/search?find_desc=florida&find_loc=Longwood&start=");
//        urlList.put("Maitland", "https://www.yelp.com/search?find_desc=florida&find_loc=Maitland&start=");
//        urlList.put("Marco Island", "https://www.yelp.com/search?find_desc=florida&find_loc=Marco%20Island&start=");
//        urlList.put("Margate", "https://www.yelp.com/search?find_desc=florida&find_loc=Margate&start=");
//        urlList.put("Melbourne", "https://www.yelp.com/search?find_desc=florida&find_loc=Melbourne&start=");
//        urlList.put("Royal Palm Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=Royal%20Palm%20Beach&start=");
//        urlList.put("Punta Gorda", "https://www.yelp.com/search?find_desc=florida&find_loc=Punta%20Gorda&start=");
//        urlList.put("Rockledge", "https://www.yelp.com/search?find_desc=florida&find_loc=Rockledge&start=");
//        urlList.put("St. Augustine Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=St.%20Augustine%20Beach&start=");
//        urlList.put("St. Petersburg", "https://www.yelp.com/search?find_desc=florida&find_loc=St.%20Petersburg&start=");
//        urlList.put("Safety Harbor", "https://www.yelp.com/search?find_desc=florida&find_loc=Safety%20Harbor&start=");
//        urlList.put("Sanibel", "https://www.yelp.com/search?find_desc=florida&find_loc=Sanibel&start=");
//        urlList.put("Sarasota", "https://www.yelp.com/search?find_desc=florida&find_loc=Sarasota&start=");
//        urlList.put("Satellite Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=Satellite%20Beach&start=");
//        urlList.put("Seaside", "https://www.yelp.com/search?cflt=restaurants&find_loc=Seaside&start=");
//        urlList.put("Sebastian", "https://www.yelp.com/search?find_desc=florida&find_loc=Sebastian&start=");
//        urlList.put("Shalimar", "https://www.yelp.com/search?find_desc=florida&find_loc=Shalimar&start=");
//        urlList.put("Stuart", "https://www.yelp.com/search?find_desc=florida&find_loc=Stuart&start=");
//        urlList.put("Surfside", "https://www.yelp.com/search?find_desc=florida&find_loc=Surfside&start=");
//        urlList.put("Tallahassee", "https://www.yelp.com/search?find_desc=florida&find_loc=Tallahassee&start=");
//        urlList.put("Tamarac", "https://www.yelp.com/search?find_desc=florida&find_loc=Tamarac&start=");
//
//        urlList.put("Tarpon Springs", "https://www.yelp.com/search?find_desc=florida&find_loc=Tarpon%20Springs&start=");


        //    urlList.put("Alachua", "https://www.yelp.com/search?find_desc=florida&find_loc=Alachua&start=");
    //    urlList.put("Altamonte Springs", "https://www.yelp.com/search?find_desc=florida&find_loc=Altamonte%20Springs&start=");
     //   urlList.put("Anna Maria", "https://www.yelp.com/search?find_desc=florida&find_loc=Anna%20Maria&start=");
    //    urlList.put("Apalachicola", "https://www.yelp.com/search?find_desc=florida&find_loc=Apalachicola&start=");
   //     urlList.put("Apopka", "https://www.yelp.com/search?find_desc=florida&find_loc=Apopka&start=");
    //    urlList.put("Atlantic Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=Atlantic%20Beach&start=");
     //   urlList.put("Auburndale", "https://www.yelp.com/search?find_desc=florida&find_loc=Auburndale&start=");
     //   urlList.put("Aventura", "https://www.yelp.com/search?find_desc=florida&find_loc=Aventura&start=");
      //  urlList.put("Avon Park", "https://www.yelp.com/search?find_desc=florida&find_loc=Avon%20Park&start=");
      //  urlList.put("Bal Harbour", "https://www.yelp.com/search?find_desc=florida&find_loc=Bal%20Harbour&start=");
       // urlList.put("Bartow", "https://www.yelp.com/search?find_desc=florida&find_loc=Bartow&start=");
       // urlList.put("Bay Harbor Islands", "https://www.yelp.com/search?find_desc=florida&find_loc=Bay%20Harbor%20Islands&start=");
    //    urlList.put("Boca Raton", "https://www.yelp.com/search?find_desc=florida&find_loc=Boca%20Raton&start=");
    //    urlList.put("Bonita Springs", "https://www.yelp.com/search?find_desc=florida&find_loc=Bonita%20Springs&start=");
    //    urlList.put("Boynton Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=Boynton%20Beach&start=");

      //  urlList.put("Celebration", "https://www.yelp.com/search?find_desc=florida&find_loc=Celebration&start=");

     //   urlList.put("Clewiston", "https://www.yelp.com/search?find_desc=florida&find_loc=Clewiston&start=");

     //   urlList.put("Fort Lauderdale", "https://www.yelp.com/search?find_desc=florida&find_loc=Fort%20Lauderdale&start=");

  //      urlList.put("Fort Pierce", "https://www.yelp.com/search?find_desc=florida&find_loc=Fort%20Pierce&start=");

    //    urlList.put("Haines City", "https://www.yelp.com/search?find_desc=florida&find_loc=Haines%20City&start=");

  //      urlList.put("Juno Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=Juno%20Beach&start=");

    //    urlList.put("Longboat Key", "https://www.yelp.com/search?find_desc=florida&find_loc=Longboat%20Key&start=");
        //    urlList.put("St. Pete Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=St.%20Pete%20Beach&start=");
   //     urlList.put("Melbourne Beach", "https://www.yelp.com/search?find_desc=florida&find_loc=Melbourne%20Beach&start=");
        //   urlList.put("Sanford", "https://www.yelp.com/search?find_desc=florida&find_loc=Sanford&start=");
    //    urlList.put("Port St. Lucie", "https://www.yelp.com/search?find_desc=florida&find_loc=Port%20St.%20Lucie&start=");
        //    urlList.put("Sewall's Point", "https://www.yelp.com/search?find_desc=florida&find_loc=Sewall%27s%20Point&start=");
    //    urlList.put("St. Augustine", "https://www.yelp.com/search?find_desc=florida&find_loc=St.%20Augustine&start=");
        //    urlList.put("St. Cloud", "https://www.yelp.com/search?find_desc=florida&find_loc=St.%20Cloud&start=");

   //     urlList.put("Tavares", "https://www.yelp.com/search?find_desc=florida&find_loc=Tavares&start=");

        for (Map.Entry me : urlList.entrySet()) {
            for (int i = 0; i <= 200; i += 10) {
                try {
                    scrape_start(me.getKey().toString(), me.getValue() + "" + i);
                } catch (Exception e) {
                }
            }
        }
    }

    void scrape_start(String city, String url) {
        firefoxDriver.get(url);
        getData(city);
    }

    void getData(String city) {
        this.city = city;
        List<WebElement> elements = firefoxDriver.findElements(By.className("lemon--li__373c0__1r9wz"));
        for (WebElement data : elements) {
            empty();
            try {
                WebElement element = data.findElement(By.className("lemon--div__373c0__1mboc"));
                try {
                    companyName = element.findElement(By.className("lemon--h4__373c0__1yd__")).getText();
                    link = element.findElement(By.className("lemon--a__373c0__IEZFH")).getAttribute("href");
                } catch (Exception e) {

                }
                try {
                    telephone = element.findElement(By.className("lemon--p__373c0__3Qnnj")).getText();

                } catch (Exception e) {

                }
                try {
                    address = element.findElement(By.className("raw__373c0__3rcx7")).getText();
                } catch (Exception e) {

                }
                try {
                    typeOfCompanay = element.findElement(By.className("priceCategory__373c0__3zW0R")).getText();
                } catch (Exception e) {
                    System.out.println(e);
                }
            } catch (Exception e) {
            }
            try {
                if (!nameList.contains(companyName) && companyName.matches("^[0-9].*$")) {
                    System.out.println(state + "," + city.replaceAll(",", " ") + "," + companyName.replaceAll(",", " ") + "," + typeOfCompanay.replaceAll(",", " ") + "," + address.replaceAll(",", " ") + "," + telephone.replaceAll(", ", " ") + "," + link );
                    fileWriter.write(state + "," + city.replaceAll(",", " ") + "," + companyName.replaceAll(",", " ") + "," + typeOfCompanay.replaceAll(",", " ") + "," + address.replaceAll(",", " ") + "," + telephone.replaceAll(", ", " ") + "," + link + "\n");
                    fileWriter.flush();
                }
                nameList.add(companyName);
            } catch (Exception e) {
            }
        }

    }

    public void empty() {
        companyName = "";
        address = "";
        telephone = "";
        typeOfCompanay = "";
        link = "";
    }


}
