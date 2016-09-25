package com.zhaojb.testdrive;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zhaojb.bean.User;

public class DeleteTestDrive {
	public static void main(String[] args) {
		String resource = "mybatis-conf.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession sqlSession = sqlSessionFactory.openSession(true);
			String deleteStatement = "com.zhaojb.bean.userMapper.deleteUser";
			User user = new User();
			user.setId(2);
			sqlSession.delete(deleteStatement, user);
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
