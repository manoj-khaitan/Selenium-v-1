package pageobjects;
import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.seleniumfirst;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class homepage extends seleniumfirst{
	public static WebElement element = null;
	
	public static boolean Isobjectdisplayed(WebElement element){
		WebDriverWait wait= new WebDriverWait(driver, 10);
		
			if(wait.until(ExpectedConditions.elementToBeClickable(element)) != null){
				return true;
			}
			else{
				return false;
			}
	}
	public static WebElement triptype(WebDriver driver){
		element = driver.findElement(By.xpath(".//*[@id='BE_flight_form']/div/div[1]/ul/li[2]/a/i"));
		return element;
	}
	
	public static WebElement destination(WebDriver driver){
		element = driver.findElement(By.xpath(".//*[@id='BE_flight_origin_city']"));
		return element;
	}
	
	public static WebElement departdate(WebDriver driver){
		element = driver.findElement(By.xpath(".//*[@id='BE_flight_form']/div/div[2]/ul/li[3]/i"));
		
		
		return element;
	}
}
