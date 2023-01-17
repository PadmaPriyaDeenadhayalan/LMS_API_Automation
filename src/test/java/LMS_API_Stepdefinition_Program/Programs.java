package LMS_API_Stepdefinition_Program;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.JSONObject;
import org.junit.Assert;

import LMS_API_BaseClass.BaseClass;
import Reader.ExcelReader;
import io.cucumber.java.en.*;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.Loggerload;

public class Programs extends BaseClass {

	public RequestSpecification spec;
	public Response res;
	public JSONObject param;
	

	// Get All Programs//

	@Given("Call {string} endpoint")
	public void call_endpoint(String baseurl1) {
		this.spec = given().baseUri(URL(baseurl1));
		this.spec.header("Accept", "application/json");
		Response res = this.spec.when().get("/allPrograms");
		this.res = res;
	}

	@When("GET request is sent")
	public void get_request_is_sent() {
		Loggerload.info("GET Request sent for fetching all Programs");
	}

	@Then("Status Code should be200 OK")
	public void status_code_should_be200_ok() {

		this.res.getStatusCode();
		System.out.println("StatusCode:" + this.res.getStatusCode());

		try {
			if (200 == this.res.getStatusCode()) {
				Assert.assertTrue("200", true);
			}
		} catch (AssertionError Error) {

			Assert.assertFalse("400", true);
		}
		Loggerload.info("Status code validated");
	}

	@Then("The Response should fetch all the programs which includes Program Id, Program Name, Program Description,Program Status,Creation Time and Last Modified Time.")
	public void the_response_should_fetch_all_the_programs_which_includes_program_id_program_name_program_description_program_status_creation_time_and_last_modified_time() {

		this.res.then().header("Content-Type", "application/json");
		Loggerload.info(this.res.getBody().asPrettyString());
		Loggerload.info("Fetching all programs");

		File file = new File("src/test/resources/Features/Schema.json");
		this.res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(file));

