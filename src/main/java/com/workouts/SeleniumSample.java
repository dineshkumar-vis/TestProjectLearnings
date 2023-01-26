package com.workouts;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Selenium 4.8.0
public class SeleniumSample {
    public static void main(String[] arg) {
        System.out.println("Test");
        test();
    }

    public static void test(){
        //String gridUrl = "http://192.168.43.215:4444/wd/hub";
        String gridUrl = "http://192.168.43.215:4444/wd/hub";
        try {
            System.setProperty("webdriver.chrome.driver","chromedriver.exe");
            /*Map<String,String> mobileEmulation=new HashMap<>();
            mobileEmulation.put("deviceName","Pixel 5");
            ChromeOptions chromeOptions=new ChromeOptions();
            chromeOptions.addArguments("disable-infobars");
            chromeOptions.setExperimentalOption("mobileEmulation",mobileEmulation);*/

            ChromeOptions chromeOptions=new ChromeOptions();
            chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));

            WebDriver driver = new ChromeDriver(chromeOptions);

            /*System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
            WebDriver driver = new EdgeDriver(DesiredCapabilities.edge());*/

            //WebDriver driver = new RemoteWebDriver(new URL(gridUrl), new ChromeOptions());
            driver.get("https://www.google.com/");
            driver.findElement(By.name("q")).sendKeys("Selenium");
            Thread.sleep(5000);
            TakesScreenshot ts=(TakesScreenshot)driver;
            File rawImage=ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(rawImage,new File("screenshots/image.jpg"));


            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("FINALLY");
        }
    }
}
