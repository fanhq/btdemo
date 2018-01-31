package com.fanhq.btdemo;

import com.fanhq.btdemo.free.ProperiesConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {Application.class}, webEnvironment= SpringBootTest.WebEnvironment.NONE)
public class BtdemoTests {

	@Autowired
	private ProperiesConfig properiesConfig;

	@Test
	public void contextLoads() {
		System.out.println(properiesConfig.getName());
		System.out.println(properiesConfig.getAddrMy());
	}

}
