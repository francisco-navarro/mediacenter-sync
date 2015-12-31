package es.fnavarro.mediasync.services.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class DownloaderServiceTest {

	//SUT
	private DownloaderService downloaderService;

	private SystemPropertiesService systemPropertiesService;

	@Before
	public void init(){
		systemPropertiesService = mock(SystemPropertiesService.class) ;
		downloaderService = new DownloaderService(systemPropertiesService);
		//Arrange
		when(systemPropertiesService.getRemoteIp()).thenReturn("localhost");
		when(systemPropertiesService.getRemoteUser()).thenReturn("fjnavarrol");
		when(systemPropertiesService.getRemotePassword()).thenReturn("56fjnavarrol");
		when(systemPropertiesService.getRemotePath()).thenReturn("");
	}

	@Test
	public void givenFileWhenUploadThenCreateInRemote() throws IOException{
		//Arrange
		String filename = "textfile.txt";
		String localPath = new File(".").getAbsolutePath().replace(".","");
		File file = createFile(localPath, filename);
		//Act
		downloaderService.download(filename, localPath);
	}

	private File createFile(String localPath, String filename) throws IOException {
		File file = new File(localPath + filename);
		if(!file.exists()){
			file.createNewFile();
		}
		writeString(file,"some text");
		return file;
	}

	private void writeString(File file, String str) throws IOException {
		FileWriter fw = new FileWriter(file);		
		for(byte c : str.getBytes()){
			fw.write(c);
		}
		fw.close();
	}
}
