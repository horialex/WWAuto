package com.tests.ui;

import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.api.flow_steps.ApiCreateItemFlowSteps;
import com.steps.frontend.LoginSteps;
import com.steps.frontend.flow_steps.ItemBookingSteps;
import com.steps.validations.ItemValidationSteps;
import com.tests.BaseTest;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class BookItemTest extends BaseTest {
	@Steps
	LoginSteps loginSteps;
	@Steps
	ItemValidationSteps itemValidationSteps;
	@Steps
	ItemBookingSteps itemBookingSteps;
	@Steps
	ApiCreateItemFlowSteps apiCreateItemFlowSteps;

	@Before
	public void setUp() {
		apiCreateItemFlowSteps.createItem();
	}

	@Test
	public void bookItemTest()
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

		loginSteps.login();
		itemBookingSteps.bookItem();
		itemBookingSteps.goToUser();
		itemValidationSteps.validateItemIsBooked();
	}
}
