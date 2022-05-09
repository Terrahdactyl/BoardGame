package testing;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class TestLeaveReviewMissingRating extends BaseTest {

	@Override
	protected void testMethod() {
		clickFirstGame();
		leaveReview("", "Nice!!");
		driver.findElement(By.xpath("//*[@id=\"container\"]/center/div[2]/form/button")).click();
		if (driver.findElement(By.xpath("/html/body/section[2]/table")).isDisplayed())
		{
			List<WebElement> reviewList = driver.findElements(By.xpath("/html/body/section[2]/table/tbody/tr/td"));
			String recentReview = reviewList.get(reviewList.size() - 1).getText();
			Assert.assertFalse(recentReview.equals("(/10.0) Nice!!"));
			
		}
		
	}

}
