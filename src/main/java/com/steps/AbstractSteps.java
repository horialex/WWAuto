package com.steps;

import com.tools.constants.EnvironmentConstants;

import net.thucydides.core.steps.ScenarioSteps;

public class AbstractSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;

	/*public DictionaryPage getHeaderPage() {

		switch (System.getProperty("runPlatform")) {

		case "desktop":
			return getPages().currentPageAt(DictionaryPage.class);
		case "mobile":
			// mobile page object to be returned here
			return getPages().currentPageAt(DictionaryPage.class);
		default:
			return null;
		}
	}*/

	//TODO navigheaza unde ? daca url-ul e fix, ca si in cazul atsa, denumiti sugestiv (navigateToBaseUrl)
	//TODO nu e nici Abstract, nu are ce cauta aici 
	public void navigate(){
		getDriver().get(EnvironmentConstants.BASE_URL);
		getDriver().manage().window().maximize();
	}

}
