package com.steps.api;

import com.tools.constants.ApiUrlConstants;
import com.tools.constants.SerenityKeyConstants;
import com.tools.entities.Booking;
import com.tools.factories.BookingFactory;
import com.tools.utils.DateFormatter;
import com.tools.utils.SessionUtils;

import net.thucydides.core.annotations.Step;

public class ApiBookingSteps extends AbstractApiSteps {

	private static final long serialVersionUID = 1L;

	@Step
	public void bookItem() {
		Booking bookingRequest = BookingFactory.getApiBookingInstance();

		Booking bookingResponse = createResource(ApiUrlConstants.BOOKINGS, bookingRequest, Booking.class);
		bookingResponse.setStartDate(DateFormatter.formatDate(bookingResponse.getStartDate()));
		bookingResponse.setEndDate(DateFormatter.formatDate(bookingResponse.getEndDate()));

		//merge first
		SessionUtils.putOnSession(SerenityKeyConstants.BOOKING, bookingRequest);
	}
}
