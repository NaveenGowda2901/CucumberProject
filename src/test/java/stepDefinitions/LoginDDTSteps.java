package stepDefinitions;

import org.testng.Assert;

import hooks.BaseClass;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SignupLoginPage;

public class LoginDDTSteps {
	
	HomePage homepage;
	SignupLoginPage signuppage;
	
	@Given("user clicks on signin link on homepage")
	public void user_clicks_on_signin_link_on_homepage() {
	    homepage = new HomePage(BaseClass.driver);
	    signuppage = new SignupLoginPage(BaseClass.driver);
	    
	    homepage.clickSinupLogin();
	}
	
	@Then("verify user login for different set of inputs {string} {string}> {string}")
	public void verify_user_login_for_different_set_of_inputs(String email, String password, String status) {
		signuppage.siginInEmail(email);
		signuppage.siginInPassword(password);
		signuppage.clickSignIn();
		
		if(status.equals("invalidemail")) {
			if(signuppage.validateIncorrectSiginPasswordOrEmail()==true)
				Assert.assertTrue(true);
			else if(signuppage.validateIncorrectSiginPasswordOrEmail()==false)
				Assert.fail();
			else if(homepage.validateLogoutLinkDisplay()==true) {
				homepage.clickLogOut();
				Assert.fail();
			}
		}
		
		if(status.equals("invalidpassword")) {
			if(signuppage.validateIncorrectSiginPasswordOrEmail()==true)
				Assert.assertTrue(true);
			else if(signuppage.validateIncorrectSiginPasswordOrEmail()==false)
				Assert.fail();
			else if(homepage.validateLogoutLinkDisplay()==true) {
				homepage.clickLogOut();
				Assert.fail();
			}
		}
		
		if(status.equals("invalidemailformat")) {
			if(signuppage.validateSigninInvalidEmailFormat()==true)
				Assert.assertTrue(true);
			else if(signuppage.validateSigninInvalidEmailFormat()==false)
				Assert.fail();
			else if(homepage.validateLogoutLinkDisplay()==true) {
				homepage.clickLogOut();
				Assert.fail();
			}
		}
		
		if(status.equals("valid")) {
			if(homepage.validateLogoutLinkDisplay()==true) {
				Assert.assertTrue(true);
				homepage.clickLogOut();
			}
			else if(homepage.validateLogoutLinkDisplay()==false)
				Assert.fail();
		}
		
		if(status.equals("missingemail")) {
			if(signuppage.validateMissingSigninEmailField()==true)
				Assert.assertTrue(true);
			else if(signuppage.validateMissingSigninEmailField()==false)
				Assert.fail();
			else if(homepage.validateLogoutLinkDisplay()==true) {
				homepage.clickLogOut();
				Assert.fail();
			}
		}
		
		if(status.equals("missingpassword")) {
			if(signuppage.validateMissingSigninPasswordField()==true)
				Assert.assertTrue(true);
			else if(signuppage.validateMissingSigninPasswordField()==false)
				Assert.fail();
			else if(homepage.validateLogoutLinkDisplay()==true) {
				homepage.clickLogOut();
				Assert.fail();
			}
		}
		
		if(status.equals("missingemailandpassword")) {
			if(signuppage.validateMissingSigninEmailField()==true)
				Assert.assertTrue(true);
			else if(signuppage.validateMissingSigninEmailField()==false)
				Assert.fail();
			else if(homepage.validateLogoutLinkDisplay()==true) {
				homepage.clickLogOut();
				Assert.fail();
			}
		}
		
	}

}
