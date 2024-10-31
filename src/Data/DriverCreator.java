//package Data;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.time.Duration;
//
//
//public class DriverCreator {
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
//}
