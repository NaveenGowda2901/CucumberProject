package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;

import hooks.BaseClass;
import io.cucumber.java.en.*;
import pages.DeleteAccountPage;
import pages.HomePage;
import pages.SignupLoginPage;

public class DeleteUserSteps {

	HomePage homepage;
	SignupLoginPage signuppage;
	DeleteAccountPage deletepage;

	@Given("Click on Signuplogin option")
	public void click_on_signup_login_option() {
		homepage = new HomePage(BaseClass.driver);
		signuppage = new SignupLoginPage(BaseClass.driver);
		deletepage = new DeleteAccountPage(BaseClass.driver);

		homepage.clickSinupLogin();
	}

	@When("Enter existing user email and password")
	public void enter_existing_user_email_and_password() throws IOException {
		signuppage.siginInEmail(BaseClass.prop().getProperty("testuser"));
		signuppage.siginInPassword(BaseClass.prop().getProperty("testpassword"));
	}

	@When("click login button")
	public void click_login_button() {
		signuppage.clickSignIn();
	}

	@When("Enter deleted user email and password")
	public void enter_deleted_user_email_and_password() throws IOException {
		signuppage.siginInEmail(BaseClass.prop().getProperty("testuser"));
		signuppage.siginInPassword(BaseClass.prop().getProperty("testpassword"));
	}

	@When("create a new user account using mandatory fields")
	public void create_a_new_user_account_using_mandatory_fields() throws IOException {
		signuppage.signUpName(BaseClass.fakerData().name().name());
		signuppage.signUpEmail(BaseClass.fakerData().internet().emailAddress());
		signuppage.clickSignUp(); 
		
		signuppage.setAccountPassword(BaseClass.fakerData().internet().password());
		signuppage.setAddressFirstName(BaseClass.fakerData().name().firstName());
		signuppage.setAddressLastName(BaseClass.fakerData().name().lastName());
		signuppage.setAddress1(BaseClass.fakerData().address().streetAddress());
		signuppage.setCountry(BaseClass.prop().getProperty("country"));
		signuppage.setState(BaseClass.fakerData().address().state());
		signuppage.setCity(BaseClass.fakerData().address().cityName());
		signuppage.setzip(BaseClass.fakerData().address().zipCode());
		signuppage.setPhone(BaseClass.fakerData().phoneNumber().cellPhone());
		signuppage.clickCreateAccount();
		
		signuppage.clickContinuetoLogin();
	}
	
	@When("navigate back in browser")
	public void navigate_back_in_browser() throws InterruptedException {
		homepage.navigateBack();
	//	Thread.sleep(3000);
		homepage.navigateBack();
	}

	@When("delete user account")
	public void delete_user_account() {
		homepage.clickDeleteAccount();
		Assert.assertEquals(deletepage.validateAccountDeletion(), true);
		deletepage.clickContinueForAccountdeletion();
	}


	//validations
	@Then("Validate the user account gets deleted")
	public void validate_the_user_account_gets_deleted() {
		Assert.assertEquals(homepage.validateSignupLoginLink(), true);
	}

	@Then("Validate logging into the application using deleted account details")
	public void validate_logging_into_the_application_using_deleted_account_details() {
		Assert.assertEquals(signuppage.validateIncorrectSiginPasswordOrEmail(), true);
	}

	@Then("validate navigating back in the browser after user account deletion")
	public void validate_navigating_back_in_the_browser_after_user_account_deletion() {
		Assert.assertEquals(homepage.validateSignupLoginLink(), true);
	}




}
