package stepDefinitions;

import org.testng.Assert;

import hooks.BaseClass;
import io.cucumber.java.en.*;
import pages.CartPage;
import pages.HomePage;
import pages.SearchPage;

public class CartSteps {

	HomePage homepage;
	SearchPage searchpage;
	CartPage cartpage;

	String searchtxt = "tshirt";

	@Given("Click on products options")
	public void click_on_products_options() {
		searchpage = new SearchPage(BaseClass.driver);
		cartpage = new CartPage(BaseClass.driver);
		homepage = new HomePage(BaseClass.driver);

		homepage.clickProducts();
	}

	@When("search a product")
	public void search_a_product() {
		searchpage.SearchProdThroughSearchBtn(searchtxt);
	}

	@When("Add the product to cart from products page")
	public void add_the_product_to_cart_from_products_page() {
		searchpage.AddProductToCartViaProductPage();
	}

	@When("click on view product")
	public void click_on_view_product() {
		searchpage.clickViewProductOfFirstSearchProduct();
	}

	@When("Add the product to cart from product display page")
	public void add_the_product_to_cart_from_product_display_page() {
		searchpage.AddProductToCartViaProductDetailsPage();
	}

	@Then("click view cart link")
	public void click_view_cart_link() {
		searchpage.clickDisplayPagePopupCartNavigation();
	}

	@Then("click continue shopping link")
	public void click_continue_shopping_link() {
		Assert.assertEquals(cartpage.validateCartPage(), true);
	}

	@Then("delete only one product from cart")
	public void delete_only_one_product_from_cart() {

	}

	@Then("Increase the quantity")
	public void increase_the_quantity() {

	}

	@Then("delete all products from cart")
	public void delete_all_products_from_cart() {

	}

	@When("search another product")
	public void search_another_product() {

	}

	//validations

	@Then("Validate Adding product to the cart via Products page")
	public void validate_adding_product_to_the_cart_via_products_page() {
		Assert.assertEquals(searchpage.validateProductAddedToCart(), true);
	}

	@Then("Validate Adding product to the cart via Product details page")
	public void validate_adding_product_to_the_cart_via_product_details_page() {
		Assert.assertEquals(searchpage.validateProductAddedToCart(), true);
	}

	@Then("Validate product added to cart pop up window on the Products page has links")
	public void validate_production_added_to_cart_pop_up_window_on_the_products_page_has_links() {
		boolean validate[] = {true, true};
		Assert.assertEquals(searchpage.validatePopup(), validate);
	}

	@Then("Validate product added to cart pop up window on the Product details page has links")
	public void validate_production_added_to_cart_pop_up_window_on_the_product_details_page_has_links() {
		boolean validate[] = {true, true};
		Assert.assertEquals(searchpage.validatePopup(), validate);

	}

	@Then("validate view cart link on the pop up of products page naviates to the cart")
	public void validate_view_cart_link_on_the_pop_up_of_products_page_naviates_to_the_cart() {
		Assert.assertEquals(cartpage.validateCartPage(), true);
	}

	@Then("validate view cart link on the pop up of product details page naviates to the cart")
	public void validate_view_cart_link_on_the_pop_up_of_product_details_page_naviates_to_the_cart() {

	}

	@Then("validate continue shopping link on the pop up of products page continues to products page")
	public void validate_continue_shopping_link_on_the_pop_up_of_products_page_continues_to_products_page() {
		Assert.assertEquals(searchpage.validateSearchPageNavigation(), true);
	}

	@Then("validate continue shopping link on the pop up of products page continues to product details page")
	public void validate_continue_shopping_link_on_the_pop_up_of_products_page_continues_to_product_details_page() {

	}




	@Then("Validate the product quantity reflects in the cart")
	public void validate_the_product_quantity_reflects_in_the_cart() {

	}

	@Then("Validate the cart total price")
	public void validate_the_cart_total_price() {

	}

	@Then("delete product from cart")
	public void delete_product_from_cart() {

	}

	@Then("Validate product deletion from cart")
	public void validate_product_deletion_from_cart() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Validate only the product of interest gets deleted from the cart")
	public void validate_only_the_product_of_interest_gets_deleted_from_the_cart() {

	}

	@Then("Validate all the items of the cart are deleted and the cart is empty")
	public void validate_all_the_items_of_the_cart_are_deleted_and_the_cart_is_empty() {

	}




}
