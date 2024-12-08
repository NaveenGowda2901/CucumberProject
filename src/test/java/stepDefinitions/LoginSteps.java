package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import hooks.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SignupLoginPage;

public class LoginSteps {

	HomePage homepage;
	SignupLoginPage signuppage;	

	String name = BaseClass.fakerData().name().firstName();
	String email = BaseClass.fakerData().internet().emailAddress();
	String password = BaseClass.fakerData().internet().password();


	@Given("Click on Signup_Login option")
	public void click_on_signup_login_option() {
		homepage = new HomePage(BaseClass.driver);
		signuppage = new SignupLoginPage(BaseClass.driver);
		
		homepage.clickSinupLogin();
	}

	@When("Enter valid login email address")
	public void enter_valid_login_email_address() throws IOException {
		signuppage.siginInEmail(BaseClass.prop().getProperty("validemail"));
	}

	@And("Enter valid login password")
	public void enter_valid_login_password() throws IOException {
		signuppage.siginInPassword(BaseClass.prop().getProperty("validpassword"));
	}

	@When("Enter invalid login email")
	public void enter_invalid_login_email() {
		signuppage.siginInEmail(email);
	}

	@When("Enter invalid login password")
	public void enter_invalid_login_password() {
		signuppage.siginInPassword(password);
	}

	@When("Enter invalid login email with missing @gmail.com")
	public void enter_invalid_login_email_with_missing_gmail_com() {
		signuppage.siginInEmail(name);
	}

	@When("Navigate back using browser back button")
	public void navigate_back_using_browser_back_button() {
		homepage.navigateBack();
	}

	@When("click logout")
	public void click_logout() {
		homepage.clickLogOut();
	}

	@When("click login")
	public void click_login() {
		signuppage.clickSignIn();
	}

	//validations
	@Then("validate login using valid email and password")
	public void validate_login_using_valid_email_and_password() {
		Assert.assertEquals(homepage.validateHomePage(), true);
		Assert.assertEquals(homepage.validateLogoutLinkDisplay(), true);
	}

	@Then("Validate login using invalid email and valid password")
	public void validate_login_using_invalid_email_and_valid_password() {
		Assert.assertEquals(signuppage.validateIncorrectSiginPasswordOrEmail(), true);
	}


	@Then("Validate login using valid email and invalid password")
	public void validate_login_using_valid_email_and_invalid_password() {
		Assert.assertEquals(signuppage.validateIncorrectSiginPasswordOrEmail(), true);
	}

	@Then("Validate login using invalid email and invalid password")
	public void validate_login_using_invalid_email_and_invalid_password() {
		Assert.assertEquals(signuppage.validateIncorrectSiginPasswordOrEmail(), true);
	}

	@Then("Validate login using invalid email format and valid password")
	public void validate_login_using_invalid_email_format_and_valid_password() {
		Assert.assertEquals(signuppage.validateSigninInvalidEmailFormat(), true);
	}

	@Then("Validate login without email and valid password")
	public void validate_login_without_email_and_valid_password() {
		Assert.assertEquals(signuppage.validateMissingSigninEmailField(), true);
	}


	@Then("Validate login with valid email and missing password")
	public void validate_login_with_valid_email_and_missing_password() {
		Assert.assertEquals(signuppage.validateMissingSigninPasswordField(), true);
	}

	@Then("Validate login with blank email and password fields")
	public void validate_login_with_blank_email_and_password_fields() {
		Assert.assertEquals(signuppage.validateMissingSigninEmailField(), true);
	}

	@Then("Validate placeholder for emailaddress and password fields")
	public void validate_placeholder_for_emailaddress_and_password_fields() {
		Assert.assertEquals(signuppage.validateSigninPlaceHolders(), true);
	}

	@Then("Validate Login and browsing back using Browser back button")
	public void validate_login_and_browsing_back_using_browser_back_button() {
		Assert.assertEquals(homepage.validateLogoutLinkDisplay(), true);
	}

	@Then("Validate Loggingout from the Application and browsing back using Browser back button")
	public void validate_loggingout_from_the_application_and_browsing_back_using_browser_back_button() {
		Assert.assertEquals(homepage.validateLogoutLinkDisplay(), false);
	}


	@Then("Validate the text into the Password field is toggled")
	public void validate_the_text_into_the_password_field_is_toggled() {
		Assert.assertEquals(signuppage.validateSigninToggledPasswordField(), true);
	}


	@Then("Validate the Password is not visible in the Page Source")
	public void validate_the_password_is_not_visible_in_the_page_source() {
		Assert.assertEquals(signuppage.validateSigninPasswordInPageSource(password), false);
	}









}
