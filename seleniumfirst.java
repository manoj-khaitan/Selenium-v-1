package selenium;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.WebDriver;
public class seleniumfirst {
	public static WebDriver driver;

	public static  WebDriver driverstart(){
		ChromeOptions options = new ChromeOptions();
		options.addArguments("chrome.switches","--disable-extensions");
		System.setProperty("webdriver.chrome.driver","C://Users\\HP-AC\\Documents\\Visual Studio 2015\\Projects\\ClassLibrary2\\ClassLibrary2\\bin\\Debug\\chromedriver.exe");
		driver = new ChromeDriver(options);
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.yatra.com");

		return driver;
	}
	public static WebDriver driveruse(){
		return driver;
	}
	
	public static void closebrowser(){
		driver.close();
		driver.quit();
		driver=null;
	}
	

}
