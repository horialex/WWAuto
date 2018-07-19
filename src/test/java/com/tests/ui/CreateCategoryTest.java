package com.tests.ui;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.api.ApiCategorySteps;
import com.steps.api.ApiLoginSteps;
import com.steps.frontend.CategorySteps;
import com.steps.frontend.HeaderSteps;
import com.steps.frontend.HomeSteps;
import com.steps.frontend.LoginSteps;
import com.tests.BaseTest;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class CreateCategoryTest extends BaseTest {

	@Steps
	LoginSteps loginSteps;
	@Steps
	public ApiLoginSteps apiLoginStepsSteps;
	@Steps
	ApiCategorySteps apiCategoryStepsSteps;
	@Steps
	HeaderSteps headerSteps;
	@Steps
	CategorySteps categorySteps;
	@Steps
	HomeSteps homePageSteps;

	@Before
	public void testPreparation() throws Exception {
		apiLoginStepsSteps.loginAsAdmin();
		apiCategoryStepsSteps.removeAllCategories();
		apiCategoryStepsSteps.createCategory();
		
	}

	@Test
	public void createCategoryTest() {
		homePageSteps.getHomePage();
		loginSteps.loginAsAdmin();
		headerSteps.goTo("ITEMS");
		categorySteps.verifyCategoryIsPresent();
	}

}
