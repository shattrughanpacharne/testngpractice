package SwagLabUpdated;

import org.openqa.selenium.By;

public class LoginpageUpdated {
	public By username=By.id("user-name");
	public By password=By.id("password");
	public By loginButton= By.id("login-button");
	////input[@id="user-name"]
	////input[@id="password"]
	////input[@id="login-button"]
	////div[@class="error-message-container error"]
	public By errormsg = By.xpath("//div[@class='error-message-container error']");



}
