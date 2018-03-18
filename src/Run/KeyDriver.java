package Run;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KeyDriver implements IAutoConstant {
	public static Generic g = new Generic();
	public static WebDriver driver;

	static {
	System.setProperty(CHROME_KEY,CHROME_VALUE);
	//System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
}
	@BeforeMethod
	public void LaunchBrowser() {
		String timeOut = g.getExcelCellValue(CONTROL_XL_PATH,"URL",1,1).toString();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(timeOut), TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		
	}
	
	@Test
	public void executeTest()throws InterruptedException {
		int countScripts = g.getExcelRowCount(CONTROL_XL_PATH, "ScriptsToRun");
		for(int j = 1;j<=countScripts;j++) {
			String ScriptName = g.getExcelCellValue(CONTROL_XL_PATH, "ScriptsToRun", j, 0);
			String RunOrNot = g.getExcelCellValue(CONTROL_XL_PATH, "ScriptsToRun", j, 1);
			if(RunOrNot.equalsIgnoreCase("Yes")) {
				int count = g.getExcelRowCount(SCRIPT_XL_PATH+ScriptName+".xlsx", "Sheet1");
				for(int i=1;i<=count;i++) {
					String elementPath = g.getExcelCellValue(SCRIPT_XL_PATH+ScriptName+".xlsx","Sheet1",i,0);
					String performAction = g.getExcelCellValue(SCRIPT_XL_PATH+ScriptName+".xlsx","Sheet1",i, 1);
					String value = g.getExcelCellValue(SCRIPT_XL_PATH+ScriptName+".xlsx", "Sheet1", i, 2);
					String ElementType = g.getExcelCellValue(SCRIPT_XL_PATH+ScriptName+".xlsx", "Sheet1", i, 3);
					Library l = new Library(driver);
					if(ElementType.equalsIgnoreCase("xpath")) {
					if(l.elementExist(elementPath)) {
						if(performAction.equalsIgnoreCase("sendKeys")) {
							l.sendKeys(elementPath, value);
						}
						else if(performAction.equalsIgnoreCase("click")) {
							l.click(elementPath);
						}
						else if(performAction.equalsIgnoreCase("verifytitle")) {
							l.verifyTitle(value);
						}
						else {
							System.out.println("No action found");
						}
					
					}
					else {
						System.out.println("Element not found "+"by "+ElementType + " = "+ elementPath);
					}
				}
					else if(l.elementExist(elementPath, "css")) {
					if(ElementType.equalsIgnoreCase("css")) {
						if(performAction.equalsIgnoreCase("sendKeys")) {
							l.sendKeys(elementPath, value, "css");
						}
						else if(performAction.equalsIgnoreCase("click")) {
							l.click(elementPath, "css");
						}
						else if(performAction.equalsIgnoreCase("verifytitle")) {
							l.verifyTitle(value, "css");
						}
						else {
							System.out.println("No action found");
						}
						
					}
					}
					else {
						System.out.println("Element not found "+"by "+ElementType + " = "+ elementPath);
					}
					if(ElementType.equalsIgnoreCase("")) {
						
						if(performAction.equalsIgnoreCase("click")) {
							l.click(elementPath, "Action");
						}
						else if(performAction.equalsIgnoreCase("verifytitle")) {
							l.verifyTitle(value, "Action");
						}
						else {
							System.out.println("No action found");
						}
						
					}
					}
					}
			}
	}

	@AfterMethod
	public void closeApplication() {
		driver.close();
	}
}

