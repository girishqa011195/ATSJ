//package Academy;
//
//import java.io.File;
//import java.io.IOException;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//
//public class CommonLibrary {
//	
//	public static WebDriver driver;
//
//
//		public void getScreenShotPath(String testCaseName) throws IOException
//		{
//		File source=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		String path=new File("user.dir")+"\\reports\\"+testCaseName+".png";
//		File dest=new File(path);
//		FileUtils.copyFile(source, dest );
//		}
//		
//
//	}


