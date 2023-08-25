Feature: F01_ShoppingCart

  # Scenarios:
  # add 1 product
  # add 2 products
  # add 1 product with 2 quantity
  # add 2 products with diff quantity
  # add products from all the 3 tabs

  Background:
    Given I open app
    Then I verify that 'Main' page is 'opened'

  Scenario: F01_1_UserCanAddMoreThanOneItem
    When I click on 'Art' top menu item
    Then I verify that 'Art' page is 'opened'
    When I add product on the '1' position choosing '1' as quantity to shopping cart
    Then I verify that 'Product Added' modal is 'opened'
    And I verify that product has the following info on the product added modal:
      | Element Name | Element Value |
      | Quantity     | 1             |
    When I click Continue Shopping button on Product Added modal window
    Then I verify that 'Product Added' modal is 'closed'
    And I verify that Cart displays '1' as products added to Shopping Cart
    When I click on 'Cart' navigation menu item
    Then I verify that 'Shopping Cart' page is 'opened'
    And I verify that '1' product is stored in Shopping Cart
#    And I verify the Shopping Cart page has the following products added:
#      | Product Position | Product Quantity |
#      | 1                | 1                |
