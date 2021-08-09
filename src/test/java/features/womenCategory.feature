Feature: select product from women's section

@womenScenario
Scenario Outline: Select a top, Dress, JumpSuit, Oxolloxo and winter essential
Given <product> and <productName> and <size> click on add to bag
When MouseHover on cart and Verify number of items added into cart and badge digit are equal
Then Clear cart
Examples:
|product|					|productName|						|size|
|Tops|						|Asymmetric Hem V-Neck Top|			|M|
|Dresses|					|Cold Shoulder Casual Dress|		|XL|

@womenScenarioWithFilter
Scenario Outline: Select Sports & Active Wear,Skirts and Bags & Purses
Given Selection <womenFilterProduct> from women Category
When Product's filter <womenFilterBrand>, <womenFilterColors>, <womenFilterPriceRange>
Then <womenFilterDiscount>, <womenFilterproductName> and <womenFilterSize> and then product added into cart
Examples:
|womenFilterProduct|		|womenFilterBrand|			|womenFilterColors|		|womenFilterPriceRange|		|womenFilterDiscount|		|womenFilterproductName|				|womenFilterSize|
|Sports & Active Wear|		|ONE/ZERO BY KOOVS|			||						|Rs.801 - 950|				|40% - 49%|					|Athleisure Reflective Logo Jacket|		|M|
|Skirts|					|D'BASIC|					||						|Rs.251 - 300|				|70% - 79%|					|Casual Skater Mini Skirt|				|M|
|Bags & Purses|				|DIWAAH|					||						|Rs.851 - 1000|				|60% - 69%|					|Overdyed Patch Logo Print Backpack |	||