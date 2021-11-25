package week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundSorttable {

	public static void main(String[] args) {
		
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.get("http://www.leafground.com/pages/sorttable.html");
	//find all the values of name and store it in list and sort
	 
 List<WebElement> name = driver.findElements(By.xpath("//table[@id='table_id']//tr/td[@class='sorting_1']"));
 int row=name.size();System.out.println(row);
 List<WebElement> name1 = driver.findElements(By.xpath("//table[@id='table_id']//following::th"));
 int col=name.size();System.out.println(col);
List<String> out=new ArrayList<String>();
 for (int i = 1; i <=row; i++) {
 for (int j= 2; j<3; j++)
	 {
	    String text = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td["+j+"]")).getText();
	     out.add(text);
	     System.out.println(text);
 
}
	 }

Collections.sort(out);
System.out.println(out);
//click on the name header
driver.findElement(By.xpath("//table[@id='table_id']//th[text()='Name']")).click();
//again get all the values and store it in the list
List<String> out1= new ArrayList<String>();
for(int k=1;k<=row;k++) 
{for(int l=2;l<3;l++)
{
	String text1 = driver.findElement(By.xpath("//table[@id='table_id']//tr["+k+"]/td["+l+"]")).getText();
	out1.add(text1);
	System.out.println(text1);
	
}}
System.out.println(out1);
if(out.equals(out1))
{System.out.println("same order" );
}
else
{System.out.println("diff order");
}

	


	}
}
