Feature: select product from men's section

@menScenario
Scenario Outline: Select Shirt, Jeans, and shorts
Given Select <mensproduct>, <mensproductName> and <menssize> click on add to bag
When mouseHover on cart and verify number of items added into cart and badge digit are equal
Then clear cart
Examples:
|mensproduct|					|mensproductName|						|menssize|
|Shirts|						|Twin Pocket Half Sleeve Shirt|			|M|
|Jeans|							|Cut & Sew Mid-Wash Denim Jeans|		|32|
|Shorts|						|Folded Hem Skinny Fit Day Shorts|		|34|

#@menScenarioWithFilter
#Scenario Outline: Select T-shirts,Trousers & Chinos and Coats & Jackets
#Given Select <Product>
#When Filter <Brand>, <colors>, <priceRange>
#Then <Discount>, <mensproductName> and <mensSize> click on add to bag
#Examples:
#|Product|					|Brand|			|colors|		|priceRange|		|Discount|		|mensproductName|							|mensSize|
#|T-Shirts & Polo Shirts|	|Blue Saint|	|Blue|			|Rs.401 - 500|		|30% - 39%|		|Slogan Graphic Print Round Neck T-shirt|	|M|
#|Trousers & Chinos|			|KOOVS|			|Blue|			|Rs.1551 - 1750|	|20% - 29%|		|Utility Pocket Casual Trousers|			|32|
#|Coats & Jackets|			|Blue Saint|	|Multi|			|Rs.1551 - 1900|	|0% - 9%|		|Button Down Jackets|						|L|