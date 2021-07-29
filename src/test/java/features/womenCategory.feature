Feature: select product from men's section

@womenScenario
Scenario Outline: Select a top, Dress, JumpSuit, Oxolloxo and winter essential
Given Select <topName>, <dressName>, <jumpSuit>, <oxolloxo> and <winterEssential> mousehover on image, Select size and click on add to bag
When MouseHover On cart
Then Verify number of items added into cart and badge digit are equal
Examples:
|topName|					|dressName|		|jumpSuit|		|Oxolloxo|		|winterEssential|
|Printed Sleeveless Top|	||