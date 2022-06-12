package com.webapp.tests;

import java.util.LinkedHashMap;

import org.aspectj.lang.annotation.Before;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.automation.core.config.ProjectConfig;
import com.automation.core.utils.data.ExcelDataReader;


public class DataProviderClass extends AllTests {
	

	

	@DataProvider (name = "data-provider-xls")
	public String[][] dpMethodXls(){
	
		LinkedHashMap<String, String> data = ExcelDataReader.readTCBinding(testID,sheetName);
		return new String[][] {{data.get("First Name"),data.get("Email"),data.get("Password")}};
	}
	
	
}