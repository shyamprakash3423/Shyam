package com.lib;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class General extends Global{
	/*Date d=new Date();
	String test=d.toString().replaceAll(":", "_").replaceAll(" ", "_");*/
	public void openbrowser() {
		System.out.println("firefox browser should open");
		System.setProperty("webdriver.firefox.marionette", "D:\\shyam\\set ups\\geckodriver.exe");
		driver = new FirefoxDriver();
		System.out.println("firefox browser is opened");	
	}
 public void openApplication() {
	 driver.navigate().to(URL);
	 System.out.println("application is opened");
 }
 public void closeApplication() {
	 driver.quit();
	 System.out.println("application is closed");
	 
 }
 public void loginprocess() {
	 System.out.println("enter username");
	 driver.findElement(By.xpath(txt_Username)).sendKeys(UN);
	 System.out.println("enter password");
	 driver.findElement(By.xpath(txt_Password)).sendKeys(PW);
	 driver.findElement(By.xpath(btn_Login)).click();
	 System.out.println("login completed successfully");
	 
 }
 public void logoutprocess() throws Exception{
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[3]/a")).click();
	 driver.findElement(By.xpath(btn_logout)).click();
	 System.out.println("Logout completed successfully");
 }
 public void openMy_Slideboxicon() throws Exception{
	 System.out.println("click on my_slidebox");
	 Thread.sleep(3000);
	 driver.findElement(By.xpath(icon_Myslidebox)).click();
	 System.out.println("my slide box is opened");
 }
 public void create_folders() throws Exception{
	 System.out.println("creating new root folder");
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(tab_Createroot)));
		driver.findElement(By.id(tab_Createroot)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newFolderName")));
		driver.findElement(By.id("newFolderName")).clear();
		driver.findElement(By.id("newFolderName")).sendKeys("Testing");
		driver.findElement(By.xpath(".//*[@id='btnFolderCreate']")).click();
		System.out.println("Root folder created");
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='#Shared/']/i")).click();
		driver.findElement(By.id("Testing/_anchor")).click();
		Thread.sleep(3000);
		System.out.println("Create Sub Folder");
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tab_Subroot)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tab_Subroot)));
		driver.findElement(By.xpath(tab_Subroot)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='newFolderName1']")));
		driver.findElement(By.xpath(".//*[@id='newFolderName1']")).sendKeys("sub1");
		driver.findElement(By.xpath(".//*[@id='btnFolderSubCreate']")).click();
		System.out.println("Subfolder created");
 }
 public void sharefile() throws Exception{
	 Thread.sleep(5000);
	 driver.findElement(By.xpath(".//*[@id='#Shared/']/i")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(".//*[@id='shyam/']/i")).click();
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='Test/_anchor']/i")).click();	
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='265b92be-a9c0-4274-8578-1e7fad12efd1']/td[1]/input")).click();
		Thread.sleep(3000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	    /*wait.until(ExpectedConditions.elementToBeSelected(By.xpath(single_share)));
		driver.findElement(By.xpath(single_share)).click();*/
		Thread.sleep(3000);
		System.out.println("share page should open");
		System.out.println("enter the share name");
		ArrayList<String> tab=new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tab.size());
		for (int i = 0; i < tab.size(); i++) {
			driver.switchTo().window(tab.get(i));
			System.out.println(driver.getCurrentUrl());	
		}
		driver.findElement(By.xpath(share_name)).sendKeys("test");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("enter the email u want to share");
		driver.findElement(By.xpath(share_email)).sendKeys("shyamprakashtesting@gmail.com");
		driver.findElement(By.xpath(share_email)).sendKeys(Keys.ENTER);
		System.out.println("email shared successfully");
 }
 public void sharemultiplefiles() throws Exception{
	Thread.sleep(5000);
	 driver.findElement(By.xpath(".//*[@id='#Shared/']/i")).click();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 driver.findElement(By.xpath(".//*[@id='shyam/']/i")).click();
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.findElement(By.xpath(".//*[@id='Test/_anchor']/i")).click();	
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.findElement(By.xpath(".//*[@id='265b92be-a9c0-4274-8578-1e7fad12efd1']/td[1]/input")).click();
	driver.findElement(By.xpath(".//*[@id='5eaae6ea-df18-4b57-a886-07cdedfdc701']/td[1]/input")).click();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.findElement(By.xpath(group_share)).click();
	Thread.sleep(3000);
	System.out.println("share page should open");
	System.out.println("enter the share name");
	driver.findElement(By.xpath(share_name)).sendKeys("test");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	System.out.println("enter the email u want to share");
	driver.findElement(By.xpath(share_email)).sendKeys("shyamprakashtesting@gmail.com");
	driver.findElement(By.xpath(share_email)).sendKeys(Keys.ENTER);
	System.out.println("email shared successfully");
	
 }
 public void editfile() throws Exception{
	 Thread.sleep(5000);
	 driver.findElement(By.xpath(".//*[@id='#Shared/']/i")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(".//*[@id='shyam/']/i")).click();
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='Test/_anchor']/i")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='265b92be-a9c0-4274-8578-1e7fad12efd1']/td[1]/input")).click();
		Thread.sleep(3000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		WebElement Edittext = driver.findElement(By.xpath(".//*[@id='txtfilename']"));
		Edittext.clear();
		Edittext.sendKeys("1.svs");
		Thread.sleep(3000);
		WebElement Editdiagname = driver.findElement(By.xpath(".//*[@id='txtcasetitle']"));
		Editdiagname.clear();
		Editdiagname.sendKeys("2.svs");
		Thread.sleep(3000);
		WebElement Editradiobtn = driver.findElement(By.name("txtgender"));
		Editradiobtn.findElement(By.id("rbtnmale")).click();
		driver.findElement(By.xpath(".//*[@id='btnupdate']")).click();
 }
 public void information() throws Exception{
	 Thread.sleep(5000);
	 driver.findElement(By.xpath(".//*[@id='#Shared/']/i")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(".//*[@id='shyam/']/i")).click();
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='Test/_anchor']/i")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='265b92be-a9c0-4274-8578-1e7fad12efd1']/td[1]/input")).click();
		Thread.sleep(3000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
    System.out.println("information should be displayed");
    driver.findElement(By.xpath(".//*[@id='modalInfoFile']/div/div/div[1]/button")).click();
 }
 public void copyfile()throws Exception{
	 Thread.sleep(5000);
	 driver.findElement(By.xpath(".//*[@id='#Shared/']/i")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(".//*[@id='shyam/']/i")).click();
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='Test/_anchor']/i")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='265b92be-a9c0-4274-8578-1e7fad12efd1']/td[1]/input")).click();
		Thread.sleep(3000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		WebElement path = driver.findElement(By.xpath(".//*[@id='modalCopyFile']/div/div/div[2]"));
		 path.findElement(By.xpath(".//*[@id='#Shared/']/i")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 path.findElement(By.xpath(".//*[@id='Testing/_anchor']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath(btn_copy)).click();
	 System.out.println("File copied Successfully");
 }
 public void movefile() throws Exception{
	 Thread.sleep(5000);
	 driver.findElement(By.xpath(".//*[@id='#Shared/']/i")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(".//*[@id='Dermatology/_anchor']")).click();
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='Dermatology/Test1/_anchor']")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='87e88b6d-5417-45dc-a93d-f79f03606eba']/td[1]/input")).click();
		Thread.sleep(3000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		WebElement path = driver.findElement(By.xpath(".//*[@id='modalCopyFile']/div/div/div[2]"));
		 path.findElement(By.xpath(".//*[@id='#Shared/']/i")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 path.findElement(By.xpath(".//*[@id='Testing/_anchor']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath(btn_move)).click();
		 System.out.println("File moved Suceessfully");
	
 }
 public void file_Qrcode() throws Exception{
	 Thread.sleep(7000);
	 driver.findElement(By.xpath(".//*[@id='#Shared/']/i")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(".//*[@id='shyam/']/i")).click();
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='Test/_anchor']/i")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='265b92be-a9c0-4274-8578-1e7fad12efd1']/td[1]/input")).click();
		Thread.sleep(3000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		WebElement txt_QRcode = driver.findElement(By.xpath(".//*[@id='txtQRCodeEmail']"));
		txt_QRcode.sendKeys("shyamprakashtesting@gmail.com");
		System.out.println("Qrcode shared Successfully");
		driver.findElement(By.xpath("btn_Qrshare")).click();
 }
 public void file_Delete() throws Exception{
	 Thread.sleep(7000);
	 driver.findElement(By.xpath(".//*[@id='#Shared/']/i")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='nikhilesh/_anchor']")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='24a83365-e7b7-4878-9974-c9da5d031a4d']/td[1]/input")).click();
		Thread.sleep(3000);
		
		/*Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);*/
		
 }
 public void UploadFile() throws Exception{
	 Thread.sleep(7000);
	 driver.findElement(By.xpath(".//*[@id='#Shared/']/i")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='nikhilesh/_anchor']")).click();
		/*driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='24a83365-e7b7-4878-9974-c9da5d031a4d']/td[1]/input")).click();*/
		Thread.sleep(3000);
		System.out.println("Upload files");
		driver.findElement(By.xpath(".//*[@id='uploadLink']/i")).click();
		System.out.println("Browse window should be opened");
		ArrayList<String> tab=new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tab.size());
		for (int i = 0; i < tab.size(); i++) {
			driver.switchTo().window(tab.get(i));
			System.out.println(driver.getCurrentUrl());	
		}
		driver.switchTo().window(tab.get(1));
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath(".//*[@id='files']"));
		element.click();
		StringSelection Stringselection = new StringSelection("C:\\Users\\jobs\\Desktop\\1.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Stringselection, null);
		Thread.sleep(3000);
		System.out.println("New Upload window should be opened");
		Thread.sleep(3000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.setAutoDelay(1000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);	
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='txtcasetitle']")).sendKeys("23");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("chkAgree")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='uploadfilestocloud']")).click();
		System.out.println("File Uploaded Successfully");
 }
 public void Screenshot() throws IOException {
	 Date d=new Date();
		String filename=d.toString().replaceAll(" ", "_").replaceAll(":", "_");
		TakesScreenshot ts =(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(""+filename+".png"));
 }
}



