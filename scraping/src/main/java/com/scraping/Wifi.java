package com.scraping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class Wifi {
    FirefoxDriver firefoxDriver = null;
    public void start() throws InterruptedException {
        firefoxDriver = new Driver().getFirefoxDriver();
        scrape();
        firefoxDriver.close();
    }

    private void scrape() throws InterruptedException {
        while (true) {
            firefoxDriver.get("http://192.168.1.1/login.html?_t=9921473");
            Thread.sleep(1000);
            List<WebElement> odd = firefoxDriver.findElements(By.className("odd"));
            int number = Integer.parseInt(odd.get(9).getText().replaceAll("Wi-Fi connected devices:", "").trim());
            if (number > 2) {
                startMusic("C:\\Users\\Hash\\Music\\music.wav");
            }
        }

    }

    void startMusic(String filePath){
        InputStream music;
        try{
            music=new FileInputStream(new File(filePath));
            AudioStream audio=new AudioStream(music);
            AudioPlayer.player.start(audio);
        }catch (Exception e){

        }
    }
}