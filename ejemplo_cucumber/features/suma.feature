Feature: suma entera
As a user 
I want to sum some values
So I can get de total of sum

Scenario Outline: suma
    Given a <value1> and <value2> to sum
    When the calc sum the values
    Then the <total> of sum is ok

    Examples:
        | value1 | value2 | total |
        | 1      | 2      | 3     |
        | 15     | 12     | 17    |
        | 12     | 15     | 17    |