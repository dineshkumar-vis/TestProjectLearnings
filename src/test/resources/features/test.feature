Feature: parallelism

 # Background:
  #  Given open browser
   # And load URL

  Scenario Outline: Value for Selenium
    Given open browser
    And load URL
    And search for <key>
    And click search
    Examples:
      | key      |
      | Selenium |

  Scenario Outline: Value for Java
    Given open browser
    And load URL
    And search for <key>
    And click search
    Examples:
      | key      |
      | Java |