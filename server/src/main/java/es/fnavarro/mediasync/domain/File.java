package es.fnavarro.mediasync.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.fnavarro.mediasync.domain.json.deserializer.FileDeserializer;
import es.fnavarro.mediasync.domain.json.serializer.FileSerializer;

@JsonSerialize(using=FileSerializer.class)
@JsonDeserialize(using=FileDeserializer.class)
public class File {
	
	private String name;
	private String path;
	private Long size;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	
	
	

}
