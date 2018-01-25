package pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import session.Instance;

public class KhanAcademyRegistration extends Instance{
	@FindBy (css = "a['/signup?continue=%2Fsignup%3Fcontinue%3D%252F%253Flearn%253D1']") WebElement signUpLink;
	@FindBy (className = "birth-month datePickerField_1deaw0b fieldWithMarginRight_1pc4la7") WebElement birthMonth;
	@FindBy (className = "birth-day datePickerField_1deaw0b fieldWithMarginRight_1pc4la7") WebElement birthDay;
	@FindBy (className = "birth-year datePickerField_1deaw0b") WebElement birthYear;
	@FindBy (className = "button_1ilkz0g-o_O-common_hqgk90-o_O-large_10vyrhl-o_O-all_tca0ge-o_O-large_j2g09w") WebElement signUpWithEmailButton;
	@FindBy (className = "textInput_1xwy4a9") WebElement email;
	@FindBy (className = "actionScreen_1012r2-o_O-actionScreenHeight_ogyq09-o_O-actionScreenPadding_18razct") WebElement registrationForm;
	@FindBy (className = "button_1ilkz0g-o_O-common_hqgk90-o_O-default_9ie9c1-o_O-all_tca0ge") WebElement signUpButton;
	@FindAll ({@FindBy (tagName = "input")}) public List<WebElement> textFields;
	
	public KhanAcademyRegistration() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickSignUpLink() {
		signUpLink.click();
	}
	
	public void setBirthDate(String birthMonth, String birthDay, String birthYear) {
		Select dropdownforMonth = new Select(this.birthMonth);
		dropdownforMonth.selectByVisibleText(birthMonth);
		
		Select dropdownforDay = new Select(this.birthDay);
		dropdownforDay.selectByVisibleText(birthDay);
		
		Select dropdownforYear = new Select(this.birthYear);
		dropdownforYear.selectByVisibleText(birthYear);	
	}
	
	public void signUpWithEmailButton() {
		signUpWithEmailButton.click();
	}
	
	public void fillUpRegistrationForm(String email, String firstName, String lastName, String password) {
		WebElement registrationForm = this.registrationForm;
		textFields = registrationForm.findElements(By.tagName("input"));
		
		textFields.get(1).sendKeys(email);
		textFields.get(2).sendKeys(firstName);
		textFields.get(3).sendKeys(lastName);
		textFields.get(4).sendKeys(password);
	}
	
	public void clickSignUpButton() {
		signUpButton.click();
	}
}
