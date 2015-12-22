package es.fnavarro.mediasync.domain.json.serializer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import es.fnavarro.mediasync.domain.ConfigValue;
import es.fnavarro.mediasync.domain.File;

public class ConfigValueSerializer extends JsonSerializer<ConfigValue> {


	@Override
	public void serialize(ConfigValue value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		final Map<String, Object> map = new HashMap<>();
		map.put(value.getId(), value.getValue());
		jgen.writeObject(map);
	}

}
