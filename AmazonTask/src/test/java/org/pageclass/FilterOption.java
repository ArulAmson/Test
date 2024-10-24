package org.pageclass;

import java.util.ArrayList;
import java.util.List;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterOption extends BaseClass {
	public FilterOption() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "span.a-text-normal")
	private List<WebElement> Brand;

	public List<WebElement> getBrand() {
		return Brand;
	}

}
