package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import session.Instance;

public class LoggedInHomePage extends Instance{

	@FindBy(xpath="//*[@id=\"_kareact_0\"]/div/div[2]/div[1]/div/div[1]/div/div/div[2]/a")
	WebElement editProfile;

	public LoggedInHomePage() {
		ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(ajaxElementLocatorFactory, this);
	}

	public void clickEditProfile() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(editProfile));
		Actions action = new Actions(driver);
		action.moveToElement(editProfile).click().build().perform();
	}

}
