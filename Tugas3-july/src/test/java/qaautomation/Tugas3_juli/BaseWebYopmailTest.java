package qaautomation.Tugas3_juli;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseWebYopmailTest {
	
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();

	@BeforeMethod
	public void openUrl() {

		WebDriverManager.chromedriver().setup();
		getDriver().set(new ChromeDriver());
		getExplicitWait().set(new WebDriverWait(getDriver().get(), Duration.ofSeconds(60)));
		getDriver().get().manage().window().maximize();
		getDriver().get().get("https://yopmail.com");

	}

	@AfterMethod
	public void close() {

		getDriver().get().quit();

	}

	public ThreadLocal<WebDriver> getDriver() {
		return driver;
	}

	public void setDriver(ThreadLocal<WebDriver> driver) {
		this.driver = driver;
	}

	public ThreadLocal<WebDriverWait> getExplicitWait() {
		return explicitWait;
	}

	public void setExplicitWait(ThreadLocal<WebDriverWait> explicitWait) {
		this.explicitWait = explicitWait;
	}
}
