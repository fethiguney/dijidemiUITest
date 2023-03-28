
  Feature: Dijidemi Login Page UI Test

    @loginpage
    Scenario: User should be click on a spesific tab and then select a random content after successfully login to the platform
      Given user goes to dijidemi url
      When user should be login successfully with valid credentials
      And user clicks on icerik tab and validates that is navigated icerikler
      Then user clicks on the 1 st content and validates that it is loaded
