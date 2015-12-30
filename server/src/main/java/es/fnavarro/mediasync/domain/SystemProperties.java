package es.fnavarro.mediasync.domain;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.fnavarro.mediasync.domain.json.deserializer.SystemPropertiesDeserializer;
import es.fnavarro.mediasync.domain.json.serializer.SystemPropertiesSerializer;

@JsonDeserialize(using=SystemPropertiesDeserializer.class)
@JsonSerialize(using=SystemPropertiesSerializer.class)
public class SystemProperties {
	
	private List<ConfigValue> list;

	public SystemProperties(){		
	}

	public SystemProperties(List<ConfigValue> values) {
		this.list = values;
	}

	public List<ConfigValue> getList() {
		return list;
	}

	public void setList(List<ConfigValue> list) {
		this.list = list;
	}
	
	

}
