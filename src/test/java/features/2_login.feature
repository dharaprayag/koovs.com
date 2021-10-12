Feature: Login into Application

@Login
Scenario: Positive scenario
Given Initialize browser with chrome and navigate to site
When click on login link and Fill up Email and Password and click on log in button
Then Landed into home page

@signinfunctionality3.1
Scenario Outline: Verify Login link should be clickable and its redirect to login page
Given Initialize browser for click on login link and get title <websiteTitle>
When Click on login link from homepage
Then Get text of login page title <loginpageTitle>
Examples:
|websiteTitle|		|loginPageTitle|
|koovs|				|login|

@signinfunctionality3.2
Scenario Outline: verify in Login page company logo should be clickable and its landed to home page
Given Initialize browser and click on login link then click on company logo
When Click on company logo to verify from login page
Then Get text of homepage title <loginHomepageTitle>
Examples:
|loginHomepageTitle|
|koovs|

@signinfunctionality3.3
Scenario Outline: Verify in Login page LOGIN link should be clickable and landed to login page
Given Initialize browser and click on login link then click on again login link
When Again click on login link to verify from login page
Then Get text of login title <loginLoginTitle>
Examples:
|loginLoginTitle|
|login|

@signinfunctionality3.4
Scenario Outline: verify in Login page, WISHLIST icon should be clickable and landed to login page with error message
Given Initialize browser and click on login link for click on wishlist icon
When Click on Wishlist icon from login link
Then Get Text of login error message <loginErrorMsg>
Examples:
|loginErrorMsg|
|sign in to access your orders|

@signinfunctionality3.5
Scenario Outline: Verify in Login page, BAG icon should be clickable and landed to login page with error message
Given Initialize browser and click on login link for click on BAG icon
When click on BAG icon from login link
Then Get Text of BAG error message from login <loginBagErrorMsg>
Examples:
|loginBagErrorMsg|
|sign in to access your orders|

@signinfunctionality3.6
Scenario Outline: verify in Login page MEN link should be clickable and landed into its relevant page
Given Initialize browser and click on login link for click on MEN link
When Click on MEN link from login page
Then Get text of Men's title <loginMenTitle>
Examples:
|loginMenTitle|
|online shopping for men|

@signinfunctionality3.7
Scenario Outline: verify in Login page WOMEN link should be clickable and landed into its relevant page
Given Initialize browser and click on login link for click on WOMEN link
When Click on WOMEN link from login page
Then Get text of Women's title <loginWomenTitle>
Examples:
|loginWomenTitle|
|online shopping for women|

#@signinfunctionality3.8
#Scenario Outline: verify in Login page CAMPAIGNS link should be clickable and landed into its relevant page
#Given Initialize browser and click on login link for click on CAMPAIGNS link
#When Click on CAMPAIGNS link from login page
#Then Get text of campaigns title <loginCampaignsTitle>
#Examples:
#|loginCampaignsTitle|
#|campaigns|

@signinfunctionality3.9
Scenario Outline: verify in Login page KOOVSXYOU link should be clickable and landed into its relevant page
Given Initialize browser and click on login link for click on KOOVSXYOU link
When Click on KOOVSXYOU link from login page
Then Get text of KOOVSXYOU's title <loginKoovsxyouTitle>
Examples:
|loginKoovsxyouTitle|
|koovsxyou|

@signinfunctionality3.10
Scenario Outline: verify in Login page THE EDIT link should be clickable and landed into its relevant page
Given Initialize browser and click on login link for click on KOOVSXYOU link
When Click on KOOVSXYOU link from login page
Then Get text of KOOVSXYOU's title <loginKoovsxyouTitle>
Examples:
|loginKoovsxyouTitle|
|koovsxyou|








































