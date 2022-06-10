Feature: Adding a new book to the library

  Scenario Outline: Adding various books

    Given an empty library

    When a librarian adds a random book and the "<property>" of that book is "<value>"

    Then the booklist shows that book with "<property>" as "<value>"

    Examples:
      | property    | value            |
      | title       | Sourcery         |
      | author      | Terry Pratchett  |
      | year        | 1989             |
      | isbn        | 123456789X       |
      | description | Es war einmal... |
      | isbn        | 9781566199094    |

  Scenario: Adding books with special characters

    Given an empty library

    When a librarian adds a random book and the "title" of that book is "  X  "

    Then the booklist shows that book with "title" as "  X  "


  Scenario Outline: There can be multiple copies of the same book with the same ISBN

    Given an empty library

    When a librarian adds a book with "<title>", "<author>", <edition>, "<year>", "<isbn>" and "<description>"
    And a librarian adds another book with "<title2>", "<author2>", <edition>, "<year>", "<isbn>" and "<description>"

    Then the booklist contains a book with "<title>", "<author>", "<year>", <edition>, "<isbn>" and "<description>"
    And the library contains <nr> copies of the book with "<isbn>"

    Examples:

      | title    | author          | edition | year | isbn       | author2                | title2               | nr | description      |
      | Sourcery | Terry Pratchett | 1       | 1989 | 0552131075 | Terry Pratchett        | Sourcery             | 2  | Es war einmal... |
      | Sourcery | Terry Pratchett | 1       | 1989 | 0552131075 | XX_DIFFERENT_AUTHOR_XX | Sourcery             | 1  | Es war einmal... |
      | Sourcery | Terry Pratchett | 1       | 1989 | 0552131075 | Terry Pratchett        | XX_DIFERENT_TITLE_XX | 1  | Es war einmal... |

  Scenario Outline: There cannot be multiple copies of the same ISBN and different Edition

    Given a library, containing only books with isbns "<allIsbn>"

    When a librarian adds a book with "<title>", "<author>", <edition>, "<year>", "<isbn>" and "<description>"

    Then the library contains <nr> copies of the book with "<isbn>"

    Examples:
      | allIsbn    | title        | author        | edition | year | isbn       | nr | description      |
      | 123456789X | A book title | A book author | 2       | 2013 | 123456789X | 1  | Es war einmal... |








