package com.mp.tools;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mp.bean.*;
public class commentDao {

	private JDBCUtils util = JDBCUtils.getJDBC();
	public commentDao() {
		util.getConnection();
	}
	
	//依据videouuid查询所有评论
	public List<VideoComment> VideoComments(String videouuid) throws Exception{
		String sql = "SELECT * FROM videocomment WHERE videouuid=? ORDER BY time DESC";
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(videouuid);
		List<VideoComment> list1 = util.findMoreRefResult(sql, list, VideoComment.class);
		return list1;
	}
	
	//添加评论
	public boolean addCom(VideoComment com) throws Exception{
		String sql = "INSERT videocomment VALUES (?,?,?,?,?)";
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(com.getVideouuid());
		list.add(com.getComment());
		list.add(com.getUseruuid());
		list.add(com.getTime());
		list.add(com.getName());
		boolean b = util.updateByPreparedStatement(sql, list);
		
		return b;
	}
	
	//依据videouuid查询个人评论
	public List<VideoComment> VideoComment(String useruuid,String videouuid) throws Exception{
		String sql = "SELECT * FROM videocomment WHERE useruuid=? AND videouuid=? ORDER BY time DESC";
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(useruuid);
		list.add(videouuid);
		List<VideoComment> com = util.findMoreRefResult(sql, list, VideoComment.class);
		return com;
		
	}
	

	
}
