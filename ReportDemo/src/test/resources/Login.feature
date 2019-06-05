#StyoryType=WEB
#Owner=ejagruti
#CreationDate=20-12-2018
@Login
Feature: Login Feature

  Background:user is successfully logged in
  When user opens the "firefox" browser
  And user enter the url "https://www.facebook.com/"


  @WithScenarioOutline
  Scenario Outline: Test login with valid credentials
      Given user is on the application login page
      When I enter valid "<username>" and valid "<password>"
    And user clicks on login button
    Then user is on the application home page
    
    

    Examples: 
   
    
      | username             | password  |
      | kadtand@yahoo.com 	 | facebook@411 |
      | kadtand@yahoo.com 	 | mano@411 |
    
 



