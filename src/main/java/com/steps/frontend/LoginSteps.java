package com.steps.frontend;

import com.pages.LoginPage;
import com.steps.AbstractSteps;
import com.tools.constants.SerenityKeyConstants;
import com.tools.entities.User;
import com.tools.utils.SessionUtils;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.Steps;

public class LoginSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	@Steps
	HomeSteps homeSteps;

	LoginPage loginPage;

	// TODO navigate to baseurl nu l-as baga in login, as face step separat
	// inainte de login
	// TODO nu cred ca e nevoie sa faci stepi separati pt enterEmail,
	// enterPasswordm,submit.
	// Faceti un step de login() care sa cheme 3 cele 3 metode direct din page.
	@StepGroup
	public void login() {
		User user = (User) SessionUtils.getFromSession(SerenityKeyConstants.USER);
		homeSteps.getHomePage();
		homeSteps.clickLogin();
		System.out.println("Password este : " + user.getPassword());
		login(user.getEmail(), user.getPassword());
	}
	
	@Step
	public void login(String email, String password) {
		loginPage.login(email, password);
	}
}
