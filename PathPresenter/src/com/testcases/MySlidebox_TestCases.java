package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.lib.General;

public class MySlidebox_TestCases extends General{
	
	MySlidebox_TestCases my;
	@Test
	public void openMy_slidebox() throws Exception {
		my = new MySlidebox_TestCases();
		my.openbrowser();
		my.openApplication();
		my.loginprocess();
		my.openMy_Slideboxicon();
	}
	@AfterMethod
	public void My_SlideboxFunctios() throws Exception{
		//my.create_folders();
		//my.sharefile();
		//my.sharemultiplefiles();
		//my.editfile();
		//my.information();
		//my.copyfile();
		//my.movefile();
		//my.file_Qrcode();	
		my.file_Delete();
		//my.UploadFile();
		
     
	
		
	}
}


