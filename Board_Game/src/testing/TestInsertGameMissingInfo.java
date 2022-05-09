package testing;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestInsertGameMissingInfo extends BaseTest {

	@Override
	protected void testMethod() {
		List<WebElement> games = driver.findElements(By.xpath("//*[@id=\"gameFo\"]"));
		String gameName = games.get(games.size()-1).getAttribute("value");
		clickAddButtonOnHomepage();
		insertGame("", "testing testing", "Action", "/Users/vyvo/Desktop/testImage.png", "2", "8");
		List<WebElement> newGames = driver.findElements(By.xpath("//*[@id=\"gameFo\"]"));
		String newGameName = newGames.get(newGames.size()-1).getAttribute("value");
		Assert.assertTrue(newGameName.equals(gameName));
	}

}
