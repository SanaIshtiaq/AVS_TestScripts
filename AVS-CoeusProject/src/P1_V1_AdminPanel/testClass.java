package P1_V1_AdminPanel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class testClass 
{
	public static void main(String [] args)
	{
		WebDriver driver = new FirefoxDriver();
	    driver.get("http://www.kayak.com/");
	    DefaultSelenium sel = new WebDriverBackedSelenium(driver,"http://www.kayak.com/");

	    sel.type("//input[@id='destination']", "s");
	    sel.fireEvent("//input[@id='destination']", "keydown");
	}
}
