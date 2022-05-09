package testing;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;
import static org.junit.Assert.fail;


public abstract class BaseTest {
	 protected WebDriver driver;
	  private StringBuffer verificationErrors = new StringBuffer();
	  JavascriptExecutor js;
	  @Before
	  public void setUp() throws Exception {
	    System.setProperty("webdriver.chrome.driver", "lib/mac/chromedriver");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    js = (JavascriptExecutor) driver;
	  }

	  @Test
	  public void testGeneric() throws Exception {
	    driver.get("http://ec2-34-227-197-215.compute-1.amazonaws.com:8080/Board_Game/Homepage");
	    testMethod();
	    	  }

	  protected abstract void testMethod();

	@After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  protected boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
	  
	  protected void insertGame(String gName, String description, String type, String imagePath, String min, String max) {
			driver.findElement(By.xpath("/html/body/section/form/input[1]")).sendKeys(gName);
			driver.findElement(By.xpath("/html/body/section/form/textarea")).sendKeys(description);
			driver.findElement(By.xpath("/html/body/section/form/input[2]")).sendKeys(type);
			driver.findElement(By.xpath("/html/body/section/form/input[3]")).sendKeys(imagePath);
			driver.findElement(By.xpath("/html/body/section/form/input[4]")).sendKeys(min);
			driver.findElement(By.xpath("/html/body/section/form/input[5]")).sendKeys(max);
			driver.findElement(By.xpath("/html/body/section/form/center/input")).click();
		}
	  protected void clickAddButtonOnHomepage() {
			driver.findElement(By.xpath("//*[@id=\"container\"]/center/div[1]/a/button")).click();
			
		}
	  protected void clickHome() {
		  driver.findElement(By.xpath("//*[@id=\"container\"]/center/div[1]/a/button")).click();
	  }
	  protected void searchGame(String gameName) {
			driver.findElement(By.xpath("//*[@id=\"container\"]/center/div[2]/form/input")).sendKeys(gameName);
			driver.findElement(By.xpath("//*[@id=\"container\"]/center/div[2]/form/input")).submit();
			isElementPresent(By.xpath("/html/body/center[3]/form/button"));
		}
	  protected void leaveReview(String rating, String comment) {
			driver.findElement(By.xpath("/html/body/center[3]/form/button")).click();
			driver.findElement(By.xpath("/html/body/section/form/input")).sendKeys(rating);
			driver.findElement(By.xpath("/html/body/section/form/textarea")).sendKeys(comment);
			driver.findElement(By.xpath("/html/body/section/form/center/button")).click();
		}

	  protected void clickFirstGame()
	  {
		  String firstGameXpath = "/html/body/center/form/table/tbody/tr[1]/td/input";
			driver.findElement(By.xpath(firstGameXpath)).click();
	  }
}
