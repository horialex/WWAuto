package com.steps.frontend;

import com.pages.ItemsPage;
import com.steps.AbstractSteps;
import com.tools.constants.SerenityKeyConstants;
import com.tools.entities.Booking;
import com.tools.factories.BookingFactory;
import com.tools.utils.SessionUtils;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class ItemSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	ItemsPage itemsPage;

	// TODO eu nici aici nu as chema stepi, ci direct din page metodele.Se
	// pierde mult timp cu Starting Step--EndingStep
	@StepGroup
	public void bookItem() {
		Booking booking = BookingFactory.getBookingInstance();
		clickBookItem(booking.getItem().getTitle());
		selectStartDate(booking.getStartDate());
		selectStartHour(booking.getStartDate());
		selectEndDate(booking.getEndDate());
		selectEndHour(booking.getEndDate());
		saveBooking();
		SessionUtils.putOnSession(SerenityKeyConstants.BOOKING, booking);
	}

	@Step
	public void selectStartHour(String startHour) {
		itemsPage.selectStartHour(startHour);
	}

	@Step
	public void selectEndHour(String endHour) {
		itemsPage.selectEndHour(endHour);
	}

	@Step
	public void clickBookItem(String itemName) {
		itemsPage.clickBookItem(itemName);

	}

	@Step
	public void selectStartDate(String startDate) {
		itemsPage.selectStartDate(startDate);
	}

	@Step
	public void selectEndDate(String endDate) {
		itemsPage.selectEndDate(endDate);
	}

	@Step
	public void saveBooking() {
		itemsPage.saveBooking();
	}
}
