package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.mongodb.client.model.geojson.Point;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqResizzable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.id("resizable"));
		//Point location=drag.getLocation();
		int x=drag.getLocation().getX();
		int y=drag.getLocation().getY();
		int l=drag.getRect().getHeight();
        Actions builder=new Actions(driver);

//below statement also works
//builder.dragAndDropBy(drag, 50, 40).perform();
builder.clickAndHold(drag).moveByOffset(100,50).perform();;
	}

}
