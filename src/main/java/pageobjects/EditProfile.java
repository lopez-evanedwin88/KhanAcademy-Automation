package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import session.Instance;

public class EditProfile extends Instance{

	@FindBy(id="nickname")
	WebElement realName;
	@FindBy(id="username")
	WebElement username;
	@FindBy(className="select2-chosen")
	WebElement locationOuter;
	@FindBy(className="select2-input")
	WebElement locationInner;
	@FindBy(className="select2-result")
	WebElement locationSelection;
	@FindBy(id="bio-picker")
	WebElement bio;
	@FindBy(xpath="//*[@id=\"username-picker-container\"]/div[3]/div/a[2]")
	WebElement saveButton;

	public EditProfile() {
		ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(ajaxElementLocatorFactory, this);
	}

	public void clickSave() {
		WebDriverWait wait = new WebDriverWait(Instance.driver, 10);
		wait.until(ExpectedConditions.visibilityOf(saveButton));
		saveButton.click();
		//Actions action = new Actions(driver);
		//action.moveToElement(saveButton).click().build().perform();
	}

	public void populateRealName(String name) {
		WebDriverWait wait = new WebDriverWait(Instance.driver, 10);
		wait.until(ExpectedConditions.visibilityOf(realName));
		realName.sendKeys(name);
	}

	public void populateUsername(String name) {
		WebDriverWait wait = new WebDriverWait(Instance.driver, 10);
		wait.until(ExpectedConditions.visibilityOf(username));
		username.sendKeys(name);
	}

	public void populateLocation(String text) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Actions action = new Actions(driver);

		wait.until(ExpectedConditions.visibilityOf(locationOuter));
		action.moveToElement(locationOuter).click().build().perform();
		locationInner.sendKeys(text);
		wait.until(ExpectedConditions.visibilityOf(locationSelection));
		action.moveToElement(locationSelection).click().build().perform();
	}

	public void populateBio(String description) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(bio));
		bio.sendKeys(description);
	}
}
