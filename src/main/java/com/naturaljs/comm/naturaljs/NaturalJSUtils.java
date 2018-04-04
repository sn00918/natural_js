package com.naturaljs.comm.naturaljs;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NaturalJSUtils {
	public static Map<String, Object> convertQParamToMap(String q) throws Exception {
		if(q == null) {
			return new HashMap<String, Object>();
		}
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(URLDecoder.decode(q, "UTF-8"), new TypeReference<Map<String, Object>>() { });
	}
}
