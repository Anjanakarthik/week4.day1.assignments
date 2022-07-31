package week4.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15000));
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password$123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Set<String>WindowHandles=driver.getWindowHandles();
		List<String>ativewindowhandle=new ArrayList<String>(WindowHandles);
		String secwindowhandle=ativewindowhandle.get(1);
		String firstwindowhandle=ativewindowhandle.get(0);
		driver.switchTo().window(secwindowhandle);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		driver.switchTo().window(firstwindowhandle);
		driver.quit();

	}

}
