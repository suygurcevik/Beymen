package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.HashMap;
import java.util.Map;

public class Driver {
    private static final ThreadLocal<WebDriver> DRIVER_TL = new ThreadLocal<>();
    private static final String START_FULL_SCREEN = "--start-fullscreen";
    @Getter
    public static String driverType ;

    public static void setDriverType(String driverType) {
        Driver.driverType = driverType;
    }


    public static WebDriver getDriver(String browser)  {
        setDriver(browser);
        return DRIVER_TL.get();
    }
    public static void setDriver(String browser) {
        WebDriver driver = null;
        switch (browser) {
            case "chrome":
                setDriverType("chrome");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--allow-insecure-localhost");
                options.addArguments("--acceptInsecureCerts");
                options.addArguments("disable-infobars");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-gpu");
                options.addArguments("--lang=en_US");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--allowed-ips");
                if (DriverConfig.getInstance().isChromeHeadless()) {
                    options.addArguments("--headless");
                }else {
                    options.addArguments(START_FULL_SCREEN);
                }

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                break;

        }
        DRIVER_TL.set(driver);
    }

    public static WebDriver getDriver() {
        return DRIVER_TL.get();
    }
}
