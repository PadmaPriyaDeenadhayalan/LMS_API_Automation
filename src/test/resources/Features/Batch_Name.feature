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
Feature: Get Batch by BatchName
@GetBatchByBatchName
     Scenario Outline: Get Batch by BatchName
     Given Call "url"/batches/batchName/ endpoint 
    When  Batch Name  from given sheetname "<SheetName>" and rownumber <RowNumber> and GET request is sent
    Then Receive vaid HTTP response code 200 for BATCH BY BATCH_BatchName
    And The Response should fetch the detail of that Particular Batch Name 
    

    Examples: 
      | SheetName        | RowNumber | 
      | GET_BATCHNAME    |     0     | 
      | GET_BATCHNAME    |     1     | 
      | GET_BATCHNAME    |     2     |
