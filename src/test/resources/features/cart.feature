Feature: Cart Operation

  Background: 
    Given Click on products options

  Scenario: Validate Adding product to the cart via Products page(TC_Cart_001)
    When search a product
    And Add the product to cart from products page
    Then Validate Adding product to the cart via Products page

  Scenario: Validate Adding product to the cart via Product details page(TC_Cart_002)
    When search a product
    And click on view product
    And Add the product to cart from product display page
    Then Validate Adding product to the cart via Product details page

  Scenario: Validate product added to cart pop up window on the 'Products' page has 'View cart' and 'Continue shopping' links(TC_Cart_003)
    When search a product
    And Add the product to cart from products page
    Then Validate product added to cart pop up window on the Products page has links

  Scenario: Validate product added to cart pop up window on the 'Product details' page has 'View cart' and 'Continue shopping' links(TC_Cart_004)
    When search a product
    And click on view product
    And Add the product to cart from product display page
    Then Validate product added to cart pop up window on the Product details page has links

  Scenario: validate 'view cart' link on the pop up of 'products' page naviates to the cart(TC_Cart_005)
    When search a product
    And Add the product to cart from products page
    Then click view cart link
    Then validate view cart link on the pop up of products page naviates to the cart

  Scenario: validate 'view cart' link on the pop up of 'product details' page naviates to the cart(TC_Cart_006)
    When search a product
    And click on view product
    And Add the product to cart from product display page
    Then click view cart link
    Then validate view cart link on the pop up of product details page naviates to the cart

  Scenario: validate 'continue shopping' link on the pop up of 'products' continues to products page(TC_Cart_007)
    When search a product
    And Add the product to cart from products page
    Then click continue shopping link
    Then validate continue shopping link on the pop up of products page continues to products page

  Scenario: validate 'continue shopping' link on the pop up of 'product details' continues to product detsils page(TC_Cart_008)
    When search a product
    And click on view product
    And Add the product to cart from product display page
    Then click continue shopping link
    Then validate continue shopping link on the pop up of products page continues to product details page

  Scenario: Validate the product quantity reflects in the cart (TC_Cart_009)
    When search a product
    And click on view product
    Then Increase the quantity
    And Add the product to cart from product display page
    Then click view cart link
    Then Validate the product quantity reflects in the cart

  Scenario: Validate the cart total price (TC_Cart_010)
    When search a product
    And click on view product
    Then Increase the quantity
    And Add the product to cart from product display page
    Then click view cart link
    Then Validate the cart total price

  Scenario: Validate product deletion from cart(TC_Cart_011)
    When search a product
    And click on view product
    Then Increase the quantity
    And Add the product to cart from product display page
    Then click view cart link
    And delete product from cart
    Then Validate product deletion from cart

  Scenario: Validate of all the items, only the item of interest gets deleted from the cart(TC_Cart_012)
    When search a product
    And click on view product
    And Add the product to cart from product display page
    Then click continue shopping link
    And Click on products options
    When search another product
    And click on view product2
    And Add the product to cart from product display page
    Then click view cart link
    And delete only one product from cart
    Then Validate only the product of interest gets deleted from the cart

  Scenario: Validate all the items of the cart are deleted and the cart is empty(TC_Cart_013)
    When search a product
    And click on view product
    And Add the product to cart from product display page
    Then click continue shopping link
    And Click on products options
    When search another product
    And click on view product2
    And Add the product to cart from product display page
    Then click view cart link
    And delete all products from cart
    Then Validate all the items of the cart are deleted and the cart is empty
