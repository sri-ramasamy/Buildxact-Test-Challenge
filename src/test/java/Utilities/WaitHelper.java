package Utilities;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.LoginPage;

public class WaitHelper{
	
	public WebDriver driver;

	public WaitHelper(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void waitForClickable(WebElement we) {
		WebDriverWait wait=new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.elementToBeClickable(we));
	}
	
	public void waitTillInvisible(WebElement we) {
		WebDriverWait wait=new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.invisibilityOf(we));
				
	}
	
	public void waitTillvisible(WebElement we) {
		WebDriverWait wait=new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	
	public void waitTillTitlePresent(WebElement we, String title) {
		WebDriverWait wait=new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	
	public void switchToTab(){
		Set<String> handles = driver.getWindowHandles();
	    String currentHandle = driver.getWindowHandle();
	    for (String handle : handles) {

	     if (!handle .equals(currentHandle))
	     {
	         driver.switchTo().window(handle);
	     }
	   }
	    
	}
	
	public void switchToParentTab() {
		driver.switchTo().defaultContent();
	}
	
	public void waittillStale() {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
	}
	
	public void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].click();", element);
	}
	
	public void pageRefresh() {
		driver.navigate().refresh();
	}
	
				
}
