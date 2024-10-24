package org.pageclass;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='nav-search']/descendant::input[@id='twotabsearchtextbox']")
	private WebElement Search;

	public WebElement getSearch() {
		return Search;
	}

	@FindBy(xpath = "//select[@aria-describedby='searchDropdownDescription']/option[text()='Electronics']")
	private WebElement Select;

	public WebElement getSelect() {
		return Select;
	}

	@FindBy(xpath = "//div[@id='nav-search']/descendant::input[@value='Go']")
	private WebElement Nextpage;

	public WebElement getNextpage() {
		return Nextpage;
	}

}
