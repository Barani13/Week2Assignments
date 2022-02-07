package mavenproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {


	/*http://leaftaps.com/opentaps/control/main

	1	Launch the browser
	2	Enter the username
	3	Enter the password
	4	Click Login
	5	Click crm/sfa link
	6	Click Leads link
	7	Click Find leads
	8	Click on Email
	9	Enter Email
	10	Click find leads button
	11	Capture name of First Resulting lead
	12	Click First Resulting lead
	13	Click Duplicate Lead
	14	Verify the title as 'Duplicate Lead'
	15	Click Create Lead
	16	Confirm the duplicated lead name is same as captured name
	17	Close the browser (Do not log out)
	
	*/	public static void main(String[] args) throws InterruptedException {
		
	
	WebDriverManager.chromedriver().setup();
	
	ChromeDriver driver=new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/main");
	driver.manage().window().maximize();
	  driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
	  
	  driver.findElement(By.id("password")).sendKeys("crmsfa");
	  
	  driver.findElement(By.className("decorativeSubmit")).click();
	  driver.findElement(By.partialLinkText("CRM/SFA")).click();
	 // Leads
	  driver.findElement(By.partialLinkText("Leads")).click();
	  //Find Leads
	  driver.findElement(By.partialLinkText("Find Leads")).click();
	  driver.findElement(By.xpath("//span[contains(text(),'Email')]")).click();
	  //emailAddress
	  driver.findElement(By.name("emailAddress")).sendKeys("sharath@gmail.com");
	  Thread.sleep(2000);
	WebElement Firstname = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a"));
	  String Fname=Firstname.getText();
	  System.out.println("First Resulting name is:- " +Firstname.getText());

	  driver.findElement(By.xpath("//td/div/a[@class='linktext']")).click();
	  Thread.sleep(2000);
	 driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
	 
	System.out.println(driver.getTitle());
	
	if(driver.getTitle().contains("Duplicate Lead")) {
		System.out.println("Tittle is verified-pass");
		
		
	}
	
	else {
		System.out.println("Tittle is not verified-fail");
	}
	  
	 
	
	driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
	WebElement Duplicatename=driver.findElement(By.id("viewLead_firstName_sp"));
	String Dname=Duplicatename.getText();
	
	if(Fname.equalsIgnoreCase(Dname)) {
		System.out.println("duplicated lead name is same as captured name");

		
	}
	else {
		System.out.println(Duplicatename.getText()+"duplicated lead name is not same as captured name");
	}
	driver.close();
	
}
}
