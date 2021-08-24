Feature: select product from women's section

@womenScenario
Scenario Outline: Select a top, Dress, Sports & Active Wear, Skirts and Bags & Purses

Given Women product <product>
When A women item <productName>
Then Click on women product then add to bag <size>
Examples:
|product|					|productName|									|size|
|Tops|						|Black Magic Party Foil Print Crop Top|			|M|
|Dresses|					|Ruffled Mesh Overlay Skater Dress|				|XL|

@womenScenarioWithFilter
Scenario Outline: Select Sports & Active Wear,Skirts and Bags & Purses
Given Selection <womenFilterProduct> from women Category
When Product's filter <womenFilterBrand>, <womenFilterPriceRange>
Then <womenFilterDiscount>, <womenFilterproductName> and <womenFilterSize> and then product added into cart
Examples:
|womenFilterProduct|		|womenFilterBrand|			|womenFilterPriceRange|		|womenFilterDiscount|		|womenFilterproductName|				|womenFilterSize|
|Sports & Active Wear|		|ONE/ZERO BY KOOVS|			|Rs.651 - 750|				|40% - 49%|					|Racerback Padded Sports Bra|			|M|
|Skirts|					|D'BASIC|					|Rs.251 - 300|				|70% - 79%|					|Pleated Midi Skirt|					|M|
|Shorts|					|Oxolloxo|					|Rs.851 - 950|				|30% - 39%|					|Belted Regular Shorts|					|L|