package com.steps.api;

import com.tools.constants.ApiUrlConstants;
import com.tools.constants.SerenityKeyConstants;
import com.tools.entities.Category;
import com.tools.factories.CategoryFactory;
import com.tools.utils.SessionUtils;

import net.thucydides.core.annotations.Step;

public class ApiCategorySteps extends AbstractApiSteps {

	private static final long serialVersionUID = 1L;

	@Step
	public void createCategory() {
		Category categoryRequest = CategoryFactory.getCategoryInstance();
		Category categoryResponse = createResource(ApiUrlConstants.CATEGORIES, categoryRequest, Category.class);

		// TODO aici e intrebarea : ce salvam pe sesiune ? In mod normal ar
		// trebui salvat requestul, pentru ca acela reprezinta datele de intrare
		// si stim sigur ca sunt corecte . Dar totodata, requestul nu e de
		// ajuns, de exemplu id-ul fiecarei entitati, cel generat automat de DB,
		// il gasesti
		// doar pe response. Poate nu e cel mai bun exemplu, avand in vedere ca
		// pt utilizator id-ul acela generat nu reprezinta mai nimic, totusi
		// se mai foloseste la cautari etc.
		// Eu as zice sa salvam requestul, dar inainte de a-l salva, sa-i
		// populam campurile lipsa cu informatiile venite de pe response,
		// informatii generate de cele mai multe ori si pt care nu avem nevoie
		// sa le validam (nici nu avem cum)
		// Este deja un exemplu foarte bun in metoda createCategoryItem() din
		// ApiItemsSteps
		
		//TODO merge objects with mergeObjects
		SessionUtils.putOnSession(SerenityKeyConstants.CATEGORY, categoryRequest);
	}
}
