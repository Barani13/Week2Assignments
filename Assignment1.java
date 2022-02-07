package mavenproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Assignment1 {
public static void main(String[] args) throws InterruptedException {
	

System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
  ChromeDriver driver = new ChromeDriver();
  driver.get("https://en-gb.facebook.com/");
  driver.manage().window().maximize();
  Thread.sleep(5000);
  driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
  Thread.sleep(5000);
  driver.findElement(By.name("firstname")).sendKeys("BARANI");
  driver.findElement(By.name("lastname")).sendKeys("PRAKASH");
  driver.findElement(By.xpath("//input[contains(@name,'reg_email__')]")).sendKeys("9789743052");
  driver.findElement(By.id("password_step_input")).sendKeys("123456789");
  
 WebElement day= driver.findElement(By.id("day"));
 
 Select DD= new Select(day);
 
 DD.selectByVisibleText("13");
 
WebElement month= driver.findElement(By.id("month"));
 
 Select DD1= new Select(month);
 
 DD1.selectByValue("6");
 
WebElement year= driver.findElement(By.id("year"));
 
 Select DD2= new Select(year);
 
 DD2.selectByValue("1996");
 
driver.findElement(By.xpath("//label[text()='Male']")).click();

 
 
  
}
}