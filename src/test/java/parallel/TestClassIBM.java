package parallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestClassIBM {
    public static void main(String[] agr) {

        System.setProperty("webdriver.chrome.driver", "<location-driver.exe>");
        WebDriver driver = new FirefoxDriver(DesiredCapabilities.chrome());
        driver.get("www.ibm.com");
        driver.findElement(By.id("username")).sendKeys("dinesh@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dinesh@123");
        driver.findElement(By.id("login")).click();


        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));


    }


    //input : 5,6,7,4,3,2,3,3,3,2
    //output : 2,3,4,5,6,7

    public void sorting(int array[]) {
        int ra[] = new int[array.length];

        for (int i = 0; i < array.length-1; i++) {
            for (int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    int temp=array[i];
                    array[j]=temp;
                    array[i]=array[j];
                }
            }
        }

    }

}
