package HotstarTest;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void SearchResults() throws InterruptedException
    {
    	
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ganu\\Downloads\\chromedriver_win32\\chromedriver.exe");
    	String arg="";
    	
    	WebDriver driver=new ChromeDriver();
    	WebDriverWait wd=new WebDriverWait(driver, 15);
    	driver.get("http://www.hotstar.com/");
    	driver.manage().window().maximize();
    	//driver.manage().timeouts().equals(obj)
    	//driver.navigate().
    	//Thread.sleep(1000);
    	driver.findElement(By.xpath("//*[@id='autoSearchBox']/li[1]/button")).click();
    	//*[@id="autoSearchBox"]/li[1]/button
    	//*[@id="autoCompleteSearchMobile"]
    	//*[@id="autoCompleteSearchId"]
    	//Thread.sleep(2000);
    	driver.findElement(By.xpath("//*[@id='autoCompleteSearchId']")).sendKeys("great");
    	//Thread.sleep(50000);
    	//WebElement display_all= driver.findElement(By.xpath("//*[@id='autoSearchBoxCards']/p[2]"));
    	wd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='autoSearchBoxCards']/p[2]")));
    	driver.findElement(By.xpath("//*[@id='autoSearchBoxCards']/p[2]")).click();
    	
    	
    	Thread.sleep(5000);
    	//wd.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='app']/div/div/div/div[1]/div[2]/div/div/div/div[2]/div/div/span/article/a/div[3]/div[2]/div/span")));
    	//List<WebElement> list=driver.findElements(By.xpath("//*[@id='app-main-view']/div/div/div/hs-cards-directive/article/a/div[1]/div/img"));
        List<WebElement> list= driver.findElements(By.xpath("//*[@id='app']/div/div/div/div[1]/div[2]/div/div/div/div[2]/div/div/span/article/a/div[3]/div[2]/div/span"));
    	//#app-main-view > div > div.row.rec-received.all-rec-ui.no-gutter.ng-scope > div:nth-child(3) > hs-cards-directive > article > a > div.hover-cover
    	//*[@id="app-main-view"]/div/div[2]/div[2]/hs-cards-directive/article/a/div[1]/div/img
    	//*[@id="app-main-view"]/div/div[2]/div[3]/hs-cards-directive/article/a/div[1]/div/img
    	//*[@id="app-main-view"]/div/div[2]/div[3]/hs-cards-directive/article/a/div[1]/div/img
    	System.out.println("List size is "+list.size()+"contents :"+list);
    	
    	HashMap<String,Integer> hmap= new HashMap<String, Integer>();
    	
    	for(WebElement element:list)
    	{
    		//System.out.println(element.getAttribute("alt"));
    		hmap.put(element.getAttribute("span"),element.getAttribute("span").toLowerCase().indexOf("great"));
    	}
    
    	//hmap.forEach(l);
    	System.out.println("Size of hashamp"+hmap.size());
    	Set set = hmap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
              Map.Entry me = (Map.Entry)iterator.next();
              System.out.print(me.getValue()+ ": ");
              System.out.println(me.getKey());
        }
        Map<String, Integer> map = sortMapByValuesWithDuplicates(hmap); 
        System.out.println("After Sorting:");
        
        for(String key:map.keySet())
        {
        	System.out.println(map.get(key)+":"+key);
        }
        /*Set set2 = map.entrySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
             Map.Entry me2 = (Map.Entry)iterator2.next();
             System.out.print(me2.getValue() + ": ");
             System.out.println(me2.getKey());
        }*/
    	
    	//System.out.println(listmap.keySet()+" "+listmap.values());
    	
    	//*[@id="app-main-view"]/div/div[2]/div[3]/hs-cards-directive/article
    	//*[@id="app-main-view"]/div/div[2]/div[6]/hs-cards-directive/article
    	
    	//*[@id="app-main-view"]/div/div[2]/div[6]/hs-cards-directive/article/a
    	//*[@id="app-main-view"]/div/div[2]/div[9]/hs-cards-directive/article/a/div[3]
    	
    	
    	//*[@id="app-main-view"]/div/div[2]/div[9]/hs-cards-directive/article/a/div[3]
    }

    private LinkedHashMap sortMapByValuesWithDuplicates(Map passedMap) {
        List mapKeys = new ArrayList(passedMap.keySet());
        List mapValues = new ArrayList(passedMap.values());
        Collections.sort(mapValues);
        Collections.sort(mapKeys);
        
        
      
        LinkedHashMap sortedMap = new LinkedHashMap();

        Iterator valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            Object val = valueIt.next();
            Iterator keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                Object key = keyIt.next();
                String comp1 = passedMap.get(key).toString();
                String comp2 = val.toString();

                if (comp1.equals(comp2)) {
                    passedMap.remove(key);
                    mapKeys.remove(key);
                    sortedMap.put((String) key, val);
                    break;
                }
            }
        }
        return sortedMap;
    }
    
    @Test
    public void getHandles() throws InterruptedException
    {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ganu\\Downloads\\chromedriver_win32\\chromedriver.exe");
    	
    	WebDriver driver=new ChromeDriver();
    	driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
    	 
        // Store and Print the name of the First window on the console

        String handle= driver.getWindowHandle();

        System.out.println(handle);

        // Click on the Button "New Message Window"

        driver.findElement(By.xpath("//*[@id='content']/p[3]/button")).click();

        // Store and Print the name of all the windows open	              

        Set handles = driver.getWindowHandles();

        System.out.println(handles);

        // Pass a window handle to the other window

        for (String handle1 : driver.getWindowHandles()) {

        	System.out.println(handle1);

        	driver.switchTo().window(handle1);

        	}

        //Alert al=driver.switchTo().alert();
                //al.accept();
        // Closing Pop Up window
        Thread.sleep(2000);
        driver.close();

        // Close Original window

        //driver.quit();
    }
    
    @Test
    public void TestAlerts()
    {
    	
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ganu\\Downloads\\chromedriver_win32\\chromedriver.exe");
    	
    	WebDriver driver=new ChromeDriver();
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	 
        // Launch the URL

        driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");

        // Click on the Button "Alert Box"

        driver.findElement(By.xpath("//button[@onclick='newAlert()']")).click();

        // Switch to JavaScript Alert window

        Alert myAlert = driver.switchTo().alert();

        // Accept the Alert

        myAlert.accept();

        // Close Original window

        driver.close();
    }
}
