package cn.jx.pxc.shoppingweb.Intermediate;

import org.springframework.stereotype.Component;

/**
 *<p> Title:  ShowPage.java</p>
 *<p> Description:  分页</p>
 * @package   cn.jx.pxc.shoppingweb.Intermediate
 * @author    黄信胜
 * @date      2019年1月4日下午2:28:26
 * @version 19.01.04
 */
@Component
@SuppressWarnings("all")
public class ShowPage {
	private Integer currentpage=1;//当前页
	private Integer totalpages=0;//得到总页数
	private Integer pageSize=4;//设置当前页的最大行记录
	
	public Integer getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(Integer currentpage) {
		this.currentpage = currentpage;
	}
	public Integer getTotalpages() {
		return totalpages;	
	}
	public void setTotalpages(Integer totalpages) {
		this.totalpages = totalpages;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
