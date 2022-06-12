package com.webapp.helpers;


import com.webapp.pages.*;
import com.automation.core.config.ProjectConfig;
import com.automation.core.utils.data.ExcelDataReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
//import junit.framework.Assert;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCaseClass {

	public static void equityPriceSorting( WebDriver driver) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(ProjectConfig.getPropertyValue("Bursa_Malaysia_URL"));
		driver.navigate().to(ProjectConfig.getPropertyValue("Bursa_Malaysia_URL"));		
		Assert.assertTrue(SortEquityPrice.equityPageValidation());
	
	}
	
	
	public static void registrationValidation( WebDriver driver,String Name, String email,String pass) {
		// TODO Auto-generated method stub
		System.out.println(ProjectConfig.getPropertyValue("Bursa_Marketplace_URL"));
		driver.navigate().to(ProjectConfig.getPropertyValue("Bursa_Marketplace_URL"));
		
		Assert.assertTrue(RegistrationPage.loginValidation(Name,email,pass));
	
	}
	
	
	

}
