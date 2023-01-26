package com.workouts.testngparallelism;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestNGSample2 {

    WebDriver driver;

    @BeforeMethod
    public void init() throws MalformedURLException {
        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver=new RemoteWebDriver(new URL("http://192.168.43.215:4444/wd/hub"), DesiredCapabilities.edge());
        driver.get("https://www.google.com/");
    }

    @Test
    public void test4() throws InterruptedException {
        System.out.println("Test 4");
        driver.findElement(By.name("q")).sendKeys("Java");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@value='Google Search']")).click();
    }

    @Test
    public void test5() throws InterruptedException {
        System.out.println("Test 5");
        driver.findElement(By.name("q")).sendKeys("Kotlin");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@value='Google Search']")).click();
    }

    @Test
    public void test6() throws InterruptedException {
        System.out.println("Test 6");
        driver.findElement(By.name("q")).sendKeys("Python");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@value='Google Search']")).click();
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }


}
