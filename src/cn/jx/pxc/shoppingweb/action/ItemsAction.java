package cn.jx.pxc.shoppingweb.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.jx.pxc.shoppingweb.Intermediate.ShowPage;
import cn.jx.pxc.shoppingweb.Utils.Pagination;
import cn.jx.pxc.shoppingweb.entity.Items;
import cn.jx.pxc.shoppingweb.service.ItemsService;
/**
 *<p> Title:  ItemsAction.java</p>
 *<p> Description:  商品类操作</p>
 * @package  cn.jx.pxc.shoppingweb.action
 * @author    黄信胜
 * @date      2018年12月23日下午3:16:06
 * @version 18.12.23
 */
@Controller
@Scope("prototype")
@SuppressWarnings("all")
public class ItemsAction extends ActionSupport implements ModelDriven<Items>{
	
	@Autowired
	private ShowPage showPage;
	
	private Items items = new Items();
	
	@Autowired
	private ItemsService itemsService;
	
	private ActionContext con = ActionContext.getContext();
	
	public ShowPage getShowPage() {
		return showPage;
	}

	public void setShowPage(ShowPage showPage) {
		this.showPage = showPage;
	}

	@Override
	public Items getModel() {
		return items;
	}

	/**
	 * 通过商品类别id查询商品
	 * @return 返回字符串 “itemslist"
	 * @throws Exception 
	 */
	public String inItemsList() throws Exception{
		con.getSession().put("itemslist", itemsService.inItemsList(items.getTid()));
		return "itemslist";
	}
	
	/**
	 * 通过商品id进入商品详细页面
	 * @return 返回字符串 “detailitems"
	 * @throws Exception 
	 */
	public String getDetailItems() throws Exception{
		ServletActionContext.getRequest().setAttribute("detailItems", itemsService.getDetailItems(items.getGid()));
		return "detailItems";
	}
	
	/**
	 * 分页处理
	 * @return
	 */
	public String findItemsPage() {
		try {
			this.PagingProcess(itemsService.sumCountSelectItems(con.getSession().get("seacherName").toString()).intValue());
			List<Items> findItemsList = itemsService.findItems(con.getSession().get("seacherName").toString(),showPage.getCurrentpage(),showPage.getPageSize());
			ServletActionContext.getRequest().setAttribute("findItemsList", findItemsList);
			return "findItems";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**通过查询商品名称
	 * @return
	 */
	public String findItems() {
		try {
			//如何保存查询条件
			this.PagingProcess(itemsService.sumCountSelectItems(items.getGname()).intValue());
			List<Items> findItemsList = itemsService.findItems(items.getGname(),showPage.getCurrentpage(),showPage.getPageSize());
			ServletActionContext.getRequest().setAttribute("findItemsList", findItemsList);
			con.getSession().put("seacherName", items.getGname());
			return "findItems";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 分页处理
	 * @param totalRecords 传入总页数
	 */
	public void PagingProcess(Integer totalRecords) {
		showPage.setTotalpages((totalRecords % showPage.getPageSize() == 0) ? (totalRecords / showPage.getPageSize()) : ((totalRecords / showPage.getPageSize()) + 1));
		if (showPage.getCurrentpage() == 0) showPage.setCurrentpage(1);
		if (showPage.getCurrentpage() >= showPage.getTotalpages()) showPage.setCurrentpage(showPage.getTotalpages());
		showPage.setPageSize(4);
		ServletActionContext.getRequest().setAttribute("showPage", showPage);
	}
}
