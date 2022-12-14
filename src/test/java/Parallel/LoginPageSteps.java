package Parallel;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.*;

public class LoginPageSteps {

	private LoginPage loginpage=new LoginPage(DriverFactory.getDriver());
	private String title;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication");
	}

	@When("user gets the tite of the page")
	public void user_gets_the_tite_of_the_page() {
	  title=loginpage.getLoginPageTitle();
	  System.out.println("Page title is:" +title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
	 Assert.assertTrue(title.contains(expectedTitle));
	}

	@Then("forgot your password  link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginpage.isForgotPwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String usname){
	    loginpage.enterUserName(usname);
	}

	@When("user enters password {string}")
	public void user_enters_password(String pswd) {
	    loginpage.enterPassword(pswd);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
	   loginpage.clickLoginButton();
	}

}
