package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import hooks.BaseClass;


public class ScreenshotListener implements ITestListener{

	public void onTestFailure(ITestResult result) {
		
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.ss").format(new Date()); //TimeStamp	

		TakesScreenshot ts = (TakesScreenshot)BaseClass.driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+ result.getName() +"_"+ timestamp+".png";

		File targetFile = new File(targetFilePath);
		try {
			FileHandler.copy(sourceFile, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
