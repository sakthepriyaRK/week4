package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround {

	public static void main(String[] args) throws IOException {
//		http://leafground.com/pages/frame.html
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
//			1.Take the the screenshot of the click me button of first frame
		driver.switchTo().frame(0);
		WebElement snap = driver.findElement(By.xpath("//button[@id='Click']"));
		File source=snap.getScreenshotAs(OutputType.FILE);
		File dest=new File("snapshot/out/snap.png");
		FileUtils.copyFile(source, dest);
		driver.switchTo().defaultContent();
		
//			2.Find the number of frames
		 List<WebElement> number = driver.findElements(By.tagName("iframe"));
		 int a=number.size();
		 List<String> ss=new ArrayList<String>();
		 for (int i = 0; i < a; i++) {
			 String text = driver.findElement(By.tagName("iframe")).getText();
			ss.add(text);
			}
		 System.out.println(ss);
		
		 
		 System.out.println(number.size());
		 
		
//			  - find the Elements by tagname - iframe
//			  - Store it in a list
//			  - Get the size of the list. (This gives the count of the frames visible to the main page)
	}

}
