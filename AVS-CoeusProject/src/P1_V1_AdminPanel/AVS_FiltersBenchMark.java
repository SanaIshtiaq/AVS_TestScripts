package P1_V1_AdminPanel;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AVS_FiltersBenchMark 
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
			
			// click to view the listing of filters against a plant
			driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[2]/table/tbody/tr[2]/td[9]/a[2]")).click();
			
			Random rand = new Random();
			
			for(int i = 2 ; i <= 5 ; i++)
			{
				//click to create new filters against a plant
				driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[1]/div/a")).click();
				
				// 1 id = filter_lfd_num
				driver.findElement(By.id("filter_lfd_num")).sendKeys("auto num "+i+ " "+rand.nextInt(200));
				
				// 2 id = filter_type
				driver.findElement(By.id("filter_type")).sendKeys("auto type "+i+ " "+RandomStringUtils.randomAlphabetic(5));
				
				// 3 id = filter_grade
				driver.findElement(By.id("filter_grade")).sendKeys("auto grade "+i+ " "+RandomStringUtils.randomAlphabetic(5));
				
				// 4 id = filter_dimensions
				driver.findElement(By.id("filter_dimensions")).sendKeys("auto dimensions "+i+ " "+RandomStringUtils.randomAlphabetic(5));
				
				// 5 id = filter_stck
				driver.findElement(By.id("filter_stck")).sendKeys("auto filter stack "+i+ " "+RandomStringUtils.randomAlphabetic(5));
				
				// 6 xpath for submit button = /html/body/div/div[2]/div[3]/div[2]/div/form/p[6]/button
				driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[2]/div/form/p[6]/button")).click();
				
				Assert.assertTrue("Filter erfolgreich hinzugefügt!" , true);
				
				System.out.println("success 3  !! ");
			}
		}
		catch(Exception e)
		{
			System.out.println("ERRORRRR ..... "+e);
		}
	}
}
