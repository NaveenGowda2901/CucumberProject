package hooks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

import io.cucumber.java.After;
import io.cucumber.java.Before;

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
	public void setUp() throws IOException {		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop().getProperty("url"));
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	public String captureScreen(String tname) {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.ss").format(new Date()); //TimeStamp	

		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+ tname +"_"+ timestamp+".png";

		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
	
	public static Faker fakerData() {
		return faker = new Faker();
	}
	

}
