package es.fnavarro.mediasync.domain.json.serializer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import es.fnavarro.mediasync.domain.ConfigValue;
import es.fnavarro.mediasync.domain.SystemProperties;

public class SystemPropertiesSerializer extends JsonSerializer<SystemProperties> {


	@Override
	public void serialize(SystemProperties value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		final Map<String, Object> map = new HashMap<>();
		for(ConfigValue config : value.getList()) {
			map.put(config.getId(), config.getValue());
		}
		jgen.writeObject(map);
	}

}
