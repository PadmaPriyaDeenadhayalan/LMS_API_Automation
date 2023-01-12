package LMS_API_Stepdefinition_Program;

import static io.restassured.RestAssured.given;

import LMS_API_BaseClass.BaseClass;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Programs extends BaseClass{
	
	public RequestSpecification spec;
	public Response res;
	
	
	@Given("Call \\{baseurl}\\/allPrograms endpoint")
	public void call_all_programs_endpoint() {
		this.spec = given().baseUri("https://lms-backend-service.herokuapp.com/lms");
		this.spec.header("Accept","application/json");
	}

	@When("GET request is sent")
	public void get_request_is_sent() {
		Response res =  this.spec.when().get("/allPrograms");
		this.res=res;
	}

	@Then("Status Code should be200 OK")
	public void status_code_should_be200_ok() {
	    
		System.out.println(res.getBody().asPrettyString());
	}

	@Then("The Response should fetch all the programs which includes Program Id, Program Name, Program Description,Program Status,Creation Time and Last Modified Time.")
	public void the_response_should_fetch_all_the_programs_which_includes_program_id_program_name_program_description_program_status_creation_time_and_last_modified_time() {
	    
		
	}
}
