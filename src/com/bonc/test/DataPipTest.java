package com.bonc.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bonc.java.RingStringBuffer;

public class DataPipTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws Exception {
		RingStringBuffer buffer = new RingStringBuffer(5);
		buffer.put("abc"); // abc
		buffer.get(1); //-> return "a".
		buffer.put("def"); // bcdef
		buffer.put("aaa"); // bcdefaaa. When the size is not enough, double the size. size=10
		buffer.size(); //-> return 10;
		buffer.get(6); //-> return "bcdefa"
		buffer.size(); //-> return 10;
		buffer.put("aaa");// aaaaa
		//buffer.get(10); //-> throw exception
		buffer.get(5);  //-> return "aaaaa"
	}

}
