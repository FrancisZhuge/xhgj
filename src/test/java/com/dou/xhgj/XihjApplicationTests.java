package com.dou.xhgj;

import com.dou.xhgj.dao.permission.RoleDao;
import com.dou.xhgj.dao.permission.UserDao;
import com.dou.xhgj.domain.UserInfo;
import com.dou.xhgj.domain.permission.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XihjApplicationTests {
	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;
	@Test
	public void contextLoads() {
		System.out.println(userDao.getUserById(1L));
	}

}
