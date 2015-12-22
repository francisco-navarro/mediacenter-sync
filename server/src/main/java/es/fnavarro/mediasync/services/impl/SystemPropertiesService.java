package es.fnavarro.mediasync.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fnavarro.mediasync.domain.ConfigValue;
import es.fnavarro.mediasync.mappers.ConfigMapper;
import es.fnavarro.mediasync.services.ISystemPropertiesService;

@Service("systemPropertiesService")
public class SystemPropertiesService extends BaseService implements ISystemPropertiesService {
	
	private ConfigMapper configMapper;
	
	String adminPassword;
	String remotePath;
	String remoteIp;
	String remoteUser;
	String remotePassword;	

	@Autowired
	public SystemPropertiesService(ConfigMapper configMapper){
		this.configMapper = configMapper;
		initProperties();
	}
	
	private void initProperties() {		
		adminPassword=createIfNotExists("adminPassword");
		remotePath=createIfNotExists("remotePath");
		remoteIp=createIfNotExists("remoteIp");
		remoteUser=createIfNotExists("remoteUser");
		remotePassword=createIfNotExists("remotePassword");	
	}
	
	private String createIfNotExists(String key){
		String value= configMapper.getProperty(key);
		if(value==null){
			configMapper.insertProperty(key, "");
		}
		return value;
	}
	
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

	public List<ConfigValue> getValues() {
		List<ConfigValue> list = new ArrayList<ConfigValue>();
		try{
			
			list.add(new ConfigValue("adminPassword",getAdminPassword()));
			list.add(new ConfigValue("remotePath", getRemotePath()));
			list.add(new ConfigValue("remoteIp",getRemoteIp()));
			list.add(new ConfigValue("remoteUser", getRemoteUser()));
			list.add(new ConfigValue("remotePassword",getRemotePassword()));	
			
		}catch(Exception e){
			logger.warn("Error fetching properties ",e);
		}
		return list;
	}
}
