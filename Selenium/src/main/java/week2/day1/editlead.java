package week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class editlead {

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
		driver.findElementByXPath("(//label[contains(text(),'First')])[3]/following::input").sendKeys("Raj");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]").click();
		String pr= driver.findElementById("sectionHeaderTitle_leads").getText();
		System.out.println(pr);
		
		//Edit lead
		driver.findElementByXPath("//a[text()='Edit']").click();
		driver.findElementById("updateLeadForm_companyName").clear();
		driver.findElementById("updateLeadForm_companyName").sendKeys("TCS");
		driver.findElementByXPath("//input[@name='submitButton']").click();
		String com = driver.findElementById("viewLead_companyName_sp").getText();
		System.out.println("the company name is "+com);
		
		
        
	}

}
