package web.action;

import java.util.List;

import web.entity.Items;
import web.entity.ItemsImgBrand;
import web.servicce.ItemsService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author 黄信胜
 *
 */
@SuppressWarnings("all")
public class ItemsAction extends ActionSupport implements ModelDriven<Items>{
	private Items items = new Items();
	private ActionContext con = ActionContext.getContext();
	private ItemsService itemsService;
	private String tablename;
	public void setItemsService(ItemsService itemsService) {
		this.itemsService = itemsService;
	}
	@Override
	public Items getModel() {
		return items;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	/**
	 * 查询商品
	 * @return 返回字符串 “itemslist"
	 */
	public String inItemsList(){
		List<Items> itemslist=itemsService.inItemsList(tablename);
		con.getSession().put("itemslist", itemslist);
		con.getSession().put("tablename",tablename);
		return "itemslist";
	}
	
	/**
	 * 进入商品详细页面
	 * @return 返回字符串 “detailitems"
	 */
	public String goDetailItems(){
		Items detailItems=itemsService.goDetailItems(tablename,items.getGid());
		con.getSession().put("detailItems", detailItems);
		return "detailitems";
	}
	/**
	 * 加载商标
	 * @return 
	 */
	public String loadItemsImgBrand() {
		ItemsImgBrand itemsImgBrand = new ItemsImgBrand();
		itemsService.loadItemsImgBrand(itemsImgBrand);
		return "loadItemsImgBrand";
	}
	
	/**
	 * 加载各类商品新货标识
	 * @return 
	 */
	public String loadItemsImgtext(){
		
		return "loadItemsImgtext";
	}
	
	/**
	 * 加载商品类型的标题
	 * @return 
	 */
	public String loadItemsTypeTitle() {
		
		return "loadItemsTypeTitle";
	}
		
}
