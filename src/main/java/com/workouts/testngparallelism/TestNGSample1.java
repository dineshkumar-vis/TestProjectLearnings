package com.workouts.testngparallelism;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class TestNGSample1 {

    WebDriver driver;

    @BeforeMethod
    public void init() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //driver = new ChromeDriver();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        driver=new RemoteWebDriver(new URL("http://192.168.43.215:4444/wd/hub"),caps);
        driver.get("https://www.google.com/");
    }

    @Test
    public void test1() throws InterruptedException {
        System.out.println("Test 1");
        driver.findElement(By.name("q")).sendKeys("testNG");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@value='Google Search']")).click();
    }

    @Test
    public void test2() throws InterruptedException {
        System.out.println("Test 2");
        driver.findElement(By.name("q")).sendKeys("selenium");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@value='Google Search']")).click();
    }

    @Test
    public void test3() throws InterruptedException {
        System.out.println("Test 3");
        driver.findElement(By.name("q")).sendKeys("Cucumber");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@value='Google Search']")).click();
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }


}
