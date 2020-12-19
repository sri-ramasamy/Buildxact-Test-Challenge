package PageObjects;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StepDefinitions.Steps;
import Utilities.WaitHelper;

public class LoginPage{
	public WebDriver ldriver;
	public String btnName;
	public WaitHelper waithelper;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		waithelper = new WaitHelper(ldriver);
		
	}
	@FindBy(id="username")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//button[@id='bx-continue']")
	@CacheLookup
	WebElement btnContinue;
	
	@FindBy(xpath="//span[contains(text(),'My Profile')]")
	@CacheLookup
	WebElement menuMyprofile;
	
	@FindBy(xpath="//label[contains(text(),'Log Out')]")
	@CacheLookup
	WebElement lnklogout;
	
	@FindBy(xpath="//button[contains(text(),'Reset Password')]")
	@CacheLookup
	WebElement resetPwd;
	
	@FindBy(xpath="//a[@id='btn-menuLock-collapse']")
	@CacheLookup
	WebElement dummyClick;
	
	@FindBy(xpath="//title")
	@CacheLookup
	WebElement title;
	
	//Loading icon 
	@FindBy(xpath="//div[@id='busy-overlay-container']/div/img")
	@CacheLookup
	WebElement loadingImg;
	
	//Reset Password link to reset the password
	@FindBy(xpath="//a[contains(text(),'RESET PASSWORD')]")
	@CacheLookup
	WebElement resetPwdLink;
	
	//Set Preferred Password - Password text box
	@FindBy(id="pswd")
	@CacheLookup
	WebElement setPreferredPwd;
	
	//loader gif
	@FindBy(xpath="//div[@style='visibility: hidden;']")
	@CacheLookup
	WebElement loaderGif;
	
	//Set Preferred Password - Password text box
	@FindBy(id="pswd-rpt")
	@CacheLookup
	WebElement reEnterPwd;
	
	@FindBy(xpath="//button[@type='submit']")
	@CacheLookup
	WebElement submitNewPwd;
	
	@FindBy(xpath="//span[contains(text(),'incorrect')]")
	@CacheLookup
	WebElement incorrectPwd;

	public void setUserName(String uname) throws InterruptedException {
		txtEmail.clear();
		Thread.sleep(5000);
		txtEmail.sendKeys(uname);
	}
	
	public void clickContinue() {
		waithelper.waitForClickable(btnContinue);
		btnContinue.click();
	}
	
	public void setPassword(String pwd) {
		txtPassword.isDisplayed();
		txtPassword.clear();
		waithelper.waitForClickable(txtPassword);
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin() throws InterruptedException {
		Thread.sleep(3000);
		waithelper.waittillStale();
		btnLogin.click();
		Thread.sleep(9000);
		waithelper.waittillStale();
	}
	
	public String getTitle() {
		return ldriver.getTitle();
	}
	
	public void myProfile() throws InterruptedException {
		waithelper.waitForClickable(menuMyprofile);
		menuMyprofile.click();
	}
	
	public void resetPwd() throws InterruptedException {
		waithelper.waitForClickable(resetPwd);
		resetPwd.click();
		//Thread.sleep(2000);
		waithelper.waittillStale();
		clickOn("OK");
		//Thread.sleep(2000);
		waithelper.waittillStale();
		dummyClick.click();
		
	}
	
	public void clickLogout() throws InterruptedException {
		waithelper.waitForClickable(menuMyprofile);
		menuMyprofile.click();
		waithelper.waitForClickable(lnklogout);
		lnklogout.isEnabled();
		lnklogout.click();
		//Thread.sleep(2000);
		waithelper.waittillStale();
		clickOn("Yes");
	}
	
	public void clickOn(String btnName) {
		
		ldriver.findElement(By.xpath("//button[contains(text(),'"+btnName+"')]")).click();;
	}
	
	public void clickResetLink() throws InterruptedException {
		Thread.sleep(8000);
		ldriver.findElement(By.xpath("(//a[contains(text(),'Reset')])[1]")).click();
	}
	
	public void clickResetPwdLink() throws InterruptedException {
		waithelper.waitForClickable(resetPwdLink);
		resetPwdLink.click();
		//waithelper.waittillStale();
		Thread.sleep(4000);
		waithelper.switchToTab();
	}
		
	public void setPreferredPassword(String prefpwd) {
		setPreferredPwd.isDisplayed();
		setPreferredPwd.clear();
		waithelper.waitForClickable(setPreferredPwd);
		setPreferredPwd.sendKeys(prefpwd);
	}
	
	public void setreEnterPassword(String repwd) throws InterruptedException {
		reEnterPwd.isDisplayed();
		reEnterPwd.clear();
		waithelper.waitForClickable(setPreferredPwd);
		reEnterPwd.sendKeys(repwd);
		Thread.sleep(2000);
	}
	
	public void submitNewPassword() throws InterruptedException {
		waithelper.waitForClickable(submitNewPwd);
		//Thread.sleep(2000);
		waithelper.waittillStale();
		submitNewPwd.click();
		//Thread.sleep(5000);
		waithelper.waittillStale();
	}
	
	public void errorMsgLogin() throws InterruptedException {
		waithelper.waitTillvisible(incorrectPwd);
	}
	
}
