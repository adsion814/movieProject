package com.mp.tools;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.InputFormatException;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mp.bean.Video;
public class VideoInfoDao {
	private   JDBCUtils utils=JDBCUtils.getJDBC();
	
	public VideoInfoDao(){
		utils.getConnection();
		
	}
	//高级分页查询视频
    public PageResult queryVideoList(ProductQueryObject op,String condition) throws Exception{
    	String sql;
    	if(condition.equals("hot")) {
    		 sql="SElECT * FROM videoinfo "+op.getQuerySql()+" ORDER BY hot DESC LIMIT ?,? ";
    	}
    	else if(condition.equals("uploadUser")) {
    		sql="SElECT * FROM videoinfo "+op.getQuerySql()+" ORDER BY uploadtime DESC LIMIT ?,? ";
    	}
    	else {
   	  sql="SElECT * FROM videoinfo "+op.getQuerySql()+" ORDER BY uploadtime DESC LIMIT ?,? ";
    	}
   	 ArrayList<Object> par = new ArrayList<Object>();
   	 if(op.params()!=null){
   		 par.addAll(op.params());
   	 }
   	 par.add((op.getCurrentpage()-1)*op.getPagesize());
   	 par.add(op.getPagesize());
   	 List<Video> listdata = utils.findMoreRefResult(sql, par, Video.class);
   	 System.out.println(sql);
   	 System.out.println(par);
   	 Integer count = (int)totalVideoCount(op);
   	 return new PageResult(listdata,op.getCurrentpage(),count,op.getPagesize(),op.getChecked());
    }	

    //查询视屏总条数
    public long totalVideoCount(ProductQueryObject op) throws Exception{
   	 long count=0;
   	 String sql="SELECT COUNT(*) FROM videoinfo "+op.getQuerySql();
   	 
   	 ResultSet set = utils.query(sql, op.params().toArray());
		
		if(set.next()){
			
			 count = set.getLong(1);
			
		}
		return count;
    }
	//插入视频进数据库
    public boolean addVideoByAdmin(Video video) throws Exception, Exception{
    	boolean flag=false;
    	String sql="INSERT INTO videoinfo VALUES(?,?,?,?,?,?,?,?,?,?,?,?) ";
    	ArrayList<Object> params = new ArrayList<Object>();
    	params.add(video.getUuid());
    	params.add(video.getName());
    	params.add(video.getAddress());
    	params.add(video.getDuration());
    	params.add(video.getHot());
    	params.add(video.getUploadTime());
    	params.add(video.getType());
    	params.add(video.getUploadUser());
    	params.add(video.getIntroduction());
    	params.add(video.getChecked());
    	params.add(video.getVideopicture());
    	params.add(video.getAskVip());
    	System.out.println(video);
    	 flag = utils.updateByPreparedStatement(sql, params);
    	return flag;
    }
    //修改视频是否通过审核(通过uuid更新)
    public boolean updateVideoChecked(String uuid,Integer checked){
    	boolean flag=false;
    	String sql="UPDATE videoinfo SET checked=? WHERE uuid=?";
    	ArrayList<Object> params = new ArrayList<Object>();
    	params.add(checked);
    	params.add(uuid);
    	try {
			 flag = utils.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
       
    	return flag;
    }
    //删除视频信息(通过uuid)
    public boolean deleteVideoInfo(String uuid){
    	boolean flag=false;
    	String sql="Delete  FROM videoinfo  WHERE uuid=? ";
    	ArrayList<Object> params = new ArrayList<Object>();
    	params.add(uuid);
    	System.out.println(params);
        System.out.println(sql+"qweqweqrqwrq");
    	try {
			 flag = utils.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    	return flag;
    }
    //通过uuid查询出视频地址(删除视频用)
    public Video queryVideoAddress(String uuid){
    	Video videoaddress=null;
    	String sql="SELECT * From videoinfo WHERE uuid=?";
    	ArrayList<Object> params = new ArrayList<Object>();
    	params.add(uuid);
    	try {
			 videoaddress = utils.findSimpleRefResult(sql, params, Video.class);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return videoaddress;
    }

    
}
