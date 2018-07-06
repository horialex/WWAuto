package com.tools.utils;

import net.serenitybdd.core.Serenity;

public class SessionUtils {

	public static Object getFromSession(String key) {
		return Serenity.getCurrentSession().get(key);
	}

	public static void putOnSession(String key, Object object) {
		Serenity.getCurrentSession().put(key, object);
	}
}
