Feature: select product from men's section

@menScenario
Scenario Outline: Select Shirt, Jeans, and shorts
Given Select <mensproduct>, <mensproductName> and <menssize> click on add to bag
When mouseHover on cart and verify number of items added into cart and badge digit are equal
Then clear cart
Examples:
|mensproduct|					|mensproductName|						|menssize|
|Shirts|						|Short Sleeve Causal Shirt|				|M|
|Jeans|							|Mid Rise Stretchable Jeans|			|32|
|Shorts|						|Smart Utility Pocket Shorts|			|32|

#@menScenarioWithFilter
#Scenario Outline: Select T-shirts,Trousers & Chinos and Coats & Jackets
#Given Select <Product>
#When Filter <Brand>, <colors>, <priceRange> and <Discount>
#Then Select <mensproductName> and <mensSize> click on add to bag 
#Examples:
#|Product|					|Brand|			|colors|		|priceRange|		|Discount|		|mensproductName|				|mensSize|
#|T-Shirts & Polo Shirts|	|Blue Saint|	|Blue|			|Rs.401 - 550|		|30% - 39%|		|Solid Crew Neck T-shirt|		|M|