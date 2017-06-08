package com.june.common;

import static org.junit.Assert.*;

import org.junit.Test;

public class JspPageTest {
	static JspPage page = new JspPage("system/log/logger", "abc");
	
	@Test
	public void testList() {
		assertEquals("system/log/logger", page.toString());
		page.setMatchPath("system/log/list");
		assertEquals("system/log/abc_list", page.toString());
	}
	@Test
	public void testQuest(){
		page = new JspPage("system/log/logger?id=123", "abc");
		assertEquals("system/log/logger", page.toString());
	}
	@Test
	public void testOneParams(){
		page = new JspPage("system/log/logger?id=123");
		assertEquals("system/log/logger", page.toString());
	}
	@Test
	public void testOneParams2(){
		page = new JspPage("system/log/logger?id=123");
		page.setMatchPath("system/log/add");
		assertEquals("system/log/logger/add", page.toString());
	}

}
