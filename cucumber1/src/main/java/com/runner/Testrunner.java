package com.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		 
		features="src/main/java/com/features",
		glue="com.stepdefiation",
		plugin="html:target",
		dryRun=false,
		monochrome=true
		
		
		
		
		)

public class Testrunner {

}
