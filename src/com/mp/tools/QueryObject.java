package com.mp.tools;

import java.util.ArrayList;

public class QueryObject {
	private ArrayList<Object> params = new ArrayList<Object>();
	private ArrayList<Object> contains = new ArrayList<Object>();
	Integer currentpage=1;
	Integer pagesize=5;
	public Integer getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(Integer currentpage) {
		this.currentpage = currentpage;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public ArrayList<Object> params() {
		return params;
	}
	public String getQuerySql(){
//		params = new ArrayList<Object>();
//		contains = new ArrayList<Object>();
		StringBuilder sql=new StringBuilder();
		customquery();
		 if(contains.size()>0){
			 sql.append("WHERE");
			 sql.append(org.apache.commons.lang3.StringUtils.join(contains,"AND"));
		 }
		 return sql.toString();
	}
	//钩子方法 子类覆盖 父类调用
	protected  void customquery(){
		
	}
	public void add(String contain, Object paramer ){
		params.add(paramer);
		contains.add(contain);
	}

}
