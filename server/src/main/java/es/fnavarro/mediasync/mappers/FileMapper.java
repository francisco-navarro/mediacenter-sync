package es.fnavarro.mediasync.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import es.fnavarro.mediasync.domain.File;

public interface FileMapper extends MapperBase {

	void add(@Param("file") File file);

	List<File> list(@Param("status") String status );

	void changeStatus(@Param("id")long id, @Param("status") String status);

}
