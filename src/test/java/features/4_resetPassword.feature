Feature: Reset Password link

@ResetPasswordScenario4.1
Scenario Outline: Verify click on Login link and then click on Reset Password Link
Given Initialize browser with chrome browser
When click on login link redirect to login page
Then Click on Reset Password Link and redirect to forgot password page<pageTitle>
Examples:
|pageTitle|
|forgot password|

@ResetPasswordScenario4.2
Scenario Outline: verify in Login page company logo should be clickable and its landed to home page
Given Click on Login link then click on Reset Password link
When Click on company logo from forgot password page
Then Get homepage title from forgot password page <resetPasswordHomePageTitle>
Examples:
|resetPasswordHomePageTitle|
|online shopping|

@ResetPasswordScenario4.3
Scenario Outline: verify in sign up page LOGIN link should be clickable and landed to login page
Then Again click on Login link <resetPasswordLoginpageTitle>
Examples:
|resetPasswordLoginpageTitle|
|login customer|

@ResetPasswordScenario4.4
Scenario Outline: verify in sign up page, WISHLIST icon should be clickable and landed to login page with error message
Then Click on Wishlist Icon <resetPasswordWishlistErrorMsg>
Examples:
|resetPasswordWishlistErrorMsg|
|sign in to access your orders, wishlist|

@ResetPasswordScenario4.5
Scenario Outline: verify in sign up page, BAG icon should be clickable and landed to login page with error message
Then Click on BAG icon <resetPasswordBagErrorMsg>
Examples:
|resetPasswordBagErrorMsg|
|sign in to access your orders, wishlist|

@ResetPasswordScenario4.6
Scenario Outline: verify in sign up page MEN link should be clickable and landed into its relevant page
Then Click on Men link <menTitlePage>
Examples:
|menTitlePage|
|online shopping for men|

@ResetPasswordScenario4.7
Scenario Outline: verify in sign up page WOMEN link should be clickable and landed into its relevant page
Then Click on Women link <womenTitlePage>
Examples:
|womenTitlePage|
|online shopping for women|

@ResetPasswordScenario4.8
Scenario Outline: verify in sign up page CAMPAIGNS link should be clickable and landed into its relevant page
Then Click on THE BLOG link <blogTitlePage>
Examples:
|blogTitlePage|
|latest fashion trends, styles and news online|

@ResetPasswordScenario4.9
Scenario Outline: verify in sign up page KOOVSXYOU link should be clickable and landed into its relevant page
Then Click on KOOVSXYOU link <koovsxyouTitlePage>
Examples:
|koovsxyouTitlePage|
|koovsxyou|

@ResetPasswordScenario4.10
Scenario Outline: verify in sign up page IN STYLE OF link should be clickable and landed into its relevant page
Then Click on IN STYLE OF link <instyleofTitlePage>
Examples:
|instyleofTitlePage|
|online fashion shopping|

@ResetPasswordScenario4.11
Scenario Outline: verify user should be able to enter input and click on search icon
Then Enter input and click on search icon and get searched page <search> <searchedPage>
Examples:
|search|			|searchedPage|
|jeans|				|buy jeans online in india|

@ResetPasswordScenario4.12
Scenario Outline: verify user should be able to click search icon without any input and pop up should be open
Then click on search icon without an enter value and open a pop up and get text <popupText>
Examples:
|popupText|
|trending searches|

@ResetPasswordScenario4.13
Scenario Outline: Enter valid email id (dharapatel80085@gmail.com) and then click on reset password button
Then Enter a valid email id and click on reset password button and get text <validEmail> <emailTextMsg>
Examples:
|validEmail|												|emailTextMsg|
|dharapatel80085@gmail.com|									|your password request has been successfully registered. please check your mail|

@ResetPasswordScenario4.14
Scenario Outline: Enter wrong email (dharagmail.com) and then click on reset password button
Then Enter an invalid email and click on reset password button and get text <invalidEmail> <emailErrorMsg>
Examples:
|invalidEmail|								|emailErrorMsg|
|dharagmail.com|							|please enter valid email|

@ResetPasswordScenario4.15
Scenario Outline: Enter wrong email with special char (****@gmai.cmo) and  then click on reset password button
Then enter an incorrect email id with special character <incorrectEmail> <errorMsg>
Examples:
|incorrectEmail|				|errorMsg|
|****@gmail.com|				|invalid email id|

@ResetPasswordScenario4.16
Scenario Outline: Enter email with numeric char (123456@gmail.com) and then click on reset password button
Then Enter a numeric char email id then click on reset password button and get text <numericEmail> <numericEmailErrorMsg>
Examples:
|numericEmail|							|numericEmailErrorMsg|
|123456@gmail.com|						|your password request has been successfully registered. please check your mail|






















