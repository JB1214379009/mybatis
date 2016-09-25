package com.zhaojb.testdrive;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zhaojb.bean.User;

public class InsertTestDrive { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String resource = "mybatis-conf.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sqlSessionFactory.openSession(true);
			String insertStatement = "com.zhaojb.bean.userMapper.addUser";
			User user = new User();
			user.setName("新增的名字");
			user.setAge(25);
			session.insert(insertStatement, user);
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
