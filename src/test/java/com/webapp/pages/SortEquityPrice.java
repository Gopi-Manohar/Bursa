package com.webapp.pages;

import com.webapp.commonDef.CommonDef;
import com.automation.core.testng.reporter.CustomReporter;
import com.automation.core.utils.reporter.Report;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

public class SortEquityPrice 
{

	public SortEquityPrice() {}
	static By tableBy= By.xpath("(//table[contains(@class,'table-borderless')])[1]");
	static By closeBy= By.xpath("//a[text()='Close']");
	static By mostActiveBy= By.xpath("(//a[@class='nav-link btn btn-effect btn-white active' and @id='pills-active-tab'])[1]");
	// Method to enter the user Data
	public static boolean equityPageValidation() throws IOException {

		String[][] s = new String[11][5];
		String[][] n = new String[11][1];
		double[] a = null;
		List<WebElement> heading = null;
		List<WebElement> col;
		List<String> code = new ArrayList<String>();
		List<Double> sortedList = new ArrayList<Double>();
		List<String> change = new ArrayList<String>();
		List<String> volume = new ArrayList<String>();
		List<String> name = new ArrayList<String>();
		try {
			CommonDef.click(closeBy);
			CommonDef.moveToElement(mostActiveBy);					
			WebElement curtable = CommonDef.getCurrentDriver().findElement(tableBy);
			List<WebElement> rows = curtable.findElements(By.tagName("tr"));

			for (int i = 1; i < rows.size(); i++)
			{
				col = rows.get(i).findElements(By.tagName("td"));
				heading = rows.get(i).findElements(By.tagName("th"));

				for (int j = 0; j < heading.size(); j++) {
					n[i][j] = heading.get(j).getText();
				}
				for (int j = 0; j < col.size(); j++){
					if (col.get(j).getText().equals("-"))
					{
						s[i][j]="0.000";
					}else
					{
						s[i][j]=col.get(j).getText();
					}
				}
			}

			for (int i = 1; i <=10; i++) {
				code.add(s[i][0]);
				sortedList.add(Double.parseDouble(s[i][2]));
				change.add(s[i][2]);
				volume.add(s[i][3]);
				name.add(n[i][0]);
			}
			HashMap<Integer, Double> hm = new HashMap<Integer, Double>();

			for (int i = 0; i < sortedList.size(); i++)
			{
				hm.put(i, sortedList.get(i));
			}
			Collections.sort(sortedList);
			Collections.reverse(sortedList);
			LinkedHashMap<Integer, Double> hm2 = new LinkedHashMap<Integer, Double>();

			for (Double d:sortedList)
			{
				for (Entry<Integer, Double> entry: hm.entrySet())
				{
					if (entry.getValue()==d)
					{
						hm2.put(entry.getKey(), d);
					}

				}
			}

			for (Entry<Integer, Double> entry2: hm2.entrySet())
			{

				if (change.get(entry2.getKey()).equals("0.000"))
				{
					System.out.println(code.get(entry2.getKey())+" "+" | "+name.get(entry2.getKey())+"  "+" | "+"  -  "+" "+" | "+volume.get(entry2.getKey())+" ");

				}else{
					System.out.println(code.get(entry2.getKey())+" "+" | "+name.get(entry2.getKey())+"  "+" | "+change.get(entry2.getKey())+" "+" | "+volume.get(entry2.getKey())+" ");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}		
		return true;

	}//method
}//class


