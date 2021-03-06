package es.fnavarro.mediasync.domain;

import java.io.Serializable;

public class ConfigValue implements Serializable{
	
	private String id;
	private String value;
	
	public ConfigValue(String id, String value) {
		this.id = id;
		this.value=value;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Config [" + id + "=" + value + "]";
	}
	
}
