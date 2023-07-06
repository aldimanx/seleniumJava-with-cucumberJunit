import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class setup {

    @Before
    public void setup() {
        // Common setup code
    }

    @After
    public void teardown() {
        // Common teardown code
    }
}

//public class setup {
//	
//	WebDriver driver = null;
//
//	  @Before
//	    public void BrowserSetup() {
//			String ProjectPatch = System.getProperty("user.dir");
//			System.setProperty("webdriver.chrome.driver", ProjectPatch+"/src/test/resources/driver/chromedriver.exe");
//			driver = new ChromeDriver();	
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//			driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
//			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
//	    }
//
//	    @After
//	    public void teardown() {
//	    	driver.close();
//			driver.quit();	   
//		}
//}
