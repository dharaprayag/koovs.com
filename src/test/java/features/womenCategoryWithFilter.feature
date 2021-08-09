#Feature: Select filtered product from women's section
#
#@womenScenarioWithFilter
#Scenario Outline: Select Sports & Active Wear,Skirts and Bags & Purses
#Given Selection <womenFilterProduct> from women Category
#When Product's filter <womenFilterBrand>, <womenFilterColors>, <womenFilterPriceRange>
#Then <womenFilterDiscount>, <womenFilterproductName> and <womenFilterSize> and then product added into cart
#Examples:
#|womenFilterProduct|		|womenFilterBrand|			|womenFilterColors|		|womenFilterPriceRange|		|womenFilterDiscount|		|womenFilterproductName|				|womenFilterSize|
#|Sports & Active Wear|		|ONE/ZERO BY KOOVS|			||						|Rs.801 - 950|				|40% - 49%|					|Athleisure Reflective Logo Jacket|		|M|
#|Skirts|					|D'BASIC|					||						|Rs.250 - 300|				|70% - 79%|					|Casual Skater Mini Skirt|				|M|
#|Bags & Purses|				|DIWAAH|					||						|Rs.801 - 1000|				|60% - 69%|					|Overdyed Patch Logo Print Backpack |	||