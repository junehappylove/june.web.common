/**
 * 中科方德软件有限公司<br>
 * june.web.common:com.june.common.JspPage.java
 * 日期:2017年6月6日
 */
package com.june.common;

/**
 * JspPage <br>
 * 
 * @author 王俊伟 wjw.happy.love@163.com
 * @blog https://www.github.com/junehappylove
 * @date 2017年6月6日 下午2:56:39
 * @version 1.0.0
 */
public class JspPage {
	private static final String[] STRS = {"/","/add","/edit","/info","/query","/import","/export","/upload","/list","view"};
	private String page;// 页面
	private String p1,p2;
	private String suff = "june_";// 前缀
	private String match;//

	public JspPage(String name) {
		if(name.contains("?")){
			name = name.substring(0, name.indexOf("?"));
		}
		this.p1 = name;
		if (name.endsWith("/")) {
			this.p2 = name;
			name = name.substring(0, name.length() - 1);
		} else {
			this.p2 = name + "/";
			this.p1 = name;
		}
		this.page = name;
		this.suff = "";//不提供前缀
	}

	public JspPage(String name, String suff) {
		if(name.contains("?")){
			name = name.substring(0, name.indexOf("?"));
		}
		this.p1 = name;
		if (name.endsWith("/")) {
			this.p2 = name;//取本级目录即可
			name = name.substring(0, name.length() - 1);
		} else {
			this.p2 = name.substring(0, name.lastIndexOf("/")) + "/";// 取上级目录
			this.p1 = name;
		}
		this.page = name;
		if (!suff.endsWith("_")) {
			suff = suff + "_";
		}
		this.suff = suff;
	}

	private String list() {
		return p2 + suff + "list";
	}

	private String add() {
		return p2 + suff + "add";
	}

	private String edit() {
		return p2 + suff + "edit";
	}

	private String info() {
		return p2 + suff + "info";
	}

	private String import_() {
		return p2 + suff + "import";
	}

	private String export() {
		return p2 + suff + "export";
	}

	private String query() {
		return p2 + suff + "query";
	}
	
	private String upload() {
		return p2 + suff + "upload";
	}
	
	private String view() {
		return p2 + suff + "view";
	}

	@Override
	public String toString() {
		if(match == null)
			return page;
		if(match != null){
			switch (match) {
			case "/":
				page = p1;
				break;
			case "/add":
				page = add();
				break;
			case "/edit":
				page = edit();
				break;
			case "/info":
				page = info();
				break;
			case "/list":
				page = list();
				break;
			case "/import":
				page = import_();
				break;
			case "/export":
				page = export();
				break;
			case "/upload":
				page = upload();
				break;
			case "/query":
				page = query();
				break;
			case "/view":
				page = view();
				break;

			default:
				break;
			}
		}
		return page;
	}

	/**
	 * 设置匹配地址
	 * @param match
	 */
	public void setMatchPath(String match) {
		if(match == null)
			return ;
		this.match = null;
		String temp = null;
		for(String str : STRS){
			if(match.endsWith(str)){
				temp = str;
				break;
			}
		}
		this.match = temp;
	}
	
}
