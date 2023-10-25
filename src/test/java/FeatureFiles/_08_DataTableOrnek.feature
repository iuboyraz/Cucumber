Feature: DataTable Ornek

  Scenario: Users List
    When Write username "ismet"
    And Write username and password "ismet" and "1234"

    And Write username as DataTable
      | ismet  |
      | mehmet |
      | ayse   |
      | fatma  |
      | ali    |
      | veli   |

    And Write username and password as DataTable
      | ismet  | 1234  |
      | mehmet | 23323 |
      | ayse   | 45454 |
      | fatma  | 44545 |
