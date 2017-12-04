package com.mp.tools;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class JDBCUtils {
	// 数据库用户名
		private static final String USERNAME = "root";
		// 数据库密码
		private static final String PASSWORD = "123456";
		// 驱动信息
		private static final String DRIVER = "com.mysql.jdbc.Driver";
		// 数据库地址
		private static final String URL = "jdbc:mysql://localhost:3306/movieproject?useSSL=false";
		private Connection connection;
		private PreparedStatement pstmt;
		private ResultSet resultSet;
		private static JDBCUtils jdbc = new JDBCUtils();

		private JDBCUtils() {
			// TODO Auto-generated constructor stub
			try {
				Class.forName(DRIVER);
				connection = getConnection();

			} catch (Exception e) {

			}
		}

		/**
		 * 获得数据库的连接
		 * 
		 * @return
		 */
		public static JDBCUtils getJDBC() {
			return jdbc;
		}

		public Connection getConnection() {
			try {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connection;
		}

		/**
		 * 增加、删除、改
		 * 
		 * @param sql
		 * @param params
		 * @return
		 * @throws SQLException
		 */
		public boolean updateByPreparedStatement(String sql, List<Object> params)
				throws SQLException {
			boolean flag = false;
			int result = -1;
			pstmt = connection.prepareStatement(sql);
			int index = 1;
			if (params != null && !params.isEmpty()) {
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(index++, params.get(i));
				}
			}
			result = pstmt.executeUpdate();
			flag = result > 0 ? true : false;
			return flag;
		}

		/**
		 * 通过反射机制查询单条记录
		 * 
		 * @param sql
		 * @param params
		 * @param cls
		 * @return
		 * @throws Exception
		 */
	
		public <T> T findSimpleRefResult(String sql, List<Object> params,
				Class<T> cls) throws Exception {
			T resultObject = null;
			int index = 1;
			pstmt = connection.prepareStatement(sql);
			if (params != null && !params.isEmpty()) {
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(index++, params.get(i));
				}
			}
			resultSet = pstmt.executeQuery();
			ResultSetMetaData metaData = resultSet.getMetaData();
			int cols_len = metaData.getColumnCount();
			while (resultSet.next()) {
				// 通过反射机制创建一个实例
				Object cols_value;
				resultObject = cls.newInstance();
				for (int i = 0; i < cols_len; i++) {
					String cols_name = metaData.getColumnName(i + 1);
					Field field = cls.getDeclaredField(cols_name);

					cols_value = resultSet.getObject(cols_name);
					if (cols_value == null) {
						cols_value = "";
					}

					field.setAccessible(true); // 打开javabean的访问权限
					field.set(resultObject, cols_value);
				}
			}
			return resultObject;

		}
		/**
		 * 通过反射机制查询多条记录
		 * 
		 * @param sql
		 * @param params
		 * @param cls
		 * @return
		 * @throws Exception
		 */
		public <T> List<T> findMoreRefResult(String sql, List<Object> params,
				Class<T> cls) throws Exception {
			List<T> list = new ArrayList<T>();
			int index = 1;
			pstmt = connection.prepareStatement(sql);
			if (params != null && !params.isEmpty()) {
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(index++, params.get(i));
				}
			}
			resultSet = pstmt.executeQuery();
			ResultSetMetaData metaData = resultSet.getMetaData();
			int cols_len = metaData.getColumnCount();
			while (resultSet.next()) {
				// 通过反射机制创建一个实例
				T resultObject = cls.newInstance();
				for (int i = 0; i < cols_len; i++) {
					String cols_name = metaData.getColumnName(i + 1);
					Field field = cls.getDeclaredField(cols_name);
					Object cols_value;
					if (field.getType().isPrimitive()) {
					}

					else {

						cols_value = field.getType().newInstance();
					}

					cols_value = resultSet.getObject(cols_name);

					if (cols_value == null) {
						cols_value = "";
					}

					field.setAccessible(true); // 打开javabean的访问权限

					field.set(resultObject, cols_value);
				}
				list.add(resultObject);
			}
			return list;
		}



		public ArrayList<String> exeDanmu(String sql,String name) throws SQLException{
			ArrayList<String> cList=new ArrayList<String>();
			pstmt=connection.prepareStatement(sql);
			pstmt.setObject(1, name);
			resultSet=pstmt.executeQuery();
			while(resultSet.next()){
				cList.add(resultSet.getString("barrage"));
			}
			return cList;
		}
		public HashSet<String> exeSK(String sql) throws SQLException{
			HashSet<String> cList=new HashSet<String>();
			pstmt=connection.prepareStatement(sql);
			resultSet=pstmt.executeQuery();
			while(resultSet.next()){
				cList.add(resultSet.getString("word"));
			}
			return cList;
		}
	    public ResultSet querySet(String sql,Object...obj){
	    	 try {
				pstmt = connection.prepareStatement(sql);
			  	 resultSet=pstmt.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	  return resultSet;
	    }
	    
	    /**
	  	 * 查询方法
	  	 * @param sql  查询语句
	  	 * @param obj  查询语句置入的参数
	  	 * @return 查询结果集
	  	 */
	  	public ResultSet query(String sql,Object...obj){
	  		try {
	  			pstmt=connection.prepareStatement(sql);
	  			if(obj!=null){
	  				for(int i=0;i<obj.length;i++){
	  					pstmt.setObject(i+1, obj[i]);
	  				}
	  			}		
	  			resultSet=pstmt.executeQuery();
	  		} catch (Exception e) {
	  			// TODO: handle exception
	  		}
	  		return resultSet;
	  	}

}
