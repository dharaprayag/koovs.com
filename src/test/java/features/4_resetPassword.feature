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



















#4.1			Verify click on Login link an get page title
#4.2			verify in sign up page company logo should be clickable and its landed to home page
#4.3			verify in sign up page LOGIN link should be clickable and landed to login page
#4.4			verify in sign up page, WISHLIST icon should be clickable and landed to login page with error message
#4.5			verify in sign up page, BAG icon should be clickable and landed to login page with error message
#4.6			verify in sign up page MEN link should be clickable and landed into its relevant page
#4.7			verify in sign up page WOMEN link should be clickable and landed into its relevant page
#4.8			verify in sign up page CAMPAIGNS link should be clickable and landed into its relevant page
#4.9			verify in sign up page KOOVSXYOU link should be clickable and landed into its relevant page
#4.10 		verify in sign up page IN STYLE OF link should be clickable and landed into its relevant page
#4.11		verify user should be able to enter input and click on search icon
#4.12		verify user should be able to click search icon without any input and pop up should be open
#4.13		Enter valid email id (dharapatel80085@gmail.com) and then click on reset password button
#4.14		Enter wrong email (dhara@gmail.com) and then click on reset password button
#4.15		Enter wrong email with special char (****dhar800@gmai.cmo) and  then click on reset password button
#4.16		Enter email with numeric char (123456@gmail.com) and then click on reset password button










