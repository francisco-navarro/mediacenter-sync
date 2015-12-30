package es.fnavarro.mediasync.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import es.fnavarro.mediasync.domain.File;

@Component
public class WorkerService extends BaseService{

	private FileService fileService;

	@Autowired
	public WorkerService(FileService fileService){
		this.fileService = fileService;		
	}

	@Scheduled(cron="0/30 * * * * ?")
	public void downloadJob(){		
		List<File> files = fileService.list("DOWNLOAD");
		if(files.size()>0){
			//Get the first and save
			fileService.save(files.get(0));
		}
	}

}
