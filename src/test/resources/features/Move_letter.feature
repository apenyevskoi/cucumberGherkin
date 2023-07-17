@move_letter
  Feature: Move letter

    Scenario Outline: Move letter from Sent to Trash bin
      Given log in user's mail service with "<username>", and "<password>"
      When user move first sent letter to Trash
      Then user open Trash Page and check letter have been moved
      And user logout
    Examples:
    |username                   |password         |
    |mail@yandex.ru             |password         |