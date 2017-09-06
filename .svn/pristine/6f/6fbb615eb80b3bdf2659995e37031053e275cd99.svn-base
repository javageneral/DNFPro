package com.dnf.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FtpUtil {  
	
	private static final Logger logger = LoggerFactory.getLogger(FtpUtil.class);
    private static FtpUtil instance;  
    private FTPClient ftpClient =null;
    private static String FTPURL = "123.207.20.144";
    private static String FTPUSERNAME =  "ftpuser";
    private static String FTPPASSWORD = "laichilueng";
    private static String BASEPATH = "/DNFPro/customer/";
    
      
    /** 
     * get FtpConManager 
     * @return FtpConManager 
     */  
    public synchronized static FtpUtil getInstance(){  
        if( instance == null ){  
            instance = new FtpUtil();  
        }  
        return instance;  
    }  
    
    
    /** 
     * <p>ftp登录</p> 
     * @param s_url ftp服务地址 
     * @param uname 用户名 
     * @param pass  密码 
     */  
    public void login(String s_url,String uname,String pass){  
        ftpClient = new FTPClient();  
        try{  
            //连接  
            ftpClient.connect(s_url, 21);  
            ftpClient.login(uname,pass);  
            //检测连接是否成功  
            int reply = ftpClient.getReplyCode();  
            if(!FTPReply.isPositiveCompletion(reply)) {  
                this.closeCon();  
                logger.error("FTP server refused connection."); 
            }  
        }catch(Exception ex){  
            logger.error(ex.getMessage());
            //关闭  
            this.closeCon();  
        }  
    }   
    
    /** 
     *<p>销毁ftp连接</p>  
     */  
    public void closeCon(){  
        if(ftpClient !=null){  
            if(ftpClient.isConnected()){  
                try {  
                    ftpClient.logout();  
                    ftpClient.disconnect();  
                } catch (IOException e) {  
                    logger.error(e.getMessage()); 
                }   
            }  
        }  
    }  
    
    
    public boolean uploadFile(InputStream input, String filename, String filePath){
    	boolean result = false;
    	this.login(FTPURL, FTPUSERNAME, FTPPASSWORD);
    	String basePath = this.BASEPATH;
    	try{   	
	    	if(ftpClient != null){
	            //切换到上传目录  
	            if (!ftpClient.changeWorkingDirectory(basePath+filePath)) {  
	                //如果目录不存在创建目录  
	                String[] dirs = filePath.split("/");  
	                String tempPath = basePath;  
	                for (String dir : dirs) {  
	                    if (null == dir || "".equals(dir)) continue;  
	                    tempPath += "/" + dir;  
	                    if (!ftpClient.changeWorkingDirectory(tempPath)) {  
	                        if (!ftpClient.makeDirectory(tempPath)) {  
	                            return result;  
	                        } else {  
	                        	ftpClient.changeWorkingDirectory(tempPath);  
	                        }  
	                    }  
	                }  
	            }
	            logger.info("即将上传文件");
	            //设置上传文件的类型为二进制类型  
	            ftpClient.enterLocalPassiveMode();
	            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);  
	            ftpClient.setControlEncoding("utf-8");
	            ftpClient.setBufferSize(1024 * 1024 * 10);
	            BufferedInputStream bis = new BufferedInputStream(input );
	            
	            //上传文件  
	            if (!ftpClient.storeFile(filename, bis)) {  
	                return result;  
	            }else{
	            	result = true;
	            }
	            logger.info("上传文件成功");
	            IOUtils.closeQuietly(input);	   
	            this.closeCon();  
	    	}
    	}catch(Exception e){
    		e.printStackTrace();
    		logger.error(e.getMessage());
            this.closeCon();  
    	}	
    	return result;
    }
    
    public boolean downloadFile(String remotePath, String filename, String localpath){
    	boolean result = false;
    	this.login(FTPURL, FTPUSERNAME, FTPPASSWORD);
    	try{
    		if(ftpClient != null){
    			ftpClient.changeWorkingDirectory(remotePath);
    			ftpClient.enterLocalPassiveMode();
    			ftpClient.setRemoteVerificationEnabled(false);
    			ftpClient.setControlEncoding("utf-8");
    			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
    			ftpClient.setBufferSize(1024 * 1024 * 10);
    			FTPFile[] fs = ftpClient.listFiles(); 
    			FTPClientConfig conf = new FTPClientConfig( FTPClientConfig.SYST_UNIX);
    			ftpClient.configure(conf);
    			 for (FTPFile ff : fs) {  
    	                if (ff.getName().equals(filename)) {  
    	                    File localFile = new File(localpath  + ff.getName());  
    	                    OutputStream is = new FileOutputStream(localFile);  
    	                    logger.info("准备下载文件");
    	                    ftpClient.retrieveFile(ff.getName(), is);    	                    
    	                    is.close();  
    	                }  
    			 }
    			 logger.info("下载完成");
    			 this.closeCon();
    			 result = true;
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    		logger.error(e.getMessage());
    	}
    	return result;
    }
    
}  
