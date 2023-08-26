Feature: F01_ShoppingCart

  Background:
    Given I open app
    Then I verify that 'Main' page is 'opened'

#  Scenario Outline: F01_1_UserCanAddOne<Product Type>Product
#    When I click on '<Product Type>' top menu item
#    Then I verify that '<Product Type>' page is 'opened'
#    When I add product on the '1' position choosing '1' as quantity to shopping cart
#    Then I verify that 'Product Added' modal is 'opened'
#    And I verify that product has the following info on the product added modal:
#      | Element Name | Element Value |
#      | Quantity     | 1             |
#
#    When I click Continue Shopping button on Product Added modal window
#    Then I verify that 'Product Added' modal is 'closed'
#    And I verify that Cart displays '1' as products added to Shopping Cart
#    When I click on 'Cart' navigation menu item
#    Then I verify that 'Shopping Cart' page is 'opened'
#    And I verify that '1' product is stored in Shopping Cart
#
#    Examples:
#      | Product Type |
#      | Clothes      |
#      | Accessories  |
#      | Art          |
#
#  Scenario Outline: F01_2_UserCanAddTwoProducts_<Product Type #1>And<Product Type #2>
#    When I click on '<Product Type #1>' top menu item
#    Then I verify that '<Product Type #1>' page is 'opened'
#    When I add product on the '1' position choosing '1' as quantity to shopping cart
#    Then I verify that 'Product Added' modal is 'opened'
#    And I verify that product has the following info on the product added modal:
#      | Element Name | Element Value |
#      | Quantity     | 1             |
#
#    When I click Continue Shopping button on Product Added modal window
#    Then I verify that 'Product Added' modal is 'closed'
#    And I verify that Cart displays '1' as products added to Shopping Cart
#    When I click on 'Cart' navigation menu item
#    Then I verify that 'Shopping Cart' page is 'opened'
#    And I verify that '1' product is stored in Shopping Cart
#
#    When I click on '<Product Type #2>' top menu item
#    Then I verify that '<Product Type #2>' page is 'opened'
#    When I add product on the '1' position choosing '1' as quantity to shopping cart
#    Then I verify that 'Product Added' modal is 'opened'
#    And I verify that product has the following info on the product added modal:
#      | Element Name | Element Value |
#      | Quantity     | 1             |
#
#    When I click Continue Shopping button on Product Added modal window
#    Then I verify that 'Product Added' modal is 'closed'
#    And I verify that Cart displays '2' as products added to Shopping Cart
#    When I click on 'Cart' navigation menu item
#    Then I verify that 'Shopping Cart' page is 'opened'
#    And I verify that '2' products are stored in Shopping Cart
#
#    Examples:
#      | Product Type #1 | Product Type #2 |
#      | Clothes         | Art             |
#      | Accessories     | Clothes         |
#      | Art             | Accessories     |
#
#  Scenario Outline: F01_3_UserCanAddAndRemove<Product Type>Product
#    When I click on '<Product Type>' top menu item
#    Then I verify that '<Product Type>' page is 'opened'
#    When I add product on the '1' position choosing '1' as quantity to shopping cart
#    Then I verify that 'Product Added' modal is 'opened'
#    And I verify that product has the following info on the product added modal:
#      | Element Name | Element Value |
#      | Quantity     | 1             |
#
#    When I click Continue Shopping button on Product Added modal window
#    Then I verify that 'Product Added' modal is 'closed'
#    And I verify that Cart displays '1' as products added to Shopping Cart
#    When I click on 'Cart' navigation menu item
#    Then I verify that 'Shopping Cart' page is 'opened'
#    And I verify that '1' product is stored in Shopping Cart
#
#    When I remove products on the following positions from my Shopping Cart:
#      | 1 |
#    Then I verify that '0' products are stored in Shopping Cart
#    When I click on '<Product Type>' top menu item
#    Then I verify that '<Product Type>' page is 'opened'
#    And I verify that Cart displays '0' as products added to Shopping Cart
#    Examples:
#      | Product Type |
#      | Clothes      |
#      | Accessories  |
#      | Art          |

