package testing;

import java.time.LocalDateTime;

public class TestInsertGame extends BaseTest {

	@Override
	protected void testMethod() {
		clickAddButtonOnHomepage();
		String gName = "Test" + LocalDateTime.now().toString();
		insertGame(gName, "testing testing", "Action", "/Users/vyvo/Desktop/testImage.png", "2", "8");
		searchGame(gName);
	}

	
}
