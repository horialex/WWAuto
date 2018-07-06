package com.pages;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;

public class AbstractPage extends PageObject {

	// TODO nu cred ca e nevoie de return la un wait
	public List<WebElement> waitForElementsByCssLocator(String cssLocator) {
		return (new WebDriverWait(getDriver(), 20))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(cssLocator)));
	}

	// TODO bagati soft assert aici de vreti
	public <T> void verifyObjects(T obj1, T obj2)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

		for (Field field : obj1.getClass().getDeclaredFields()) {

			field.setAccessible(true);

			if (field.get(obj1) == null) {
				Assert.assertNull(field.get(obj2));

			} else {
				Assert.assertTrue(
						"<< " + field.getName() + " >> doesn't match !! Expected : " + field.get(obj1) + " Actual "
								+ field.get(obj2),
						((String) (field.get(obj2))).contentEquals((String) field.get(obj1)));
			}
		}
	}

	// TODO bagati soft assert aici de vreti
	public <T> void verifyObjectsIgnoreNull(T obj1, T obj2)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

		for (Field field : obj1.getClass().getDeclaredFields()) {

			field.setAccessible(true);

			if (!(field.get(obj1) == null && field.get(obj2) == null)) {
				Assert.assertTrue("<< " + field.getName() + " >> doesn't match !! Expected : " + field.get(obj1)
						+ " Actual " + field.get(obj2),
						((String) (field.get(obj2))).contains((String) field.get(obj1)));
			}
		}
	}

	// TODO poate fi folosita cand vrei sa populezi requestul cu date
	// sumplimentare ce vin pe response, de ex id-ul. Obj1 = request, obj2 =
	// response
	public static Object mergeObjects(Object obj1, Object obj2) throws Exception {
		Field[] allFields = obj1.getClass().getDeclaredFields();
		for (Field field : allFields) {

			field.setAccessible(true);

			if (field.get(obj1) == null && field.get(obj2) != null) {
				field.set(obj1, field.get(obj2));
			}
		}
		return obj1;
	}

}
