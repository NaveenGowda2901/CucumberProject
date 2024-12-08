package stepDefinitions;

import java.io.FileOutputStream;
import java.io.IOException;

import org.testng.Assert;

import hooks.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SignupLoginPage;

public class RegisterSteps {

	HomePage homepage;
	SignupLoginPage signuppage;	
	String name = BaseClass.fakerData().name().name();
	String lname = BaseClass.fakerData().name().lastName();
	String email = BaseClass.fakerData().internet().emailAddress();
	String password= BaseClass.fakerData().internet().password();
	String company = BaseClass.fakerData().company().name();
	String address = BaseClass.fakerData().address().streetAddress();
	String state = BaseClass.fakerData().address().state();
	String city = BaseClass.fakerData().address().cityName();
	String zip = BaseClass.fakerData().address().zipCode();
	String phone = BaseClass.fakerData().number().digits(10);
	
	@Given("Click on Signup\\/Login option")
	public void click_on_signup_login_option() {
		homepage = new HomePage(BaseClass.driver);
		signuppage = new SignupLoginPage(BaseClass.driver);

		homepage.clickSinupLogin();
	}

	@When("Enter valid email address")
	public void enter_valid_email_address() {
		signuppage.signUpEmail(email);
	}

	@Then("Click on Signup")
	public void click_on_signup() {
		signuppage.clickSignUp();
	}

	@When("Enter valid name")
	public void enter_valid_name() {
		signuppage.signUpName(name);
	}

	@And("Enter email with missing @gmail.com")
	public void enter_email_with_missing_gmail_com() {
		signuppage.signUpEmail(name);
	}

	@When("Enter existing user name and email address in the respective fields")
	public void enter_existing_user_name_and_email_address_in_the_respective_fields() throws IOException {
		signuppage.signUpName(BaseClass.prop().getProperty("validname"));
		signuppage.signUpEmail(BaseClass.prop().getProperty("validemail"));
	}


	@Then("Click on Create Account")
	public void click_on_create_account() {
		signuppage.clickCreateAccount();
	}
	
	@When("Fill all mandatory and non-mandatory fields of account info page with valid data")
	public void fill_all_mandatory_and_non_mandatory_fields_of_account_info_page_with_valid_data() throws IOException {
		signuppage.selectGender(BaseClass.prop().getProperty("gender"));
		signuppage.setAccountPassword(password);
		signuppage.selectDate(BaseClass.prop().getProperty("date"));
		signuppage.selectMonth(BaseClass.prop().getProperty("month"));
		signuppage.selectYear(BaseClass.prop().getProperty("year"));
		signuppage.clickNewsLetter();
		signuppage.clickSpecialOffers();
		signuppage.setAddressFirstName(name);
		signuppage.setAddressLastName(lname);
		signuppage.setCompany(company);
		signuppage.setAddress1(address);
		signuppage.setAddress2(BaseClass.fakerData().address().streetAddress());
		signuppage.setCountry(BaseClass.prop().getProperty("country"));
		signuppage.setState(state);
		signuppage.setCity(city);
		signuppage.setzip(zip);
		signuppage.setPhone(phone);
	}
	
	@When("Fill only mandatory fields of account info page with valid data")
	public void fill_only_mandatory_fields_of_account_info_page_with_valid_data() throws IOException {
		signuppage.setAccountPassword(password);
		signuppage.setAddressFirstName(name);
		signuppage.setAddressLastName(lname);
		signuppage.setAddress1(address);
		signuppage.setCountry(BaseClass.prop().getProperty("country"));
		signuppage.setState(state);
		signuppage.setCity(city);
		signuppage.setzip(zip);
		signuppage.setPhone(phone);
		
		//Storing the registered user email and password in properties file
		BaseClass.properties.put("testuser", email);
		BaseClass.properties.put("testpassword", password);
		FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
		BaseClass.properties.store(fos, "");
	}
	
	@When("Fill all mandatory details leave the password field empty")
	public void fill_all_mandatory_details_leave_the_password_field_empty() throws IOException {
		signuppage.setAddressFirstName(name);
		signuppage.setAddressLastName(lname);
		signuppage.setAddress1(address);
		signuppage.setCountry(BaseClass.prop().getProperty("country"));
		signuppage.setState(state);
		signuppage.setCity(city);
		signuppage.setzip(zip);
		signuppage.setPhone(phone);
	}
	
