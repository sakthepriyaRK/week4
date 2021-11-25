package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWebTable {

	public static void main(String[] args) {
		
			WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.get("http://www.leafground.com/pages/table.html");
	
			//1)Get the count of number of rows and columns
	
	List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table_id']//tr"));
	int rowsize=rows.size();
	int colsize = 0;
	System.out.println("row size="+rowsize);
	for (int i = 1; i <=rowsize; i++) 
	{
		List<WebElement> col = driver.findElements(By.xpath("//table[@id='table_id']//tr["+i+"]/td"));
	colsize=col.size();
	}
	System.out.println("column size="+colsize);
	
//	2)Get the Progress value of 'Learn to Interact with elements
	
	 String progreesValue = driver.findElement(By.xpath("//table[@id='table_id']//tr[3]/td[2]")).getText();
System.out.println("progreesValue of Learn To Locators:" +progreesValue);

//3)Check the vital task for the least completed progress
boolean VitalTask = driver.findElement(By.xpath("//table[@id='table_id']//tr[3]//input[@type='checkbox']")).isSelected();
	System.out.println("VitalTask checkbox:" +VitalTask);
	}

}
