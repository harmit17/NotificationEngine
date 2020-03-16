package com.finablr.platform.notification.util;

import java.util.Map;

import com.finablr.platform.notification.exceptionhandler.model.DataNotFoundException;

public class MergePlaceHolder {
		
	public static String replacePlaceholders(Map<String, String> templateData, String templateBody) {
		if(templateData==null || templateBody==null) {
			throw new DataNotFoundException("Found null objects");		//will change to proper exception class
		}
		if(templateData.isEmpty()||templateBody.isEmpty()) {
			return templateBody;
		}
		for(String key : templateData.keySet()) {
			templateBody = templateBody.replaceAll("\\{\\{"+key+"\\}\\}", templateData.get(key));
		}
		return templateBody;
	}

}
