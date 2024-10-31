package RightMenu;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;




//To capture the right menu in List view
public class RightMenuCapture {
    public static void main(String[] args) {
        String siteName;
        String webDriver = "webdriver.edge.driver";
        String driverPath = "C:\\Users\\NHANND12\\Downloads\\EdgeDriver\\edgedriver_win64\\msedgedriver.exe";
        String loginUrl = "https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=161&ct=1727854720&rver=7.5.2211.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26deeplink%3dowa%252f%26RpsCsrfState%3dbd17b267-47e7-828a-c40f-e6e7d38d36c4&id=292841&aadredir=1&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c";
        String view1Suffix = "/Lists/List/view1.aspx";
        String view4Suffix = "/Lists/List/view4.aspx";
        String view3Suffix = "/Lists/List/view3.aspx";
        String viewAllSuffix = "/Lists/List/viewStatus.aspx";

        //UAT
//        List<String> urls = Arrays.asList(
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_keieikeikaku", //No UI Department
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_NaibuTosei", //No UI Department
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_news99",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_report", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_rinri",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_kiteiMenu", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_kiteiNaiki",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_kiteiFuroku", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_kiteiMain",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_ISO14000", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_BosaiNews",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_Csr", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_pressrelease",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_IntraKiyaku",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_Privacy",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_rinri",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_DogyoTasya",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_KankeiGaisya",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/News01",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/News02",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/News03",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/News04",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/News05"
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/News06",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/News08",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/News09",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/News10",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_Bcp"

//                    "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_system",
//                    "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_soumu", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_jinji",
//                    "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_keiri", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_eigyo",
//                    "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_kenchiku", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_kouji",
//                    "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_gouzai", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_tecinfo",
//                    "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_anzen", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_mcenter",
//                    "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/od_sbtnintei"
//        );

        //PROD
        List<String> urls = Arrays.asList(
                //Department lists
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_system",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_news99",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_keieikeikaku",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_naibutosei",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_soumu",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_jinji", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_keiri",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_eigyo", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_kenchiku",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_kouji", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_gouzai",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_tecinfo", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_anzen",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_mcenter",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_sbtnintei",

                //Nomral lists
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_report", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_rinri",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_kiteiMenu", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_kiteiNaiki",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_kiteiFuroku", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_kiteiMain",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_ISO14000",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_BosaiNews",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_Csr", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_pressrelease",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_IntraKiyaku",
                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_Privacy",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_rinri",
                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_DogyoTasya",
                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_KankeiGaisya",
                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/News01",
                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/News02",
                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/News03",
                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/News04",
                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/News05"
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/News06",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/News08",
//                "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/News09", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/News10", "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_Bcp"
        );


        System.setProperty(webDriver, driverPath);

        EdgeOptions options = new EdgeOptions();

        options.addArguments("window-size=1900,1200");
        options.addArguments("force-device-scale-factor=1.5");
        options.addArguments("-inprivate");
        //options.addArguments("--start-fullscreen");

        WebDriver driver = new EdgeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get(loginUrl);

            try {
                WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Sign in') or contains(@aria-label, 'Sign in')]")));
                closeButton.click();
                System.out.println("Closed the Microsoft sign-in assistance popup.");
            } catch (Exception e) {
                System.out.println("No Microsoft assistance popup appeared.");
            }

            // Enter email
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("loginfmt")));
            emailField.sendKeys("1020K011702@obayashi-road.co.jp");
            emailField.submit(); // Submit the email form

            // Wait for the password field to be visible
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("passwd")));
            passwordField.sendKeys("JK202409"); // Replace with your password
            passwordField.submit(); // Submit the password form

            for (String url : urls) {
                List<String> viewLists;
                if (!url.contains("od_kitei")) {
                    viewLists = List.of(url + view1Suffix, url + view4Suffix, url + viewAllSuffix);
                } else if (!url.contains("od_kiteiMenu")) {
                    viewLists = List.of(url + view3Suffix);
                } else {
                    viewLists = List.of(url);
                }
                for (String view : viewLists) {
                    System.out.println("Checking: " + view);

                    //String prefix = "TeamSite_1020_0020/"; //UAT
                    String prefix = "TeamSite_1020_0010/"; //PROD
                    int startIndex = view.indexOf(prefix);
                    if (startIndex != -1) {
                        // Extract the substring from the starting index to the end
                        siteName = view.substring(startIndex);

                        try {
                            driver.get(view);
                            Thread.sleep(3000); // Wait for the page to load; adjust if necessary
                            takeScreenshot(driver, siteName);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            } finally{
                driver.quit();
            }
        }
    private static void takeScreenshot(WebDriver driver, String categoryName) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        try {
            // Define the destination file
            File destFile = new File("C:\\Users\\NHANND12\\Pictures\\RightMenu_Lists\\" + categoryName + ".png");
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot taken for: " + categoryName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

