package mavenproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {
	/*
	 * //Pseudo Code
	 * 
	 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
	 * 
	 * 2. Enter UserName and Password Using Id Locator
	 * 
	 * 3. Click on Login Button using Class Locator
	 * 
	 * 4. Click on CRM/SFA Link
	 * 
	 * 5. Click on contacts Button
	 * 
	 * 6. Click on Create Contact
	 *  
	 * 7. Enter FirstName Field Using id Locator
	 * 
	 * 8. Enter LastName Field Using id Locator
	 * 
	 * 9. Enter FirstName(Local) Field Using id Locator
	 * 
	 * 10. Enter LastName(Local) Field Using id Locator
	 * 
	 * 11. Enter Department Field Using any Locator of Your Choice
	 * 
	 * 12. Enter Description Field Using any Locator of your choice 
	 * 
	 * 13. Enter your email in the E-mail address Field using the locator of your choice
	 * 
	 * 14. Select State/Province as NewYork Using Visible Text
	 * 
	 * 15. Click on Create Contact
	 * 
	 * 16. Click on edit button 
	 * 
	 * 17. Clear the Description Field using .clear
	 * 
	 * 18. Fill ImportantNote Field with Any text
	 * 
	 * 19. Click on update button using Xpath locator
	 * 
	 * 20. Get the Title of Resulting Page.
     */
	public static void main(String[] args) {
		
		

		//System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		  ChromeDriver driver = new ChromeDriver();
		  driver.get("http://leaftaps.com/opentaps/control/login");
		  driver.manage().window().maximize();
		  driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		  
		  driver.findElement(By.id("password")).sendKeys("crmsfa");
		  
		  driver.findElement(By.className("decorativeSubmit")).click();
		  driver.findElement(By.partialLinkText("CRM/SFA")).click();
		  driver.findElement(By.partialLinkText("Contacts")).click();
	      driver.findElement(By.partialLinkText("Create Contact")).click();
		  WebElement FirstName=driver.findElement(By.id("firstNameField"));
		  
		  FirstName.sendKeys("BARANI");
		  
		  WebElement LastName=driver.findElement(By.id("lastNameField"));
		  
		  LastName.sendKeys("PRAKASH");
		  //firstNameLocal
		  //lastNameField
		  WebElement FirstNameLocal=driver.findElement(By.id("createContactForm_firstNameLocal"));
		  WebElement LastNameLocal=driver.findElement(By.id("createContactForm_lastNameLocal"));
		  
		  FirstNameLocal.sendKeys("BHARANI");
		  LastNameLocal.sendKeys("M");
		  
		  driver.findElement(By.xpath("//input[@id='createContactForm_departmentName']")).sendKeys("MECHANICAL ENGG");
		 
		  driver.findElement(By.id("createContactForm_description")).sendKeys("Test");
	
		  driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("baraniprakash121@gmail.com");
		  
		  Select State = new Select(driver.findElement(By.id("createContactForm_generalStateProvinceGeoId")));
		  
		  State.selectByVisibleText("New York");
		  ////input[@class='smallSubmit']
		  driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		  
		  
		  driver.findElement(By.partialLinkText("Edit")).click();
		  driver.findElement(By.id("updateContactForm_description")).clear();
		  
		  driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Test");
		  
		  driver.findElement(By.xpath("//input[@value='Update']")).click();
		  
		 String Title=driver.getTitle();
		 
		 System.out.println("Title of the Resulting Page is"+" "+Title);
		  
	}
	
	

}
