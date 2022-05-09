package testing;

import org.junit.Assert;
import org.openqa.selenium.By;

public class TestSearchUnsuccessful extends BaseTest {

	@Override
	protected void testMethod() {
		driver.findElement(By.xpath("//*[@id=\"container\"]/center/div[2]/form/input")).sendKeys("Unsuccessful");
		driver.findElement(By.xpath("//*[@id=\"container\"]/center/div[2]/form/input")).submit();
		String title = driver.findElement(By.xpath("/html/body/section/center/h2")).getText();
		Assert.assertTrue(title.equals("Could not find \"Unsuccessful\""));
	}

}
