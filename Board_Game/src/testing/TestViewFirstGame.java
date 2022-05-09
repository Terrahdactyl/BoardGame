package testing;

import org.openqa.selenium.By;

public class TestViewFirstGame extends BaseTest {

	@Override
	protected void testMethod() {
		clickFirstGame();
		isElementPresent(By.xpath("/html/body/center[3]/form/button"));
	}

}
