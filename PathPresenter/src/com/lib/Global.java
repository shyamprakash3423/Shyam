package com.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Global {
	public WebDriver driver;
	public WebDriverWait wait;

	public String UN = "ppdev1@gmail.com";
	public String PW = "Admin$123";
	public String URL = "https://www.pathpresenter.net";
	public String txt_Username = ".//*[@id='UserName']";
	public String txt_Password = ".//*[@id='Password']";
	public String btn_Login = ".//*[@id='submit_contact']";
	public String btn_logout  =  ".//*[@id='navbar']/ul/li[3]/ul/li[1]/a";
	public String icon_Myslidebox = "html/body/div[1]/div[1]/div[1]";
	public String tab_Createroot = "crtRoot";
	public String tab_Subroot = ".//*[@id='crtSub'][1]";
	public String group_share = ".//*[@id='crtRoot'][2]";
	public String single_share =".//*[@id='1277d460-5494-408e-8472-b5f1efbd86d5']/td[12]/a[2]/i";
	public String share_name = ".//*[@id='txtFileName']";
	public String share_email = ".//*[@id='txtEmail']";
	public String btn_editupdate = ".//*[@id='btnupdate']";
	public String btn_copy = ".//*[@id='btnCopyFile']";
	public String btn_move = ".//*[@id='btnMoveFile']";
	public String btn_Qrshare = ".//*[@id='modalShareQR']/div/div/div[2]/div/div/button";
	public String btn_delete = ".//*[@id='rename']";
	public String upld_btn = ".//*[@id='uploadLink']/i";
	
}


