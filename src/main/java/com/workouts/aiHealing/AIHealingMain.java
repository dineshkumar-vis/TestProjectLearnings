package com.workouts.aiHealing;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AIHealingMain {
    public static void main(String[] arg) throws InterruptedException {

        AIHealingObject firstName = new AIHealingObject("//input[@id='fname']", "input", "text", "fname", "firstname", "");
        AIHealingObject lastName = new AIHealingObject("//input[@name='lastname']", "input", "text", "", "lastname", "");
        AIHealingObject rdoMale = new AIHealingObject("//input[@value='Male']", "input", "radio", "gender", "gender", "Male");
        AIHealingObject rdoFemale = new AIHealingObject("//input[@value='Female']", "input", "radio", "gender", "gender", "Female");
        AIHealingObject chkMusic = new AIHealingObject("//input[@name='music']", "input", "checkbox", "hobbies", "music", "Music");
        AIHealingObject chkCricket = new AIHealingObject("//input[@name='cricket']", "input", "checkbox", "hobbies", "cricket", "Cricket");
        AIHealingObject chkChess = new AIHealingObject("//input[@name='chess']", "input", "checkbox", "hobbies", "chess", "Chess");

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/732141/OneDrive%20-%20Cognizant/Desktop/AITestHtml.html");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        enterValue(driver, firstName, "Dinesh");
        enterValue(driver, lastName, "Kumar");
        click(driver,rdoMale);
        click(driver,chkCricket);

    }

    public static void enterValue(WebDriver driver, AIHealingObject uiObject, String textValue) {

        try {
            driver.findElement(By.xpath(uiObject.xpath)).sendKeys(textValue);
        } catch (NoSuchElementException e) {
            if (uiObject.tag.equals("input") && uiObject.type.equals("text")) {
                System.out.println("Object Healing for " + uiObject.xpath);
                List<WebElement> webElementList = driver.findElements(By.className("input[type='text']"));
                for (WebElement element : webElementList) {
                    System.out.println("ELEMENT : " + uiObject.xpath + " : " + element.getAttribute("id"));
                    if (!element.getAttribute("id").isEmpty()) {
                        if (element.getAttribute("id").equals(uiObject.id) || element.getAttribute("id").equals(uiObject.name))
                            element.sendKeys(textValue);
                    }
                }
            }

        } catch (Exception e) {

        }

    }

    public static void click(WebDriver driver, AIHealingObject uiObject) {

        try {
            driver.findElement(By.xpath(uiObject.xpath)).click();
        } catch (NoSuchElementException e) {
            if (uiObject.tag.equals("input") && uiObject.type.equals("radio")) {
                System.out.println("Object Healing for " + uiObject.xpath);

                List<WebElement> webElementList = driver.findElements(By.className("input[type='text']"));
                for (WebElement element : webElementList) {
                    System.out.println("ELEMENT : " + uiObject.xpath + " : " + element.getAttribute("id"));
                    if (!element.getAttribute("id").isEmpty()) {

                    }
                }
            }

        } catch (Exception e) {

        }

    }
}
