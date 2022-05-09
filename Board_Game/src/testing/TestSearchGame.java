package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestSearchGame extends BaseTest {

	@Override
	protected void testMethod() {
		List<WebElement> games = driver.findElements(By.xpath("//*[@id=\"gameFo\"]"));
		int numGames = games.size();
		String gameName = games.get(numGames - 1).getAttribute("value"); 
		searchGame(gameName);
	}

	
}
