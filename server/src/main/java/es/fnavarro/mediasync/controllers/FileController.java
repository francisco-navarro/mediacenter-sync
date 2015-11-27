package es.fnavarro.mediasync.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileController {	

	@RequestMapping(value = "/files/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void list(HttpServletRequest request) {
		
	}

}
