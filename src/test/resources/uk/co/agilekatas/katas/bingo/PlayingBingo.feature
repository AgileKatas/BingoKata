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
