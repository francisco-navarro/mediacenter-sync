package es.fnavarro.mediasync.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.fnavarro.mediasync.domain.File;
import es.fnavarro.mediasync.mappers.FileMapper;
import es.fnavarro.mediasync.services.IFileService;

@Transactional
@Service("fileService")
public class FileService implements IFileService {
	
	private FileMapper fileMapper;
	private DownloaderService downloaderService;
	
	@Autowired
	public FileService(FileMapper fileMapper, DownloaderService downloaderService){
		this.fileMapper = fileMapper;
		this.downloaderService = downloaderService;
	}

	@Override
	public void add(File file) {
		fileMapper.add(file);
	}

	@Override
	public List<File> list(String status) {
		return fileMapper.list(status);
	}

	@Override
	public void changeStatus(long id, String status) {
		fileMapper.changeStatus(id,status);
	}

	@Override
	public void changeName(long id, String name) {
		
	}

	@Transactional
	public void save(File file) {		
		changeStatus(file.getId(), "DOWNLOADING");
		downloaderService.download(file.getName(),file.getPath());
	} 

}
