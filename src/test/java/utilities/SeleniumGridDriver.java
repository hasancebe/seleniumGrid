package utilities;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SeleniumGridDriver {
    static WebDriver driver;
    static DesiredCapabilities capabilities = new DesiredCapabilities();

    public static WebDriver remoteDriverChromeOptions() {

        try {
            driver = new RemoteWebDriver(new URL("http://192.168.1.107:4444"), new ChromeOptions());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            driver.manage().window().maximize();

        } catch (MalformedURLException e) {
            System.out.println("chrome driver did not found " + e.getMessage());
        }
        return driver;

    }


    public static WebDriver remoteDriverEdgeOptions() {

        try {
            driver = new RemoteWebDriver(new URL("http://192.168.1.107:4444"), new EdgeOptions());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            driver.manage().window().maximize();

        } catch (MalformedURLException e) {
            System.out.println("edge driver did not found " + e.getMessage());
            ;
        }
        return driver;


    }

    public static WebDriver setUpChromeDriver() {


        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("109.0.5414.120");
        ChromeOptions options = new ChromeOptions();
        options.merge(capabilities);
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.1.107:4444"), options);
        } catch (MalformedURLException e) {
            System.out.println("chrome driver did not found " + e.getMessage());
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.manage().window().maximize();

        return driver;
    }

    public static WebDriver setUpEdgeDriver() {


        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setBrowserName("edge");
        capabilities.setVersion("109.0.1518.70");
        EdgeOptions options = new EdgeOptions();
        options.merge(capabilities);
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.1.107:4444"), options);
        } catch (MalformedURLException e) {
            System.out.println("edge driver did not found " + e.getMessage());
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.manage().window().maximize();

        return driver;
    }

    public static void closeDriver() {

        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}