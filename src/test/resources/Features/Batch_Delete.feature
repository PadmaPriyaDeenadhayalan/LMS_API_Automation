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

Feature: Delete Batches by ID

   @DeleteBatchById
	   Scenario Outline:  Delete Batch By Id
   Given Call from batch "url"/batches/batch endpoint 
   When  BatchID  from given sheetname "<SheetName>" and rownumber <RowNumber> and Delete request is sent
   Then Receive vaid HTTP response code 200 
   And The Response should be Message: Batch with Id-Number deleted Successfully!

    Examples: 
   | SheetName              | RowNumber | 
      | DEL_BATCHID         |     0     | 
      | DEL_BATCHID  				| 		1			|
      
     
