Feature: select product from men's section

@menScenarioWithFilter
Scenario Outline: Select T-shirts,Trousers & Chinos and Coats & Jackets
Given Select <Product>
When Filter <Brand>, <colors>, <priceRange>
Then <Discount>, <mensproductName> and <mensSize> click on add to bag
Examples:
|Product|					|Brand|			|colors|		|priceRange|		|Discount|		|mensproductName|							|mensSize|
|T-Shirts & Polo Shirts|	|Blue Saint|	|Blue|			|Rs.401 - 500|		|30% - 39%|		|Slogan Graphic Print Round Neck T-shirt|	|M|
|Trousers & Chinos|			|KOOVS|			||				||					|20% - 29%|		|Tapered Casual Trousers|					|32|
|Coats & Jackets|			|SID & SOM|		|Multi|			||					|20% - 29%|		|All Over Multi Check Bomber Jacket|		|L|