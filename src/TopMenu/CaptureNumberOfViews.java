package TopMenu;

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
import java.util.NoSuchElementException;

import Data.ConstructTestingTarget;

public class CaptureNumberOfViews {
    public static void main(String[] args) {
        ConstructTestingTarget constructTestingTarget = new ConstructTestingTarget();
//        LoginFunction loginFunction = new LoginFunction();
        List<String> urls = constructTestingTarget.readLinksFromFile("src/Data/batch1_UI_PC_1");
        List<String> navigationItems = List.of("全社共通情報", "部門情報", "個別情報", "グループ情報", "各店情報");
        //List<String> menuList = List.of("BCP", "関連コンテンツ", "こんなときどうする？");
        // Set the path for the Edge WebDriver executable

        System.setProperty("webdriver.edge.driver", "C:\\Users\\NHANND12\\Downloads\\EdgeDriver\\msedgedriver.exe");
//
        // Initialize EdgeOptions
        EdgeOptions options = new EdgeOptions();
        options.addArguments("window-size=1900,1200");
        //options.addArguments("window-size=430,932");
        options.addArguments("force-device-scale-factor=1"); // Approximate 150% scaling
        options.addArguments("-inprivate"); // Enable InPrivate browsing
        //options.addArguments("--start-fullscreen");
//        Map<String, Object> mobileEmulation = new HashMap<>();
//        mobileEmulation.put("deviceMetrics", Map.of("width", 430, "height", 932, "pixelRatio", 2));

//        options.setExperimentalOption("mobileEmulation", mobileEmulation);

        // Initialize Edge WebDriver
        WebDriver driver = new EdgeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set timeout

        try {
            // Open the web application
            driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=161&ct=1727854720&rver=7.5.2211.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26deeplink%3dowa%252f%26RpsCsrfState%3dbd17b267-47e7-828a-c40f-e6e7d38d36c4&id=292841&aadredir=1&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");

            // Enter email
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("loginfmt")));
            emailField.sendKeys("1020K011702@obayashi-road.co.jp");
            emailField.submit(); // Submit the email form

            // Wait for the password field to be visible
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("passwd")));
            passwordField.sendKeys("JK202409");
            passwordField.submit(); // Submit the password form

            List<String> viewLists = List.of("/Lists/List/view.aspx", "/Lists/List/view1.aspx", "/Lists/List/view2.aspx", "/Lists/List/view3.aspx", "/Lists/List/view4.aspx", "/Lists/List/viewStatus.aspx");

            for (String url : urls) {
                for (String view : viewLists) {
                    String fullPath = url + view;
                    System.out.println("Checking: " + fullPath);
                    driver.get(fullPath);

                    String prefix = "TeamSite_1020_0010/"; // PROD
                    int startIndex = fullPath.indexOf(prefix);

                    if (startIndex != -1) {
                        // Extract the substring from the starting index to the end
                        String siteName = fullPath.substring(startIndex);

                        // Click on the specific menu's down-arrow
                    try {
                            // Wait for the specific menu's down-arrow to be visible
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[text()='ナビゲーション']")));

                            // If found, take a screenshot
                        takeScreenshot(driver, siteName + "view" + viewLists.indexOf(view));
                        System.out.println("Accessed successfully: " + view);

                    } catch (NoSuchElementException e) {
                            // If not found, print the message
                            System.out.println("Site does not exist: " + view);
                    } catch (TimeoutException e) {
                            // Handle the case where the wait times out
                            System.out.println("Site does not exist (timeout): " + view);
                    }
                } else {
                    System.out.println("Prefix not found in view: " + view);
                }
            }
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
            File destFile = new File("C:\\Users\\NHANND12\\Pictures\\Leftmenu\\" + categoryName + ".png"); // Ensure 'screenshots' directory exists
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot taken for: " + categoryName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
