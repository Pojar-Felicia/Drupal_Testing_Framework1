package com.pentalog.helpers;

import lombok.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

import static com.pentalog.core.ConfigConstants.*;
import static com.pentalog.helpers.Browser.OS_NAME_PLACEHOLDER;
import static java.lang.String.format;

public class BrowserFactory {

    private static final String DRIVERS = "drivers";
    private static final String browserName = "Firefox";

    private BrowserFactory() {
    }

    /**
     * Open new Driver instance for respective Browser
     *
     * @param arguments String... Ex: "--start-maximized", "--disable-notifications"
     * @return WebDriver
     */
    public static WebDriver openBrowser(String... arguments) {
        return openBrowser(Browser.get(browserName), arguments);
    }

    /**
     * Open new Driver instance for respective Browser
     *
     * @param browser   Browser Ex: Browser.CHROME...
     * @param arguments String... Ex: "--start-maximized", "--disable-notifications"
     * @return WebDriver
     */
    public static WebDriver openBrowser(Browser browser, String... arguments) {
        WebDriver driver = instantiateDriver(browser, arguments);
        System.out.println(format("Browser '%s' was opened", browser.name.toUpperCase()));
        setCustomDriverSettings(driver);
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.register(new HighlightingListener());
        return eventFiringWebDriver;
    }

    /**
     * Get new Driver instance for respective Browser
     *
     * @param browser Browser Ex: Browser.CHROME
     * @return WebDriver
     */
    public static WebDriver getDriver(@NonNull Browser browser) {
        System.out.printf("Current browser is %s%n", browser.name);
        return instantiateDriver(browser);
    }

    private static WebDriver instantiateDriver(@NonNull Browser browser, String... arguments) {
        String pathToDriver = getDriverPath(browser);
        System.setProperty(browser.driverProperty, pathToDriver);
        switch (browser) {
            case CHROME:
                return new ChromeDriver(new ChromeOptions().addArguments(arguments));
            case FIREFOX:
                return new FirefoxDriver(new FirefoxOptions().addArguments(arguments));
            case SAFARI:
                return new SafariDriver(new SafariOptions());
            case EDGE:
                return new EdgeDriver(new InternetExplorerOptions());
            default:
                throw new RuntimeException(format("Could not create new instance of driver for %s", browser.name));
        }
    }

    /**
     * Set common driver configs
     *
     * @param driver WebDriver
     */
    private static void setCustomDriverSettings(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(DEFAULT_ELEMENT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(SCRIPT_TIMEOUT, TimeUnit.SECONDS);
        System.out.printf("Were installed implicitlyWait: '%s', pageLoadTimeout: '%s', scriptTimeout: '%s'%n",
                DEFAULT_ELEMENT_WAIT, PAGE_LOAD_TIMEOUT, SCRIPT_TIMEOUT);
    }

    /**
     * Get path to driver for respective browser
     *
     * @param browser Browser Ex: Browser.CHROME...
     * @return String driver path Ex: drivers/windows/chromedriver.exe
     */
    private static String getDriverPath(Browser browser) {
        OSType os = OSType.detect();

        switch (browser) {
            case CHROME:
            case FIREFOX:
            case EDGE: {
                return String.join("/",
                        DRIVERS,
                        browser.driverLocation.replace(OS_NAME_PLACEHOLDER, os.name)
                                + os.executableExtention);
            }
            case SAFARI: {
                return browser.driverLocation;
            }
            default:
                throw new RuntimeException(format("Could not generate path to driver for %s", browser));
        }
    }

}