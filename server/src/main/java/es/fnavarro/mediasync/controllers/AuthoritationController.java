package es.fnavarro.mediasync.controllers;

import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.fnavarro.mediasync.domain.Token;
import es.fnavarro.mediasync.exception.SystemException;
import es.fnavarro.mediasync.services.impl.SystemPropertiesService;

@RestController
@RequestMapping(value = "/authSession")
public class AuthoritationController {
	
	
	private SystemPropertiesService systemPropertiesService;
	private HashSet<Token> tokens;
	
	@Autowired
	public AuthoritationController( SystemPropertiesService systemPropertiesService){
		this.systemPropertiesService = systemPropertiesService;
		tokens = new HashSet<>();
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json" )
	public void list (){
		
	}
	
	@RequestMapping(value = "/{password}", method = RequestMethod.PUT, produces = "application/json" )
	public Token login ( @PathVariable("password") String password) throws SystemException{
		if( !isPasswordEmpty() ){
			if(systemPropertiesService.getAdminPassword().equals(password)){
				return newToken();
			}else{
				return null;
			}			
		}else{
			systemPropertiesService.setAdminPassword(password);
			return newToken();
		}
	}

	private boolean isPasswordEmpty() {
		return !(systemPropertiesService.getAdminPassword()!= null 
				&& systemPropertiesService.getAdminPassword().length()>0);
	}

	private Token newToken() {
		Token token = Token.createToken();
		tokens.add(token);
		return token;
	}
	
}
