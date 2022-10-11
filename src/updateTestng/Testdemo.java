package updateTestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testdemo {
	WebDriver driver;
	@Test
	public void open_browser() {
		System.setProperty("webdriver.chrome.driver","F:\\salenium setup\\chrome driver\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);
	//	driver.manage().timeouts().(1500, TimeUnit.SECONDS);
		driver.get("https://ijmeet.com/register?csrt=3501598330926279659");
		driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]")).click();
		String errormsg=driver.findElement(By.xpath("//div[@class='input-group']/following-sibling::label[@for=\"name\"]")).getText();
	if(!errormsg.isEmpty()) {
		System.out.println("Pass");
	}else {
		throw new ArrayIndexOutOfBoundsException();
	}

}
}
