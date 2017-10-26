package com.dou.xhgj;

import com.alibaba.fastjson.JSONObject;
import com.dou.xhgj.domain.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XihjApplicationTests {

	@Test
	public void contextLoads() {
		UserInfo userInfo = new UserInfo();
		userInfo.setLocked(false);
		userInfo.setPassword("11");
		userInfo.setSalt("2333");
		userInfo.setAreaId(1L);
		userInfo.setBuildingId(1L);
		userInfo.setId(1L);
		userInfo.setUsername("cc");
		userInfo.setUserNo("111");
		JSONObject data = new JSONObject();
		data.put("user",userInfo);
		System.out.println(data.toJSONString());
	}

}
