package PermissionGroup;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class PermissionGroup {
    public static void main(String[] args) {
        //PROD
        List<String> items = Arrays.asList(
                //list
                "od_report", "od_rinri", "od_kiteiMenu", "od_kiteiNaiki", "od_kiteiFuroku", "od_kiteiMain", "od_ISO14000",
                "od_BosaiNews", "od_Csr",
                //"od_pressrelease",
                "od_IntraKiyaku", "od_Privacy", "od_rinri", "od_DogyoTasya",
                "od_KankeiGaisya", "News01", "News02", "News03", "News04", "News05", "News06", "News08", "News09", "News10", "od_Bcp",

                //department
                "od_system", "od_news99", "od_keieikeikaku", "od_naibutosei", "od_soumu", "od_jinji", "od_keiri", "od_eigyo", "od_kenchiku", "od_kouji", "od_gouzai", "od_tecinfo", "od_anzen", "od_mcenter", "od_sbtnintei"
        );

        System.setProperty("webdriver.edge.driver", "C:\\Users\\NHANND12\\Downloads\\EdgeDriver\\edgedriver_win64\\msedgedriver.exe");

        // Initialize EdgeOptions
        EdgeOptions options = new EdgeOptions();
        options.addArguments("window-size=1900,1200");
        options.addArguments("force-device-scale-factor=1.5"); // Approximate 150% scaling
        options.addArguments("-inprivate"); // Enable InPrivate browsing

        // Initialize Edge WebDriver
        WebDriver driver = new EdgeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set timeout

        try {
            // Open the web application
            driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=161&ct=1727854720&rver=7.5.2211.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26deeplink%3dowa%252f%26RpsCsrfState%3dbd17b267-47e7-828a-c40f-e6e7d38d36c4&id=292841&aadredir=1&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");

            // Enter email
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("loginfmt")));
            emailField.sendKeys("1020K011702@obayashi-road.co.jp"); // Replace with your email
            emailField.submit(); // Submit the email form

            // Wait for the password field to be visible
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("passwd")));
            passwordField.sendKeys("JK202409"); // Replace with your password
            passwordField.submit(); // Submit the password form

            for (String item : items) {
                //String fullUrl = "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/" + item + "/_layouts/15/user.aspx";  //UAT
                String fullUrl = "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/" + item + "/_layouts/15/user.aspx";  //PRO
                System.out.println(fullUrl);
                driver.get(fullUrl);
                Thread.sleep(3000); // Adjust as necessary
                takeScreenshot(driver, item);
                }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
    // Method to take a screenshot
    private static void takeScreenshot(WebDriver driver, String categoryName) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        try {
            // Define the destination file
            File destFile = new File("C:\\Users\\NHANND12\\Pictures\\PermissionGroups\\" + categoryName + ".png"); // Ensure 'screenshots' directory exists
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot taken for: " + categoryName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
