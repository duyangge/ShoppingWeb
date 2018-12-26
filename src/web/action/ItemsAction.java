package web.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import web.entity.Items;
import web.service.ItemsService;
/**
 *<p> Title:  ItemsAction.java</p>
 *<p> Description:  商品类操作</p>
 * @package   web.action
 * @author    黄信胜
 * @date      2018年12月23日下午3:16:06
 * @version 1.0
 */
@Controller("itemsAction")
@Scope("prototype")
@SuppressWarnings("all")
public class ItemsAction extends ActionSupport implements ModelDriven<Items>{
	
	private Items items = new Items();
	
	private ActionContext con = ActionContext.getContext();
	
	@Resource(name="itemsService")
	private ItemsService itemsService;
	
	public void setItemsService(ItemsService itemsService) {
		this.itemsService = itemsService;
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
		System.out.println("1"+con.getSession().toString());
		con.getSession().put("detailItems", itemsService.getDetailItems(items.getGid()));
		System.out.println("2"+con.getSession().toString());
		return "detailItems";
	}
	
/*	*//**
	 * 加载首页商标
	 * @return 
	 * @throws Exception 
	 *//*
	public void loadItemsBrand() throws Exception {
		con.getSession().put("manBrand", itemsService.loadItemsBrand(1));
		con.getSession().put("sportBrand", itemsService.loadItemsBrand(2));
	}
	
	*//**
	 * 加载首页商品描述
	 * @return 
	 * @throws Exception 
	 *//*
	public void loadItemsShowText() throws Exception{
		con.getSession().put("manShowText", itemsService.loadItemsShowText(1));
		con.getSession().put("sportShowText", itemsService.loadItemsShowText(2));
	}
	
	*//**
	 * 加载商品类型
	 * @return 
	 * @throws Exception 
	 *//*
	public void loadItemsType() throws Exception {
		con.getSession().put("manType", itemsService.loadItemsType(1).get(0));
		con.getSession().put("sportType", itemsService.loadItemsType(2).get(0));
	}
	
	*//**
	 * 首页加载所有，加载完毕
	 * @return 
	 * @throws Exception 
	 *//*
	public String loadAll() throws Exception {
		this.loadItemsType();
		this.loadItemsBrand();
		this.loadItemsShowText();
		return SUCCESS;
	}*/
}
