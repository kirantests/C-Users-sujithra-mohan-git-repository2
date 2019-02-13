package week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class Dulpicatelead {

	public static void main(String[] args) throws InterruptedException {
		// Edit Lead in Leaftaps
		
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		        ChromeDriver driver = new ChromeDriver();
		        
				driver.get("http://leaftaps.com/opentaps/");
				driver.manage().window().maximize();
				
				//login
				driver.findElementById("username").sendKeys("demosalesmanager");
				driver.findElementById("password").sendKeys("crmsfa");
				driver.findElementByClassName("decorativeSubmit").click();
				driver.findElementByLinkText("CRM/SFA").click();
				driver.findElementByLinkText("Leads").click();
				
				//Find lead 
				driver.findElementByLinkText("Find Leads").click();
				Thread.sleep(2000);
				driver.findElementByXPath("//span[text()='Email']").click();
				driver.findElementByName("emailAddress").sendKeys("demo");
				driver.findElementByXPath("//button[text()='Find Leads']").click();
				Thread.sleep(2000);
				String comp = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-companyName']//a)[3]").getText();
				driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[3]").click();
				driver.findElementByXPath("//a[text()='Duplicate Lead']").click();
				driver.findElementByName("submitButton").click();
				String compare= driver.findElementById("viewLead_companyName_sp").getText();
				System.out.println(compare);
				if(compare.contains(comp))
				{
					System.out.println("Company name Matched");
				}
				
				
				

	}

}
