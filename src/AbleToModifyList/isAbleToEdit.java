package AbleToModifyList;

import Data.ConstructTestingTarget;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class isAbleToEdit {
    public static void main(String[] args) {
        ConstructTestingTarget constructTestingTarget = new ConstructTestingTarget();
//        LoginFunction loginFunction = new LoginFunction();
        List<String> urls = constructTestingTarget.readLinksFromFile("src/Data/testingDepartments_0010");
        List<String> navigationItems = List.of("全社共通情報", "部門情報", "個別情報", "グループ情報", "各店情報");
        //List<String> menuList = List.of("BCP", "関連コンテンツ", "こんなときどうする？");
        // Set the path for the Edge WebDriver executable

        //PROD
//        List<String> urls = Arrays.asList(
//                //Department lists
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_system",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_news99",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_keieikeikaku",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_naibutosei"
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_soumu",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_jinji", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_keiri",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_eigyo", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_kenchiku",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_kouji", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_gouzai",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_tecinfo", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_anzen",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_mcenter",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_sbtnintei",
//
//                //Nomral lists
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_report"
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_rinri",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_kiteiMenu", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_kiteiNaiki",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_kiteiFuroku", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_kiteiMain",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_ISO14000",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_BosaiNews",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_Csr", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_pressrelease",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_IntraKiyaku", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_Privacy",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_rinri",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_DogyoTasya",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_KankeiGaisya", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/News01",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/News02", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/News03",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/News04", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/News05",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/News06",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/News08",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/News09", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/News10", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_Bcp"
//        );

        System.setProperty("webdriver.edge.driver", "C:\\Users\\NHANND12\\Downloads\\EdgeDriver\\edgedriver_win64\\msedgedriver.exe");
//
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
            emailField.sendKeys("1020K011702@obayashi-road.co.jp");
            emailField.submit(); // Submit the email form

            // Wait for the password field to be visible
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("passwd")));
            passwordField.sendKeys("JK202409");
            passwordField.submit(); // Submit the password form


            for (String url : urls) {
                List<String> viewLists;
                if (!url.contains("od_kitei")) {
                    viewLists = List.of(url + "/Lists/List/view1.aspx", url + "/Lists/List/view4.aspx", url + "/Lists/List/viewStatus.aspx");
                }
                else if (!url.contains("od_kiteiMenu")) {
                    viewLists = List.of(url + "/Lists/List/view3.aspx");
                } else {
                    viewLists = List.of(url);
                }

                for (String view : viewLists) {
                    System.out.println("Checking: " + view);
                    driver.get(view);

                    // Click on the specific menu's down-arrow
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[text()='ナビゲーション']")));
                    WebElement specificMenu = driver.findElement(By.xpath(".//a[text()='ナビゲーション']"));

                    String menu = "ナビゲーション_";
                    //String prefix = "TeamSite_1020_0020/"; //UAT
                    String prefix = "TeamSite_1020_0010/"; //PROD
                    int startIndex = view.indexOf(prefix);
                    if (startIndex != -1) {
                        //Extract the substring from the starting index to the end
                        String siteName = view.substring(startIndex, startIndex);

                        try {
                            specificMenu.click();
                        } catch (Exception e) {
                            System.out.println("Regular click failed, attempting JavaScript click.");
                            JavascriptExecutor js = (JavascriptExecutor) driver;
                            js.executeScript("arguments[0].click();", specificMenu);
                        }

                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//a[text()='全社共通情報']")));

                        for (String item : navigationItems) {
                            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[text()='" + item + "']//parent::div//i")));
                            WebElement chevronButton = driver.findElement(By.xpath(".//a[text()='" + item + "']//parent::div//i"));
                            chevronButton.click();
                            Thread.sleep(2000); // Adjust as necessary
                            takeScreenshot(driver,  siteName + menu + item);
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
            File destFile = new File("C:\\Users\\NHANND12\\Pictures\\TopMenu_Navigation_Lists\\" + categoryName + ".png"); // Ensure 'screenshots' directory exists
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot taken for: " + categoryName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

