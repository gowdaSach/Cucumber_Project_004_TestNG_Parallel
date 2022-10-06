package Parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.LoginPage;
import com.pages.MyAccountPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;


public class MyAccountPageSteps {

	private LoginPage loginpage=new LoginPage(DriverFactory.getDriver());;
	private MyAccountPage myaccountPage;
	;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
	  List<Map<String, String>> credentialList=credTable.asMaps();
	 String usname= credentialList.get(0).get("username");
	 String pswrd= credentialList.get(0).get("password");
	 
	 DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication");
	 myaccountPage=loginpage.doLogin(usname, pswrd);
	}

	@Given("user is on Accounts Page")
	public void user_is_on_accounts_page() {
	 String	title=myaccountPage.pageTitle(); 
		System.out.println("My Account Page Title:"+title);
	}


	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionTable) {
		List<String>expectedAccountSectionList=sectionTable.asList();
		System.out.println("The Actual Accounts Section Headers list is :"+expectedAccountSectionList);
		
		List<String>actualAccountSectionList=myaccountPage.sectionHeadersName();
		System.out.println("The Expected Accounts Section Headers list is :"+actualAccountSectionList);
	      
		Assert.assertTrue(expectedAccountSectionList.containsAll(actualAccountSectionList));

	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer sectionCount) {
	   Assert.assertTrue(myaccountPage.sectionHeadersCount()==sectionCount);
	}

}
