package mavenproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Buttons {
	public static void main(String[] args) throws InterruptedException {
		
	
	
WebDriverManager.chromedriver().setup();
	
	ChromeDriver driver=new ChromeDriver();
	driver.get("http://leafground.com/pages/Button.html");
	driver.manage().window().maximize();
	Thread.sleep(2000);
	
	WebElement Colour=driver.findElement(By.id("color"));
	System.out.println("The Button Colour is"+" "+Colour.getCssValue("background-color"));
	
	
	WebElement Size=driver.findElement(By.id("size"));
	System.out.println("The Size is"+" "+Size.getSize());
	//position
	WebElement Location=driver.findElement(By.id("position"));
	System.out.println("The Location of the Field"+" "+Location.getLocation());
}
}