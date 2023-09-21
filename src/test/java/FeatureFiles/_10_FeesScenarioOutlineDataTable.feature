#Senaryo:
#  Daha önceki Fee Functionality Senaryosunu
#  name, code, intCode ve priority için 5 farklý kombinasyon için çalýþtýrýnýz.

Feature: Fees multiple values functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline:Fees Functionality

    And Click on the element in the LeftNav
      | setup      |
      | parameters |
      | fees       |

    And Click on the element in the DialogContent
      | addButton |

    And User sends the keys into the DialogBox
      | nameInput       | <name>     |
      | codeInput       | <code>     |
      | integrationCode | <intcode>  |
      | priorityCode    | <priority> |

    And Click on the element in the DialogContent
      | toggleBar  |
      | saveButton |

    Then Success message should be displayed

    And User deletes the element from the DialogBox
      | <name> |

    Then Success message should be displayed
    Examples:
      | name           | code | intcode  | priority |
      | AliCabbarFee01 | 1111 | PayPal   | 1111     |
      | AliCabbarFee02 | 1112 | Cash     | 1111     |
      | AliCabbarFee03 | 1113 | Cheque   | 1111     |
      | AliCabbarFee04 | 1114 | ApplePay | 1111     |
      | AliCabbarFee05 | 1115 | Crypto   | 1111     |