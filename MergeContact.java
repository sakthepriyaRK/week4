package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
      Set<String> allwindow = driver.getWindowHandles();
       System.out.println("allwindow:"+allwindow.size());
       List<String> windows=new ArrayList<String>(allwindow);
     String windownext = windows.get(1);
   String windowfirst = windows.get(0);
   driver.switchTo().window(windownext);
   Thread.sleep(2000);
  // driver.findElement(By.xpath("//div[@class='x-grid3-row']/td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first']/following::a[@class='linktext']")).click();
    //WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
   
    //driver.findElement(By.xpath("//table[contains(@class,'x-grid3-row-table')]/a")).click();
driver.findElement(By.xpath("//table[contains(@class,'x-grid3-row-table')]//td//a[@class='linktext']")).click();

   // driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();

 
//               	 * 9. Click on Widget of To Contact
driver.switchTo().window(windowfirst);

driver.findElement(By.xpath("//table[@class='twoColumnForm']//following::img[2]")).click();

 //                      * 10. Click on Second Resulting Contact

Set<String> allwindow2 = driver.getWindowHandles();
System.out.println("allwindow2:"+allwindow2.size());
List<String> windows2=new ArrayList<String>(allwindow2);
String windownext2 = windows2.get(1);
String windowfirst2 = windows2.get(0);
driver.switchTo().window(windownext2);
Thread.sleep(2000);
driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();

 //		 * 11. Click on Merge button using Xpath Locator
driver.switchTo().window(windowfirst2);
Thread.sleep(2000);
driver.findElement(By.xpath("//a[text()='Merge']")).click();

//		 * 12. Accept the Alert

driver.switchTo().alert().accept();

//		 * 13. Verify the title of the page
System.out.println("Page title:"+driver.getTitle());
	}

}
