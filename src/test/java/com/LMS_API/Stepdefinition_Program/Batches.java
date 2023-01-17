package com.LMS_API.Stepdefinition_Program;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.JSONObject;
import org.junit.Assert;

import com.LMS_API.BaseClass.BaseClass;
import com.LMS_API.Reader.ExcelReader;
import com.LMS_API.utility.Loggerload;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Batches extends BaseClass{
	
	public RequestSpecification spec;
	public Response res;
	public JSONObject param;
	public String batch_Name;
	public String batch_Description;
	public String batch_Status;
	public String bprogram_Id;



//Get All Batches
@Given("Call {string} endpoint")
public void call_endpoint(String url1) {
	this.spec = given().baseUri(URL(url1));

	this.spec.header("Accept","application/json");

}

@When("Get request for Batch is sent")
public void get_request_for_batch_is_sent() {
	Response res =  this.spec.when().get("/batches");
	this.res=res;

}

@Then("Status Code should be {string}")
public void status_code_should_be(String string) {
	
	Loggerload.info("Get All Programs Result");
	Loggerload.info("Status Code : "+res.statusCode()+ res.statusLine());
	
	
}

@Then("The Response should fetch all the batches which includes Batch Id, Batch Name, Batch Description,Batch Status,Creation Time and Last Modified Time.")
public void the_response_should_fetch_all_the_batches_which_includes_batch_id_batch_name_batch_description_batch_status_creation_time_and_last_modified_time() {

	Loggerload.info(res.getBody().asPrettyString());

}

//Get Batches By Id

@Given("Call {string}\\/batches\\/batchId\\/ endpoint")
public void call_batches_batch_id_endpoint(String url1) {
	this.spec = given().baseUri(URL(url1));
	this.spec.header("Accept","application/json");
}


@When("GET request is sent form given sheetname {string} and rownumber {int}")
public void get_request_is_sent_form_given_sheetname_and_rownumber(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException
{
   ExcelReader reader = new ExcelReader();
	List<Map<String, String>> testData = reader.getData(
			"C:\\Users\\bernipoornima\\git\\LMS_API_Automation\\TestData\\Batch.xlsx",
			SheetName);
	String batch_id = testData.get(RowNumber).get("Batch Id");
	this.res = spec.when()
.get("https://lms-backend-service.herokuapp.com/lms/batches/batchId/" + batch_id);

Loggerload.info(res.asPrettyString());
 
}



@Then("Status Code should Display {string}")
public void status_code_should_display(String string) {
    int statusCode = res.getStatusCode();
    Assert.assertEquals(statusCode, 200);
	Loggerload.info("Status Code : "+res.statusCode()+ res.statusLine());
	
}

@Then("The Response should fetch the detail of that Particular Batchid.")
public void the_response_should_fetch_the_detail_of_that_particular_batchid() {
	Loggerload.info(res.getBody().asPrettyString());
}

//Get Batches By Batch Name


@Given("Call {string}\\/batches\\/batchName\\/ endpoint")
public void call_batches_batch_name_endpoint(String url1) {
	this.spec = given().baseUri(URL(url1));
	this.spec.header("Accept","application/json");
}

@When("Batch Name  from given sheetname {string} and rownumber {int} and GET request is sent")
public void batch_name_from_given_sheetname_and_rownumber_and_get_request_is_sent(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	  ExcelReader reader = new ExcelReader();
	  List<Map<String, String>> testData = reader.getData(
	      "C:\\Users\\bernipoornima\\git\\LMS_API_Automation\\TestData\\Batch.xlsx",
	      SheetName);

	  String batch_name = testData.get(RowNumber).get("Batch Name");

	  this.res = spec.when()
	      .get("https://lms-backend-service.herokuapp.com/lms/batches/batchName/" + batch_name);
}

@Then("Receive vaid HTTP response code {int} for BATCH BY BATCH_BatchName")
public void receive_vaid_http_response_code_for_batch_by_batch_batch_name(Integer int1) {
    int statusCode = res.getStatusCode();
    Assert.assertEquals(statusCode, 200);
	Loggerload.info("status code    :"+res.statusCode()+" "+"status line"+res.statusLine());
}

@Then("The Response should fetch the detail of that Particular Batch Name")
public void the_response_should_fetch_the_detail_of_that_particular_batch_name() {
	  Loggerload.info(this.res.getBody().asPrettyString());
}

//Get Batches By Program Id

@Given("Call {string}\\/batches\\/program\\/ endpoint")
public void call_batches_program_endpoint(String url1) {
	this.spec = given().baseUri(URL(url1));
	this.spec.header("Accept","application/json");
}


@When("Batch ProgramID  from given sheetname {string} and rownumber {int} and GET request is sent")
public void batch_program_id_from_given_sheetname_and_rownumber_and_get_request_is_sent(String  SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	  ExcelReader reader = new ExcelReader();
	  List<Map<String, String>> testData = reader.getData(
	      "C:\\Users\\bernipoornima\\git\\LMS_API_Automation\\TestData\\Batch.xlsx",
	      SheetName);

	  String program_id = testData.get(RowNumber).get("Program Id");

	  this.res = spec.when()
	      .get("https://lms-backend-service.herokuapp.com/lms/batches/program/" + program_id);
}

@Then("Receive vaid HTTP response code {int} for BATCH BY BATCH_ProgramId")
public void receive_vaid_http_response_code_for_batch_by_batch_program_id(Integer int1) {
    int statusCode = res.getStatusCode();
    Assert.assertEquals(statusCode, 200);
	  Loggerload.info("status code     :      "+this.res.statusCode()+" \n\n "+"status line      :     "+this.res.statusLine());
}

@Then("The Response should fetch the detail of that Particular Batch by using program Id")
public void the_response_should_fetch_the_detail_of_that_particular_batch_by_using_program_id() {
	Loggerload.info(this.res.getBody().asPrettyString());
}

//Put Without Intialization

@Given("Call this {string} PUT Batch api end point")
public void call_this_put_batch_api_end_point(String url1) {
	 this.spec = given().baseUri(URL(url1));
	  //this.spec.header("Accept","application/json");
}

@When("Without Intialize the header Send  Batch PUT HTTP rquest with Batch updated details from shetname {string} and rownumber {int}")
public void without_intialize_the_header_send_batch_put_http_rquest_with_batch_updated_details_from_shetname_and_rownumber(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	ExcelReader reader = new ExcelReader();
	  List<Map<String,String>> testData = 
	      reader.getData("C:\\Users\\bernipoornima\\git\\LMS_API_Automation\\TestData\\Batch.xlsx",
	          SheetName);
	  String batch_id = testData.get(RowNumber).get("batchId");
	  String batch_Name = testData.get(RowNumber).get("batchName");  
	  String batch_Description = testData.get(RowNumber).get("batchDescription");
	  String batch_Status = testData.get(RowNumber).get("batchStatus");
	  String batch_NoOfClasses = testData.get(RowNumber).get("batchNoOfClasses");
	  String program_Id = testData.get(RowNumber).get("programId");
	  String program_Name = testData.get(RowNumber).get("programName");
	  
	      JSONObject param=new JSONObject();
	      param.put("batchName",batch_Name);
	      param.put("batchDescription",batch_Description);
	      param.put("batchStatus",batch_Status);
	      param.put("batchNoOfClasses",batch_NoOfClasses);
	      param.put("programId",program_Id);
	      param.put("programName",program_Name);

	  
	  this.res=spec.when().body(param.toString())
	        .put("https://lms-backend-service.herokuapp.com/lms/batches/" +batch_id).then().log().all().extract().response();

}

@Then("Validate the HTTP response code {int} for PUT1 request")
public void validate_the_http_response_code_for_put1_request(Integer int1) {
	
	Loggerload.info("status code     :      "+this.res.statusCode()+" \n\n "+"status line      :     "+this.res.statusLine());
	    
}

@Then("Fetch the details from the response body for  Batch PUT1 request.")
public void fetch_the_details_from_the_response_body_for_batch_put1_request() {

    int statusCode = res.getStatusCode();
    Assert.assertEquals(statusCode,201);
    Loggerload.info(res.asPrettyString());
	
}


//Update Batch By Id

@Given("Call this {string}\\/batches\\/ endpoint")
public void call_this_batches_endpoint(String url1){
	 this.spec = given().baseUri(URL(url1));
	  this.spec.header("Accept","application/json");
	  //this.spec.header("Content-Type","application/json");
}



@When("Set request Header")
public void set_request_header() {
	  this.spec.header("Content-Type","application/json");
}

@When("Send  Batch PUT HTTP rquest with Batch updated details from sheetname {string} and rownumber {int}")
public void send_batch_put_http_rquest_with_batch_updated_details_from_sheetname_and_rownumber(String    SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	ExcelReader reader = new ExcelReader();
	  List<Map<String,String>> testData = 
	      reader.getData("C:\\Users\\bernipoornima\\git\\LMS_API_Automation\\TestData\\Batch.xlsx",
	          SheetName);
	  String batch_id = testData.get(RowNumber).get("batchId");
	  String batch_Name = testData.get(RowNumber).get("batchName");  
	  String batch_Description = testData.get(RowNumber).get("batchDescription");
	  String batch_Status = testData.get(RowNumber).get("batchStatus");
	  String batch_NoOfClasses = testData.get(RowNumber).get("batchNoOfClasses");
	  String program_Id = testData.get(RowNumber).get("programId");
	  String program_Name = testData.get(RowNumber).get("programName");
	  
	      JSONObject param=new JSONObject();
	      param.put("batchName",batch_Name);
	      param.put("batchDescription",batch_Description);
	      param.put("batchStatus",batch_Status);
	      param.put("batchNoOfClasses",batch_NoOfClasses);
	      param.put("programId",program_Id);
	      param.put("programName",program_Name);

	  
	  this.res=spec.when().body(param.toString())
	        .put("https://lms-backend-service.herokuapp.com/lms/batches/" +batch_id).then().log().all().extract().response();

}

@Then("validate the HTTP response code {int}")
public void validate_the_http_response_code(Integer int1) {
	
	Loggerload.info("status code     :      "+this.res.statusCode()+" \n\n "+"status line      :     "+this.res.statusLine());
	  	
	    int statusCode = res.getStatusCode();
	    Assert.assertEquals(statusCode, 200);
	    Loggerload.info(this.res.getBody().asPrettyString());
	    

}



//Create Batch


@Given("Call the {string}")
public void call_the(String baseurl) {
	this.spec = given().baseUri(baseurl);
	this.spec.header("Accept","application/json");
	
   this.spec.header("Content-Type","application/json");
}

@When("Set request Header with POSt Batch details from shetname {string} and rownumber {int} and Sent POST HTTP request")
public void set_request_header_with_po_st_batch_details_from_shetname_and_rownumber_and_sent_post_http_request(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	ExcelReader reader = new ExcelReader();
	  List<Map<String,String>> testData = 
	      reader.getData("C:\\Users\\bernipoornima\\git\\LMS_API_Automation\\TestData\\Batch.xlsx",
	          SheetName);
	  String batch_Name = testData.get(RowNumber).get("batchName");  
	  String batch_Description = testData.get(RowNumber).get("batchDescription");
	  String batch_Status = testData.get(RowNumber).get("batchStatus");
	  String batch_NoOfClasses = testData.get(RowNumber).get("batchNoOfClasses");
	  String program_Id = testData.get(RowNumber).get("programId");
	  
	  
	      JSONObject param=new JSONObject();
	      param.put("batchName",batch_Name);
	      param.put("batchDescription", batch_Description);
	      param.put("batchStatus",batch_Status);
	      param.put("batchNoOfClasses",batch_NoOfClasses);
	      param.put("programId",program_Id);
	    
	  
	  this.res=spec.when().body(param.toString())
	        .post("https://lms-backend-service.herokuapp.com/lms/batches").then().log().all().extract().response();
}

@Then("Receive vaid HTTP response code {int} for Batch POST request")
public void receive_vaid_http_response_code_for_batch_post_request(Integer int1) {
	

    int statusCode = res.getStatusCode();
    Assert.assertEquals(statusCode,201);
Loggerload.info("status code     :      "+this.res.statusCode()+" \n\n "+"status line      :     "+this.res.statusLine());
}

@Then("The Response should fetch the detail of  Created New Batch")
public void the_response_should_fetch_the_detail_of_created_new_batch() {



	    Loggerload.info(this.res.getBody().asPrettyString());
}

//Push without Intialization


@Given("call the {string}\\/batches save endpoint")
public void call_the_batches_save_endpoint(String url1) {
	this.spec = given().baseUri(URL(url1));
	this.spec.header("Accept","application/json");
	
   //this.spec.header("Content-Type","application/json");

}

@When("with out initialize the header send Post request with new Batch deatials from sheetname {string} and rownumber {int} and request sent")
public void with_out_initialize_the_header_send_post_request_with_new_batch_deatials_from_sheetname_and_rownumber_and_request_sent(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	ExcelReader reader = new ExcelReader();
	  List<Map<String,String>> testData = 
	      reader.getData("C:\\Users\\bernipoornima\\git\\LMS_API_Automation\\TestData\\Batch.xlsx",
	          SheetName);
	  String batch_Name = testData.get(RowNumber).get("batchName");  
	  String batch_Description = testData.get(RowNumber).get("batchDescription");
	  String batch_Status = testData.get(RowNumber).get("batchStatus");
	  String batch_NoOfClasses = testData.get(RowNumber).get("batchNoOfClasses");
	  String program_Id = testData.get(RowNumber).get("programId");
	  
	  
	      JSONObject param=new JSONObject();
	      param.put("batchName",batch_Name);
	      param.put("batchDescription", batch_Description);
	      param.put("batchStatus",batch_Status);
	      param.put("batchNoOfClasses",batch_NoOfClasses);
	      param.put("programId",program_Id);
	    
	  
	  this.res=spec.when().body(param.toString())
	        .post("https://lms-backend-service.herokuapp.com/lms/batches").then().log().all().extract().response();
}

@Then("validatebnew batch ststus code")
public void validatebnew_batch_ststus_code() {

    int statusCode = res.getStatusCode();
    Assert.assertEquals(statusCode,201);
	Loggerload.info("status code     :      "+this.res.statusCode()+" \n\n "+"status line      :     "+this.res.statusLine());
}

@Then("Received response from the response body")
public void received_response_from_the_response_body() {

	    Loggerload.info(res.asPrettyString());
	   
}


//Delete Batch By Id


@Given("Call from batch {string}\\/batches\\/batch endpoint")
public void call_from_batch_batches_batch_endpoint(String url1) {
	this.spec = given().baseUri(URL(url1));
	this.spec.header("Accept","application/json");
}


@When("BatchID  from given sheetname {string} and rownumber {int} and Delete request is sent")
public void batch_id_from_given_sheetname_and_rownumber_and_delete_request_is_sent(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	 ExcelReader reader = new ExcelReader(); 
     List<Map<String, String>> testData =reader.getData(
    		 "C:\\Users\\bernipoornima\\git\\LMS_API_Automation\\TestData\\Batch.xlsx",SheetName); 
           
     String batch_Delete = testData.get(RowNumber).get("Del Batch ID");
     
     this.res = spec.when()
   	      .get("https://lms-backend-service.herokuapp.com/lms/batches/" + batch_Delete);
    
}


@Then("Receive vaid HTTP response code {int}")
public void receive_vaid_http_response_code(Integer int1) {
    int statusCode = res.getStatusCode();
    Assert.assertEquals(statusCode, 200);
Loggerload.info("Status Code : "+res.statusCode()+ res.statusLine());
	
}

@Then("The Response should be Message: Batch with Id-Number deleted Successfully!")
public void the_response_should_be_message_batch_with_id_number_deleted_successfully() {
    // Write code here that turns the phrase above into concrete actions
  Loggerload.info(res.asPrettyString());
}



}
