Feature: Testing for basic validation when adding new books

  Scenario Outline: Providing invalid input data for new books

    Given an empty library

    When a librarian adds a book with "<title>", "<author>", <edition>, "<year>", "<isbn>" and "<description>"

    Then the page contains error message for field "<field>"
    And The library contains no books

    Examples:

      | isbn       | author          | title    | edition | year | description                                                                                                                                                                                                                                                      | field       |
      | 0XXXXXXXX5 | Terry Pratchett | Sourcery | 1       | 1989 | Es war einmal...                                                                                                                                                                                                                                                 | isbn        |
      | 0552131075 | Terry Pratchett | Sourcery | 1       | 1    | Es war einmal...                                                                                                                                                                                                                                                 | year        |
      | 0552131075 | Terry Pratchett | Sourcery | 1       | 1989 | Es war einmal...Es war einmal...Es war einmal...Es war einmal...Es war einmal...Es war einmal...Es war einmal...Es war einmal...Es war einmal...Es war einmal...Es war einmal...Es war einmal...Es war einmal...Es war einmal...Es war einmal...Es war einmal... | description |

