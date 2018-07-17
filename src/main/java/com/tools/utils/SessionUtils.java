package com.tools.utils;

import java.util.ArrayList;
import java.util.List;

import net.serenitybdd.core.Serenity;

public class SessionUtils {

	public static Object getFromSession(String key) {
		return Serenity.getCurrentSession().get(key);
	}

	public static void putOnSession(String key, Object object) {
		Serenity.getCurrentSession().put(key, object);
	}

	public static void saveObjectListInSerenitySession(String key, Object obj) {
		if (!Serenity.getCurrentSession().containsKey(key)) {
			Serenity.getCurrentSession().put(key, new ArrayList<>());
		}
		((List<Object>) Serenity.getCurrentSession().get(key)).add(obj);
	}
}
