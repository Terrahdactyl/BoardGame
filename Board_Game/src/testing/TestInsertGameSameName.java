package testing;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.openqa.selenium.By;


public class TestInsertGameSameName extends BaseTest {

	@Override
	protected void testMethod() {
		clickAddButtonOnHomepage();
		String gName = "Test" + LocalDateTime.now().toString();
		insertGame(gName, "testing testing", "Action", "/Users/vyvo/Desktop/testImage.png", "2", "8");
		searchGame(gName);
		String des1 = driver.findElement(By.xpath("/html/body/section[1]")).getText();
		clickHome();
		clickAddButtonOnHomepage();
		insertGame(gName, "testing 2nd", "Action", "/Users/vyvo/Desktop/testImage.png", "2", "8");
		searchGame(gName);
		String actualDes = driver.findElement(By.xpath("/html/body/section[1]")).getText();
		Assert.assertTrue(actualDes.equals(des1));
	}

}
