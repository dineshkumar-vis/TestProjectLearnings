package com.workouts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumSample extends Thread {
    public static void main(String[] arg) {
        System.out.println("Test");
        SeleniumSample ss=new SeleniumSample();
        SeleniumSample ss1=new SeleniumSample();
        ss.start();
        //ss1.start();
    }

    public void run(){
        test();
    }

    public void test(){
        String gridUrl = "http://192.168.43.215:4444/wd/hub";
        try {
            //System.setProperty("webdriver.chrome.driver","chromedriver.exe");
            //WebDriver driver = new ChromeDriver(DesiredCapabilities.chrome());

            System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
            WebDriver driver = new EdgeDriver(DesiredCapabilities.edge());

            //WebDriver driver = new RemoteWebDriver(new URL(gridUrl), DesiredCapabilities.edge());
            driver.get("https://www.google.com/");
            driver.findElement(By.name("q")).sendKeys("Dinesh Kumar");
            Thread.sleep(5000);
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("FINALLY");
        }
    }
}
