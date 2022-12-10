Feature: GetBooksFeature
  Scenario: Get all saved books from Book endpoint
    When The user sends a request to Book endpoint
    Then A list of saved books is displayed