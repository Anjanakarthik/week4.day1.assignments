package week4.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithWindows {
	public static void main(String[] args) throws Exception {
		//
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15000));
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("home")).click();
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String>WindowHandles=driver.getWindowHandles();
		System.out.println("Number of windows opened are " +WindowHandles.size());
		
		//List<String>lstwindowhanles=new ArrayList<String>(WindowHandles);
		
		driver.findElement(By.id("color")).click();
		Set<String>WindowHandlestwo=driver.getWindowHandles();
		List<String>lstwindowhanlestwo=new ArrayList<String>(WindowHandlestwo);
		int count=lstwindowhanlestwo.size();
		for(int j =1;j<count;j++) {
			driver.switchTo().window(lstwindowhanlestwo.get(j));
			driver.close();
			
			}
		driver.switchTo().window(lstwindowhanlestwo.get(0));
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//button[@id='color'])[2]")).click();
	
		Set<String>WindowHandlesthree=driver.getWindowHandles();
		List<String>lstWindowHandlesthree=new ArrayList<String>(WindowHandlesthree);
		int countnew=lstWindowHandlesthree.size();
		
		for(int i =1;i<lstWindowHandlesthree.size();i++) {
			driver.switchTo().window(lstWindowHandlesthree.get(i));
	System.out.println(driver.getTitle());
		}
		
	
	}

}
