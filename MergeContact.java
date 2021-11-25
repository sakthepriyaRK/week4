package week4.day2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
//		/*
//		 * //Pseudo Code
//		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
//* 1. Launch URL "http://leaftaps.com/opentaps/control/login"
//2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
//		 * 3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		
//		 * 4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
//		 * 5. Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		
//		 * 6. Click on Merge Contacts using Xpath Locator
		 driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		 
//		 * 7. Click on Widget of From Contact
       driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
       
//		 * 8. Click on First Resulting Contact
//driver.findElement(By.xpath("//div[@class='x-grid3-row']/td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first']/following::a[@class='linktext']")).click();
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
   //driver.findElement(By.xpath("//table[(contains(@class,'x-grid3-row-table')]/a)")).click();
driver.findElement(By.xpath("//table[contains(@class,'x-grid3-row-table')]//td//a[@class='linktext']")).click();
//driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
//		 * 9. Click on Widget of To Contact
//		 * 
//		 * 10. Click on Second Resulting Contact
//		 * 
//		 * 11. Click on Merge button using Xpath Locator
//		 * 
//		 * 12. Accept the Alert
//		 * 
//		 * 13. Verify the title of the page

	}

}
