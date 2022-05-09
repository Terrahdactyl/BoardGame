package testing;

import org.openqa.selenium.By;

public class TestReturnHomepage extends BaseTest{

	@Override
	protected void testMethod() {
		clickFirstGame();
		clickHome();
		isElementPresent(By.xpath("//*[@id=\"roll\"]/button"));
	}

}
