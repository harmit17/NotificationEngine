package com.finablr.platform.notification.convert;

import java.io.IOException;
import java.util.Map;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.apache.logging.log4j.util.Strings;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finablr.platform.notification.exceptionhandler.model.BadInputException;



@Converter
public class TypeConvert implements AttributeConverter<Map<String, String>, String> {

	static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
	@Override
	public String convertToDatabaseColumn(Map<String, String> attribute) {
		 if (attribute == null) {
	            return null;
	        }

	        try {
	            return OBJECT_MAPPER.writeValueAsString(attribute);
	        } catch (IOException e) {
	            throw new BadInputException("Failed to convert map to JSON string.");
	        }
	}

	@Override
	public Map<String, String> convertToEntityAttribute(String dbData) {
		if (Strings.isEmpty(dbData)) {
            return null;
        }
        try {
            return OBJECT_MAPPER.readValue(dbData, Map.class);
        } catch (IOException e) {
            throw new BadInputException("Failed to convert JSON string to map.");
        }
	}
}
