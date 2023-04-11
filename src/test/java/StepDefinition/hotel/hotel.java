package StepDefinition.hotel;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.PageHotel;


public class hotel {
	WebDriver driver = null;

	PageHotel hotel;
	
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
		@After
	public void tearDown(){
		driver.close();
		driver.quit();
	}
	
	
	
	@Given("user at hotel section")
	public void user_at_hotel_section() {
		
		driver.navigate().to("https://www.pegipegi.com/");
		hotel = new PageHotel(driver);
	}

	@When("^user input location (.*) & guest (.*) detail")
	public void user_input_location_jakarta_people_detail(String location, String guest) throws InterruptedException {
	  
		hotel.formLocation(location);
		hotel.formGuest(guest);
	}

	@And("click cari hotel button")
	public void click_cari_hotel_button() throws InterruptedException {
	
		hotel.buttonCari();
		}

	@Then("^user will be directed to hotel list(.*)")
	public void user_will_be_directed_to_hotel_list(String location) throws InterruptedException {
	   Thread.sleep(2000);
		WebElement CariHotel = driver.findElement(By.xpath("//button[text()=\"Cari Hotel\"]"));
		if(CariHotel.isDisplayed()) {
			CariHotel.click();
	}
		else {
			System.out.println("skip gaada pilihan");
			}
		String SearchLocation = driver.findElement(By.xpath("(//span[@itemprop=\"name\"])[2]")).getText();
		Assert.assertEquals(SearchLocation, location);
	}

	@When("user click pencarian terakhir")
	public void user_click_pencarian_terakhir() {
	    hotel.buttonPencarianTerakhir();
	}

	@Then("user will see pop up pencarian terakhir")
	public void user_will_see_pop_up_pencarian_terakhir() {
	   driver.findElement(By.xpath("//h4[@class=\"modal-title\"]")).isDisplayed();
	}
}
