package es.fnavarro.mediasync.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fnavarro.mediasync.mappers.ConfigMapper;
import es.fnavarro.mediasync.services.ISystemPropertiesService;

@Service("systemPropertiesService")
public class SystemPropertiesService implements ISystemPropertiesService {
	
	private ConfigMapper configMapper;
	
	private String adminPassword;
	private String remotePath;
	private String remoteIp;
	private String remoteUser;
	private String remotePassword;
	
	public ConfigMapper getConfigMapper() {
		return configMapper;
	}

	public void setConfigMapper(ConfigMapper configMapper) {
		this.configMapper = configMapper;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getRemotePath() {
		return remotePath;
	}

	public void setRemotePath(String remotePath) {
		this.remotePath = remotePath;
	}

	public String getRemoteIp() {
		return remoteIp;
	}

	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}

	public String getRemoteUser() {
		return remoteUser;
	}

	public void setRemoteUser(String remoteUser) {
		this.remoteUser = remoteUser;
	}

	public String getRemotePassword() {
		return remotePassword;
	}

	public void setRemotePassword(String remotePassword) {
		this.remotePassword = remotePassword;
	}

	@Autowired
	public SystemPropertiesService(ConfigMapper configMapper){
		this.configMapper = configMapper;
	}
	
	

}
