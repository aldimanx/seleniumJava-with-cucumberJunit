package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class PageOrder {

	 @FindBy (partialLinkText = "CEK PESANAN")
	    WebElement btn_pesanan;
	  	 
	 WebDriver driver;
	    
    public PageOrder(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    
    public void cekPesanan() {
    	btn_pesanan.click();
    }
    
}
