package stepDefinitions;

import org.testng.Assert;

import hooks.BaseClass;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchPage;

public class SearchSteps {
	
	HomePage homepage;
	SearchPage searchpage;
	
	String searchtxt = "tshirt";
	
	@Given("Click on Products option")
	public void click_on_products_option() {
	    homepage = new HomePage(BaseClass.driver);
	    searchpage = new SearchPage(BaseClass.driver);
	    
	    homepage.clickProducts();
	}

	@When("Enter name of a product in search bar and click enter key")
	public void enter_name_of_a_product_in_search_bar() {
		searchpage.SearchProdThroughEnterKey(searchtxt);
	}

	@When("Enter name of a product in search bar and click on search button")
	public void enter_name_of_a_product_in_search_bar_and_click_on_search_button() {
		searchpage.SearchProdThroughSearchBtn(searchtxt);
	}
	
	@When("Click on view product")
	public void click_on_view_product() {
		searchpage.clickViewProductOfFirstSearchProduct();
	}

	//validations
	@Then("Validate the Products page is loaded")
	public void validate_the_products_page_is_loaded() {
		Assert.assertEquals(searchpage.validateSearchPageNavigation(), true);
	}
	
	@Then("Validate Search a product via search button")
	public void validate_search_a_product_via_search_button() {
		Assert.assertEquals(searchpage.validateSearchProduct().contains(searchtxt), true);
	}

	@Then("Validate search bar placeholder")
	public void validate_search_bar_placeholder() {
		Assert.assertEquals(searchpage.validateSearchBarPlaceholder(), "Search Product");
	}
	
	@Then("Validate Search a product via pressing Enter key")
	public void validate_search_a_product_via_pressing_enter_key() {
		Assert.assertEquals(searchpage.validateSearchProduct().contains(searchtxt), true);
	}
	
	@Then("Validate search product details are loaded when click on the product")
	public void validate_search_product_details_are_loaded_when_click_on_the_product() {
		Assert.assertEquals(searchpage.validateSearchProduct().contains("product_details"), true);
	}

	@Then("Validate Availability, Brand, Condition, Category and Price are displayed")
	public void validate_availability_brand_condition_category_and_price_are_displayed() {
		Assert.assertEquals(searchpage.validateProductDetails(searchtxt), true);
	}




}
