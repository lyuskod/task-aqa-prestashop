@smoke @add_multiple_products
Feature: F02_AddMultipleProducts

  Scenario Outline: F01_2_UserCanAddTwoProducts_<Product Type #1>And<Product Type #2>
    When I click on '<Product Type #1>' top menu item
    Then I verify that '<Product Type #1>' page is 'opened'

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

    When I click on '<Product Type #2>' top menu item
    Then I verify that '<Product Type #2>' page is 'opened'

    When I add product on the '1' position choosing '1' as quantity to shopping cart
    Then I verify that 'Product Added' modal is 'opened'
    And I verify that product has the following info on the product added modal:
      | Element Name | Element Value |
      | Quantity     | 1             |

    When I click Continue Shopping button on Product Added modal window
    Then I verify that 'Product Added' modal is 'closed'
    And I verify that Cart displays '2' as products added to Shopping Cart

    When I click on 'Cart' navigation menu item
    Then I verify that 'Shopping Cart' page is 'opened'
    And I verify that '2' products are stored in Shopping Cart

    Examples:
      | Product Type #1 | Product Type #2 |
      | Clothes         | Art             |
      | Accessories     | Clothes         |
      | Art             | Accessories     |