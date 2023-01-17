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
Feature: Delete request

@DeleteByProgramName
Scenario Outline: Deleted Request by Program Name
    Given Call "baseurl" /deletebyprogname/programname
    When Program name from given sheetname "<SheetName>" and rownumber <RowNumber> and DELETE request is sent
    Then Status Code should be200 OK
    
  Examples: 
      | SheetName          | RowNumber |
      | DELETE_PROGRAMNAME |         0 |
      | DELETE_PROGRAMNAME |         1 |
      | DELETE_PROGRAMNAME |         2 |

