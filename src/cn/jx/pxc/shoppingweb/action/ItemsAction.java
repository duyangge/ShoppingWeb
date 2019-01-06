package cn.jx.pxc.shoppingweb.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

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
	
	private Items items = new Items();
	
	@Autowired
	private ItemsService itemsService;
	
	private ActionContext con = ActionContext.getContext();
	
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
		//con.getSession().put("detailItems", itemsService.getDetailItems(items.getGid()));
		ServletActionContext.getRequest().setAttribute("detailItems", itemsService.getDetailItems(items.getGid()));
		return "detailItems";
	}
	
	
	/**通过查询商品名称
	 * @return
	 */
	public String findItems() {
		try {
			System.out.println(items.getGname());
			List<Items> findItemsList = itemsService.findItems(items.getGname());
			//con.getSession().put("findItemsList", findItemsList);
			ServletActionContext.getRequest().setAttribute("findItemsList", findItemsList);
			return "findItems";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
