package P1_V1_AdminPanel;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AVS_CreateNewCustomer 
{
	
	public static void main(String [] args)
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://avs.coeus-solutions.de/admin/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().window().maximize(); 
		
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("coeus");
		
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("coeus123");
		
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/form/p[3]/button")).click();
		
			
		//Assert.assertTrue("Kunden" , true);
	
		System.out.println("success 1 !! ");
		
		
		// ...........................................................................
		
		// Neuen Kunden hinzufügen  create new customer
		driver.findElement(By.linkText("Neuen Kunden hinzufügen")).click();
					
		// 2 id = customer_name
		driver.findElement(By.id("customer_name")).sendKeys("customer "+RandomStringUtils.randomAlphabetic(5));
		
		// 3 id = customer_number
		driver.findElement(By.id("customer_number")).sendKeys("123456 ");
		
		// 4 id = customer_address
		driver.findElement(By.id("customer_address")).sendKeys("c1 12345 ");
					
		// 5 id = customer_postalcode_city
		driver.findElement(By.id("customer_postalcode_city")).sendKeys("12345");
		
		// 6 id = customer_email
		driver.findElement(By.id("customer_email")).sendKeys("five123@coeus.de");
		
		// 7 id = customer_tel_nr
		driver.findElement(By.id("customer_tel_nr")).sendKeys("12345");
					
		// 8 id = customer_tel_nr
		driver.findElement(By.id("customer_alt_tel_nr")).sendKeys("123456");
		
		// 9 id = customer_mobile_nr
		driver.findElement(By.id("customer_mobile_nr")).sendKeys("033612345");
					
		// 10 id = contact_people
		driver.findElement(By.id("contact_people")).sendKeys("sana : 12345");
					
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[2]/div/form/p[11]/button")).click();
					
		// ...........................................................................
	
	}

}
