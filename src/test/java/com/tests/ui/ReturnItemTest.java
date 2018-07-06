package com.tests.ui;

import com.steps.api.ApiBookingSteps;
import com.steps.api.flow_steps.ApiCreateItemFlowSteps;
import com.steps.frontend.*;
import com.steps.frontend.flow_steps.ItemBookingSteps;
import com.steps.validations.ItemValidationSteps;
import com.tests.BaseTest;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class ReturnItemTest extends BaseTest {
	@Steps
	LoginSteps loginSteps;
	@Steps
	ItemValidationSteps itemValidationSteps;
	@Steps
	ItemBookingSteps itemBookingSteps;
	@Steps
	ApiCreateItemFlowSteps apiCreateItemFlowSteps;
	@Steps
	ApiBookingSteps apiBookingSteps;

	@Before
	public void setUp() {
		apiCreateItemFlowSteps.createItem();
		apiBookingSteps.bookItem();
	}

	@Test
	public void returnItemTest()
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

		loginSteps.login();
		itemBookingSteps.goToUser();
		itemBookingSteps.returnItem();
		itemValidationSteps.validateItemIsReturned();
	}
}
