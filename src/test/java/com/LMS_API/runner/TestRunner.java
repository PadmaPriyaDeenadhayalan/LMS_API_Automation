package com.LMS_API.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)


@CucumberOptions(
		plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"html:target/cucumber-reports/reports.html","timeline:test-output-thread/"},
		 features = {"./src/test/resources/Features"},
	        glue = {"com.LMS_API.Stepdefinition"})

public class TestRunner {

}
