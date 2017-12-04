package com.mp.tools;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mp.bean.CommentCount;



public class VideoCommentDao  {
	private   JDBCUtils utils=JDBCUtils.getJDBC();
	public VideoCommentDao(){
		utils.getConnection();
		
	}
	//通过视频ID查询所有评论数
    public CommentCount totalVideoCommentCount(String uuid) throws Exception{
    	long count=0;
      	 String sql="SELECT COUNT(*) FROM videocomment where videouuid=?  ";
      	 ResultSet set = utils.query(sql, uuid);
   		if(set.next()){
   			 count = set.getLong(1);
   		}
   		return new CommentCount(count,uuid);
       }
	//
//	public CommentCount queryVideoComment(String uuid) throws Exception{
//	     String sql="SELECT * FROM videocomment where videouuid=? ";
//	     ArrayList<Object> params=new ArrayList<Object>();
//        params.add(uuid);
//	 	utils.releaseConn();
//     List<VideoComment> video = utils.findMoreRefResult(sql,params,VideoComment.class );
//     Integer totalVideoCommentCount = (int)totalVideoCommentCount(uuid);
//			return  new CommentCount(totalVideoCommentCount,uuid);
//		}
//    public long totalBookCount(String uuid) throws Exception{
//   	 long count=0;
//   	 String sql="SELECT COUNT(*) FROM videocomment where videouuid=? ";
////   	 ArrayList<Object> params = new ArrayList<Object>();
////  	 params.add(uuid);
//   	 ResultSet set = utils.query(sql, uuid);
//		
//		if(set.next()){
//			
//			 count = set.getLong(1);
//			
//		}
//		return count;
//   	 
//	  
//	
//	
//}
}