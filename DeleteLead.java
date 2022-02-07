package mavenproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	
	/*http://leaftaps.com/opentaps/control/main
	 
	Delete Lead:
	1	Launch the browser
	2	Enter the username
	3	Enter the password
	4	Click Login
	5	Click crm/sfa link
	6	Click Leads link
	7	Click Find leads
	8	Click on Phone
	9	Enter phone number
	10	Click find leads button
	11	Capture lead ID of First Resulting lead
	12	Click First Resulting lead
	13	Click Delete
	14	Click Find leads
	15	Enter captured lead ID
	16	Click find leads button
	17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
	18	Close the browser (Do not log out)
*/
	public static void main(String[] args) throws InterruptedException {
		
	
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

		driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();

		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("123456");
		Thread.sleep(2000);
		   WebElement lead = driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]"));
		   
		    lead.click();
		    Thread.sleep(2000);
		    WebElement leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId'][1]//a"));
		String leadid2 = leadID.getText();
		System.out.println("The leadid is"+" "+leadid2);
		leadID.click();
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadid2);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		WebElement ExpectedValue = driver.findElement(By.xpath("//div[text()='No records to display']"));
		String Evalue = ExpectedValue.getText();
		String actualvalue = "No records to display";
		if (Evalue.equalsIgnoreCase(actualvalue)) {
			System.out.println("Lead ID is Deleted Successfully !!!");
		} else {
			System.out.println("Lead ID is not Deleted Successfully !!!");
		}
		driver.close();
}
}
