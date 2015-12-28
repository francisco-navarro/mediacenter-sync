package es.fnavarro.mediasync.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.fnavarro.mediasync.domain.SystemProperties;
import es.fnavarro.mediasync.services.impl.SystemPropertiesService;

@RestController
@RequestMapping(value = "/configuration")
public class ConfigurationController {
	
	
	private SystemPropertiesService systemPropertiesService;
	
	@Autowired
	public ConfigurationController( SystemPropertiesService systemPropertiesService){
		this.systemPropertiesService = systemPropertiesService;
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public SystemProperties get() {		
		return new SystemProperties(systemPropertiesService.getValues());
	}
	
}
