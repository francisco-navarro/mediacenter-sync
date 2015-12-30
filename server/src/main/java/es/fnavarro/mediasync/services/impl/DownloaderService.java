package es.fnavarro.mediasync.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.Selectors;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fnavarro.mediasync.services.IDownloaderService;

@Service("downloaderService")
public class DownloaderService extends BaseService implements IDownloaderService{

	private SystemPropertiesService systemPropertiesService; 
	private static Properties props;

	@Autowired
	public DownloaderService(SystemPropertiesService systemPropertiesService){
		this.systemPropertiesService = systemPropertiesService;
	}

	@Override
	public void download(String name, String path) {
		startFTP(name, path);
	}


	public boolean startFTP(String name, String path){

		StandardFileSystemManager manager = new StandardFileSystemManager();

		try {

			
			String serverAddress = systemPropertiesService.getRemoteIp();
			String userId = systemPropertiesService.getRemoteUser();
			String password = systemPropertiesService.getRemotePassword();
			String remoteDirectory = systemPropertiesService.getRemotePath();


			//check if the file exists
			String filepath = path +  name;
			File file = new File(filepath);
			if (!file.exists()){
				throw new RuntimeException("Error. Local file not found");
			}

			//Initializes the file manager
			manager.init();

			//Setup our SFTP configuration
			FileSystemOptions opts = new FileSystemOptions();
			SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(
					opts, "no");
			SftpFileSystemConfigBuilder.getInstance().setUserDirIsRoot(opts, true);
			SftpFileSystemConfigBuilder.getInstance().setTimeout(opts, 10000);

			//Create the SFTP URI using the host name, userid, password,  remote path and file name
			String sftpUri = "sftp://" + userId + ":" + password +  "@" + serverAddress + "/" + 
					remoteDirectory + name;

			// Create local file object
			FileObject localFile = manager.resolveFile(file.getAbsolutePath());

			// Create remote file object
			FileObject remoteFile = manager.resolveFile(sftpUri, opts);

			// Copy local file to sftp server
			remoteFile.copyFrom(localFile, Selectors.SELECT_SELF);
			System.out.println("File upload successful");

		}
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		finally {
			manager.close();
		}

		return true;
	}


}
