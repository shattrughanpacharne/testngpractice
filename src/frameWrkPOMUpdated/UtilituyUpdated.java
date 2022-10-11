package frameWrkPOMUpdated;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class UtilituyUpdated {
	public WebDriver driver;
	ExtentHtmlReporter htmlreport;  //used to intialize the location of file to be saved
	ExtentReports report;   //to create/start the report
	ExtentTest logger;    //log the result of report
	String timestamp=new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date());
	

	//@BeforeTest
		public void open_browser() {//F:\salenium setup\chrome driver\chromedriver_win32 (1)
			System.setProperty("webdriver.chrome.driver","F:\\salenium setup\\chrome driver\\chromedriver_win32 (1)\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
			driver.get("https://www.saucedemo.com/");//link vr janayasathi
			
		}
//@AfterTest
		public void driverClose() {
	try {
		Thread.sleep(10000);
		
	}catch(InterruptedException e) {
		e.printStackTrace();
	}
		driver.close();	
		}

@BeforeSuite
public void initreport()
{
	htmlreport=new ExtentHtmlReporter("F:\\salenium setup\\Extenddreports folder\\samplr reports jar"+timestamp+".html");
	report=new ExtentReports();
	report.attachReporter(htmlreport);
}


@AfterSuite
public void endreport()
{
	report.flush();//use for convrt in html file
}
public void starttestcase() {
	logger=report.createTest("");
}
public void starttestcase(String testname)
	{
		logger=report.createTest(testname);
	}
	
	public void markstatus(String statusname,String description)
	{
		if(statusname.equalsIgnoreCase("info"))
		{
			logger.log(Status.INFO,description);
		}
		else if(statusname.equalsIgnoreCase("pass"))
		{
			logger.log(Status.PASS,description);
		}
		else if(statusname.equalsIgnoreCase("fail"))
		{
			logger.log(Status.FAIL,description);
		}
	}
	public ArrayList<String>dataread(String filepath,String sheetname,int cellno)
	{
		ArrayList<String>obja= new ArrayList<String>();//creating obj of arraylist class
		
		try {
			FileInputStream fs=new
			FileInputStream(filepath);//excel path from your machine
			XSSFWorkbook workbook= new XSSFWorkbook(fs);
			XSSFSheet objsheet = workbook.getSheet(sheetname);
			 
			int rowcount=objsheet.getLastRowNum();
			for(int a=1;a<=rowcount;a++)// loop for rows
			{
				XSSFRow row = objsheet.getRow(a);
				String temp = row.getCell(cellno).getStringCellValue();//picking every value from excel cell
				obja.add(temp);//saving value in arraylist
			}
			workbook.close();
			fs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return obja;//returning the arraylist having all values
		
				
			}

}
