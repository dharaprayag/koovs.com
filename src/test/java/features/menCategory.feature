Feature: select product from men's section

@menScenario
Scenario Outline: Select Shirt, Jeans, and shoes
Given Select <mensproduct>, <mensproductName> and <menssize> click on add to bag
When mouseHover on cart and verify number of items added into cart and badge digit are equal
Then clear cart
Examples:
|mensproduct|					|mensproductName|						|menssize|
|Shirts|						|Short Sleeve Causal Shirt|				|M|
|Jeans|							|Mid Rise Stretchable Jeans|			|32|