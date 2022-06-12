package com.webapp.pages;

import com.webapp.commonDef.CommonDef;
import com.automation.core.testng.reporter.CustomReporter;
import com.automation.core.utils.reporter.Report;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Set;

public class RegistrationPage {

	static By registerTabBy =  By.xpath("//div[@class='newnav-button' and contains(text(),'Register')]");
	static By displayNameTxtBy = By.xpath("//input[@id='newpopup-register-user' ]");
	static By emailAddressBY = By.xpath("//input[@id='newpopup-register-email' ]");
	static By passwordTxtBy = By.xpath("//input[@id='newpopup-register-pass' ]");
	static By faceBookTabBy = By.xpath("//i[@id='newpopup-register-fb']");
	static By registerBtnBy = By.xpath("//button[@value='Sign Up']");



	// Method to enter the user Data using DataProvider
	public static boolean loginValidation(String displayName, String email,String password) {
		boolean login = false;
		try {

			CommonDef.click(registerTabBy);
			CommonDef.sendKeys(displayNameTxtBy, displayName );
			CommonDef.sendKeys(emailAddressBY, email );
			CommonDef.sendKeys(passwordTxtBy,password );
			CommonDef.click(registerBtnBy);
			login= true;

		} catch (Exception e) {
			CommonDef.logs(e.getMessage());
		}
		return login;
	}

	

}
