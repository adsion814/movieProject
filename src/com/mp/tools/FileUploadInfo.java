package com.mp.tools;



public class FileUploadInfo {  
	  
    private final int K = 1024;  
      
    private final int M = K * 1024;  

   
    /** 
     * 总大小 
     */  
    private long totalSize;  
    /** 
     * 开始上传时间 
     */  
    private long startTime = System.currentTimeMillis();  
    /** 
     * 已上传多少 
     */  
    private long uploadSize;  
      
    /** 
     * 上传速度(K/S) 
     */  
    public double getUploadSpeed_K(){  
        long currentTime = System.currentTimeMillis();  
        long usedTime = currentTime - startTime;  
        if(usedTime == 0.0){  
            return 0.0;  
        }  
        return getUploadSize_K()/usedTime*1000d;  
    }  
    /** 
     * 获取已上传百分比 
     * @return 
     */  
    public double getUploadPercent(){  
        return (getUploadSize()*1.00/getTotalSize())*100d;  
    }  
    /** 
     * 剩余时间(s) 
     * @return 
     */  
    public double getRemainTime(){  
        double speedKB = getUploadSpeed_K();  
        if(speedKB<= 0.00){  
            return -1d;  
        }  
        return (getTotalSize_K() - getUploadSize_K())/speedKB;  
    }  
    /** 
     * 已上传时间 
     * @return 
     */  
    public double getUseTime(){  
        return (System.currentTimeMillis() - startTime)/1000d;  
    }  
      
    public long getTotalSize() {  
        return totalSize;  
    }  
      
    public double getTotalSize_K(){  
        return getTotalSize()*1.0/K;  
    }  
      
    public double getTotalSize_M(){  
        return getTotalSize()*1.0/M;  
    }  
      
    public long getUploadSize() {  
        return uploadSize;  
    }  
      
    public double getUploadSize_K(){  
        return getUploadSize()/K;  
    }  
      
    public double getUploadSize_M(){  
        return getUploadSize()/M;  
    }  
      
    public void setTotalSize(long totalSize) {  
        this.totalSize = totalSize;  
    }  
      
      
    public void setUploadSize(long uploadSize) {  
        this.uploadSize = uploadSize;  
    }  
      
    private String double2String(double d){  
        return String.format("%.2f", d);  
    }  
      
    public String toString(){  
        return  "{"+  
                "'totalSize':'"+double2String(getTotalSize_M())+"M',"+  
                "'uploadSize':'"+double2String(getUploadSize_M())+"M',"+  
                "'uploadSpeed':'"+double2String(getUploadSpeed_K())+"KB/s',"+  
                "'uploadPrecent':'"+double2String(getUploadPercent())+"',"+  
                "'remainTime':'"+(getRemainTime()<0?"未知":double2String(getRemainTime()))+"s"+"',"+  
                "'useTime':'"+double2String(getUseTime())+"s' " 
              +
                "}";  
    }


	
}  
