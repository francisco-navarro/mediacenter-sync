package es.fnavarro.mediasync.services.impl;

import java.io.File;
import java.util.Properties;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.Selectors;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpProgressMonitor;

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
		//startFTP(name, path);
		startJSch(name, path);
	}


	private void startJSch(String name, String path) {
		try{
			String serverAddress = systemPropertiesService.getRemoteIp();
			String userId = systemPropertiesService.getRemoteUser();
			String password = systemPropertiesService.getRemotePassword();
			String remoteDirectory = systemPropertiesService.getRemotePath();
			
			JSch jsch=new JSch();
			
			
		    Session session=jsch.getSession(userId, serverAddress, 22);
		    session.setPassword(password);
		    session.setConfig(getConfig());
		    
		    
		    session.connect();
			
		    Channel channel=session.openChannel("sftp");
		    channel.connect();
		    ChannelSftp c=(ChannelSftp)channel;
		    
		    SftpProgressMonitor monitor = new SystemOutProgressMonitor();
			c.put(path+name,remoteDirectory + name, monitor , ChannelSftp.OVERWRITE);
			
		    c.disconnect();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public class SystemOutProgressMonitor implements SftpProgressMonitor
	{
	    public SystemOutProgressMonitor() {;}

	    public void init(int op, java.lang.String src, java.lang.String dest, long max) 
	    {
	        System.out.println("STARTING: "+op+" "+src+" -> "+dest+" total: "+max);
	    }

	    public boolean count(long bytes)
	    {
	        for(int x=0;x<bytes;x++) {
	            System.out.print("#");
	        }
	        return(true);
	    }

	    public void end()
	    {
	        System.out.println("\nFINISHED!");
	    }
	}

	private Properties getConfig() {
		Properties config = new java.util.Properties(); 
		config.put("StrictHostKeyChecking", "no");
		return config;
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
