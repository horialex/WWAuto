package com.steps.frontend;

import com.pages.CategoriesPage;
import com.steps.AbstractSteps;
import com.tools.constants.SerenityKeyConstants;
import com.tools.entities.Category;
import com.tools.utils.SessionUtils;

import net.thucydides.core.annotations.Step;

public class CategorySteps extends AbstractSteps {
    
	private static final long serialVersionUID = 1L;
	
	CategoriesPage categoriesPage;

    @Step
    public void selectCategory(){
        Category category =  (Category) SessionUtils.getFromSession(SerenityKeyConstants.CATEGORY);
        categoriesPage.selectCategory(category.getName());
    }
}
