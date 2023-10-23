package support;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static JavascriptExecutor getExecutor() {
        return (JavascriptExecutor) driver;
    }

    public static WebDriverWait getWait() {
        return getWait(Duration.ofSeconds(10));
    }

    public static WebDriverWait getWait(Duration timeout) { return new WebDriverWait(driver, timeout);}

    public static Actions getActions() {
        return new Actions(driver);
    }

    public static void initialize() { initialize("chrome", false); }

    public static void teardown() {
        driver.close();
        driver.quit();
    }

    public static void initialize(String browser, boolean isHeadless) {

        String osName = System.getProperty("os.name");
        boolean isUnixBased = osName != null && (osName.contains("Mac") || osName.contains("Linux"));
        switch (browser) {
            case "chrome":
                String chromeDriverName = isUnixBased ? "chromedriver" : "chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", getDriversDirPath() + chromeDriverName);
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("profile.managed_default_content_setting_values.geolocation", 2);
                prefs.put("profile.managed_default_content_setting_values.notifications", 2);
                prefs.put("profile.managed_default_content_setting_values.popups", 0);
                prefs.put("download.prompt_for_download", false);
                prefs.put("download.directory_upgrade", true);
                prefs.put("download.default_directory", getDownloadsPath());
                prefs.put("credentials_enable_service", false);
                prefs.put("password_manager_enabled", false);
                prefs.put("safebrowsing.enabled", true);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--window-size=1920,1200");
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.setExperimentalOption("prefs", prefs);
                chromeOptions.addExtensions(new File(System
                    .getProperty("user.dir") + "/src/test/resources/config/SelectorsHub 4.6.2.0.crx"));
                if (!isHeadless) {
                    chromeOptions.addArguments("--window-size=1920,1200");
                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    chromeOptions.addArguments("--disable-gpu");
                }

                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                String geckoDriverName = isUnixBased ? "geckodriver" : "geckodriver.exe";
                System.setProperty("webdriver.gecko.driver", getDriversDirPath() + geckoDriverName);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setProfile(getFirefoxProfile());

                if (isHeadless) {
                    firefoxOptions.addArguments("--headless");
                }

                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", getDriversDirPath() + "MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", getDriversDirPath() + "IEDriverServer.exe");
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                // Configure IE-specific options if needed
                driver = new InternetExplorerDriver(ieOptions);
                break;
            case "grid":
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName("chrome");
                capabilities.setPlatform(Platform.ANY);
                URL hubUrl = null;
                try {
                    hubUrl = new URL("http://localhost:4444/wd/hub");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver = new RemoteWebDriver(hubUrl, capabilities);
                break;
            default:
                throw new RuntimeException("Driver is not implemented for: " + browser);
        }
    }

    private static Map<String, Object> getChromePreferences() {

        Map<String, Object> chromePreferences = new HashMap<>();
        chromePreferences.put("profile.default_content_settings.geolocation", 2);
        chromePreferences.put("download.prompt_for_download", false);
        chromePreferences.put("download.directory_upgrade", true);
        chromePreferences.put("download.default_directory", getDownloadsPath());
        chromePreferences.put("credentials_enable_service", false);
        chromePreferences.put("password_manager_enabled", false);
        chromePreferences.put("safebrowsing.enabled", "true");
        return chromePreferences;
    }

    private static FirefoxProfile getFirefoxProfile() {

        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("xpinstall.signatures.required", false);
        firefoxProfile.setPreference("app.update.enabled", false);
        firefoxProfile.setPreference("browser.download.folderList", 2);
        firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
        firefoxProfile.setPreference("browser.download.dir", getDownloadsPath());
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip;application/octet-stream;application/x-zip;application/x-zip-compressed;text/css;text/html;text/plain;text/xml;text/comma-separated-values");
        firefoxProfile.setPreference("browser.helperApps.neverAsk.openFile", "application/zip;application/octet-stream;application/x-zip;application/x-zip-compressed;text/css;text/html;text/plain;text/xml;text/comma-separated-values");
        firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
        firefoxProfile.setPreference("plugin.disable_full_page_plugi‌​n_for_types", "application/pdf,application/vnd.adobe.xfdf,application/vnd.‌​fdf,application/vnd.‌​adobe.xdp+xml");
        firefoxProfile.setPreference("webdriver.log.driver", "OFF");
        return firefoxProfile;
    }

    private static String getDriversDirPath() {
        return System.getProperty("user.dir") + String.format("%1$ssrc%1$stest%1$sresources%1$sdrivers%1$s", File.separator);
    }

    private static String getDownloadsPath() {
        return System.getProperty("user.dir") + String.format("%1$ssrc%1$stest%1$sresources%1$sdownloads%1$s", File.separator);
    }
}
