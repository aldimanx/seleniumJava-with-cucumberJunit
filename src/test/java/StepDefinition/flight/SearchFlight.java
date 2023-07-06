package StepDefinition.flight;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pages.PageFlight;
import pages.PageOrder;

public class SearchFlight {

	WebDriver driver = null;
	PageFlight flight;
	PageOrder order;

	@Given("user at flight section")
	public void user_at_flight_section() {

		String ProjectPatch = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", ProjectPatch+"/src/test/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.navigate().to("https://www.pegipegi.com/flight/");
		flight = new PageFlight(driver);
	}

	@When("^user input (.*) order pesawat detail")
	public void user_input_order_pesawat_detail(String passengers) {
		   flight.formDewasa(passengers);

	}

	@And("click cari tiket button")
	public void click_cari_tiket_button() {
		flight.cariTiket();

	}

	@Then("user will be directed to ticket list")
	public void user_will_be_directed_to_ticket_list() {
	String UbahPencarian = driver.findElement(By.xpath("//input[@value=\"UBAH PENCARIAN\"]")).getAccessibleName();
	Assert.assertEquals(UbahPencarian, "UBAH PENCARIAN");
	driver.close();
	driver.quit();
	}
	
	@When("user click cek pesanan")
	public void user_click_cek_pesanan() {
		order = new PageOrder(driver);
	    order.cekPesanan();
	}

	@Then("user will be directed to cek pesanan form")
	public void user_will_be_directed_to_cek_pesanan_form() {
		driver.findElement(By.xpath("//h2[text()=\"Cek Pesanan\"]")).isDisplayed();
		driver.close();
		driver.quit();	   
	}
}
