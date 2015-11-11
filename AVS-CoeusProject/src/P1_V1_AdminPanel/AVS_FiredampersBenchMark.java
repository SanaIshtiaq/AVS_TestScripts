package P1_V1_AdminPanel;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AVS_FiredampersBenchMark 
{
	public static void main(String [] args)
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
			
			driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[2]/table/tbody/tr[4]/td[8]/a")).click();
			
			// click to listing of firedampers against a plant
			driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[2]/table/tbody/tr[2]/td[9]/a[1]")).click();
			System.out.println("success 2  !! ");
			
			for(int i = 1 ; i <= 5 ; i++)
			{
				//click to create new firedamper against a plant
				//driver.findElement(By.linkText("Neue Brandschutzklappe")).click();
				driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[1]/div/a")).click();
				
				Random rand = new Random();
				
				// 1 id = dampers_lfd_num
				driver.findElement(By.id("dampers_lfd_num")).sendKeys("auto fire damper num "+i+ " "+rand.nextInt(200));
				
				// 2 id = dampers_msr_labeling
				driver.findElement(By.id("dampers_msr_labeling")).sendKeys("auto fire damper label "+i+ " "+RandomStringUtils.randomAlphabetic(5));
				
				// 3 id = dampers_type_of_air
				driver.findElement(By.id("dampers_type_of_air")).sendKeys("auto fire damper air type "+i+ " "+RandomStringUtils.randomAlphabetic(5));
				
				// 4 id = dampers_fitting
				driver.findElement(By.id("dampers_fitting")).sendKeys("auto fire damper fitting "+i+ " "+RandomStringUtils.randomAlphabetic(5));
				
				// 5 xpath of submit button = /html/body/div/div[2]/div[3]/div[2]/div/form/p[5]/button 
				driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[2]/div/form/p[5]/button")).click();
				
				Assert.assertTrue("Brandschutzklappe erfolgreich hinzugefügt!" , true);
				
				System.out.println("success 3  !! ");
			}
		}
		catch(Exception e)
		{
			System.out.println("ERRORRRR ..... "+e);
		}
	}
}
