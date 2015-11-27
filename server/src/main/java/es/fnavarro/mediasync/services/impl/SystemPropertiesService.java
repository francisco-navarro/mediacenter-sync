package es.fnavarro.mediasync.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fnavarro.mediasync.mappers.ConfigMapper;
import es.fnavarro.mediasync.services.ISystemPropertiesService;

@Service("systemPropertiesService")
public class SystemPropertiesService implements ISystemPropertiesService {
	
	
	private ConfigMapper configMapper;
	
	@Autowired
	public SystemPropertiesService(ConfigMapper configMapper){
		this.configMapper = configMapper;
	}

}
