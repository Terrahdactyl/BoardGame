package testing;

import org.junit.Assert;
import org.openqa.selenium.By;


public class TestLeaveReview extends BaseTest {

	@Override
	protected void testMethod() {
		clickFirstGame();
		leaveReview("10", "Nice Game!");
		String title = driver.findElement(By.xpath("/html/body/section/center/h2")).getText();
		Assert.assertTrue(title.equals("Your review has been submitted!"));
	}

}
