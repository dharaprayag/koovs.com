Feature: Sign up functionality

@getTitleSrNo.1
Scenario: Get website title
Given Initialize browser
Then Get text of website Title


@signupFunctionalitySrNo.2.1
Scenario Outline: Click on Signup link and get title
Given Initialize browser for click on signup link and get title
When Click on sign up link
Then Get title of sign up page <expectedSignupTitle>
Examples:
|expectedSignupTitle|
|signup|


@signupFunctionalitySrNo.2.2
Scenario Outline: Click on Signup link and then click on company logo and get title
Given Initialize browser and click on signup link for get homepage title
When Click on company logo
Then Get title of homepage <expectedHomepageTitle>
Examples:
|expectedSignupTitle|
|online shopping|

@signupFunctionalitySrNo.2.3
Scenario Outline: Click on Signup link and then click on Login link and get title
Given Initialize browser and click on signup link for login link title
When Click on Login link
Then Get title of Login page <expectedLoginTitle>
Examples:
|expectedSignupTitle|
|login|


@signupFunctionalitySrNo.2.4
Scenario Outline: Click on Signup link and then click on wishlist icon and get error message
Given Initialize browser and click on signup link for click on wishlist icon and get error message
When Click on wishlist icon
Then Get error message <getErrorMsg>
Examples:
|expectedSignupTitle|
|sign in to access your orders|


@signupFunctionalitySrNo.2.5
Scenario Outline: Click on Signup link and then click on bag icon and get error message
Given Initialize browser and click on signup link for click on bag icon and get error message
When Click on bag icon
Then Get bag error message <getErrorMsgForBag>
Examples:
|getErrorMsgForBag|
|sign in to access your orders|

@signupFunctionalitySrNo.2.6
Scenario Outline: Click on Signup link and then click on Men link and landed it on mens section
Given Initialize browser and click on signup link
When click on Men link
Then Landed in Mens section <getMenTitle>
Examples:
|getMenTitle|
|online shopping for men|

@signupFunctionalitySrNo.2.7
Scenario Outline: Click on Signup link and then click on women link and landed it on women section
Given Initialize browser for click on women link and click on signup link
When click on women link
Then Landed in women section <getWomenTitle>
Examples:
|getWomenTitle|
|online shopping for women|

@signupFunctionalitySrNo.2.8
Scenario Outline: Click on Signup link and then click on CAMPAIGNS link
Given Initialize browser for click on CAMPAIGNS link and click on signup link
When click on CAMPAIGNS
Then Landed on CAMPAIGNS page <getCampaigns>
Examples:
|getCampaigns|
|koovs|

@signupFunctionalitySrNo.2.9
Scenario Outline: Click on Signup link and then click on THE EDIT link
Given Initialize browser for click on THE EDIT link and click on signup link
When click on THE EDIT
Then Landed on THE EDIT page <getTheEditPageTitle>
Examples:
|getTheEditPageTitle|
|fashion|

@signupFunctionalitySrNo.2.10
Scenario Outline: Enter input and click on search icon
Given Initialize browser for click on Signuplink link
When enter input in Search field <productSearch> and click on search icon
Then Landed on page whatever enter in search field <getTitleBasedOnSearch>
Examples:
|productSearch|				|getTitleBasedOnSearch|
|Dresses|					|shopping site in india|

@signupFunctionalitySrNo.2.11
Scenario Outline: Click on Search icon
Given Initialize browser for click on Search icon and click on signup link
When click on Search icon
Then Open a pop up and get text <expectedText>
Examples:
|expectedText|
|trending searches|













