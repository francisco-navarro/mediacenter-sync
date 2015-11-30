package es.fnavarro.mediasync.domain.json.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import es.fnavarro.mediasync.domain.File;

public class FileDeserializer extends JsonDeserializer<File>{

	@Override
	public File deserialize(JsonParser json, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
		final JsonNode root = json.getCodec().readTree(json);
		File file = new File();
		
		file.setName(root.get("name").asText());
		file.setPath(root.get("path").asText());
		file.setSize(root.get("size").asLong());
		return file;
	}

}
