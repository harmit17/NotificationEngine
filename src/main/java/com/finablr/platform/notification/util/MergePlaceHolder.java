package com.finablr.platform.notification.util;

import java.util.Map;

public class MergePlaceHolder {
		
	public String replacePlaceholders(Map<String, String> templateData, String templateBody) {
		for(String key : templateData.keySet()) {
			templateBody = templateBody.replaceAll("\\{\\{"+key+"\\}\\}", templateData.get(key));
		}
		return templateBody;
	}

}
