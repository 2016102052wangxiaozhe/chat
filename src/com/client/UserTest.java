package com.client;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class UserTest {

	User book=null;
	
	@Before
	public void setup() throws Exception {
		System. out.println("���Կ�ʼ��");
		 book = new User();
		System.out.println("book���󱻳�ʼ����");
	}
	
	@After
	public void tearDown() throws Exception {
	     System.out.println("book���󽫱�����");
	      book = null;
	     System.out.println("���Խ�����");
	  }

	
	@Test
	public void testSetUsername() {
		 book.setUsername("ASP"); //����name���Ե�ֵΪASP
		   //ʹ��Assert�鿴name���Ե�ֵ�Ƿ�ΪASP�����Ǹ���Ȼ���ִ���Ĳ���
		 assertEquals("ASP", book.getUsername());
		 System.out.println("Username���Ա����ԣ�");
	
	}

	@Test
	public void testSetIP() {
	      book.setIP("001"); //����id���Ե�ֵΪ001
			 //ʹ��Assert�鿴id���Ե�ֵ�Ƿ�Ϊ001
		  assertEquals("001", book.getIP());
		  System.out.println("ip���Ա����ԣ�");
	}

	

}
