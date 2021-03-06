Feature: Login into Application

#@Login
#Scenario: Positive scenario
#Given Initialize browser with chrome and navigate to site
#When click on login link and Fill up Email and Password and click on log in button
#Then Landed into home page

#@loginfunctionality3.1
#Scenario Outline: Verify Login link should be clickable and its redirect to login page
#Given Initialize browser for click on login link and get title <websiteTitle>
#When Click on login link from homepage
#Then Get text of login page title <loginpageTitle>
#Examples:
#|websiteTitle|		|loginpageTitle|
#|koovs|				|login|
#
#@loginfunctionality3.2
#Scenario Outline: verify in Login page company logo should be clickable and its landed to home page
#Given Login click on company logo
#When Click on company logo to verify from login page
#Then Get text of homepage title <loginHomepageTitle>
#Examples:
#|loginHomepageTitle|
#|koovs|
#
#@loginfunctionality3.3
#Scenario Outline: Verify in Login page LOGIN link should be clickable and landed to login page
#Given Login click on again login link
#When Again click on login link to verify from login page
#Then Get text of login title <loginLoginTitle>
#Examples:
#|loginLoginTitle|
#|login|
#
#@loginfunctionality3.4
#Scenario Outline: verify in Login page, WISHLIST icon should be clickable and landed to login page with error message
#Given Login click on wishlist icon
#When Click on Wishlist icon from login link
#Then Get Text of login error message <loginErrorMsg>
#Examples:
#|loginErrorMsg|
#|sign in to access your orders|
#
#@loginfunctionality3.5
#Scenario Outline: Verify in Login page, BAG icon should be clickable and landed to login page with error message
#Given Login click on BAG icon
#When click on BAG icon from login link
#Then Get Text of BAG error message from login <loginBagErrorMsg>
#Examples:
#|loginBagErrorMsg|
#|sign in to access your orders|

#@loginfunctionality3.6
#Scenario Outline: verify in Login page MEN link should be clickable and landed into its relevant page
#Given Initialize browser and click on login MEN link
#When Click on MEN link from login page
#Then Get text of Men's title <loginMenTitle>
#Examples:
#|loginMenTitle|
#|online shopping for men|

#@loginfunctionality3.7
#Scenario Outline: verify in Login page WOMEN link should be clickable and landed into its relevant page
#Given Initialize browser and click login link for click WOMEN link
#When Click on WOMEN link from login page
#Then Get text of Women's title <loginWomenTitle>
#Examples:
#|loginWomenTitle|
#|online shopping for women|

#@loginfunctionality3.8
#Scenario Outline: verify in Login page CAMPAIGNS link should be clickable and landed into its relevant page
#Given Initialize browser and click on login link for click on CAMPAIGNS link
#When Click on CAMPAIGNS link from login page
#Then Get text of campaigns title <loginCampaignsTitle>
#Examples:
#|loginCampaignsTitle|
#|campaigns|

#@loginfunctionality3.9
#Scenario Outline: verify in Login page KOOVSXYOU link should be clickable and landed into its relevant page
#Given Initialize browser and click on KOOVSXYOU link
#When Click on KOOVSXYOU link from login page
#Then Get text of KOOVSXYOU's title <loginKoovsxyouTitle>
#Examples:
#|loginKoovsxyouTitle|
#|koovsxyou|
#
#@loginfunctionality3.10
#Scenario Outline: verify in Login page IN STYLE OF link should be clickable and landed into its relevant page
#Given click on IN STYLE OF link
#When Click on IN STYLE OF link from login page
#Then Get text of IN STYLE OF's title <loginInstyleOfTitle>
#Examples:
#|loginInstyleOfTitle|
#|fashion|
#
#@loginfunctionality3.11
#Scenario Outline: verify user should be able to enter input and click on search icon
#Given Initialize browser and then click on login link for enter a value in search field
#When click on Search icon with enter input from login page <searchInputFromLogin>
#Then landed on page which is based on input and get text <loginSearchedPageTitle>
#Examples:
#|searchInputFromLogin|		|loginSearchedPageTitle|
#|Jeans|						|buy jeans|

#@loginFunctionality3.12
#Scenario Outline: verify user should be able to click search icon without any input and pop up should be open
#Given Initialize browser for click on Search icon from login page
#When click on Search icon from login page
#Then Get pop up and get text from login page <expectedText>
#Examples:
#|expectedText|
#|trending searches|
#
#@loginFunctionality3.13
#Scenario: verify user should be able click on Google login with Google
#Given Initialize browser for click on Google Link from login page
#Then Click on Google Link
#
#@loginFunctionality3.14
#Scenario: verify user should be able click on Google login with Google
#Given Initialize browser for click on Facebook Link from login page
#Then Click on Facebook Link
#
@loginFunctionalitySrNo.3.15To3.25
Scenario Outline: Verify Login form
Given Initialize browser and click on login link<srNo> <scenario>
When Enter an email<loginEmail>
When Enter a password<loginPassword>
When Click on SHOW or HIDE link in password field<showorhide>
Then Click on LOGIN button<loginButtonClick> <errorMsg>
Then Find error message<errorMsg>
Examples:
|srNo|									|scenario|																|loginEmail|					|loginPassword|				|showorhide|			|errorMsg|			|loginButtonClick|
#|loginFunctionalitySrNo.3.15|			|valid email and valid password which is used during sign up|			|dharapatel80085@gmail.com|		|Dharapatel80085@|			|click|					|not|			|click|
|loginFunctionalitySrNo.3.16|			|Invalid email and invalid password|									|dharapatel@gmail.com|			|dharapatel@|				|not|					|blank|			|click|
|loginFunctionalitySrNo.3.17|			|Login with both empty fields|											|blank|							|blank|						|not|					|blank|			|click|
|loginFunctionalitySrNo.3.18|			|leave blank email field and use valid password|						|blank|							|Dharapatel80085@|			|click|					|blank|			|click|
|loginFunctionalitySrNo.3.19|			|valid email and leave blank password field|							|dharapatel80085@gmail.com|		|blank|						|click|					|blank|			|click|
|loginFunctionalitySrNo.3.20|			|leave blank email and invalid password|								|blank|							|dhara@80085|				|not|					|blank|			|not|
|loginFunctionalitySrNo.3.21|			|invalid email and leave blank password|								|dhara@gmail.com|				|blank|						|click|					|blank|			|not|
|loginFunctionalitySrNo.3.22|			|Invalid (wrong) email and Valid password|								|abcd@mail|						|Dharapatel80085@|			|not|					|blank|			|not|
|loginFunctionalitySrNo.3.23|			|valid email and invalid password|										|dharapatel80085@gmail.com|		|abc|						|click|					|blank|			|click|
|loginFunctionalitySrNo.3.24|			|invalid email (use alphanumeric and special char) and valid password|	|****dhar800@gmai.cmo|			|Dharapatel80085@|			|not|					|blank|			|not|
|loginFunctionalitySrNo.3.25|			|Valid email and invalid password (use alphanumeric and special char)|	|dharapatel80085@gmail.com|		|12*abc@123|				|click|					|blank|			|click|
#

















