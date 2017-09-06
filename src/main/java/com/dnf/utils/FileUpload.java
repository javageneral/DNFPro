package com.dnf.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUpload {  
	
	private static final Logger logger = LoggerFactory.getLogger(FileUpload.class);
	
    public static final String FILE_PATH = "webapp/resources/customer/";  
    	
    //文件上传  
    public static boolean uploadIdCardFile(MultipartFile file, String filepath, String filename) {  
    	boolean result = false;
      
        try{
        	File filePath = new File(filepath);
	        if  (!filePath .exists()){       
	        	filePath .mkdirs();
	         }

	        File tempFile = new File(filepath, String.valueOf(filename));  
//	        if (!tempFile.getParentFile().exists()) {  
//	            tempFile.getParentFile().mkdir();  
//	        }  
//	        if (!tempFile.exists()) {  
//	            tempFile.createNewFile();  
//	        }  
//	        file.transferTo(tempFile); 
            InputStream fis = file.getInputStream();
            FileOutputStream fos = new FileOutputStream(tempFile);  
      
            byte[] read = new byte[1024];  
            int len = 0;  
            while((len = fis.read(read))!= -1){  
                fos.write(read,0,len);  
            }  
            fis.close();  
            fos.flush();  
            fos.close();
	        result = true;
        }catch(Exception e){
        	e.printStackTrace();
        	logger.error(e.getMessage());
        }
        return result; 
    }  
  
    public static File getFile(String fileName) {  
        return new File(FILE_PATH, fileName);  
    }  
}  