package P1_V1_AdminPanel;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AVS_PlantsBenchMark 
{
	public static void main (String [] args)
	{
		try
		{
			//Neuen Kunden hinzufügen -- add new customer
			
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
			//driver.findElement(By.cssSelector("html body.loginbody div.mainwrapper div.rightpanel div.maincontent div.contentinner.content-users table.table.table-bordered")).click();
			
		    System.out.println("success 2 !! ");
		    
			//driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[2]/table"));
			
			System.out.println("success 3  !! ");
		    
			driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[2]/table/tbody/tr[4]/td[8]/a")).click();
			
			// click to create new plant
			System.out.println("success 4  !! ");
		    
			int i = 1 ;
			while(i <= 5)
			{
				//driver.findElement(By.linkText("Neue Anlage ")).click();
				driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[1]/div/a")).click();
				//Assert.assertTrue("Sana >> Anlage >> Neue Anlage hinzufügen", true);
				
				// 1 id = plant_name -- textField
				driver.findElement(By.id("plant_name")).sendKeys("auto plant name " + RandomStringUtils.randomAlphabetic(5));
				
				// 2 id = plant_manufacturer -- textField
				driver.findElement(By.id("plant_manufacturer")).sendKeys("auto plant manufacturer "+i+ " " + RandomStringUtils.randomAlphabetic(5));
				
				// 3 id = plant_type -- textField
				driver.findElement(By.id("plant_type")).sendKeys("auto plant type "+ RandomStringUtils.randomAlphabetic(5));
				
				// 4 name = plant_year_of_construction -- dropdown
				new Select(driver.findElement(By.name("plant_year_of_construction"))).selectByVisibleText("1980");
				
				// 5 id = plant_material -- textField
				driver.findElement(By.id("plant_material")).sendKeys("auto plant material "+ RandomStringUtils.randomAlphabetic(5));
				
				// 6 id = plant_location -- textField
				driver.findElement(By.id("plant_location")).sendKeys("auto plant location "+ RandomStringUtils.randomAlphabetic(5));
				
				// 7 id = plant_aircondition_type -- textField
				driver.findElement(By.id("plant_aircondition_type")).sendKeys("auto aircondition type "+ RandomStringUtils.randomAlphabetic(5));
				
				// 8 id = plant_other_info -- textArea
				driver.findElement(By.id("plant_other_info")).sendKeys("auto other info "+ RandomStringUtils.randomAlphabetic(5));
				
				// 9 xpath = /html/body/div[1]/div[2]/div[3]/div[2]/div/form/p[9]/button -- submit button
				driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[2]/div/form/p[9]/button")).click();
				
				Assert.assertTrue("Die Anlage wurde erfolgreich hinzugefügt! " , true);
				i++;
			}	
		}
		catch(Exception e)
		{
			System.out.println("ERROR ........... : "+e);
		}
	}
}
