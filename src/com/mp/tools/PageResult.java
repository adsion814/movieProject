package com.mp.tools;

import java.util.List;

public class PageResult {
	private List listdata;
	private Integer totalpage;
	private Integer currentpage;
	private Integer totalcount;
	private Integer pagesize;
	private Integer prepage;
	private Integer nextpage;
	private PageIndex index;
	private Integer checked=-1;
	
	
	public PageIndex getIndex() {
		return index;
	}

	public void setIndex(PageIndex index) {
		this.index = index;
	}

	public PageResult(List listdata,  Integer currentpage,
			Integer totalcount, Integer pagesize,Integer checked)
			 {
		super();
		this.listdata = listdata;
		this.currentpage = currentpage;
		this.totalcount = totalcount;
		this.pagesize = pagesize;
		this.checked=checked;
		this.totalpage = this.totalcount%this.pagesize==0?this.totalcount/this.pagesize:(this.totalcount/this.pagesize)+1;
		this.prepage = this.currentpage-1>=1?this.currentpage-1:1;
		this.nextpage = this.currentpage+1<=this.totalpage?this.currentpage+1:this.totalpage;
		this.index=PageIndex.getPageIndex(5, this.currentpage, this.totalpage);
		
	}
	
	public PageResult(List listdata, Integer totalpage, Integer currentpage,
			Integer totalcount, Integer pagesize, Integer prepage,
			Integer nextpage) {
		super();
		this.listdata = listdata;
		this.totalpage = totalpage;
		this.currentpage = currentpage;
		this.totalcount = totalcount;
		this.pagesize = pagesize;
		this.prepage = prepage;
		this.nextpage = nextpage;
	}

	public PageResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List getListdata() {
		return listdata;
	}
	public void setListdata(List listdata) {
		this.listdata = listdata;
	}
	public Integer getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(Integer totalpage) {
		this.totalpage = totalpage;
	}
	public Integer getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(Integer currentpage) {
		this.currentpage = currentpage;
	}
	public Integer getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(Integer totalcount) {
		this.totalcount = totalcount;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public Integer getPrepage() {
		return prepage;
	}
	public void setPrepage(Integer prepage) {
		this.prepage = prepage;
	}
	public Integer getNextpage() {
		return nextpage;
	}
	public void setNextpage(Integer nextpage) {
		this.nextpage = nextpage;
	}
	@Override
	public String toString() {
		return "PageResult [listdata=" + listdata + ", totalpage=" + totalpage
				+ ", currentpage=" + currentpage + ", totalcount=" + totalcount
				+ ", pagesize=" + pagesize + ", prepage=" + prepage
				+ ", nextpage=" + nextpage + "]";
	}

	public Integer getChecked() {
		return checked;
	}

	public void setChecked(Integer checked) {
		this.checked = checked;
	}

	

	
	

}
