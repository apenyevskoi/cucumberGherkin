@write_letter
Feature: Write letter

  Scenario Outline: Write letter in yandex mail
    Given user login to url, with "<username>", and "<password>"
    When user send letter to "mail@yandex.ru"
    Then letter should have been sent
    And user logout
  Examples:
    |username                   |password         |
    |mail@yandex.ru             |password         |