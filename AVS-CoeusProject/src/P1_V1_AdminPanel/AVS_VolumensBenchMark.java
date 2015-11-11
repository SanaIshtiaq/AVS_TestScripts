package P1_V1_AdminPanel;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AVS_VolumensBenchMark 
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
			
			//click on a customer
			driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[2]/table/tbody/tr[4]/td[8]/a")).click();
			
			// click to listing of volumens against a plant
			driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[2]/table/tbody/tr[2]/td[9]/a[3]")).click();
			System.out.println("success 2  !! ");
			
			for(int i = 1 ; i <= 5 ; i++)
			{			
				//click to create new volumens against a plant
				driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[1]/div/a")).click();
				
				Random rand = new Random();
				
				// 1 id = volume_lfd_num
				driver.findElement(By.id("volume_lfd_num")).sendKeys("auto volume num "+i+ " "+rand.nextInt(200));
				
				// 2 id = volume_msr_labeling
				driver.findElement(By.id("volume_msr_labeling")).sendKeys("auto volume label "+RandomStringUtils.randomAlphabetic(5));
				
				// 3 id = volume_axis
				driver.findElement(By.id("volume_axis")).sendKeys("auto volume axis "+RandomStringUtils.randomAlphabetic(5));
				
				// 4 id = volume_type
				driver.findElement(By.id("volume_type")).sendKeys("auto volume type "+RandomStringUtils.randomAlphabetic(5));
				
				// 5 id = volume_luftart
				driver.findElement(By.id("volume_luftart")).sendKeys("auto volume luftart "+RandomStringUtils.randomAlphabetic(5));
				
				// 6 id = volume_dimensions
				driver.findElement(By.id("volume_dimensions")).sendKeys("auto volume dimensions "+RandomStringUtils.randomAlphabetic(5));
				
				// 7 id = volume_actual_value
				driver.findElement(By.id("volume_actual_value")).sendKeys("1"+rand.nextInt(200));
				
				
				// 8 id = arbeitsvordruck - - it should be removed
				driver.findElement(By.id("arbeitsvordruck")).sendKeys("auto volume arbeit "+RandomStringUtils.randomAlphabetic(5));
				
				// 9 xpath of submit button =  /html/body/div/div[2]/div[3]/div[2]/div/form/p[9]/button
				driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[2]/div/form/p[9]/button")).click();
				
				Assert.assertTrue("Volumenstromregler erfolgreich hinzugefügt!" , true);
				
				System.out.println("success 3  !! ");
			}
		}
		catch(Exception e)
		{
			System.out.println("ERRORRRR ..... "+e);
		}
	}
}
