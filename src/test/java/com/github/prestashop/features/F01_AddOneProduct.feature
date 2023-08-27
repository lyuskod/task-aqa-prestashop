Feature: F01_AddOneProduct

  Scenario Outline: F01_1_UserCanAddOne<Product Type>Product
    When I click on '<Product Type>' top menu item
    Then I verify that '<Product Type>' page is 'opened'

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

    Examples:
      | Product Type |
      | Clothes      |
      | Accessories  |
      | Art          |

  Scenario Outline: F01_2_UserCanAdd<Product Type>With<Product Quantity>Quantity
    When I click on '<Product Type>' top menu item
    Then I verify that '<Product Type>' page is 'opened'

    When I add product on the '1' position choosing '<Product Quantity>' as quantity to shopping cart
    Then I verify that 'Product Added' modal is 'opened'
    And I verify that product has the following info on the product added modal:
      | Element Name | Element Value      |
      | Quantity     | <Product Quantity> |

    When I click Continue Shopping button on Product Added modal window
    Then I verify that 'Product Added' modal is 'closed'
    And I verify that Cart displays '<Product Quantity>' as products added to Shopping Cart

    When I click on 'Cart' navigation menu item
    Then I verify that 'Shopping Cart' page is 'opened'
    And I verify that '1' products are stored in Shopping Cart

    Examples:
      | Product Type | Product Quantity |
      | Clothes      | 2                |
      | Accessories  | 3                |
      | Art          | 4                |