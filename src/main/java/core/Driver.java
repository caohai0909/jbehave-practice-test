package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

	private Driver() {
	}

	public static WebDriver driver;

	
	public static void init() {
		PropertyUtils.initializePropertyFile("\\test.properties");
		String testBrowser = PropertyUtils.property.getProperty("test.browser");

        if (testBrowser.equals("firefox")) {
        	WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
        } else if (testBrowser.equals("chrome")) {
        	WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
        }else {
            throw new AssertionError("Unsupported browser: " + System.getProperty("test.browser"));
        }
	}
	
	
	
	public static void openBrowser(String testBrowser) {
		switch (testBrowser) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println(testBrowser + " Can NOT define!");
		}
	}

	public static void tearDown() {
		driver.quit();
	}
}
