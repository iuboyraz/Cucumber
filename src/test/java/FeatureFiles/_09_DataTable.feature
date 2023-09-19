Feature: DataTable Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Create a country
    And Click on the element in the LeftNav
      | setup      |
      | parameters |
      | countries  |

    And Click on the element in the DialogContent
      | addButton |

    And User sends the keys into the DialogBox
      | nameInput | cabbarUlk59 |
      | codeInput | c5900       |

    And Click on the element in the DialogContent
      | saveButton |

    Then Success message should be displayed

    And User deletes the element from the DialogBox
      | cabbarUlk59 |

    Then Success message should be displayed

  Scenario: Create a Nationality
    And Click on the element in the LeftNav
  | setup      |
  | parameters |
  | nationalities  |

    And Click on the element in the DialogContent
      | addButton |

    And User sends the keys into the DialogBox
      | nameInput | cabbarNation59 |

    And Click on the element in the DialogContent
      | saveButton |

    Then Success message should be displayed

    And User deletes the element from the DialogBox
      | cabbarNation59 |

    Then Success message should be displayed

  Scenario: Fees Functionality
    And Click on the element in the LeftNav
      | setup      |
      | parameters |
      | fees  |

    And Click on the element in the DialogContent
      | addButton |

    And User sends the keys into the DialogBox
      | nameInput       | Ali Cabbar fee1 |
      | codeInput       | cabbar59 |
      | integrationCode | acb59 |
      | priorityCode    | 1111 |

    And Click on the element in the DialogContent
      | toggleBar |
      | saveButton |

    Then Success message should be displayed

    And User deletes the element from the DialogBox
      | Ali Cabbar fee1 |

    Then Success message should be displayed