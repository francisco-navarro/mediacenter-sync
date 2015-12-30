package es.fnavarro.mediasync.domain.json.deserializer;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import es.fnavarro.mediasync.domain.ConfigValue;
import es.fnavarro.mediasync.domain.SystemProperties;

public class SystemPropertiesDeserializer extends JsonDeserializer<SystemProperties> {


	@Override
	public SystemProperties deserialize(JsonParser json, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		SystemProperties properties = new SystemProperties();
		properties.setList(new ArrayList<>());
		
		final JsonNode root = json.getCodec().readTree(json);
		
		addProperty(properties, root,"remoteUser");
		addProperty(properties, root,"remoteIp");
		addProperty(properties, root,"remotePath");
		addProperty(properties, root,"remotePassword");
		addProperty(properties, root,"adminPassword");
		
		return properties;
	}

	private void addProperty(SystemProperties properties, final JsonNode root, String value) {
		ConfigValue configValue = new ConfigValue(value, root.get(value).asText());
		properties.getList().add(configValue);
	}

}
