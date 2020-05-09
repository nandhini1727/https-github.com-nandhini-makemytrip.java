package selenium.workout;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Azure {
public static void main(String[] args) throws InterruptedException
{
	//1) Go to https://azure.microsoft.com/en-in/
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://azure.microsoft.com/en-in/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		

		//2) Click on Pricing
	driver.findElementByXPath("//a[text()='Pricing'][1]").click();
		//3) Click on Pricing Calculator
	driver.findElementByLinkText("Pricing calculator").click();
	
		//4) Click on Containers
	driver.findElementByXPath("//button[@data-event-property='containers']").click();
		//5) Select Container Instances
	driver.findElementByXPath("(//span[text()='Container Instances'])[3]").click();
		//6) Click on Container Instance Added View`
Thread.sleep(2000);	
driver.findElementByXPath("//a[@id='new-module-loc']").click();
//7) Select Region as "South India"
	WebElement drpdwn = driver.findElementByXPath("//select[@class='select'][1]");
	Select dropdown=new Select(drpdwn);
	dropdown.selectByVisibleText("South India");
		//8) Set the Duration as 180000 seconds
	driver.findElementByXPath("//input[@aria-label='Seconds']").sendKeys(Keys.chord(Keys.CONTROL,"a"),"180000");

	//	9) Select the Memory as 4GB
	WebElement drpdwn1 = driver.findElementByXPath("//select[@aria-label='Memory'][1]");
	Select dropdown1=new Select(drpdwn1);
	dropdown1.selectByVisibleText("4 GB");
		//10) Enable SHOW DEV/TEST PRICING
	driver.findElementByXPath("//button[@aria-label='Show Dev/Test Pricing Toggle button']").click();
		//11) Select Indian Rupee  as currency
	WebElement drpdwn2 = driver.findElementByXPath("//select[@class='select currency-dropdown']");
	Select dropdown2=new Select(drpdwn2);
	dropdown2.selectByVisibleText("Indian Rupee (₹)");
		//12) Print the Estimated monthly price
	WebElement text=driver.findElementByXPath("//span[text()='₹288.77']");
	System.out.println("Estimated monthly price is:"+text.getText());
	
		//13) Click on Export to download the estimate as excel
	Thread.sleep(2000);
	driver.findElementByXPath("//button[text()='Export']").click();
		//14) Verify the downloaded file in the local folder
if(new File("C:\\Users\\Nandhini\\Downloads\\ExportedEstimate.xlsx").exists()){
	System.out.println("File is downloaded successfully");}
	else {
		System.out.println("File is not downloaded");
	
}
	//15) Navigate to Example Scenarios and Select CI/CD for Containers
		/*
		  driver.findElementByXPath("//a[text()='Example Scenarios']").click();
		 * driver.findElementByXPath("//button[@title='CI/CD for Containers']").click();
		 */	
WebElement msehvr = driver.findElementByXPath("//li[@id='solution-architectures-picker']");
Actions builder=new Actions(driver);
builder.moveToElement(msehvr).perform();
driver.findElementByXPath("(//button[@class='solution-architecture-item false'])[2]").click();
Thread.sleep(2000);

//16) Click Add to Estimate
	driver.findElementByXPath("//button[text()='Add to estimate']").click();
		//17) Change the Currency as Indian Rupee
	WebElement drpdwn3 = driver.findElementByXPath("//select[@aria-label='Currency'][1]");
	Select dropdown3=new Select(drpdwn);
	dropdown3.selectByVisibleText("Indian Rupee (₹)");

	
		//18) Enable SHOW DEV/TEST PRICING
	driver.findElementByXPath("//div[@class='toggler-slide ']").click();
		//19) Export the Estimate
	driver.findElementByXPath("//button[@class='calculator-button button-transparent export-button']").click();
		//20) Verify the downloded file in the local folder	
	if(new File("C:\\Users\\Nandhini\\Downloads\\ExportedEstimate (1).xlsx").exists()){
		System.out.println("Now too File is downloaded successfully");}
		else {
			System.out.println("File is not downloaded");
		
	}

}
}
