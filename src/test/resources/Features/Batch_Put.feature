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
Feature: Update Batch by batch iD

	Scenario Outline: Update  Batches by Batch Id without intialize the heade 
  Given Call this "{{baseurl}}/batches/(BatchId)" PUT Batch api end point
  When Without Intialize the header Send  Batch PUT HTTP rquest with Batch updated details from shetname "<SheetName>" and rownumber <RowNumber> 
  Then Validate the HTTP response code 200 for PUT1 request
  And  Fetch the details from the response body for  Batch PUT1 request. 
   
  Examples: 
      | SheetName  | RowNumber | 
      | PUT_BATCH  |  0   |
 
  @UpdateBatch
  Scenario Outline: Update  Batches by Batch Id 
  Given Call this "url"/batches/ endpoint 
  When Set request Header
  And Send  Batch PUT HTTP rquest with Batch updated details from sheetname "<SheetName>" and rownumber <RowNumber> 
  Then validate the HTTP response code 200
   
  Examples: 
      | SheetName  | RowNumber | 
      | PUT_BATCH   |  0   |
      | PUT_BATCH   |  1  |
      | PUT_BATCH   |  2   |
      | PUT_BATCH   |  3   |
      | PUT_BATCH   |  4   |
      | PUT_BATCH   |  5   |
      | PUT_BATCH   |  6   |
      | PUT_BATCH   |  7   |
      | PUT_BATCH   |  8   |
