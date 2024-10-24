package org.report;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;


public class ReportingClass {
	public static void generateReport(String json) {
		File file = new File("target");
		Configuration con = new Configuration(file,"Adactin");
		con.addClassifications("User Story", "87192");
		con.addClassifications("Tool", "JDK11.0");
		List<String> li = new LinkedList<String>();
		li.add(json);
		ReportBuilder report = new ReportBuilder(li,con);
		report.generateReports();
		
	}
}
