package com.pages;


import java.util.List;

import org.openqa.selenium.By;

import com.tools.utils.StringHelpers;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ItemsPage extends AbstractPage {
    @FindBy(css="div[class*='list-container']")
    WebElementFacade itemsContainer;
    @FindBy(css="input[class*='booking_start_date']")
    WebElementFacade startDate;
    @FindBy(css="input[class*='booking_end_date']")
    WebElementFacade endDate;
    @FindBy(css="input[class*='booking_start_hour']")
    WebElementFacade startHour;
    @FindBy(css="input[class*='booking_end_hour']")
    WebElementFacade endHour;
    @FindBy(css="div[class*='picker-open']")
    WebElementFacade datePickerContainer;
    @FindBy (css="#create-booking-action")
    WebElementFacade save;
    @FindBy (css="div.ui-timepicker-wrapper")
    WebElementFacade hourContainer;
    @FindBy (css="div[class*='picker-open'] div.datepicker-months thead th.next")
    WebElementFacade nextYear;

    public void saveBooking(){
        save.click();
        // TO DO ensure form was saved - maybe success message
    }

    // TODO faceti 2 metode, una care doar returneaza un item, a doua care da
 	// click pe el sa se bazeze pe prima. Poate mai tarziu e nevoie de altceva decat click
    public void clickBookItem(String itemName){
        List<WebElementFacade> itemList = itemsContainer.thenFindAll(By.cssSelector("div[class='white-box clearfix single-item']"));
        for(WebElementFacade item : itemList){
            String it = item.findBy(By.cssSelector("h3 a")).getText().trim();
            if(it.contentEquals(itemName)){
                WebElementFacade bookButton = item.find(By.cssSelector("button"));
                bookButton.click();
                break;
            }
        }
    }

    /** this is for the cases where you
    * don't want some of the steps to
    * appear in report.
    * otherwise the methods inside can
    * be annotated in steps*/
    //TODO daca nu vrei sa apara in raport de ce nu le chemi direct din page ? 
    public void selectStartDate(String date){
        startDate.click();
        selectYear(date);
        selectMonth(date);
        selectDay(date);
    }

    public void selectEndDate(String date){
        endDate.click();
        selectYear(date);
        selectMonth(date);
        selectDay(date);
    }

    public void selectStartHour(String hour){
        startHour.click();
        selectHour(hour.split(",")[1].trim());
    }

    public void selectEndHour(String hour){
        endHour.click();
        selectHour(hour.split(",")[1].trim());
    }

    public void selectMonth(String date){
        String m = date.split(",")[0].split(" ")[0];
        List<WebElementFacade> monthList = datePickerContainer.thenFindAll(By.cssSelector("div.datepicker-months tbody span"));
        for(WebElementFacade month : monthList){
            if(month.getText().contentEquals(m)){
                month.click();
                break;
            }
        }
    }

    public void selectYear(String date){
        datePickerContainer.find(By.cssSelector("div.datepicker-days thead th.picker-switch")).click();
        String providedYear = date.split(",")[0].split(" ")[2];
        String displayedYear = datePickerContainer.find(By.cssSelector("div.datepicker-months thead th.picker-switch")).getText();
        System.out.println(displayedYear);
        int noOfNext = Integer.valueOf(providedYear) - Integer.valueOf(displayedYear);
        for(int i = 0; i < noOfNext; i++){
            displayedYear = datePickerContainer.find(By.cssSelector("div.datepicker-months thead th.picker-switch")).getText();
            if(!displayedYear.contentEquals(providedYear)){
                nextYear.click();
            }
        }
    }

    public void selectDay(String date){
        String d = date.split(",")[0].split(" ")[1];
        List<WebElementFacade> dayList = datePickerContainer.thenFindAll(By.cssSelector("div.datepicker-days tbody tr td[class='day']"));
        for(WebElementFacade day : dayList){
            if(day.getText().contentEquals(StringHelpers.cleanZeroLeadingStrings(d))){
                day.click();
                break;
            }
        }
    }

    public void selectHour(String hour){
        List<WebElementFacade> hourList = hourContainer.thenFindAll(By.cssSelector("ul li"));
        for(WebElementFacade h : hourList){
            if(h.getText().contains(hour)){
                h.click();
                break;
            }
        }
    }
}