	@When("Fill all mandatory details leave the LastName field empty")
	public void fill_all_mandatory_details_leave_the_last_name_field_empty() throws IOException {
		signuppage.setAccountPassword(password);
		signuppage.setAddressFirstName(name);
		signuppage.setAddress1(address);
		signuppage.setCountry(BaseClass.prop().getProperty("country"));
		signuppage.setState(state);
		signuppage.setCity(city);
		signuppage.setzip(zip);
		signuppage.setPhone(phone);
	}
	
	@When("Fill all mandatory details leave the FirstName field empty")
	public void fill_all_mandatory_details_leave_the_first_name_field_empty() throws IOException {
		signuppage.setAccountPassword(password);
		signuppage.setAddressLastName(lname);
		signuppage.setAddress1(address);
		signuppage.setCountry(BaseClass.prop().getProperty("country"));
		signuppage.setState(state);
		signuppage.setCity(city);
		signuppage.setzip(zip);
		signuppage.setPhone(phone);
	}
	
	@When("Fill all mandatory details leave the AddressLine1 field empty")
	public void fill_all_mandatory_details_leave_the_address_line1_field_empty() throws IOException {
		signuppage.setAccountPassword(password);
		signuppage.setAddressFirstName(name);
		signuppage.setAddressLastName(lname);
		signuppage.setCountry(BaseClass.prop().getProperty("country"));
		signuppage.setState(state);
		signuppage.setCity(city);
		signuppage.setzip(zip);
		signuppage.setPhone(phone);
	}
	
	@When("Fill all mandatory details leave the State field empty")
	public void fill_all_mandatory_details_leave_the_state_field_empty() throws IOException {
		signuppage.setAccountPassword(password);
		signuppage.setAddressFirstName(name);
		signuppage.setAddressLastName(lname);
		signuppage.setAddress1(address);
		signuppage.setCountry(BaseClass.prop().getProperty("country"));
		signuppage.setCity(city);
		signuppage.setzip(zip);
		signuppage.setPhone(phone);
	}
	
	@When("Fill all mandatory details leave the City field empty")
	public void fill_all_mandatory_details_leave_the_city_field_empty() throws IOException {
		signuppage.setAccountPassword(password);
		signuppage.setAddressFirstName(name);
		signuppage.setAddressLastName(lname);
		signuppage.setAddress1(address);
		signuppage.setCountry(BaseClass.prop().getProperty("country"));
		signuppage.setState(state);
		signuppage.setzip(zip);
		signuppage.setPhone(phone);
	}
	
	@When("Fill all mandatory details leave the zipcode field empty")
	public void fill_all_mandatory_details_leave_the_zipcode_field_empty() throws IOException {
		signuppage.setAccountPassword(password);
		signuppage.setAddressFirstName(name);
		signuppage.setAddressLastName(lname);
		signuppage.setAddress1(address);
		signuppage.setCountry(BaseClass.prop().getProperty("country"));
		signuppage.setState(state);
		signuppage.setCity(city);
		signuppage.setPhone(phone);
	}
	
	@When("Fill all mandatory details leave the Mobile Number field empty")
	public void fill_all_mandatory_details_leave_the_mobile_number_field_empty() throws IOException {
		signuppage.setAccountPassword(password);
		signuppage.setAddressFirstName(name);
		signuppage.setAddressLastName(lname);
		signuppage.setAddress1(address);
		signuppage.setCountry(BaseClass.prop().getProperty("country"));
		signuppage.setState(state);
		signuppage.setCity(city);
		signuppage.setzip(zip);
	}
	
	@When("Fill all mandatory details and supply alphabets in mobile number field")
	public void fill_all_mandatory_details_and_supply_alphabets_in_mobile_number_field() throws IOException {
		signuppage.setAccountPassword(password);
		signuppage.setAddressFirstName(name);
		signuppage.setAddressLastName(lname);
		signuppage.setAddress1(address);
		signuppage.setCountry(BaseClass.prop().getProperty("country"));
		signuppage.setState(state);
		signuppage.setCity(city);
		signuppage.setzip(zip);
		signuppage.setPhone(name);
	}
	
	@When("Click Create Account")
	public void click_create_account() {
		signuppage.clickCreateAccount();
	}
	
	@When("Click continue to login")
	public void click_continue_to_login() {
		signuppage.clickContinuetoLogin();
	}
	
	//validations
	
	@Then("validate Signup with emptyName field")
	public void validate_signup_with_empty_name_field() {
		Assert.assertEquals(signuppage.validateMissingSignUpNameField(), true);
	}
	
	@Then("validate Signup with emptyEmail field")
	public void validate_signup_with_empty_email_field() {
		Assert.assertEquals(signuppage.validateMissingSignUpEmailField(), true);
	}
	
