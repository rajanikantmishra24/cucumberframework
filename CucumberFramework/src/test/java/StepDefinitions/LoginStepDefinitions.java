package StepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStepDefinitions extends BaseTest {
	public LoginPage lp;
	public HomePage hp;
	
	@Given("user should be on login page")
	public void user_should_be_on_login_page() {
		StartApp();
		lp=new LoginPage(driver);
		hp=new HomePage(driver);
	    
	}
	@When("user enters the valid userid and valid password")
	public void user_enters_the_valid_userid_and_valid_password() {
		lp.setUsername("admin");
		lp.setPassword("admin");
	    
	}
	@When("click on login button")
	public void click_on_login_button() {
		lp.clickLogin();
	  
	}
	@Then("User should be navigated to home page")
	public void user_should_be_navigated_to_home_page() {
		hp.checkMyPipelineDashboard();
	    
	}
	@Then("user can see Logout Link appear on the home page")
	public void user_can_see_logout_link_appear_on_the_home_page() {
	   hp.clickLogout();
	}
	
	@When("user enters the invalid userid as {string} and invalid password as {string}")
	public void user_enters_the_invalid_userid_as_and_invalid_password_as(String userid, String pwd) {
		lp.login(userid, pwd);
	}
	
	@And("close browser")
	public void close_browser() {
	    driver.quit();
	}
	
	@When("user enters the valid userid as {string} and valid password as {string}")
	public void user_enters_the_valid_userid_as_and_valid_password_as(String string, String string2, io.cucumber.datatable.DataTable dataTable) {
		List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
        lp.login(data.get(0).get("userid"), data.get(0).get("password"));
	}
	
	@When("user enters the valid userid as {string} and password as {string}")
	public void validlogin(String string, String string2) {
	    lp.login(string, string2);
          
	}


}
