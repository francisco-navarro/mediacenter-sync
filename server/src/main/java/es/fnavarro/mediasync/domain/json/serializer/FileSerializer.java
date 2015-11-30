package es.fnavarro.mediasync.domain.json.serializer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import es.fnavarro.mediasync.domain.File;


public class FileSerializer  extends JsonSerializer<File> {

	@Override
	public void serialize(File value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		
		final Map<String, Object> map = new HashMap<>();
		map.put("name", value.getName());
		map.put("path", value.getPath());
		map.put("size", value.getSize());
		jgen.writeObject(map);
	}

}
