package LMS_API_BaseClass;

import static io.restassured.RestAssured.given;

import io.restassured.specification.RequestSpecification;

public class BaseClass {

	private String programName;
	private String programDescription;
	private String programStatus;
	private String creationTime;
	private String lastModTime;
	
	public RequestSpecification spec;

	
	
	public String URL(String baseurl)
	{
		String baseurl1="https://lms-backend-service.herokuapp.com/lms";
		return baseurl1;
	}
	
}

