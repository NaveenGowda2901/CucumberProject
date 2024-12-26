package hooks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.Listeners;

import com.github.javafaker.Faker;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(utilities.ScreenshotListener.class)
public class BaseClass {

	public static WebDriver driver;
	public static Properties properties;
	public static Faker faker;

	public static Properties prop() throws IOException {
		properties = new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
		properties.load(fis);
		return properties;
	}

	@Before
	public void setUp() throws IOException, URISyntaxException {	
		String browser = prop().getProperty("browser");
		String os = prop().getProperty("os");
		String url = prop().getProperty("url");
		String execution_env = prop().getProperty("execution_env");

		if(execution_env.equalsIgnoreCase("local")) {
			switch(browser.toLowerCase()) {
			case "chrome" : WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); break;
			case "edge" : 	WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(); break;
			case "firefox": WebDriverManager.firefoxdriver().setup(); 
			driver = new FirefoxDriver(); break;
			default: System.out.println("Invalid browser"); return;
			}
		}

		else if(os.equals("remote")) {
			//			DesiredCapabilities decap = new DesiredCapabilities();
			//
			//			switch(browser.toLowerCase()) {
			//			case "chrome" : decap.setBrowserName("chrome"); break;
			//			case "edge"   : decap.setBrowserName("MicrosoftEdge"); break;
			//			case "firefox": decap.setBrowserName("firefox"); break;
			//			default: System.out.println("Invalid browser"); return;
			//			}
			//
			//			switch(os.toLowerCase()) {
			//			case "windows" : decap.setPlatform(Platform.WIN10); break;
			//			case "mac" : decap.setPlatform(Platform.MAC); break;
			//			case "linux" : decap.setPlatform(Platform.LINUX); break;
			//			default: System.out.println("Invalid browser"); return;
			//			}

			MutableCapabilities options;

			switch (browser.toLowerCase()) {
			case "chrome": options = new ChromeOptions(); break;
			case "edge": options = new EdgeOptions(); break;
			case "firefox": options = new FirefoxOptions(); break;
			case "safari": options = new SafariOptions(); break;
			default:System.out.println("Invalid browser");return;
			}

			switch (os.toLowerCase()) {
			case "windows": options.setCapability("platformName", "windows"); break;
			case "mac": options.setCapability("platformName", "mac"); break;
			case "linux": options.setCapability("platformName", "linux"); break;
			default: System.out.println("Invalid OS"); return;
			}

			URL remoteURL = new URI("http://localhost:4444/wd/hub").toURL();
			driver = new RemoteWebDriver(remoteURL, options);	
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	public static Faker fakerData() {
		return faker = new Faker();
	}


}
