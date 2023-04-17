package StepDefinition.hotel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;

public class test {
	WebDriver driver = null;
	
	@Before
	public void browserSetup() {
		String ProjectPatch = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", ProjectPatch+"/src/test/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	}     
}
