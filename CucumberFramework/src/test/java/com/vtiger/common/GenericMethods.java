package com.vtiger.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class GenericMethods {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	
	public GenericMethods(WebDriver driver)
	{
		this.driver = driver;
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	
	public void enterValue(WebElement elm, String val,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.isEnabled();
		
		elm.clear();
		
		elm.sendKeys(val);
		}
		catch(Exception e)
		{
			
			System.out.println(e.getMessage());
		}
	}
	
	
	public void clickElement(WebElement elm,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(elm));
		elm.click();		
		
		
		}
		catch(Exception e)
		{
			
			
		}
	}
	
	public boolean elementDisplay(WebElement elm,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(elm));
		
		return elm.isDisplayed();				
		}
		catch(Exception e)
		{
			
			
			return false;
		}
	}
	
	
	public boolean elementEnable(WebElement elm,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(elm));
		
		return elm.isEnabled();				
		}
		catch(Exception e)
		{
			
			
			return false;
		}
	}
	
	public String getScreenshot()  {
		//below line is just to append the date format with the screenshot name to avoid duplicate names		
	    String destination=null;
		try
		{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//after execution, you could see a folder "FailedTestsScreenshots" under src folder
		destination = System.getProperty("user.dir") + "/src/test/java/com/vtiger/report/screenshot/"+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//Returns the captured file path
		return destination;
	}
	

}
