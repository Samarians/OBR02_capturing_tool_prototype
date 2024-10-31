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
import java.util.List;

public class TopMenuOthersForDepartment {
    public static void main(String[] args) {
        // Set the path for the Edge WebDriver executable

        List<String> urls = List.of(
                //UAT
                //"https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_system",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_soumu", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_jinji",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_keiri", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_eigyo",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_kenchiku", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_kouji",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_gouzai", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_tecinfo",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_anzen", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_mcenter",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_sbtnintei",

                //PROD
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_system",
                //"https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_news99",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_keieikeikaku",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_naibutosei"
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_soumu",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_jinji", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_keiri",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_eigyo", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_kenchiku",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_kouji", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_gouzai",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_tecinfo", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_anzen",
                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_mcenter",
                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_sbtnintei"
        );

        System.setProperty("webdriver.edge.driver", "C:\\Users\\NHANND12\\Downloads\\EdgeDriver\\msedgedriver.exe");

        // Initialize EdgeOptions
        EdgeOptions options = new EdgeOptions();
        options.addArguments("window-size=1900,1200");
        options.addArguments("force-device-scale-factor=1"); // Approximate 150% scaling
        options.addArguments("-inprivate"); // Enable InPrivate browsing

        // Initialize Edge WebDriver
        WebDriver driver = new EdgeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set timeout

        try {
            // Open the web application
            driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=161&ct=1727854720&rver=7.5.2211.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26deeplink%3dowa%252f%26RpsCsrfState%3dbd17b267-47e7-828a-c40f-e6e7d38d36c4&id=292841&aadredir=1&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");

            // Enter email
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("loginfmt")));
            emailField.sendKeys("1020K011704@obayashi-road.co.jp"); // Replace with your email
            emailField.submit(); // Submit the email form

            // Wait for the password field to be visible
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("passwd")));
            passwordField.sendKeys("JK202409"); // Replace with your password
            passwordField.submit(); // Submit the password form

            for (String url : urls) {
                System.out.println("Checking: " + url);

                driver.get(url);
                Thread.sleep(3000);

                List<String> menuList = List.of("BCP", "関連コンテンツ", "こんなときどうする？");
                for (String menu : menuList) {

                    // Click on the specific menu's down-arrow

                    WebElement specificMenu = driver.findElement(By.xpath(".//span[text()='" + menu + "']"));

                    //String prefix = "TeamSite_1020_0020"; //UAT
                    String prefix = "TeamSite_1020_0010"; //PROD
                    int startIndex = url.indexOf(prefix);
                    if (startIndex != -1) {
                        // Extract the substring from the starting index to the end
                        String siteName = url.substring(startIndex);

                        //specificMenu.click(); // Click the menu to expand

                        try {
                            specificMenu.click();
                            Thread.sleep(3000);
                            takeScreenshot(driver, siteName + menu);
                        } catch (Exception e) {
                            System.out.println("Regular click failed, attempting JavaScript click.");
                            JavascriptExecutor js = (JavascriptExecutor) driver;
                            js.executeScript("arguments[0].click();", specificMenu); // Fallback to JavaScript click
                        }
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
            File destFile = new File("C:\\Users\\NHANND12\\Pictures\\TopMenu_NotNavigation\\" + categoryName + ".png"); // Ensure 'screenshots' directory exists
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot taken for: " + categoryName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}