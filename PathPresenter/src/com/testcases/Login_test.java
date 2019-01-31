package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.lib.General;

public class Login_test extends General{
	Login_test l ;
	@Test
	public void login_act() {
		l= new Login_test();
		l.openbrowser();
		l.openApplication();
		l.loginprocess();
	}
	@AfterMethod
	public void Logout() throws Exception {
		l.logoutprocess();
	}
}
