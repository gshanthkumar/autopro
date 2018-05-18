package com.yrszone.automation.ui.test;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yrszone.automation.ui.exception.AutomationDriverException;
import com.yrszone.automation.ui.exception.AutomationElementNotFoundException;
import com.yrszone.automation.ui.testsetup.TestConfig;
import com.yrszone.automation.ui.testsetup.TestPageClass;
import com.yrszone.automation.ui.webdriver.UIWebDriver;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfig.class})
public class PageTest {
	@Autowired
	UIWebDriver driver;
	@Autowired
	TestPageClass tp;
	
	
	@Before
	public void initialize(){
		//System.setProperty("webdriver.gecko.driver", "C:\\TestAutomation\\SeleniumWrapper\\src\\main\\resources\\drivers\\geckodriver.exe");
		if(driver.getNativeWebDriver()==null){
			driver.setUpBrowser();
		}
	}
	
	@Test
	public void test() throws AutomationElementNotFoundException, AutomationDriverException, IOException{
		driver.connect("http://google.com");
		tp.test();
		

		
	}
	
	@After
	public void ss(){
		for(WebDriver driver : driver.getActiveDrivers()){
			driver.quit();
		}
	}
	

}
