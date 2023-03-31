
  Feature: Dijidemi Login Page UI Test

    @login
    Scenario: User should not login with invalid credentials
      Given user goes to dijidemi url
      When user should not login with invalid credentials



    @selectContent
    Scenario: User should be click on a spesific tab and then select a random content after successfully login to the platform
      Given user goes to dijidemi url
      When user should be login with valid credentials
      And user clicks on icerik tab and validates that is navigated icerikler
      Then user clicks on the 1 st content and validates that it is loaded



