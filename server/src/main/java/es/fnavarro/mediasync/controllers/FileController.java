package es.fnavarro.mediasync.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.fnavarro.mediasync.domain.File;
import es.fnavarro.mediasync.services.IFileService;

@RestController
@RequestMapping(value = "/files/")
public class FileController {
	
	private IFileService fileService;
	
	@Autowired
	public FileController(IFileService fileService) {
		this.fileService = fileService;
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<File> list(HttpServletRequest request) {		
		return fileService.list();
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public void add(HttpServletRequest request, @RequestBody File file ) {
		
		fileService.add(file);
	}

}
