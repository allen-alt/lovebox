package cn.util;
/**
 * 字符串工具类
 * @author 
 *
 */
public class StringUtil {
	/**
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if(str==null||"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 判断是否不是空
	 * @param str
	 * @return
	 */
	public static boolean isNotempty(String str) {
		if(str!=null&&!"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}

}
