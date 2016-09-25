package com.zhaojb.testdrive;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zhaojb.bean.User;

public class UpdateTestDrive {
	public static void main(String[] args) {
		String resource = "mybatis-conf.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession sqlSession = sqlSessionFactory.openSession(true);
			String updateStatement = "com.zhaojb.bean.userMapper.updateUser";
			User user = new User();
			user.setId(1);
			user.setName("修改后的名字");
			user.setAge(21);
			sqlSession.update(updateStatement, user);
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
