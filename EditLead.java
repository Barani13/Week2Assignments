package mavenproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {
	public static void main(String[] args) throws InterruptedException {
	    
		
		/*http://leaftaps.com/opentaps/control/main
		
		* 1	Launch the browser
		* 2	Enter the username
		* 3	Enter the password
		* 4	Click Login
		* 5	Click crm/sfa link
		* 6	Click Leads link
		* 7	Click Find leads
		* 8	Enter first name
		* 9	Click Find leads button
		* 10 Click on first resulting lead
		* 11 Verify title of the page
		* 12 Click Edit
		* 13 Change the company name
		* 14 Click Update
		* 15 Confirm the changed name appears
		* 16 Close the browser (Do not log out)
*/
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
		  Thread.sleep(3000);
		  driver.findElement(By.id("ext-gen248")).sendKeys("sharath");
		  driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).click();
		  Thread.sleep(2000);
			if(driver.getTitle().contains("View Lead")) {
				System.out.println("Tittle is verified-pass");
				
				
			}
			driver.findElement(By.xpath("//a[text()='Edit']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("updateLeadForm_companyName")).clear();
			driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("XYZ");
			driver.findElement(By.xpath("//input[@value='Update']")).click();
		 	WebElement Companyname = driver.findElement(By.id("viewLead_companyName_sp"));
			System.out.println("CompanyName after Update is - " +Companyname.getText());
			if(Companyname.isDisplayed()) {  
				System.out.println(" CompanyName updated successfully");

			}
			else {
				System.out.println("Not updated  ");
			}
			
		driver.close();

}
}
