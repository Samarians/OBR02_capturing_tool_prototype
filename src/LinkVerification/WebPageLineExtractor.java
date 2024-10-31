package LinkVerification;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Duration;

public class WebPageLineExtractor {
    public static void main(String[] args) {
        // URL of the page you want to read

        System.setProperty("webdriver.edge.driver", "C:\\Users\\NHANND12\\Downloads\\EdgeDriver\\msedgedriver.exe");

        // Initialize EdgeOptions
        EdgeOptions options = new EdgeOptions();
        options.addArguments("window-size=1900,1200");
        options.addArguments("force-device-scale-factor=1.5"); // Approximate 150% scaling
        options.addArguments("-inprivate"); // Enable InPrivate browsing

        // Initialize Edge WebDriver
        WebDriver driver = new EdgeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set timeout
        String site = "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020"; // Replace with your target URL

        try {
            // Open a connection to the URL
            driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=161&ct=1727854720&rver=7.5.2211.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26deeplink%3dowa%252f%26RpsCsrfState%3dbd17b267-47e7-828a-c40f-e6e7d38d36c4&id=292841&aadredir=1&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");

            // Enter email
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("loginfmt")));
            emailField.sendKeys("1020K011704@obayashi-road.co.jp"); // Replace with your email
            emailField.submit(); // Submit the email form

            // Wait for the password field to be visible
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("passwd")));
            passwordField.sendKeys("JK202409"); // Replace with your password
            passwordField.submit(); // Submit the password form

            driver.get(site);
            Thread.sleep(7000);

            String pageSource = driver.getPageSource();

            // Extract the JSON portion
            String quickLaunchPart = extractQuickLaunch(pageSource);

            if (quickLaunchPart != null) {
                JSONArray quickLaunchArray = new JSONArray(quickLaunchPart);

                for (int i = 0; i < quickLaunchArray.length(); i++) {
                    JSONObject item = quickLaunchArray.getJSONObject(i);
                    String title = item.getString("Title");
                    String url = item.getString("Url");
                    System.out.println("Title: " + title);
                    System.out.println("URL: " + url);
                }
            } else {
                System.out.println("quickLaunch not found.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    private static String extractQuickLaunch(String pageSource) {
        String navInfoStart = "\"spPageContextInfo\":";
        int startIndex = pageSource.indexOf(navInfoStart);

        if (startIndex == -1) {
            return null; // spPageContextInfo not found
        }

        String navInfoPart = pageSource.substring(startIndex);
        String quickLaunchStart = "\"quickLaunch\":";
        int quickLaunchIndex = navInfoPart.indexOf(quickLaunchStart);

        if (quickLaunchIndex == -1) {
            return null; // quickLaunch not found
        }

        int arrayStart = quickLaunchIndex + quickLaunchStart.length();
        int arrayEnd = navInfoPart.indexOf("]", arrayStart) + 1; // Find the end of the quickLaunch array
        return navInfoPart.substring(arrayStart, arrayEnd).trim();
    }
    }