		System.out.println("Json Schema Validated");

	}

	// Get Single Program//

	@Given("Call {string} \\/programs endpoint")
	public void call_programs_endpoint(String baseurl1) {

		this.spec = given().baseUri(URL(baseurl1));
		this.spec.header("Accept", "application/json");

	}

	@When("Program id from given sheetname {string} and rownumber {int} and GET request is sent")
	public void program_id_from_given_sheetname_and_rownumber_and_get_request_is_sent(String SheetName,
			Integer RowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(
				"/Users/dineshkumar/Documents/workspace-spring-tool-suite-4-4.12.1.RELEASE/LMS_API_Automation/TestData/Program.xlsx",
				SheetName);

		String program_id = testData.get(RowNumber).get("Program Id");

		this.res = spec.when().get("https://lms-backend-service.herokuapp.com/lms/programs/" + program_id);

		Loggerload.info("Get request sent for fetching particular Program Id");

	}

	@Then("The Response should fetch the detail of that Particular Program id.")
	public void the_response_should_fetch_the_detail_of_that_particular_program_id() {
//		Response singleProgram = this.res.then().header("Content-Type", "application/json").statusCode(statusCode);
		Loggerload.info(this.res.getBody().asPrettyString());

		int singleProgramStatusCode = this.res.getStatusCode();
		System.out.println("SingleProgramStatusCode:" + singleProgramStatusCode);

		Loggerload.info("Fetching Particular Progam Id and vaildating Status code");
	}

	// Delete Program Id//

	@Given("Call {string} \\/deletebyprogid\\/ProgramID")
	public void call_deletebyprogid_program_id(String baseurl1) {

		this.spec = given().baseUri(URL(baseurl1));
		this.spec.header("Content-Type", "application/json");
	}

	@When("Program id from given sheetname {string} and rownumber {int} and DELETE request is sent")
	public void program_id_from_given_sheetname_and_rownumber_and_delete_request_is_sent(String SheetName,
			Integer RowNumber) throws InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(
				"/Users/dineshkumar/Documents/workspace-spring-tool-suite-4-4.12.1.RELEASE/LMS_API_Automation/TestData/Program.xlsx",
				SheetName);

		String program_id = testData.get(RowNumber).get("Program Id");

		this.res = spec.when().delete("https://lms-backend-service.herokuapp.com/lms/deletebyprogid/" + program_id);

		Loggerload.info(this.res.getBody().asPrettyString());
	}

	// Delete by Program Name//

	@Given("Call {string} \\/deletebyprogname\\/programname")
	public void call_deletebyprogname_programname(String baseurl1) {
		this.spec = given().baseUri(URL(baseurl1));
		this.spec.header("Accept", "application/json");
	}

	@When("Program name from given sheetname {string} and rownumber {int} and DELETE request is sent")
	public void program_name_from_given_sheetname_and_rownumber_and_delete_request_is_sent(String SheetName,
			Integer RowNumber) throws InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(
				"/Users/dineshkumar/Documents/workspace-spring-tool-suite-4-4.12.1.RELEASE/LMS_API_Automation/TestData/Program.xlsx",
				SheetName);

		String program_name = testData.get(RowNumber).get("Program Name");

		this.res = spec.when().delete("https://lms-backend-service.herokuapp.com/lms/deletebyprogname/" + program_name);
		Loggerload.info(this.res.getBody().asPrettyString());
	}

	// Post Program//

	@Given("Call {string} \\/saveprogram endpoint")
	public void call_saveprogram_endpoint(String baseurl1) {
		this.spec = given().baseUri(URL(baseurl1));
		this.spec.header("Content-Type", "application/json");
	}

	@When("Post Program details from given sheetname {string} and rownumber {int} and POST request is sent")
	public void post_program_details_from_given_sheetname_and_rownumber_and_post_request_is_sent(String SheetName,
			Integer RowNumber) throws InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(
				"/Users/dineshkumar/Documents/workspace-spring-tool-suite-4-4.12.1.RELEASE/LMS_API_Automation/TestData/Program.xlsx",
				SheetName);

		String program_Name = testData.get(RowNumber).get("programName");
		String program_Desc = testData.get(RowNumber).get("programDescription");
		String program_Status = testData.get(RowNumber).get("programStatus");
		String creation_Time = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "+01:00";
		String last_ModTime = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "+01:00";

		JSONObject param = new JSONObject();
		param.put("programName", program_Name);
		param.put("programDescription", program_Desc);
		param.put("programStatus", program_Status);
		param.put("creationTime", creation_Time);
		param.put("lastModTime", last_ModTime);

		this.res = spec.when().body(param.toString()).post("https://lms-backend-service.herokuapp.com/lms/saveprogram");
	}

	@Then("The Created program details should be displayed in response")
	public void the_created_program_details_should_be_displayed_in_response() {

		Loggerload.info(this.res.getBody().asPrettyString());

		System.out.println("StatusCode:" + this.res.getStatusCode());

	}

	@Then("Status Code should be201 created")
	public void status_code_should_be201_created() {
		try {
			if (201 == this.res.getStatusCode()) {
				Assert.assertTrue("New Program Created", true);
			}
		} catch (AssertionError Error) {

			Assert.assertFalse("New Program not Created", true);
		}
	}

	// Put Program by Id//

	@Given("Call {string} \\/putprogram\\/id endpoint")
	public void call_putprogram_id_endpoint(String baseurl1) {

		this.spec = given().baseUri(URL(baseurl1));
		this.spec.header("Content-Type", "application/json");

	}

	@When("Update Program details from given sheetname {string} and rownumber {int} and PUT request is sent")
	public void update_program_details_from_given_sheetname_and_rownumber_and_put_request_is_sent(String SheetName,
			Integer RowNumber) throws InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(
				"/Users/dineshkumar/Documents/workspace-spring-tool-suite-4-4.12.1.RELEASE/LMS_API_Automation/TestData/Program.xlsx",
				SheetName);

		String program_Id = testData.get(RowNumber).get("programId");
		String program_Name = testData.get(RowNumber).get("programName");
		String program_Desc = testData.get(RowNumber).get("programDescription");
		String program_Status = testData.get(RowNumber).get("programStatus");
		String creation_Time = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "+01:00";
		String last_ModTime = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "+01:00";

		JSONObject param = new JSONObject();
		param.put("programId", program_Id);
		param.put("programName", program_Name);
		param.put("programDescription", program_Desc);
		param.put("programStatus", program_Status);
		param.put("creationTime", creation_Time);
		param.put("lastModTime", last_ModTime);

		this.res = spec.when().body(param.toString())
				.put("https://lms-backend-service.herokuapp.com/lms/putprogram/" + program_Id);
	}

	@Then("Status Code should be200Ok")
	public void status_code_should_be200ok() {

		Loggerload.info(this.res.getBody().asPrettyString());

		System.out.println("StatusCode:" + this.res.getStatusCode());

	}

	@Then("The Response will display the Updated ProgramName and Program Description")
	public void the_response_will_display_the_updated_program_name_and_program_description() {
		try {
			if (200 == this.res.getStatusCode()) {
				Assert.assertTrue("Program Updated", true);
			}
		} catch (AssertionError Error) {

			Assert.assertFalse("Program Not updated", true);
		}
	}

	// Put Program for Name Without header//
	
	@Given("Call {string} \\/program\\/\\(programName)")
	public void call_program_program_name(String baseurl1) {
	    
		this.spec = given().baseUri(URL(baseurl1));
	}
	
	@Then("Status Code should be415 unsupported media type")
	public void status_code_should_be415_unsupported_media_type() {
	   
		try {
			if (415 == this.res.getStatusCode()) {
				Assert.assertTrue("Media type not supported", true);
			}
		} catch (AssertionError Error) {

			Assert.assertFalse("Program updated", true);
		}
	}
	
	// Post Program Without header//
	
	@Given("Call {string}\\/saveprogram")
	public void call_saveprogram(String baseurl1) {
	    
		this.spec = given().baseUri(URL(baseurl1));
	}
	
	// Put Program for ID Without header//
	
	@Given("Call {string} \\/putprogram\\/\\{programId}")
	public void call_putprogram(String baseurl1) {
	    
		this.spec = given().baseUri(URL(baseurl1));
	}
	
	// Put Program by Name//

	@Given("Call {string} \\/putprogram\\/programName endpoint")
	public void call_putprogram_program_name_endpoint(String baseurl1) {

		this.spec = given().baseUri(URL(baseurl1));
		this.spec.header("Content-Type", "application/json");
	}

	@When("Update Program details with Program Name from given sheetname {string} and rownumber {int} and PUT request is sent")
	public void update_program_details_with_program_name_from_given_sheetname_and_rownumber_and_put_request_is_sent(
			String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(
				"/Users/dineshkumar/Documents/workspace-spring-tool-suite-4-4.12.1.RELEASE/LMS_API_Automation/TestData/Program.xlsx",
				SheetName);

		String program_Name = testData.get(RowNumber).get("programName");
		String program_Desc = testData.get(RowNumber).get("programDescription");
		String program_Status = testData.get(RowNumber).get("programStatus");
		String creation_Time = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "+01:00";
		String last_ModTime = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "+01:00";

		JSONObject param = new JSONObject();
		param.put("programName", program_Name);
		param.put("programDescription", program_Desc);
		param.put("programStatus", program_Status);
		param.put("creationTime", creation_Time);
		param.put("lastModTime", last_ModTime);

		this.res = spec.when().body(param.toString())
				.put("https://lms-backend-service.herokuapp.com/lms/program/" + program_Name);

	}

	@Then("Validate  the updated programName")
	public void validate_the_updated_program_name() {

		Loggerload.info(this.res.getBody().asPrettyString());

		System.out.println("StatusCode:" + this.res.getStatusCode());

	}

}
