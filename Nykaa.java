package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) {
//		1) Go to https://www.nykaa.com/
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.nykaa.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
//			2) Mouseover on Brands and Search L'Oreal Paris
		WebElement brands = driver.findElement(By.xpath("//div[@id='headerMenu']//following::a[text()='brands']"));
		Actions builder=new Actions(driver);
		builder.moveToElement(brands).perform();
		
		
//			3) Click L'Oreal Paris
		driver.findElement(By.xpath("//div[@class='css-ov2o3v']/a[text()='L'Oreal Paris']")).click();
		
//			4) Check the title contains L'Oreal Paris(Hint-GetTitle)
	   String title = driver.getTitle();
	 System.out.println("Title is:"+title);
		
//			5) Click sort By and select customer top rated
	driver.findElement(By.xpath("//button[@class='top css-p2rfnw']/span[text()='Sort By : popularity']")).click();
	driver.findElement(By.xpath("//button[@class='control-value']/span[text()='customer top rated']]")).click();
	
	
//			6) Click Category and click Hair->Click haircare->Shampoo
	
	driver.findElement(By.xpath("//div[@class='filter-open css-nbw8dp']/span[text()='Category']")).click();
	driver.findElement(By.xpath("//div[@class=' css-15dbf9i']/span[text()='Hair']")).click();
	driver.findElement(By.xpath("//div[@class=' css-15dbf9i']/span[text()='Hair Care']")).click();
	driver.findElement(By.xpath("//div[@class=' control-value']/span[text()='Shampoo']")).click();
//			
	
	//      7) Click->Concern->Color Protection
	driver.findElement(By.xpath("//div[@class=' filter-open css-nbw8dp']/span[text()='Concern']")).click();
	driver.findElement(By.xpath("//div[@class=' control-value']/span[text()='Color Protection']")).click();

	
//			8)check whether the Filter is applied with Shampoo
	String check = driver.findElement(By.xpath("//div[@class='css-1f2fmpt']/span[text()='Filters Applied']")).getText();
	System.out.println(check);
	List<WebElement> filtervalue = driver.findElements(By.className("filter-value"));
	System.out.println("filtervalue size:"+filtervalue.size());
	for (WebElement each : filtervalue) {
		String filtervaluetext = each.getText();
		if(filtervaluetext=="Shampoo")
		{System.out.println("filter applied");
		}
		else
		{System.out.println("filter not applied");
		}
		
		
	}
	
    //			9) Click on L'Oreal Paris Colour Protect Shampoo

	driver.findElement(By.xpath("//div[@class='lazy-load-wrap']/img[text()='L'Oreal Paris Colour Protect Shampoo']")).click();

	//			10) GO to the new window and select size as 175ml
	
	Set<String> allwindow = driver.getWindowHandles();
	System.out.println("allwindow size:"+allwindow.size());
	List<String>windows=new ArrayList<String>(allwindow);
	String firstwindow = windows.get(0);
	String windownext = windows.get(1);
	
//			11) Print the MRP of the product
//			12) Click on ADD to BAG
//			13) Go to Shopping Bag 
//			14) Print the Grand Total amount
//			15) Click Proceed
//			16) Click on Continue as Guest
//			17) Check if this grand total is the same in step 14
//			18) Close all windows

}

}
