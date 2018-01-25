package test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageobjects.EditProfile;
import pageobjects.LoggedInHomePage;

public class EditProfileTest {

	//HomePage homePage;
	LoggedInHomePage logHome;
	EditProfile editProf;

	@BeforeClass
	public void setup() {
		//homePage = new HomePage();
		logHome = new LoggedInHomePage();
		editProf = new EditProfile();
	}

	//assuming not logged in yet
	/*@Test (priority=1)
	public void logIn() {
		homePage.clickLogin();
		homePage.autofillEmail();
		homePage.autofillPassword();
		homePage.submit();
		Assert.assertTrue(true);
	}*/

	@Parameters({"testUsername","testLocation","testBio"})
	@Test
	public void editProfileTest(String testUsername, String testLocation, String testBio) {
		WebElement username;
		WebElement bio;
		WebElement location;

		logHome.clickEditProfile();
		editProf.populateUsername(testUsername);
		editProf.populateLocation(testLocation);
		editProf.populateBio(testBio);
		editProf.clickSave();

		username = logHome.getUsername();
		bio = logHome.getBio();
		location = logHome.getLocation();

		Assert.assertEquals(username.getText(),"@" + testUsername);
		Assert.assertEquals(bio.getText(), testBio);
		Assert.assertEquals(location.getText(), testLocation);
	}
}
