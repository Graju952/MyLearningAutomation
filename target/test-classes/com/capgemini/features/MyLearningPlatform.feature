Feature: My learning platform
  I want to use this template for my feature file

  Scenario: My learning platform mandatory courses validation
    Given user lands on MyLearning page "https://mylearning.capgemini.com/"
    When user clicks on view all icon
    And select Recommended from filter
    Then store Course details in excel sheet