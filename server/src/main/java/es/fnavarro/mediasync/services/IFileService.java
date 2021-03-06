package es.fnavarro.mediasync.services;

import java.util.List;

import es.fnavarro.mediasync.domain.File;

public interface IFileService {

	void add(File file);

	List<File> list(String status);

	void changeStatus(long id, String status);

	void changeName(long id, String name);

}
