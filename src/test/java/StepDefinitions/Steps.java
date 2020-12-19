package StepDefinitions;

import java.awt.Desktop.Action;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import PageObjects.AddUser;
import PageObjects.LoginPage;
import Utilities.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Steps {
	
	public WebDriver driver;
	public LoginPage lp;
	public AddUser au;
	
	//User Login steps
	
	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		driver=new ChromeDriver();
	    lp=new LoginPage(driver);
	    au=new AddUser(driver);
	}

	@When("user opens URL {string}")
	public void iuser_opens_url(String url) {
	    driver.get(url);
	    driver.manage().window().maximize();
	}

	@And("user enters email as {string} and password as {string}")
	public void user_enters_email_as(String email, String password) throws InterruptedException {
	    lp.setUserName(email);
	    lp.clickContinue();
	    Thread.sleep(2000);
	    lp.setPassword(password);
	    //Thread.sleep(3000);
	}
	
	@And("user clicks on login button")
	public void click_on_continue() throws InterruptedException {
	    lp.clickLogin();
	    //Thread.sleep(5000);
	}
	

	
	@Then("page title of landing page is {string}")
	public void title_displayed(String title) throws InterruptedException {
		//Thread.sleep(5000);
		String actual_title = lp.getTitle();
		System.out.println("Test title:" +actual_title);
		Assert.assertEquals(title, actual_title);
	}
	
	@When("user clicks on log out link")
	public void click_logout() throws InterruptedException {
		lp.clickLogout();
		Thread.sleep(8000);
	}
	
	@Then("close browser")
	public void close_browser() throws InterruptedException {
	    driver.quit();
	}
	
	//Reset Password Steps
	
	@Then("user clicks on my profile")
	public void my_Profile() throws InterruptedException {
		lp.myProfile();
	}
	
	@When("user clicks on reset password")
	public void reset_pwd() throws InterruptedException {
		lp.resetPwd();
	}
	
	@And("user clicks on Reset link")
	public void resetLink() throws InterruptedException {
		lp.clickResetLink();
	}
	
	@And("user clicks on Reset Password button")
	public void resetPasswordBtn() throws InterruptedException {
		lp.clickResetPwdLink();
		//Thread.sleep(3000);	
	}
	
	@And("user enters the new password as {string}" )
	public void user_enters_new_password_as(String password) throws InterruptedException {
	    lp.setPreferredPassword(password);
	    Thread.sleep(3000);
	    lp.setreEnterPassword(password);
	    Thread.sleep(3000);   
	}
	
	@And("user submits new password" )
	public void user_submits_new_password_as() throws InterruptedException {
		lp.submitNewPassword();  
		Thread.sleep(5000);
	}
	
	@Then("error message is displayed")
	public void error_message_display() throws InterruptedException {
		lp.errorMsgLogin(); 
	}
	
	//Add User Steps
	
	@And("user clicks on My Business menu")
	public void click_mybusiness_menu() throws InterruptedException {
		au.clickMyBusiness();	
	}
	
	@And("user clicks on Users radio button")
	public void click_user_radiobtn() throws InterruptedException {
		au.clickUsers();	
	}
	
	@And("user clicks on Add User icon")
	public void click_add_user_icon() throws InterruptedException {
		au.clickAddIcon();	
	}
	
	@And("user enters first name")
	public void enter_first_name() throws InterruptedException {
		au.userFirstName();
	}
	
	@And("user enters last name")
	public void enter_last_name() throws InterruptedException {
		au.userLastName();
	}
	
	@And("user enters email")
	public void enter_email() throws InterruptedException, IOException {
		au.userEmail();
	}
	
	@And("user enters phone")
	public void enter_phone() throws InterruptedException {
		au.userPhoneNum();
	}
	
	@And("user clicks on OK button")
	public void click_ok() throws InterruptedException {
		au.clickOKbutton();
	}
	
	@And("user navigates to email {string}")
	public void openEmailURL(String emailURL) throws InterruptedException {
		String fName=au.firstName;
		emailURL="https://email.ghostinspector.com/"+fName+"@email.ghostinspector.com";
		driver.get(emailURL);
		Thread.sleep(6000);
		driver.navigate().refresh();
	}
	@And("user activates the account")
	public void activateEmailAccount() throws InterruptedException {
		au.activateLink();
	}
	
	@And("user clicks on welcome mail")
		public void clickWelcomeMail() throws InterruptedException {
		au.openWelcomeEmail();
	}
	
	@And("user activates account")
	public void activateMail() throws InterruptedException {
	au.activateLink();
	}
	
	@And("user provides email as {string} and password as {string}")
	public void loginCredentials(String newUserName, String newPassword) throws InterruptedException, IOException {
		
		//Reading from file.
		FileReader FR = new FileReader("Data/usernames.txt");
		BufferedReader BR = new BufferedReader(FR);
		String Username = BR.readLine();
		
		lp.setUserName(Username);
		lp.clickContinue();
		Thread.sleep(2000);
		lp.setPassword(newPassword);
		lp.clickLogin();
		Thread.sleep(2000);
	}

}


