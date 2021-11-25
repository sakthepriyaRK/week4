package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {
	
public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
ChromeOptions options = new ChromeOptions();
options.addArguments("--disable-notifications");
ChromeDriver driver = new ChromeDriver(options);
driver.get("https://www.myntra.com/");
driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			//2) Mouse hover on MeN 
WebElement momen = driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Men']"));
Actions builder=new Actions(driver);
builder.moveToElement(momen).perform();
			//3) Click Jackets 
driver.findElement(By.xpath("//div[@data-group='men']//a[text()='Jackets']")).click();
			//4) Find the total count of item 
String text = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
System.out.println(text);	

String text1=text.replaceAll("[\\D ]","" ).replaceAll("[\\W\\s]","" );
System.out.println(text1);
int d=Integer.parseInt(text1);

//5) Validate the sum of categories count match

String text2 = driver.findElement(By.xpath("//input[@value='Jackets']/following::span[@class='categories-num'][1]")).getText();
String text3 = driver.findElement(By.xpath("//input[@value='Jackets']/following::span[@class='categories-num'][2]")).getText();	
System.out.println(text2);

String text22=text2.replaceAll("\\W","" );System.out.println(text22);
String text33=text3.replaceAll("\\W","" );System.out.println(text33);
int a=Integer.parseInt(text22);
int b=Integer.parseInt(text33);
int c=a+b;
if(d==c)
{System.out.println("count same");
}
else
{System.out.println("count diff");}

//6) Check jackets

driver.findElement(By.xpath("//input[@type='checkbox']/following::div[@class='common-checkboxIndicator']")).click();

//7) Click + More option under BRAND
driver.findElement(By.xpath("//span[text()='Brand']/following::div[@class='brand-more']")).click();

//	8) Type Duke and click checkbox
driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("Duke");
driver.findElement(By.xpath("//input[@value='Duke']/following::div[@class='common-checkboxIndicator']")).click();


       //9) Close the pop-up x
driver.findElement(By.xpath("//ul[@class='FilterDirectory-indices']/following::span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
////10) Confirm all the Coats are of brand Duke
//			    Hint : use List 
List<WebElement>Duke = driver.findElements(By.xpath("//h3[text()='Duke']"));
System.out.println(Duke.size());

for (WebElement webElement : Duke) {
	String textduke=webElement.getText();
	//System.out.println(textduke);
	if(!textduke.equals("Duke"))
	{System.out.println("the brand is not duke");
	}
}
			//11) Sort by Better Discount


WebElement discount = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
Actions Builder=new Actions(driver);
Builder.moveToElement(discount).perform();
driver.findElement(By.xpath("//label[text()='Better Discount']")).click();

       //12) Find the price of first displayed item
//String Priceofirst = driver.findElement(By.xpath("//div[@class='product-price']/following::span[@class='product-discountedPrice']")).getText();
String Priceofirst = driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
System.out.println("Price of 1st item:"+Priceofirst);
		
        //13) Click on the first product	
driver.findElement(By.xpath("//div[@class='product-sliderContainer']/following::div[@class='product-productMetaInfo']")).click();
			
           //14) Click on WishList Now

Set<String> allwindow = driver.getWindowHandles();
System.out.println("allwindow:"+allwindow.size());
List<String> windows=new ArrayList<String>(allwindow);
String windownext = windows.get(1);
String windowfirst = windows.get(0);
driver.switchTo().window(windownext);
Thread.sleep(2000);
//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));

driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
//Thread.sleep(4000);
//driver.findElement(By.xpath("//div[@class='size-buttons-size-container']//following::span[text()='WISHLIST']")).click();
//driver.findElement(By.xpath("//span[contains(@class,'product-actionsButton')]")).click();
			//14) Close Browser(driver.close())
driver.close();
}


		
	}


