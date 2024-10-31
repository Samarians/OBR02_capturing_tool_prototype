package Services;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class LoginFunction {

//    public static JSONObject readJsonFromFile(String filePath) {
//        StringBuilder jsonBuilder = new StringBuilder();
//        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                jsonBuilder.append(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return new JSONObject(jsonBuilder.toString());
//    }

    private void login() {
//        JSONObject jsonObject = readJsonFromFile(filePath);
//        String loginSite = jsonObject.getString("loginSite");
//        JSONObject account = jsonObject.getJSONObject("account");
//
//        String email = account.getString("email");
//        String password = account.getString("password");
//
//        // Here you can add your login logic (e.g., send a request to the login site)
//        // For now, we'll just print the login attempt
//        System.out.println("Attempting to log in at " + loginSite + " with email: " + email);
//
//        // Simulate a successful login for demonstration
//        System.out.println("Logged in successfully at " + loginSite);
        System.setProperty("webdriver.edge.driver", "C:\\Users\\NHANND12\\Downloads\\EdgeDriver\\edgedriver_win64\\msedgedriver.exe");

        // Initialize EdgeOptions
        EdgeOptions options = new EdgeOptions();
        options.addArguments("window-size=1900,1200");
        options.addArguments("force-device-scale-factor=1.5"); // Approximate 150% scaling
        options.addArguments("-inprivate"); // Enable InPrivate browsing

        // Initialize Edge WebDriver
        WebDriver driver = new EdgeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set timeout


        driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=161&ct=1727854720&rver=7.5.2211.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26deeplink%3dowa%252f%26RpsCsrfState%3dbd17b267-47e7-828a-c40f-e6e7d38d36c4&id=292841&aadredir=1&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");

        // Enter email
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("loginfmt")));
        emailField.sendKeys("1020K011702@obayashi-road.co.jp");
        emailField.submit(); // Submit the email form

        // Wait for the password field to be visible
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("passwd")));
        passwordField.sendKeys("JK202409");
        passwordField.submit(); // Submit the password form
    }
}

//    public static void main(String[] args) {
//        String filePath = "src/Data/AccountCredentials.json"; // Specify your file path here
//        loginFromJson(filePath);
//
//        System.setProperty("webdriver.edge.driver", "C:\\Users\\NHANND12\\Downloads\\EdgeDriver\\edgedriver_win64\\msedgedriver.exe");
//
//        // Initialize EdgeOptions
//        EdgeOptions options = new EdgeOptions();
//        options.addArguments("window-size=1900,1200");
//        options.addArguments("force-device-scale-factor=1.5"); // Approximate 150% scaling
//        options.addArguments("-inprivate"); // Enable InPrivate browsing
//
//        // Initialize Edge WebDriver
//        WebDriver driver = new EdgeDriver(options);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set timeout
//        driver.get("https://obayashig.sharepoint.com/sites/TeamSite_1020_0010/od_system");
//    }
//}
