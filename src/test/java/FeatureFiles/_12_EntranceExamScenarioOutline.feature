#Senaryo :
#  Bir önceki Entrance Exams Giriþ Senaryosunu
#  Aþaðýdaki deðerler için çalýþtýrýnýz.
#
#| ExamName        | AcademicPeriodOption         | GradeLevelOption |
#| Math exam is1   | academicPeriod1              | gradeLevel2  |
#| IT exam is1     | academicPeriod1              | gradeLevel3  |
#| Oracle exam is1 | academicPeriod1              | gradeLevel4  |
#| Math exam is2   | academicPeriod1              | gradeLevel5  |

Feature: Creating multiple exam

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Create an Exam and Delete

    And Click on the element in the LeftNav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And Click on the element in the DialogContent
      | addButton |

    And User sends the keys into the DialogBox
      | nameInput | <name> |

    And Click on the element in the DialogContent
      | academicPeriod  |
      | academicPeriod1 |
      | gradeLevel      |
      | gradeLevel2     |

    And Click on the element in the DialogContent
      | saveButton |

    Then Success message should be displayed

    # Silme ekranýna ulaþmak için tekrar navigate yapýldý
    And Click on the element in the LeftNav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And Click on the element in the DialogContent
      | searchAcademicPeriod |
      | academicPeriod1      |

    And User deletes the element from the DialogBox
      | <name> |

    Then Success message should be displayed
    Examples:
      | name            |
      | Math exam is1   |
      | IT exam is1     |
      | Oracle exam is1 |
      | Math exam is2   |

