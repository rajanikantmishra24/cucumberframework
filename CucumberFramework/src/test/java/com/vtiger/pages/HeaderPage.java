package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.vtiger.common.GenericMethods;

public class HeaderPage {
	
	public WebDriver driver;
	public GenericMethods gm;
	
	
	public  HeaderPage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		gm = new GenericMethods(driver);
	}
	
	
	@FindBy(linkText="Logout")
	WebElement lnk_logout;
	
	@FindBy(linkText="New Lead")
	WebElement lnk_NewLead;
	
	@FindBy(linkText="Leads")
	WebElement lnk_Leads;
	
	@FindBy(linkText="My Account")
	WebElement lnk_MyAccount;
	
	@FindBy(linkText="New Account")
	WebElement lnk_NewAccount;
	
	@FindBy(linkText="Home")
	WebElement lnk_Home;
	
	public void clickHome()
	{
		gm.clickElement(lnk_Home,"Link Home");
	}
	
	public void clickNewAccount()
	{
		gm.clickElement(lnk_NewAccount,"Link New Account");
	}
	
	public void clickMyAccount()
	{
		gm.clickElement(lnk_MyAccount,"Link My Account");
	}
	
	public void clickLogout()
	{
		gm.clickElement(lnk_logout,"Link Logout");
	}
	
	public void clickNewLead()
	{
		gm.clickElement(lnk_NewLead,"Link New Lead");
	}

}
