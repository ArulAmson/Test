package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.report.ReportingClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\amazonProduct.feature", glue = "org.step", plugin = {
		"html:target\\htmlReport", "junit:target\\junitReport.junit", "json:target\\jsonReport.json" })
public class TestRunnerClass {

	@AfterClass
	public static void afterclass() {
		try {
			ReportingClass.generateReport("target\\jsonReport.json");
		} catch (Exception e) {
			System.out.println(e.getClass());
		}
	}

}

