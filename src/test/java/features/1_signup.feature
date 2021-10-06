Feature: Sign up functionality

#@getTitleSrNo.1
#Scenario: Get website title
#Given Initialize browser
#Then Get text of website Title
#
#@signupFunctionalitySrNo.2.1
#Scenario Outline: Click on Signup link and get title
#Given Initialize browser for click on signup link and get title
#When Click on sign up link
#Then Get title of sign up page <expectedSignupTitle>
#Examples:
#|expectedSignupTitle|
#|signup|
#
#@signupFunctionalitySrNo.2.2
#Scenario Outline: Click on Signup link and then click on company logo and get title
#Given Initialize browser and click on signup link for get homepage title
#When Click on company logo
#Then Get title of homepage <expectedHomepageTitle>
#Examples:
#|expectedHomepageTitle|
#|online shopping|
#
#@signupFunctionalitySrNo.2.3
#Scenario Outline: Click on Signup link and then click on Login link and get title
#Given Initialize browser and click on signup link for login link title
#When Click on Login link
#Then Get title of Login page <expectedLoginTitle>
#Examples:
#|expectedLoginTitle|
#|login|
#
#@signupFunctionalitySrNo.2.4
#Scenario Outline: Click on Signup link and then click on wishlist icon and get error message
#Given Initialize browser and click on signup link for click on wishlist icon and get error message
#When Click on wishlist icon
#Then Get error message <getErrorMsg>
#Examples:
#|getErrorMsg|
#|sign in to access your orders|
#
#@signupFunctionalitySrNo.2.5
#Scenario Outline: Click on Signup link and then click on bag icon and get error message
#Given Initialize browser and click on signup link for click on bag icon and get error message
#When Click on bag icon
#Then Get bag error message <getErrorMsgForBag>
#Examples:
#|getErrorMsgForBag|
#|sign in to access your orders|
#
#@signupFunctionalitySrNo.2.6
#Scenario Outline: Click on Signup link and then click on Men link and landed it on mens section
#Given Initialize browser and click on signup link
#When click on Men link
#Then Landed in Mens section <getMenTitle>
#Examples:
#|getMenTitle|
#|online shopping for men|
#
#@signupFunctionalitySrNo.2.7
#Scenario Outline: Click on Signup link and then click on women link and landed it on women section
#Given Initialize browser for click on women link and click on signup link
#When click on women link
#Then Landed in women section <getWomenTitle>
#Examples:
#|getWomenTitle|
#|online shopping for women|
#
#@signupFunctionalitySrNo.2.8
#Scenario Outline: Click on Signup link and then click on THE BLOG link
#Given Initialize browser for click on THE BLOG link and click on signup link
#When click on THE BLOG
#Then Landed on Blog page <getBlogPgaeTitle>
#Examples:
#|getBlogPgaeTitle|
#|latest fashion trends|
#
#@signupFunctionalitySrNo.2.9
#Scenario Outline: Click on Signup link and then click on KOOVSXYOU link
#Given Initialize browser for click on KOOVSXYOU link and click on signup link
#When click on KOOVSXYOU
#Then Landed on KOOVSXYOU page <getKoovsxyouPageTitle>
#Examples:
#|getKoovsxyouPageTitle|
#|koovsxyou|
#
#@signupFunctionalitySrNo.2.10
#Scenario Outline: Click on Signup link and then click on IN STYLE OF link
#Given Initialize browser for click on IN STYLE OF link and click on signup link
#When click on IN STYLE OF
#Then Landed on IN STYLE OF page <getInStyleOfPageTitle>
#Examples:
#|getInStyleOfPageTitle|
#|fashion|
#
#@signupFunctionalitySrNo.2.11
#Scenario Outline: Enter an input in search field and then click on search icon
#Given Initialize browser and then click on signup link for enter a value in search field
#When click on Search icon with input <searchInput>
#Then landed on page which is based on search input and get text <searchedPageTitle>
#Examples:
#|searchInput|		|searchedPageTitle|
#|Dresses|			|for women & men|
#
#@signupFunctionalitySrNo.2.12
#Scenario Outline: Click on Search icon
#Given Initialize browser for click on Search icon and click on signup link
#When click on Search icon
#Then Open a pop up and get text <expectedText>
#Examples:
#|expectedText|
#|trending searches|

@signupFunctionalitySrNo.2.13To2.24
Scenario Outline: Verify Signup form
Given Initialize browser and click on signuplink
Given functionality serial number <srNo> and <scenario>
When Input of FullName <name>
When Enter an input of Email <email>
When Enter an input of Password <password>
When Input of MobileNumber <number>
When Click male or female radio button <maleOrFemale>
#When Click on checkbox
Then Click on SIGNUP button

Examples:
|srNo|									|scenario|																	|name|				|email|							|password|					|number|			|maleOrFemale|
|SignupFunctionalitySrNo.2.13|			|verify signup with valid credentials|										|Dhara Patel|		|dharapatel|					|Dharapatel80085@|			|0|					|Male|
|SignupFunctionalitySrNo.2.14|			|verify signup with invalid full name and another credentials valid|		|abcdefg|			|dharapatel|					|Dharapatel80085@|			|0|					|Female|
|SignupFunctionalitySrNo.2.15|			|Sign up with invalid Email and another credentials are valid|				|Dhara Patel|		|*****|							|Dharapatel80085@|			|0|					|Male|
|SignupFunctionalitySrNo.2.16|			|Sign up with invalid password and another credentials are valid|			|Dhara Patel|		|dharapatel|					|******|					|0|					|Female|
|SignupFunctionalitySrNo.2.17|			|Sign up with invalid Mobile number and another credentials are valid|		|Dhara Patel|		|dharapatel|					|Dharapatel80085@|			|****|				|Male|
|SignupFunctionalitySrNo.2.18|			|verify signup with all invalid credentials|								|12345|				|******|						|******|					|****|				|blank|
|SignupFunctionalitySrNo.2.19|			|Sign up with full name field blank and another credentials are valid|		|blank|				|dharapatel|					|Dharapatel80085@|			|0|					|Female|
|SignupFunctionalitySrNo.2.20|			|Sign up with Email field blank and another credentials are valid|			|Dhara Patel|		|blank|							|Dharapatel80085@|			|0|					|Male|
|SignupFunctionalitySrNo.2.21|			|Sign up with Password field blank and another credentials are valid|		|Dhara Patel|		|dharapatel|					|blank|						|0|					|Female|
|SignupFunctionalitySrNo.2.22|			|Sign up with Mobile number field blank and another credentials are valid|	|Dhara Patel|		|dharapatel|					|Dharapatel80085@|			|blank|				|Male|
|SignupFunctionalitySrNo.2.23|			|Sign up with Gender field blank and another credentials are valid|			|Dhara Patel|		|dharapatel|					|Dharapatel80085@|			|0|					|blank|
|SignupFunctionalitySrNo.2.24|			|Leave blank all the field|													|blank|				|blank|							|blank|						|blank|				|blank|

