package qaautomation.Tugas4_juli;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
	@FindBy(xpath = "//input[@id='user-name']")
	private WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;

	@FindBy(xpath = "//input[@id='login-button']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//h3[contains(text(),'Epic sadface: Username and password do not match a')]")
	private WebElement messageErrorLogin;
	
	@FindBy(xpath = "//h3[contains(text(),'Epic sadface: Username is required')]")
	private WebElement messageErrorUsername;
	
	@FindBy(xpath = "//h3[contains(text(),'Epic sadface: Password is required')]")
	private WebElement messageErrorPassword;

	public LoginPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}

	public void loginWeb(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		loginBtn.click();
	}

	public void inputUsername(String user) {
		username.sendKeys(user);
	}

	public void inputPassword(String pass) {
		password.sendKeys(pass);
	}

	public void clickLoginButton() {
		loginBtn.click();
	}
	
	public String getMessageError() {
		return messageErrorLogin.getText();
	}
	
	public String getMessageErrorUsername() {
		return messageErrorUsername.getText();
	}
	
	public String getMessageErrorPassword() {
		return messageErrorPassword.getText();
	}
}
