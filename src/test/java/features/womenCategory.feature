Feature: select product from women's section

@womenScenario
Scenario Outline: Select a top, Dress, JumpSuit, Oxolloxo and winter essential
Given Select <product> and <productName> and <size> click on add to bag
When MouseHover On cart
Then Verify number of items added into cart and badge digit are equal
Examples:
|product|					|productName|						|size|
|Tops|						|V-Neck Tribal Print Blouse|		|M|
|Dresses|					|Solid Casual Shift Dress|			|L|