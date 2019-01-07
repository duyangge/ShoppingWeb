package cn.jx.pxc.shoppingweb.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.jx.pxc.shoppingweb.entity.Items;
import cn.jx.pxc.shoppingweb.service.LoadFileService;

/**
 *<p> Title:  LoadFileAction.java</p>
 *<p> Description:  加载首页文件</p>
 * @package   cn.jx.pxc.shoppingweb.action
 * @author    黄信胜
 * @date      2018年12月23日下午5:01:15
 * @version 1.0
 */
@Controller
@Scope("prototype")
@SuppressWarnings("all")
public class LoadFileAction extends ActionSupport implements ModelDriven<Items>{
	
	private Items items = new Items();
	
	@Autowired
	private LoadFileService loadFileService;

	private ActionContext con = ActionContext.getContext();
	
	@Override
	public Items getModel() {
		return items;
	}

	/**
	 * 加载首页商标
	 * @return 
	 * @throws Exception 
	 */
	public void loadItemsBrand() throws Exception {
		con.getSession().put("manBrand", loadFileService.loadItemsBrand(1));
		con.getSession().put("sportBrand", loadFileService.loadItemsBrand(2));
	}
	
	/**
	 * 加载首页商品描述
	 * @return 
	 * @throws Exception 
	 */
	public void loadItemsShowText() throws Exception{
		con.getSession().put("manShowText", loadFileService.loadItemsShowText(1));
		con.getSession().put("sportShowText", loadFileService.loadItemsShowText(2));
	}
	
	/**
	 * 加载商品类型
	 * @return 
	 * @throws Exception 
	 */
	public void loadItemsType() throws Exception {
		con.getSession().put("manType", loadFileService.loadItemsType(1).get(0));
		con.getSession().put("sportType", loadFileService.loadItemsType(2).get(0));
	}
	
	/**
	 * 首页加载所有，加载完毕
	 * @return 
	 * @throws Exception 
	 */
	public String loadAll() throws Exception {
		this.loadItemsType();
		this.loadItemsBrand();
		this.loadItemsShowText();
		return SUCCESS;
	}
}
