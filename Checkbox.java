package mavenproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement Checkbox1=driver.findElement(By.xpath("//input[@type='checkbox']"));
		if(Checkbox1.isSelected()){
			
			System.out.println("Java is Selected");
		}
		
		else {
			System.out.println("Java is Not Selected");
		}
		
		WebElement Checkbox2=driver.findElement(By.xpath("(//input[@type='checkbox'])[6]"));
	if(Checkbox2.isSelected()){
			
			System.out.println("selenium is Selected");
		}
		
		else {
			System.out.println("selenium is Not Selected");
		}
		
		
}
}
