Feature: select product from men's section

@menScenario
Scenario Outline: Select Shirt, Jeans, and shorts
Given Select <mensproduct>, <mensproductName> and <menssize> click on add to bag
When mouseHover on cart and verify number of items added into cart and badge digit are equal
Then clear cart
Examples:
|mensproduct|					|mensproductName|						|menssize|
|Shirts|						|Acid-Wash Front Patch Pocket Shirt|	|L|
|Jeans|							|Cut & Sew Mid-Wash Denim Jeans|		|32|
|Shorts|						|Folded Hem Skinny Fit Day Shorts|		|34|

@menScenarioWithFilter
Scenario Outline: Select T-shirts,Trousers & Chinos and Coats & Jackets
Given Men scenario with filter <Product>
When Filter <Brand>, <colors>, <priceRange>
Then <Discount>, <mensproductName> and <mensSize> and add to bag
Examples:
|Product|					|Brand|			|colors|		|priceRange|		|Discount|		|mensproductName|								|mensSize|
|T-Shirts & Polo Shirts|	|Blue Saint|	|Blue|			|Rs.400 - 500|		|30% - 39%|		|Slogan Graphic Print Round Neck T-shirt|		|M|
|Trousers & Chinos|			|KOOVS|			|Blue|			|Rs.1000 - 1200|	|30% - 39%|		|Corduroy Elasticated Waist Cropped Trousers|	|32|
|Coats & Jackets|			|Blue Saint|	|Multi|			|Rs.1601 - 1950|	|0% - 9%|		|Taupe Full Sleeves Regular Fit Jacket|			|L|