package testing;

import org.openqa.selenium.By;

public class TestRollDice extends BaseTest {
	@Override
	protected void testMethod() {
		driver.findElement(By.xpath("//*[@id=\"roll\"]/button")).click();
		isElementPresent(By.xpath("/html/body/center[3]/form/button"));
	}
}
