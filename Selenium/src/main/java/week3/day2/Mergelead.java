package week3.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mergelead {

	public static void main(String[] args) throws InterruptedException {
		// Homework - Merge lead
		
		//Driver initialisation
		//pulled from github
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	    ChromeDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    
	    //login leaftaps
	    driver.get("http://leaftaps.com/opentaps/");
	    driver.findElementById("username").sendKeys("demosalesmanager");
	    driver.findElementById("password").sendKeys("crmsfa");
	    driver.findElementByClassName("decorativeSubmit").click();
	    
	    //Go to Merge lead option
	    driver.findElementByLinkText("CRM/SFA").click();
	    driver.findElementByLinkText("Leads").click();
	    driver.findElementByLinkText("Merge Leads").click();
	    
	    driver.findElementByXPath("//a[contains(@href,'partyIdFrom')]").click();
	    
	    //Window handling - Proceed to new window
	    Set<String> allwindows = driver.getWindowHandles();
	    List<String> ls = new ArrayList<String>();
	    ls.addAll(allwindows);
	    
	    String newwindow = ls.get(1);
	    driver.switchTo().window(newwindow);
	    
	    //Provide input lead
	    driver.findElementByName("id").sendKeys("10138");
	    driver.findElementByXPath("//button[text()='Find Leads']").click();
	    Thread.sleep(3000);
	    driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a").click();
	    
	    //Back to primary window
	    String parentwindow = ls.get(0);
	    driver.switchTo().window(parentwindow);
	    driver.findElementByXPath("//a[contains(@href,'partyIdTo')]").click();
	    
	    //Move to new window and enter To values
	    Set<String> allwindows2 = driver.getWindowHandles();
	    List<String> ls2 = new ArrayList<String>();
	    ls2.addAll(allwindows2);
	    String newwindow2 = ls2.get(1);
	    driver.switchTo().window(newwindow2);
	    
	    //Pass on values
	    driver.findElementByName("id").sendKeys("10132");
	    driver.findElementByXPath("//button[text()='Find Leads']").click();
	    Thread.sleep(3000);
	    driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a").click();
	    
	    //Back to primary
	    driver.switchTo().window(ls2.get(0));
	    driver.findElementByLinkText("Merge").click();
	    Alert alert = driver.switchTo().alert(); 
	    alert.accept();
	    
	    driver.findElementByLinkText("Find Leads").click();
	    driver.findElementByName("id").sendKeys("10138");
	    driver.findElementByXPath("//button[text()='Find Leads']").click();
	    
	    
	    
	    
	    
	    
	    

		

	}

}
