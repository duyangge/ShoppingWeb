package cn.jx.pxc.shoppingweb.Utils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

import sun.misc.BASE64Encoder;

/**
 *<p> Title:  Md5.java</p>
 *<p> Description:  md5加密</p>
 * @package   cn.jx.pxc.shoppingweb.Utils
 * @author    黄信胜
 * @date      2019年1月4日下午2:37:45
 * @version 19.01.04
 */
public class Md5 {
	
	/**利用MD5进行加密
	 * @param str
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
	    //确定计算方法
	    MessageDigest md5=MessageDigest.getInstance("MD5");
	    BASE64Encoder base64en = new BASE64Encoder();
	    //加密后的字符串
	    String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
	    return newstr;
	  }
	
	  /**判断用户密码是否正确
	 * @param newpasswd 用户输入的密码
	 * @param oldpasswd 正确密码
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public boolean checkpassword(String newpasswd,String oldpasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException{
	    if(EncoderByMd5(newpasswd).equals(oldpasswd))
	      return true;
	    else
	      return false;
	  }
	
	
}
