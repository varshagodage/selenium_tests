package HotstarTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertTests {

	
	public WebDriver createDriver()
	{
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ganu\\Downloads\\chromedriver_win32\\chromedriver.exe");
    	
    	WebDriver driver=new ChromeDriver();
		
		
		return driver;
		
	}
	
	@Test
	public void testAlert1() throws InterruptedException
	{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ganu\\Downloads\\chromedriver_win32\\chromedriver.exe");
    	
    	WebDriver driver=new ChromeDriver();
		driver.get("http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/");
		//This step will result in an alert on screen
		driver.findElement(By.xpath("//*[@id='content']/p[4]/button")).click();
 
		
		Alert al=driver.switchTo().alert();
		System.out.println("Alert Text is"+al.getText());
		Thread.sleep(2000);
		al.accept();
		//Once alert is present try to click on any button on the page
		//driver.findElement(By.xpath("//*[@id='content']/p[16]/button")).click();
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test
	public void testConfirmAlert()
	{
		WebDriver driver=createDriver();
		
		driver.get("http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/");
		driver.manage().window().maximize();
		// This step will result in an alert on screen
		WebElement element = driver.findElement(By.xpath("//*[@id='content']/p[8]/button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
	    //element.click();
		Alert confirmationAlert = driver.switchTo().alert();
		String alertText = confirmationAlert.getText();
		System.out.println("Alert text is " + alertText);
		confirmationAlert.dismiss();
	}
	
	@Test
	public void testPromprAlert() throws InterruptedException
	{
		WebDriver driver=createDriver();
		driver.get("http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/");
		driver.manage().window().maximize();
		// This step will result in an alert on screen
		WebElement element = driver.findElement(By.xpath("//*[@id='content']/p[11]/button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
 
		Alert promptAlert  = driver.switchTo().alert();
		String alertText = promptAlert .getText();
		System.out.println("Alert text is " + alertText);
		//Send some text to the alert
		promptAlert .sendKeys("Accepting the alert");
		Thread.sleep(4000); //This sleep is not necessary, just for demonstration
		promptAlert .accept();
	}
}
