package week3.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class jqueryselectable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Initial steps
				System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
				ChromeDriver driver= new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get("http://jqueryui.com/selectable/");
					    
				// Get to frame
				
				driver.switchTo().frame(0);
		
		WebElement item1 = driver.findElementByXPath("//li[text()='Item 1']");
		WebElement item3 = driver.findElementByXPath("//li[text()='Item 3']");
		WebElement item5 = driver.findElementByXPath("//li[text()='Item 5']");
		
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.CONTROL).click(item1).click(item3).click(item5).perform();
	}

}
