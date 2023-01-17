#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Update Program details by Name without header

  Scenario Outline: Update Program By Program Name without header intialization
    Given Call "baseurl" /program/(programName)
    When  Update Program details with Program Name from given sheetname "<SheetName>" and rownumber <RowNumber> and PUT request is sent
    Then Status Code should be415 unsupported media type
    And Validate  the updated programName
    
    Examples: 
      | SheetName        | RowNumber |
      | PUT_PROGRAMNAME  |         0 |
      | PUT_PROGRAMNAME  |         1 |

