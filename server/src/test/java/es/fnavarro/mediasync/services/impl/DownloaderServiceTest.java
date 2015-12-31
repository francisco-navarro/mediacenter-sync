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
		File localPath = new File(".");
		File file = createFile(localPath, filename);
		//Act
		downloaderService.download(filename, localPath.getAbsolutePath());
	}

	private File createFile(File localPath, String filename) throws IOException {
		File file = new File(localPath.getAbsolutePath().replace(".", filename));
		if(!file.exists()){
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file);		
//		for(char c : )
//			System.out.print(c); //prints the characters one by one
//		fr.close();
		return file;
	}
}
