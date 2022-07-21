package StepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public static Properties prop;
	
	
	
	


	
	public void StartApp()
	{	
		readproperties();
		if(prop.getProperty("browser").equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver  = new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver  = new FirefoxDriver();
		}
		else if(prop.getProperty("browser").equals("edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver  = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("AppUrl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("GlobalTimeout"))));
		
		
	}
	
	public void tearDown()
	{
		driver.quit();
	}
	
	
	public void readproperties() 
	{
		try
		{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/setting.properties");
		prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	

}
