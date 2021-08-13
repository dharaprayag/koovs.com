Feature: Cart Feature

@calculateTotalAmount
Scenario: Sum of items prices and Bag Total should be same
Given Click on cart icon
When Get items prices and convert into int
Then Get text of Bag total compare with when condition

@numberOfitemsInCart
Scenario: Number of items added into cart and badge digit should be same
Given Mousehover on cart
When Total number items in cart and compare with Badge digit
Then Clear cart