	@Then("validate Signup with empty Name and Email Address field")
	public void validate_signup_with_empty_name_and_email_address_field() {
		Assert.assertEquals(signuppage.validateMissingSignUpNameField(), true);
	}
	
	@Then("validate Signup with valid name and invalid email format")
	public void validate_signup_with_valid_name_and_invalid_email_format() {
		Assert.assertEquals(signuppage.validateSignupInvalidEmailFormat(), true);
	}
	
	@Then("validate Signup with existing user details")
	public void validate_signup_with_existing_user_details() {
		Assert.assertEquals(signuppage.validateSignUpWithExistingUser(), true);
	}
	
	@Then("validate Signup leaving all the fields of Account info empty")
	public void validate_signup_leaving_all_the_fields_of_account_info_empty() {
		Assert.assertEquals(signuppage.validateMissingAccountPasswordField(), true);
	}
	
	@Then("validate Name field in account info matches the Signup name")
	public void validate_name_field_in_account_info_matches_the_signup_name() {
		Assert.assertEquals(signuppage.validateNameFieldAccountInfo(), name);
	}

	@Then("validate Email field in account info matches the Signup email")
	public void validate_email_field_in_account_info_matches_the_signup_email() {
		Assert.assertEquals(signuppage.validateEmailFieldAccountInfo(), email);
	}
	
	@Then("validate Email field in account info is disabled")
	public void validate_email_field_in_account_info_is_disabled() {
		Assert.assertEquals(signuppage.validateEmailFieldAccountInfoDisabled(), false);
	}

	@Then("Validate all the mandatory fields are marked as mandatory")
	public void validate_all_the_mandatory_fields_are_marked_as_mandatory() {
String[] result = signuppage.validateMandatoryFieldsMarked();
		
		boolean flag=false;
		for(String i:result) {
			if(i.equals("true")) 
				flag = true;
		}
		Assert.assertEquals(flag, true);
	}
	
	@Then("Validate account creation")
	public void validate_account_creation() {
		Assert.assertEquals(signuppage.validateAccountCreation(), true);
	}
	
	@Then("Validate Signup")
	public void validate_signup() {
		Assert.assertEquals(homepage.validateLogoutLinkDisplay(), true);
	}
	
	
	@Then("Validate Signup leaving password field in Account info field empty")
	public void validate_signup_leaving_password_field_in_account_info_field_empty() {
		Assert.assertEquals(signuppage.validateMissingAccountPasswordField(), true);
	}

	@Then("Validate Signup leaving FirstName field empty in Account info field")
	public void validate_signup_leaving_first_name_field_empty_in_account_info_field() {
		Assert.assertEquals(signuppage.validateMissingAddressFirstNameField(), true);
	}

	@Then("Validate Signup leaving Last Name field empty in Account info field")
	public void validate_signup_leaving_last_name_field_empty_in_account_info_field() {
		Assert.assertEquals(signuppage.validateMissingLastNameField(), true);
	}
	
	@Then("Validate Signup leaving Address Line1 field empty in Account info field")
	public void validate_signup_leaving_address_line1_field_empty_in_account_info_field() {
		Assert.assertEquals(signuppage.validateMissingAddressFirstLineField(), true);
	}

	@Then("Validate Signup leaving State field empty in Account info field")
	public void validate_signup_leaving_state_field_empty_in_account_info_field() {
		Assert.assertEquals(signuppage.validateMissingAddressStateField(), true);
	}
	
	@Then("Validate Signup leaving City field empty in Account info field")
	public void validate_signup_leaving_city_field_empty_in_account_info_field() {
		Assert.assertEquals(signuppage.validateMissingAddressCityField(), true);
	}
	
	@Then("Validate Signup leaving zipcode field empty in Account info fields")
	public void validate_signup_leaving_zipcode_field_empty_in_account_info_fields() {
		Assert.assertEquals(signuppage.validateMissingAddressZipCodeField(), true);
	}

	@Then("Validate Signup leaving Mobile Number field empty in Account info fields")
	public void validate_signup_leaving_mobile_number_field_empty_in_account_info_fields() {
		Assert.assertEquals(signuppage.validateMissingAddressPhoneField(), true);
	}
	
	@Then("Validate mobile number field of account info does not take alphabets as input")
	public void validate_mobile_number_field_of_account_info_does_not_take_alphabets_as_input() {
		Assert.assertEquals(signuppage.validateInvalidAddressPhoneField(), true);
	}
}
