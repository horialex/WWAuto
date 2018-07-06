package com.steps.api;

import com.tools.constants.ApiUrlConstants;
import com.tools.constants.SerenityKeyConstants;
import com.tools.entities.Items;
import com.tools.factories.ItemFactory;
import com.tools.utils.SessionUtils;

import net.thucydides.core.annotations.Step;

public class ApiItemsSteps extends AbstractApiSteps {

	private static final long serialVersionUID = 1L;

    @Step
    public void createCategoryItem() {

        Items itemsRequest = ItemFactory.getCategoryItemsInstance();
        Items itemsResponse = createResource(ApiUrlConstants.ITEMS, itemsRequest, Items.class);
        itemsRequest.setId(itemsResponse.getId());

        SessionUtils.putOnSession(SerenityKeyConstants.ITEM, itemsRequest);
    }
    
}
