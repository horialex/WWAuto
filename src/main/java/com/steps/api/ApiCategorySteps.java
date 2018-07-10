package com.steps.api;

import com.tools.constants.ApiUrlConstants;
import com.tools.constants.SerenityKeyConstants;
import com.tools.entities.Category;
import com.tools.factories.CategoryFactory;
import com.tools.utils.MergeUtils;
import com.tools.utils.SessionUtils;

import net.thucydides.core.annotations.Step;

public class ApiCategorySteps extends AbstractApiSteps {

	private static final long serialVersionUID = 1L;

	@Step
	public void createCategory() throws IllegalAccessException, InstantiationException {
		Category categoryRequest = CategoryFactory.getCategoryInstance();
		Category categoryResponse = createResource(ApiUrlConstants.CATEGORIES, categoryRequest, Category.class);
		categoryRequest= MergeUtils.mergeObjects(categoryRequest, categoryResponse);
		System.out.println("ID " + categoryRequest.getId());
		SessionUtils.putOnSession(SerenityKeyConstants.CATEGORY, categoryRequest);
	}
}
