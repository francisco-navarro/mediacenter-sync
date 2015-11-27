package es.fnavarro.mediasync.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fnavarro.mediasync.mappers.FileMapper;
import es.fnavarro.mediasync.services.IFileService;

@Service("fileService")
public class FileService implements IFileService {
	
	private FileMapper fileMapper;
	
	@Autowired
	public FileService(FileMapper fileMapper){
		this.fileMapper =fileMapper;
	}
	

}
