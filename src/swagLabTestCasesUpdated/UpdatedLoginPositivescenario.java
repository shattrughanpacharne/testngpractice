package swagLabTestCasesUpdated;

import java.util.ArrayList;

import org.testng.annotations.Test;

import SwagLabUpdated.HomepageUpdated;
import SwagLabUpdated.LoginpageUpdated;
import frameWrkPOMUpdated.UtilituyUpdated;

public class UpdatedLoginPositivescenario extends UtilituyUpdated {
	LoginpageUpdated objloginrepo =new LoginpageUpdated();//webelement acess from repository
HomepageUpdated  objhomerepo = new HomepageUpdated();
ArrayList<String>usernames=dataread("F:\\salenium setup\\testexcel\\SauceLab.xlsx","Sheet1",0);
ArrayList<String>password=dataread("F:\\salenium setup\\testexcel\\SauceLab.xlsx","Sheet1",1);
String exphomerur1= "https://www.saucedemo.com/inventory.html";

@Test(priority=1)
public void initbrowser() {
	 open_browser();//utility class's method call
}
@Test(priority=2)
public void login() {
	starttestcase("login positive scenario");
	for(int i=0;i<usernames.size();i++)
	{
		driver.findElement(objloginrepo.username).sendKeys(usernames.get(i));
		driver.findElement(objloginrepo.password).sendKeys(usernames.get(i));
		driver.findElement(objloginrepo.loginButton).click();
		
		String actualurl=driver.getCurrentUrl();
		
		if(actualurl.equals(exphomerur1))
		{
			markstatus("pass","Login succesfull for user" +usernames.get(i));
			
		}
		else
		{
			markstatus("fail", "login failed for user " +usernames.get(i));
		
			}
		driver.findElement(objhomerepo .menu).click();
		driver.findElement(objhomerepo.logoutButton).click();

		
	}
	driver.close();
}


}



