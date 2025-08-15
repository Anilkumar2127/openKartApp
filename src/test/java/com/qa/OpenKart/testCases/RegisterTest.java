package com.qa.OpenKart.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.OpenKart.base.BaseTest;
import com.qa.Utilities.ExcelUtiles;

public class RegisterTest extends BaseTest {

	
	@BeforeClass
	public void doSetUp() {
		accregpage=loginpage.navigateToRegisteration();
	}
	
	@Test(dataProvider="getNewUserDataFromExcel")
	public void registerNewUser(String firstname,String lastname,String mob,String password,String subscribe) {
	Assert.assertEquals(true,accregpage.doUserRegister(firstname,lastname,mob, password,subscribe));	
	}
	
	/*
	 * Getting data from excel with help of ExcelUtiles
	 */
	@DataProvider
	public Object[][] getNewUserDataFromExcel() {
		String sheetName="RegisterData";
		Object regData[][]=ExcelUtiles.getDataFromExcel(sheetName);
		return regData;
	}
	
	@DataProvider
	public Object[][] getUserRegTestDate() {
		return new Object[][] {
			{"anil", "kumar","9876543211", "password1231","yes"},
			{"dileep", "kumar","9876543212", "password1232","no"},
			{"satri", "kumar", "9876543213", "password1234","yes"}
		};
	}
	
}
