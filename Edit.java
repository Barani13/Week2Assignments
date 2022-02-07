package mavenproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit {
	public static void main(String[] args) throws InterruptedException {
		
	

	WebDriverManager.chromedriver().setup();
	
	ChromeDriver driver=new ChromeDriver();
	driver.get("http://leafground.com/pages/Edit.html");
	driver.manage().window().maximize();
	Thread.sleep(2000);
	
	WebElement TextBox=driver.findElement(By.xpath("//input[@disabled='true']"));
	if(TextBox.isEnabled()) {
		System.out.println("TextBox is Enabled");
	}
	else {
		System.out.println("TextBox is disabled");
	}
}
}