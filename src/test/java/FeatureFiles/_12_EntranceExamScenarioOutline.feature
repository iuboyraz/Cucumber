#Senaryo :
#  Bir �nceki Entrance Exams Giri� Senaryosunu
#  A�a��daki de�erler i�in �al��t�r�n�z.
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
      | nameInput | <ExamName> |

    And Click on the element in the DialogContent
      | academicPeriod |

    And Click on the element in the DialogContent
      #| academicPeriod1 |
      | <AcademicPeriodOption> |

    And Click on the element in the DialogContent
      | gradeLevel |

    And Click on the element in the DialogContent
      #| gradeLevel2     |
      | <GradeLevelOption> |

    And Click on the element in the DialogContent
      | saveButton |

    Then Success message should be displayed

    # Silme ekran�na ula�mak i�in tekrar navigate yap�ld�
    And Click on the element in the LeftNav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And Click on the element in the DialogContent
      | searchAcademicPeriod |
      | academicPeriod1      |

    And User deletes the element from the DialogBox
      | <ExamName> |

    Then Success message should be displayed
    Examples:
      | ExamName        | AcademicPeriodOption | GradeLevelOption |
      | Math exam is1   | academicPeriod1      | gradeLevel2      |
      | IT exam is1     | academicPeriod1      | gradeLevel2      |
      | Oracle exam is1 | academicPeriod1      | gradeLevel2      |
      | Math exam is2   | academicPeriod1      | gradeLevel2      |

