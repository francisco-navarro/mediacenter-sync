package es.fnavarro.mediasync.mappers;

import org.apache.ibatis.annotations.Param;

public interface ConfigMapper extends MapperBase {
	
	public String getProperty(@Param("property") String property);
	
	public void updateProperty(@Param("property") String property, @Param("value") String value);
	
	public void insertProperty(@Param("property") String property, @Param("value")  String value);

}
