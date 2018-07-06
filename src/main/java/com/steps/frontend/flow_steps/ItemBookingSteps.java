package com.steps.frontend.flow_steps;

import com.steps.frontend.BookingsSteps;
import com.steps.frontend.CategorySteps;
import com.steps.frontend.HeaderSteps;
import com.steps.frontend.ItemSteps;
import com.steps.frontend.UsersSteps;

import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.Steps;

public class ItemBookingSteps {
    @Steps
    HeaderSteps headerSteps;
    @Steps
    CategorySteps categorySteps;
    @Steps
    ItemSteps itemSteps;
    @Steps
    UsersSteps usersSteps;
    @Steps
    BookingsSteps bookingsSteps;

    @StepGroup
    public void bookItem(){
        headerSteps.goTo("ITEMS");
        categorySteps.selectCategory();
        itemSteps.bookItem();
    }
    
    @StepGroup
    public void goToUser(){
        headerSteps.goTo("USERS");
        usersSteps.selectUser();
    }

    @StepGroup
    public void returnItem(){
        bookingsSteps.returnItem();
    }

}
