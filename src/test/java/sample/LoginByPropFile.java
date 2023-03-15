package sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Property_Utility;

public class LoginByPropFile {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		/*FileInputStream fis=new FileInputStream("./src/main/resources/Commondata.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);*/
		
		Property_Utility plib=new Property_Utility();
		plib.getPropValue("url");
		String URL = plib.getPropValue("url");
		String USERNAME = plib.getPropValue("username");
		String PASSWORD = plib.getPropValue("password");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//create organization
		Random ran=new Random();
		int ranNum = ran.nextInt();
		
		Excel_Utility elib=new Excel_Utility();
		String data = elib.getDataByUsingDataFormatter("Organization", 0, 0)+ranNum;
		
		/*FileInputStream fes=new FileInputStream("./src/main/resources/ExcelFeb.xlsx");
		Workbook book=WorkbookFactory.create(fes);
		Sheet sheetName = book.getSheet("Organization");
		Row rowNum = sheetName.getRow(0);
		Cell celNum = rowNum.getCell(0);
		String data = celNum.getStringCellValue()+ranNum;*/
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("accountname")).sendKeys(data);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(3000);
		driver.close();
	}
}
