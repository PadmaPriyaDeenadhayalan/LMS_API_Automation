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
Feature: Title of your feature
  I want to use this template for my feature file

   @GETBatchById
   Scenario Outline: Verify a Particular Batch Id as a Response
   Given Call "url"/batches/batchId/ endpoint to get particular batch id
   When GET request is sent form given sheetname "<SheetName>" and rownumber <RowNumber>
   Then Status Code should Display "200 OK"
   And The Response should fetch the detail of that Particular Batchid.

    Examples: 
      |SheetName  |RowNumber| 
      | GET_BATCHID |  0 |
      |GET_BATCHID |  1|
      
