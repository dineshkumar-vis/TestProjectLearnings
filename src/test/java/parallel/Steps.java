package parallel;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Steps {
    WebDriver driver;

    @Before
    public void before() {

    }

    @After
    public void after() {
        driver.quit();
    }

    @Given("open browser")
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        //driver=new RemoteWebDriver(new URL("http://192.168.43.215:4444/wd/hub"), DesiredCapabilities.chrome());
    }

    @And("load URL")
    public void loadURL() {
        driver.get("https://www.google.com/");
    }

    @And("^search for (.*)$")
    public void searchForKey(String key) throws InterruptedException {
        System.out.println("Test 1");
        driver.findElement(By.name("q")).sendKeys(key);
        Thread.sleep(1000);
    }

    @And("click search")
    public void clickSearch() {
        driver.findElement(By.xpath("//input[@value='Google Search']")).click();
    }

}
