package week4.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MrgeContact {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();

		//login
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		//election of leads
		driver.findElement(By.linkText("CRM/SFA")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//input[@name='ComboBox_partyIdFrom']/following::img[1]")).click();
		Set<String>Windowhandles=driver.getWindowHandles();
		List<String>lstwindowHandles=new ArrayList<String>(Windowhandles);
		driver.switchTo().window(lstwindowHandles.get(1));
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		driver.switchTo().window(lstwindowHandles.get(0));
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Alert alert =driver.switchTo().alert();
		alert.accept();
		System.out.println(driver.getTitle());
		
	}

}
