package com.mp.serviceImpl;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;
import org.springframework.stereotype.Component;

import com.mp.tools.FileUploadInfo;

@Component  
public class FileUploadProgress implements ProgressListener {  
    private HttpSession session;  
    
    public void setSession(HttpSession session){  
        this.session=session;  
        FileUploadInfo status = new FileUploadInfo();  
        session.setAttribute("status", status);  
    }  
  
    /*  
     * pBytesRead 到目前为止读取文件的比特数 pContentLength 文件总大小 pItems 目前正在读取第几个文件  
     */  
    public void update(long uploadSize, long totalSize,int item) {  
    	FileUploadInfo status = (FileUploadInfo) session.getAttribute("status");  
      
  
         status.setTotalSize(totalSize);
         status.setUploadSize(uploadSize);
    
    }


  
}  
