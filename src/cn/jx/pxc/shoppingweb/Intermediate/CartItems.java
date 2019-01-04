package cn.jx.pxc.shoppingweb.Intermediate;

import java.io.Serializable;

import cn.jx.pxc.shoppingweb.entity.Cart;
import cn.jx.pxc.shoppingweb.entity.Items;
/**
 *<p> Title:  CartItems.java</p>
 *<p> Description:  购物车的临时映射类</p>
 * @package   cn.jx.pxc.shoppingweb.Intermediate
 * @author    黄信胜
 * @date      2019年1月4日下午2:27:23
 * @version 19.01.04
 */
@SuppressWarnings("all")
public class CartItems implements Serializable{
	private Integer cuid;
	private Integer cid;
	private Integer gid;
	private Integer uid;
	private Integer gnum;
	private String gname;
	private String gbrand;
	private String gintroduce;
	private Double gprice;
	private String imgsrc;
	private Double sellPrice;
	public CartItems(){
		super();
	}
	
	
	/**
	 * @param cid
	 * @param gid
	 * @param uid
	 * @param gnum
	 * @param gname
	 * @param gbrand
	 * @param gintroduce
	 * @param gprice
	 * @param imgsrc
	 * @param sellPrice
	 */
	public CartItems(Integer cid, Integer gid, Integer uid, Integer gnum, String gname, String gbrand,
			String gintroduce, Double gprice, String imgsrc, Double sellPrice) {
		super();
		this.cid = cid;
		this.gid = gid;
		this.uid = uid;
		this.gnum = gnum;
		this.gname = gname;
		this.gbrand = gbrand;
		this.gintroduce = gintroduce;
		this.gprice = gprice;
		this.imgsrc = imgsrc;
		this.sellPrice = sellPrice;
	}


	public Double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public Integer getCuid() {
		return cuid;
	}
	public void setCuid(Integer cuid) {
		this.cuid = cuid;
	}
	public Integer getCid(){
		return cid;
	}

	public Integer getGid() {
		return gid;
	}

	public Integer getUid() {
		return uid;
	}

	public Integer getGnum() {
		return gnum;
	}

	public String getGname() {
		return gname;
	}

	public String getGbrand() {
		return gbrand;
	}

	public String getGintroduce() {
		return gintroduce;
	}

	public Double getGprice() {
		return gprice;
	}

	public String getImgsrc() {
		return imgsrc;
	}

}
