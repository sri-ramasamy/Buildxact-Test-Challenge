package PageObjects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitHelper;

public class AddUser {
	public WebDriver ldriver;
	public String title;
	public WaitHelper waithelper;
	
	int i = new Random().nextInt(900) + 100;
	public String firstName="TestFirst_"+i;
	public String fName=firstName;
	
	public String randomNumbers = RandomStringUtils.randomNumeric(3);
	public String phoneNo = "0444123"+randomNumbers;
	
	
	public AddUser(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		waithelper = new WaitHelper(ldriver);
		
	}
	@FindBy(xpath="//span[contains(text(),'Business')]")
	@CacheLookup
	WebElement menuMyBusiness;
	
	@FindBy(xpath="//label[contains(text(),'Users')]")
	@CacheLookup
	WebElement radiobtnUsers;
	
	@FindBy(xpath="//i[@class='ti-plus']")
	@CacheLookup
	WebElement addIcon;
	
	@FindBy(xpath="//h4[contains(text(),'New User')]")
	@CacheLookup
	WebElement adduserTitle;
	
	@FindBy(xpath="//label[contains(text(),'First Name')]/following-sibling::input")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(xpath="//label[contains(text(),'Last Name')]/following-sibling::input")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(xpath="//label[@class='text-info'][contains(text(),'Email')]/following-sibling::input")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id="phone")
	@CacheLookup
	WebElement txtPhoneNum;
	
	@FindBy(xpath="//button[contains(text(),'OK')]")
	@CacheLookup
	WebElement btnOK;
	
	@FindBy(xpath="//a[contains(text(),'Welcome to Buildxact')]")
	@CacheLookup
	WebElement welcomeMail;
	
	@FindBy(xpath="//a[contains(text(),'ACTIVATE')]")
	@CacheLookup
	WebElement linkActivate;
	
	
	public void clickMyBusiness() throws InterruptedException {
		Thread.sleep(3000);
		waithelper.waitForClickable(menuMyBusiness);
		menuMyBusiness.click();
		Thread.sleep(3000);
		//waithelper.waitTillvisible(radiobtnUsers);
	}
		
	public void clickUsers() throws InterruptedException {
		waithelper.waitForClickable(radiobtnUsers);
		radiobtnUsers.click();
		Thread.sleep(3000);
		//waithelper.waitTillvisible(addIcon);
	}
	public void clickAddIcon() throws InterruptedException {
		waithelper.waitForClickable(addIcon);
		addIcon.click();
		//waithelper.waitTillInvisible(adduserTitle);
		Thread.sleep(3000);
	}
	
	public void userFirstName() throws InterruptedException {
		txtFirstName.clear();
		txtFirstName.sendKeys(firstName);
		Thread.sleep(2000);
	}
	
	public void userLastName() throws InterruptedException {
		txtLastName.clear();
		int i = new Random().nextInt(11) + 1;
		txtLastName.sendKeys("LastName_"+i);
		Thread.sleep(2000);
	}
	public void userEmail() throws InterruptedException, IOException {
		txtEmail.clear();
		int i = new Random().nextInt(11) + 1;
		txtEmail.sendKeys(firstName+"@email.ghostinspector.com");
		String newName=firstName+"@email.ghostinspector.com";
		Thread.sleep(2000);
		
		 //Create File In   
		  String TestFile = "Data/usernames.txt";
		  File FC = new File(TestFile);//Created object of java File class.
		  FC.createNewFile();//Create file.
		  
		  //Writing In to file.
		  FileWriter FW = new FileWriter(TestFile);
		  BufferedWriter BW = new BufferedWriter(FW);
		  BW.write(newName);
		  BW.close();
	}
	public void userPhoneNum() throws InterruptedException {
		txtPhoneNum.clear();
		txtPhoneNum.sendKeys(phoneNo);
		Thread.sleep(2000);
	}
	public void clickOKbutton() throws InterruptedException {
		waithelper.waitForClickable(btnOK);
		btnOK.click();
		Thread.sleep(3000);
	}
	
	public void openWelcomeEmail() throws InterruptedException {
		waithelper.waitForClickable(welcomeMail);
		welcomeMail.click();
		Thread.sleep(3000);
	}
	public void activateLink() throws InterruptedException {
		waithelper.waitForClickable(linkActivate);
		linkActivate.click();
		Thread.sleep(4000);
		waithelper.switchToTab();
	}
	
	
	
}
