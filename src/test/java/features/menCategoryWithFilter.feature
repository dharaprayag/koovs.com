Feature: select product from men's section

@menScenarioWithFilter
Scenario Outline: Select T-shirts,Trousers & Chinos and Coats & Jackets
Given Select <Product>
When Filter <Brand>, <colors>, <priceRange> and <Discount>
Then Select <mensproductName> and <mensSize> click on add to bag 
Examples:
|Product|					|Brand|			|colors|		|priceRange|		|Discount|		|mensproductName|				|mensSize|
|T-Shirts & Polo Shirts|	|Blue Saint|	|Blue|			|Rs.401 - 550|		|30% - 39%|		|Solid Crew Neck T-shirt|		|M|
|Trousers & Chinos|			|KOOVS|			||				||					|20% - 29%|		|Tapered Casual Trousers|		|32|