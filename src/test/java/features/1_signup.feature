Feature: Sign up functionality

#@getTitleSrNo.1
#Scenario: Get website title
#Given Initialize browser
#Then Get text of website Title
#
#
#@signupFunctionalitySrNo.2.1
#Scenario: Click on Signup link and get title
#Given Initialize browser for click on signup link and get title
#When Click on sign up link
#Then Get title of sign up page
#
#
#@signupFunctionalitySrNo.2.2
#Scenario: Click on Signup link and then click on company logo and get title
#Given Initialize browser and click on signup link for get homepage title
#When Click on company logo
#Then Get title of homepage
#
#
#@signupFunctionalitySrNo.2.3
#Scenario: Click on Signup link and then click on Login link and get title
#Given Initialize browser and click on signup link for login link title
#When Click on Login link
#Then Get title of Login page
#
#
#@signupFunctionalitySrNo.2.4
#Scenario: Click on Signup link and then click on wishlist icon and get error message
#Given Initialize browser and click on signup link for click on wishlist icon and get error message
#When Click on wishlist icon
##Then Get error message
#
#
#@signupFunctionalitySrNo.2.5
#Scenario: Click on Signup link and then click on bag icon and get error message
#Given Initialize browser and click on signup link for click on bag icon and get error message
#When Click on bag icon
#Then Get bag error message

@signupFunctionalitySrNo.2.6
Scenario: Click on Signup link and then click on Men link and landed it on mens section
Given Initialize browser and click on signup link
When click on Men link
Then Landed in Mens section

@signupFunctionalitySrNo.2.7
Scenario: Click on Signup link and then click on women link and landed it on women section
Given Initialize browser for click on women link and click on signup link
When click on women link
Then Landed in women section

@signupFunctionalitySrNo.2.8
Scenario: Click on Signup link and then click on THE BLOG link
Given Initialize browser for click on THE BLOG link and click on signup link
When click on THE BLOG
Then Landed on Blog page

@signupFunctionalitySrNo.2.9
Scenario: Click on Signup link and then click on KOOVSXYOU link
Given Initialize browser for click on KOOVSXYOU link and click on signup link
When click on KOOVSXYOU
Then Landed on KOOVSXYOU page

@signupFunctionalitySrNo.2.10
Scenario: Click on Signup link and then click on IN STYLE OF link
Given Initialize browser for click on IN STYLE OF link and click on signup link
When click on IN STYLE OF
Then Landed on IN STYLE OF page














