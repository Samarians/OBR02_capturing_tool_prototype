package Lists;

import Data.TestTarget;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static java.util.List.of;

public class PermissionGroupId {
    public static void main(String[] args) {

        String noGroupUser = "\"ユーザー情報リスト\" リストのこのビューに表示するアイテムはありません。";
        String groupUser = "大林道路_本店ＤＸソリューション部(04課長級以上)";
        String groupMember = "S_社報 メンバー";
        String groupViewer = "S_社報 閲覧者";
        String groupOwner = "S_社報 所有者";
        String groupApprover = "S_社報_承認者";

        //List<TestTarget> testTargetList = new ArrayList<>();

        //TestTarget odReport = new TestTarget("od_report", List.of(1693, 1694, 1695, 1696), List.of("S_社報 メンバー", "S_社報 閲覧者", "S_社報 所有者", "S_社報_承認者"));

        HashMap<String, List<Number>> lists = new HashMap<>();
        lists.put("od_report", List.of(1693, 1694, 1695, 1696));
        lists.put("od_rinri", List.of(1701, 1702, 1703, 1704));
        lists.put("od_kiteiMenu", List.of(1705, 1706, 1707, 1708));
        lists.put("od_kiteiNaiki", List.of(1705, 1706, 1707, 1708));
        lists.put("od_kiteiFuroku", List.of(1705, 1706, 1707, 1708));
        lists.put("od_kiteiMain", List.of(1705, 1706, 1707, 1708));
        lists.put("od_ISO14000", List.of(1710, 1711, 1712, 1713));
        lists.put("od_BosaiNews", List.of(1710, 1711, 1712, 1713));
        lists.put("od_Csr", List.of(1718, 1719, 1720, 1721));
        lists.put("od_IntraKiyaku", List.of(1722, 1723, 1724, 1725));
        lists.put("od_Privacy", List.of(1726, 1727, 1728, 1729));
        lists.put("od_DogyoTasya", List.of(1730, 1731, 1732, 1733));
        lists.put("od_KankeiGaisya", List.of(1734, 1735, 1736, 1737));
        lists.put("News01", List.of(1738, 1739, 1740, 1741));
        lists.put("News02", List.of(1742, 1743, 1744, 1745));
        lists.put("News03", List.of(1746, 1747, 1748, 1749));
        lists.put("News04", List.of(1750, 1751, 1752, 1753));
        lists.put("News05", List.of(1754, 1755, 1756, 1757));
        lists.put("News06", List.of(1758, 1759, 1760, 1761));
        lists.put("News08", List.of(1762, 1763, 1764, 1765));
        lists.put("News09", List.of(1766, 1767, 1768, 1769));
        lists.put("News10", List.of(1770, 1771, 1772, 1773));
        lists.put("od_Bcp", List.of(1774, 1775, 1776, 1777));
        lists.put("tosyo", List.of(1781, 1782));
        lists.put("0100505", List.of(1785, 1786, 1787));
        lists.put("0100504", List.of(1788, 1789, 1790));
        lists.put("TS_gyomuteian", List.of(3, 4, 5, 30));



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

            for (String key : lists.keySet()) {
                String permisionList = "https://obayashig.sharepoint.com/sites/TeamSite_1020_0001/" + key + "/_layouts/15/user.aspx";

                System.out.println("Checking permission configuration of " + key);
                driver.get(permisionList);
                Thread.sleep(3000);
                takeScreenshot(driver, key);
                String pageSource = driver.getPageSource();

                if (pageSource.contains(groupMember) && pageSource.contains(groupViewer) && pageSource.contains(groupOwner) && pageSource.contains(groupApprover)) {
                    System.out.println("Group permissions are configured successfully");
                } else {
                    System.out.println("Permission group is missing");
                }
//                for (Number groupdId : lists.get(key)) {
//                    //String fullUrl = "https://obayashig.sharepoint.com/sites/TeamSite_1020_0020/" + item + "/_layouts/15/user.aspx";  //UAT
//                    String groupSite = "https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/" + key + "/_layouts/15/people.aspx?MembershipGroupId=" + groupdId;  //PRO
//                    System.out.println("Checking: " + groupSite);
//                    driver.get(groupSite);
//                    Thread.sleep(3000); // Adjust as necessary
//                    takeScreenshot(driver, key + "_" + groupdId);
//                    String groupIdPageSource = driver.getPageSource();
//
//                    if (groupIdPageSource.contains(noGroupUser)) {
//                        System.out.println(noGroupUser + " found on the page: " + groupSite);
//                    } else if (groupIdPageSource.contains(groupUser)) {
//                        System.out.println(groupUser + " found on the page: " + groupSite);
//                    } else {
//                        System.out.println("No relevant message found on the page: " + groupSite);
//                    }
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static void takeScreenshot(WebDriver driver, String categoryName) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        try {
            File destFile = new File("C:\\Users\\NHANND12\\Pictures\\PermissionGroups_0001\\" + categoryName + ".png");
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot taken for: " + categoryName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
