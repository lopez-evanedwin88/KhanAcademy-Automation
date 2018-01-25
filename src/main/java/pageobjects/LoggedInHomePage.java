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
	@FindBy(className="nickname")
	WebElement realName;
	@FindBy(className="username")
	WebElement username;
	@FindBy(className="bio")
	WebElement bio;
	@FindBy(className="location-text")
	WebElement location;

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

	public WebElement getRealName() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(realName));
		return realName;
	}

	public WebElement getUsername() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(username));
		return username;
	}

	public WebElement getBio() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(bio));
		return bio;
	}

	public WebElement getLocation() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(location));
		return location;
	}

}
