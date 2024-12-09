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
	CartPage cart;
	String quantity="5";

	String product1 = "tops";
	String product2 = "dress";
	String productChosen;
	String productChosen2;

	@Given("Click on products options")
	public void click_on_products_options() {
		searchpage = new SearchPage(BaseClass.driver);
		cart = new CartPage(BaseClass.driver);
		homepage = new HomePage(BaseClass.driver);

		homepage.clickProducts();
	}

	@When("search a product")
	public void search_a_product() {
		searchpage.SearchProdThroughSearchBtn(product1);
	}

	@When("Add the product to cart from products page")
	public void add_the_product_to_cart_from_products_page() {
		searchpage.AddProductToCartViaProductPage();
	}

	@When("click on view product")
	public void click_on_view_product() {
		searchpage.clickViewProductOfFirstSearchProduct();
		productChosen = searchpage.getProductName();
		System.out.println("product1:"+productChosen);
	}

	@When("click on view product2")
	public void click_on_view_product2() {
		searchpage.clickViewProductOfFirstSearchProduct();
		productChosen2 = searchpage.getProductName();
		System.out.println("product2:"+productChosen2);
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
		searchpage.clickDisplayPageContinueShopping();
	}

	@Then("delete only one product from cart")
	public void delete_only_one_product_from_cart() throws InterruptedException {
		cart.deleteItemFromCart(productChosen);
	}

	@Then("Increase the quantity")
	public void increase_the_quantity() {
		searchpage.setProductQuantity(quantity);
	}

	@Then("delete all products from cart")
	public void delete_all_products_from_cart() {
		cart.deleteAllCartItems();
	}

	@When("search another product")
	public void search_another_product() {
		searchpage.SearchProdThroughSearchBtn(product2);
	}

	@Then("delete product from cart")
	public void delete_product_from_cart() throws InterruptedException {
		Thread.sleep(3000);
		cart.deleteItemFromCart(productChosen);
		Thread.sleep(3000);
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
		Assert.assertEquals(cart.validateCartPage(), true);
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
		Assert.assertEquals(searchpage.validateSearchPageNavigation(), true);
	}

	@Then("Validate the product quantity reflects in the cart")
	public void validate_the_product_quantity_reflects_in_the_cart() {
		Assert.assertEquals(cart.displayProductQuantity(productChosen), quantity);
	}

	@Then("Validate the cart total price")
	public void validate_the_cart_total_price()  {
		System.out.println(productChosen);
		int cartQuantity = Integer.parseInt(cart.displayProductQuantity(productChosen));
		Double itemPrice = cart.getItemPrice(productChosen);
		Double totalPrice = cartQuantity*itemPrice;

		System.out.println("Cart quantity: " + cartQuantity);
		System.out.println("Expected total price: "+ totalPrice);
		System.out.println("Actual Total Price: " + cart.getItemTotalPrice(productChosen));

		Assert.assertEquals(cart.getItemTotalPrice(productChosen), totalPrice);
	}

	@Then("Validate product deletion from cart")
	public void validate_product_deletion_from_cart() {
		Assert.assertEquals(cart.verifyItemDelete(productChosen), true);
	}

	@Then("Validate only the product of interest gets deleted from the cart")
	public void validate_only_the_product_of_interest_gets_deleted_from_the_cart() {
		Assert.assertEquals(cart.verifyItemDelete(product1), true);
	}

	@Then("Validate all the items of the cart are deleted and the cart is empty")
	public void validate_all_the_items_of_the_cart_are_deleted_and_the_cart_is_empty() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(cart.validateAllItemsDeleted(), true);
	}




}
