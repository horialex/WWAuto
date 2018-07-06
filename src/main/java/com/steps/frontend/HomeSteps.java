package com.steps.frontend;

import com.pages.HomePage;
import com.steps.AbstractSteps;
import net.thucydides.core.annotations.Step;

public class HomeSteps extends AbstractSteps {
	
	private static final long serialVersionUID = 1L;
	
	HomePage homePage;

    @Step
    public void clickLogin(){
        homePage.clickLogin();
    }
}