#  Scenario Outline: F01_4_UserCanAddTwoProducts_<Product Type #1>And<Product Type #2>_AndRemoveOne
#    When I click on '<Product Type #1>' top menu item
#    Then I verify that '<Product Type #1>' page is 'opened'
#    When I add product on the '1' position choosing '1' as quantity to shopping cart
#    Then I verify that 'Product Added' modal is 'opened'
#    And I verify that product has the following info on the product added modal:
#      | Element Name | Element Value |
#      | Quantity     | 1             |
#
#    When I click Continue Shopping button on Product Added modal window
#    Then I verify that 'Product Added' modal is 'closed'
#    And I verify that Cart displays '1' as products added to Shopping Cart
#    When I click on 'Cart' navigation menu item
#    Then I verify that 'Shopping Cart' page is 'opened'
#    And I verify that '1' product is stored in Shopping Cart
#
#    When I click on '<Product Type #2>' top menu item
#    Then I verify that '<Product Type #2>' page is 'opened'
#    When I add product on the '1' position choosing '1' as quantity to shopping cart
#    Then I verify that 'Product Added' modal is 'opened'
#    And I verify that product has the following info on the product added modal:
#      | Element Name | Element Value |
#      | Quantity     | 1             |
#
#    When I click Continue Shopping button on Product Added modal window
#    Then I verify that 'Product Added' modal is 'closed'
#    And I verify that Cart displays '2' as products added to Shopping Cart
#    When I click on 'Cart' navigation menu item
#    Then I verify that 'Shopping Cart' page is 'opened'
#    And I verify that '2' products are stored in Shopping Cart
#
#    When I remove products on the following positions from my Shopping Cart:
#      | 1 |
#    Then I verify that '1' products are stored in Shopping Cart
#    When I click on '<Product Type #2>' top menu item
#    Then I verify that '<Product Type #2>' page is 'opened'
#    And I verify that Cart displays '1' as products added to Shopping Cart
#
#    Examples:
#      | Product Type #1 | Product Type #2 |
#      | Clothes         | Art             |

#  Scenario Outline: F01_5_UserCanAdd<Product Type>With<Product Quantity>Quantity
#    When I click on '<Product Type>' top menu item
#    Then I verify that '<Product Type>' page is 'opened'
#    When I add product on the '1' position choosing '<Product Quantity>' as quantity to shopping cart
#    Then I verify that 'Product Added' modal is 'opened'
#    And I verify that product has the following info on the product added modal:
#      | Element Name | Element Value      |
#      | Quantity     | <Product Quantity> |
#
#    When I click Continue Shopping button on Product Added modal window
#    Then I verify that 'Product Added' modal is 'closed'
#    And I verify that Cart displays '<Product Quantity>' as products added to Shopping Cart
#    When I click on 'Cart' navigation menu item
#    Then I verify that 'Shopping Cart' page is 'opened'
#    And I verify that '1' products are stored in Shopping Cart
#
#    Examples:
#      | Product Type | Product Quantity |
#      | Clothes      | 2                |
#      | Accessories  | 3                |
#      | Art          | 4                |

  Scenario Outline: F01_6_UserCanOrder<Product Type>Product
    When I click on '<Product Type>' top menu item
    Then I verify that '<Product Type>' page is 'opened'
    When I add product on the '1' position choosing '1' as quantity to shopping cart
    Then I verify that 'Product Added' modal is 'opened'
    And I verify that product has the following info on the product added modal:
      | Element Name | Element Value |
      | Quantity     | 1             |

    When I click Proceed to Checkout button on Product Added modal window
    Then I verify that 'Shopping Cart' page is 'opened'
    And I verify that '1' products are stored in Shopping Cart

    When I click Proceed to Checkout button on Shopping Cart
    Then I verify that 'Personal Information' page is 'opened'
    When I configure the Personal Information page as follows:
      | Element Name               | Element Value         |
      | Social title Mr            | checked               |
      | First name                 | Automation            |
      | Last name                  | Tester                |
      | Email                      | automation@tester.com |
      | Receive Offers From Others | checked               |
      | Agree Terms And Conditions | checked               |
      | Customer Data Privacy      | checked               |
    And I click Continue button on Personal Information page
    Then I verify that 'Addresses' page is 'opened'
    When I configure the Addresses page as follows:
      | Element Name | Element Value        |
      | Addresses    | Selenium, Cucumber 5 |
      | Postal Code  | 22001                |
      | City         | Allure               |
      | Country      | France               |
    And I click Continue on the Addresses page
    Then I verify that 'Shipping Method' page is 'opened'

    When I select Click and collect on Shipping Method page
    And I click Continue on the Shipping Method page
    Then I verify that 'Payment' page is 'opened'

    When I select 'Pay by bank wire' option on Payment page
    And I check Terms and Conditions checkbox on Payment page
    And I click Place Order button on Payment page
    Then I verify that 'Order confirmed' page is 'opened'
    And I verify that '1' product is stored in ordered products table on Order confirmed page

    When I click on '<Product Type>' top menu item
    Then I verify that '<Product Type>' page is 'opened'
    And I verify that Cart displays '0' as products added to Shopping Cart

    Examples:
      | Product Type |
      | Clothes      |
#      | Accessories  |
#      | Art          |