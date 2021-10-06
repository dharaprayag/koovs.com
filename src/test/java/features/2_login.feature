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













