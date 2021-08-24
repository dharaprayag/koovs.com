Feature: select product from men's section

@menScenario
Scenario Outline: Select Shirt, Jeans, T-shirts & Polo Shirts, Trousers & Chinos and Coats & Jackets
Given Select <mensproduct>
When Choose <mensproductName>
Then <menssize> click on add to bag
Examples:
|mensproduct|					|mensproductName|						|menssize|
|Shirts|						|Acid-Wash Front Patch Pocket Shirt|	|L|
|Jeans|							|Mid Rise Slim Fit Jeans|				|34|

@menScenarioWithFilter
Scenario Outline: Select T-shirts,Trousers & Chinos and Coats & Jackets
Given Men scenario with filter <Product>
When Filter <Brand>, <colors>, <priceRange>
Then <Discount>, <mensproductName> and <mensSize> and add to bag
Examples:
|Product|					|Brand|			|colors|		|priceRange|		|Discount|		|mensproductName|								|mensSize|
|T-Shirts & Polo Shirts|	|KOOVS|			|Blue|			|Rs.751 - 1300|		|0% - 9%|		|Men's Oversized Black T-shirt|					|M|
|Trousers & Chinos|			|Blue Saint|	|Blue|			|Rs.551 - 700	|	|60% - 69%|		|Contrast Side Tape Drawcord Trouser|			|32|
|Coats & Jackets|			|SID & SOM|		|Multi|			|Rs.1951 - 2200|	|20% - 29%|		|Camo Jacquard Bomber Jacket|					|L|