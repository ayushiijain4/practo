package factory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static Logger logger;
	public Properties p;

	public static WebDriver driver;

	@BeforeTest
	@Parameters({"os","browser" })
	public  void setUp(String os,String br) throws IOException

	{
		logger = LogManager.getLogger(this.getClass());
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(file);
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap=new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			}
				else if(os.equalsIgnoreCase("mac")) {
					cap.setPlatform(Platform.MAC);
					
			}
				else {
				System.out.println("no match found");
					
			}
			switch (br.toLowerCase()) {
		
			case "chrome":
				cap.setBrowserName("chrome");
				break;
			case "edge":
				cap.setBrowserName("MicrosoftEdge");
				break;

			default:
				System.out.println("no match found");
				break;
			}
		 driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		}
		
		
		else if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
		
		
		
		
		//local execution
		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("no match found");
			return;

		}
		}

		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appURL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		logger.info("***loaded successfully***");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		logger.info("all windows are closed");

	}

	public String captureScreen(String name) throws IOException {
		 {String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot takeScreenshot = (TakesScreenshot)driver;
			File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
			String targetFilePath=System.getProperty("user.dir")+"\\Screenshot\\" + name +"-" + timeStamp + ".png";
			File targetFile = new File(targetFilePath);
			sourceFile.renameTo(targetFile);
			return targetFilePath;
				
		 }
	}
}
