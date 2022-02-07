package mavenproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {
	public static void main(String[] args) {
		
	
	System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
	  ChromeDriver driver = new ChromeDriver();
	  driver.get("https://acme-test.uipath.com/login");
	  driver.manage().window().maximize();
	  
	  driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
	  driver.findElement(By.id("password")).sendKeys("leaf@12");
	//button[text()='login']
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	String Title=driver.getTitle();
	System.out.println("Title of the page is"+" "+Title);

	driver.findElement(By.partialLinkText("Log Out")).click();
	driver.close();

}
}
