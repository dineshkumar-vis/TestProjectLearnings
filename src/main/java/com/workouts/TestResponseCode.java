package com.workouts;

import java.util.Iterator;
import java.util.logging.Level;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestResponseCode {
    public static void main(String[] args) {
        // simple page (without many resources so that the output is
        // easy to understand
        String url = "https://intellipaat.com/";

        DownloadPage(url);
    }

    private static void DownloadPage(String url) {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        ChromeDriver driver = null;

        try {
            ChromeOptions options = new ChromeOptions();
            // add whatever extensions you need
            // for example I needed one of adding proxy, and one for blocking
            // images
            // options.addExtensions(new File&#40;file, "proxy.zip"&#41;);
            // options.addExtensions(new File&#40;"extensions",
            // "Block-image_v1.1.crx"&#41;);

            DesiredCapabilities cap =new  DesiredCapabilities();
            cap.setCapability(ChromeOptions.CAPABILITY, options);

            // set performance logger
            // this sends Network.enable to chromedriver
            LoggingPreferences logPrefs = new LoggingPreferences();
            logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
            cap.setCapability("goog:loggingPrefs", logPrefs);

            driver = new ChromeDriver();

            // navigate to the page
            System.out.println("Navigate to " + url);
            driver.navigate().to(url);

            // and capture the last recorded url (it may be a redirect, or the
            // original url)
            String currentURL = driver.getCurrentUrl();

            // then ask for all the performance logs from this request
            // one of them will contain the Network.responseReceived method
            // and we shall find the "last recorded url" response
            LogEntries logs = driver.manage().logs().get("performance");

            int status = -1;

            System.out.println("\nList of log entries:\n");

            for (Iterator<LogEntry> it = logs.iterator(); it.hasNext(); ) {
                LogEntry entry = it.next();

                try {
                    JSONObject json = new JSONObject(entry.getMessage());

                    //System.out.println("$$JSON : "+json.toString());

                    JSONObject message = json.getJSONObject("message");
                    String method = message.getString("method");

                    if (method != null && "Network.responseReceived".equals(method)) {
                        System.out.println("$$JSON : "+json.toString());
                        JSONObject params = message.getJSONObject("params");

                        JSONObject response = params.getJSONObject("response");
                        String messageUrl = response.getString("url");

                        if (currentURL.equals(messageUrl)) {
                            status = response.getInt("status");

                            System.out.println("---------- returned response for " + messageUrl + ": " + status);

                            System.out.println("---------- headers: "+ response.get("headers"));
                        }
                    }
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            System.out.println("\nstatus code: " + status);
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
