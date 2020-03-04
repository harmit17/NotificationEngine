package com.finablr.platform.notification.convert;

import java.util.Map;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.postgresql.util.HStoreConverter;


@Converter
public class TypeConvert implements AttributeConverter<Map<String, String>, String> {

	@Override
	public String convertToDatabaseColumn(Map<String, String> attribute) {
		return HStoreConverter.toString(attribute);
	}

	@Override
	public Map<String, String> convertToEntityAttribute(String dbData) {
		return HStoreConverter.fromString(dbData);
	}
}
