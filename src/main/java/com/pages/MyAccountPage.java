package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {

	private WebDriver driver;
	
	private By accSection=By.cssSelector("div#center_column span");
	
	public MyAccountPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public int sectionHeadersCount()
	{
		return driver.findElements(accSection).size();
	}
	
	public String pageTitle()
	{
		return driver.getTitle();
	}
	
	public List<String> sectionHeadersName()
	{
		List<String>list=new ArrayList<>();
		
		List<WebElement> sectionList=driver.findElements(accSection);	
		for(WebElement e:sectionList)
		{
		String txt=	e.getText();
		list.add(txt);
		}
		return list;
	}
	
	
}
