Feature: F01_ShoppingCart

  Background:
    Given I open app
    Then I verify that Main Page is opened

  Scenario: F01_1_UserCanAddMoreThanOneItem
    When I click on 'Art' top menu item
    Then I verify that Art page is 'opened'
#    When I add product on the '1' position choosing '2' as quantity to shopping cart
#    Then I verify that product added modal is opened
#    And I verify that product has the following info on the product added modal:
