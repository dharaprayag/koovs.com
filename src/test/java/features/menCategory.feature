Feature: select product from men's section

@menScenario
Scenario Outline: Select Shirt, Jeans, and shorts
Given Select <mensproduct>
When Choose <mensproductName>
Then <menssize> click on add to bag
Examples:
|mensproduct|					|mensproductName|						|menssize|
|Shirts|						|Acid-Wash Front Patch Pocket Shirt|	|L|
|Jeans|							|Dark Wash Zipper Hem Skinny Jeans|		|32|

@menScenarioWithFilter
Scenario Outline: Select T-shirts,Trousers & Chinos and Coats & Jackets
Given Men scenario with filter <Product>
When Filter <Brand>, <colors>, <priceRange>
Then <Discount>, <mensproductName> and <mensSize> and add to bag
Examples:
|Product|					|Brand|			|colors|		|priceRange|		|Discount|		|mensproductName|								|mensSize|
|T-Shirts & Polo Shirts|	|Blue Saint|	|Blue|			|Rs.401 - 500|		|20% - 29%|		|Henley Neck Long Sleeve T-Shirt|				|S|
|Trousers & Chinos|			|KOOVS|			|Blue|			|Rs.1000 - 1200|	|30% - 39%|		|Corduroy Elasticated Waist Cropped Trousers|	|32|
|Coats & Jackets|			|Blue Saint|	|Multi|			|Rs.1601 - 1950|	|0% - 9%|		|Taupe Full Sleeves Regular Fit Jacket|			|L|