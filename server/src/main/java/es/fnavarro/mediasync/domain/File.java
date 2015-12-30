package es.fnavarro.mediasync.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import es.fnavarro.mediasync.domain.json.deserializer.FileDeserializer;

@JsonDeserialize(using=FileDeserializer.class)
public class File {
	
	private Long id;
	private String name;
	private String path;
	private Long size;
	private Boolean saved;
	private Boolean discarded;
	private String status;
	
	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getSaved() {
		return saved;
	}
	public void setSaved(Boolean saved) {
		this.saved = saved;
	}
	public Boolean getDiscarded() {
		return discarded;
	}
	public void setDiscarded(Boolean discarded) {
		this.discarded = discarded;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public java.io.File getFile(){
		return new java.io.File(path+name);
	}
	

}
