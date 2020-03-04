package com.finablr.platform.notification.convert;

import javax.persistence.AttributeConverter;

public class typeconvert implements AttributeConverter<String, String>{

	@Override
	  public String convertToDatabaseColumn(String value) {
	      return value.concat(value);
	  }

	  @Override
	  public String convertToEntityAttribute(String key) {
	      return key.concat(key);
	  }
}
