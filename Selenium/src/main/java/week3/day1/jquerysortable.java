package week3.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class jquerysortable {

	public static void main(String[] args) {
		// jquery sortable homework - Actions
		
		//Initial steps
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://jqueryui.com/sortable/");
			    
		// Get to frame
		
		driver.switchTo().frame(0);
		WebElement item = driver.findElementByXPath("//li[text()='Item 1']");
		WebElement item4 = driver.findElementByXPath("//li[text()='Item 4']");
		int y = item4.getLocation().getY();
		
		Actions builder= new Actions(driver);
		//builder.sendKeys(Keys.CONTROL).click(item).dragAndDrop(item, item4).perform();
		builder.sendKeys(Keys.CONTROL).click(item).dragAndDropBy(item, 0, y).perform();
		
		//Another method - movetoelement.movebyoffset
		
			    

	}

}
