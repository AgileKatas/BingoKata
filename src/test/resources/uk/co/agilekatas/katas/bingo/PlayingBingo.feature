Feature: Playing Bingo

  Scenario Outline: Generating Bingo Cards
    Given I have a Bingo card generator
    When I generate a Bingo card
    Then the generated card has 25 unique spaces
    And the generated card has a FREE space in the middle
    And column "<Column>" only contains numbers between "<Lower Bound>" and "<Upper Bound>" inclusive

    Examples:
      | Column | Lower Bound | Upper Bound |
      | B      | 1           | 15          |
      | I      | 16          | 30          |
      | N      | 31          | 45          |
      | G      | 46          | 60          |
      | O      | 61          | 75          |

  Scenario: Calling Bingo Numbers
    Given I have a Bingo caller
    When I call a number
    Then the number is between 1 and 75 inclusive

    Given I have a Bingo caller
    When I call a number 75 times
    Then all numbers between 1 and 75 are present
    And no number has been called more than once
