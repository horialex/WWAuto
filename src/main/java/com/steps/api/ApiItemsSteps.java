package com.steps.api;

import com.tools.constants.ApiUrlConstants;
import com.tools.constants.SerenityKeyConstants;
import com.tools.entities.Items;
import com.tools.factories.ItemFactory;
import com.tools.utils.MergeUtils;
import com.tools.utils.SessionUtils;

import net.thucydides.core.annotations.Step;

public class ApiItemsSteps extends AbstractApiSteps {

	private static final long serialVersionUID = 1L;

    @Step
    public void createCategoryItem() throws IllegalAccessException, InstantiationException {
        Items itemsRequest = ItemFactory.getCategoryItemsInstance();
        Items itemsResponse = createResource(ApiUrlConstants.ITEMS, itemsRequest, Items.class);
        itemsRequest = MergeUtils.mergeObjects(itemsRequest, itemsResponse);
        SessionUtils.putOnSession(SerenityKeyConstants.ITEM, itemsRequest);
    }
    
}
