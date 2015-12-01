package es.fnavarro.mediasync.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.fnavarro.mediasync.domain.File;
import es.fnavarro.mediasync.services.IFileService;

@RestController
@RequestMapping(value = "/files")
public class FileController {
	
	private IFileService fileService;
	
	@Autowired
	public FileController(IFileService fileService) {
		this.fileService = fileService;
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<File> list(HttpServletRequest request) {	
		String status = request.getParameter("status");
		return fileService.list(status);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public void add(HttpServletRequest request, @RequestBody File file ) {		
		fileService.add(file);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	public void changeStatus( @PathVariable("id") long id,
			@RequestBody File file) {	
		fileService.changeStatus(id, file.getStatus().toUpperCase());
	}

}
