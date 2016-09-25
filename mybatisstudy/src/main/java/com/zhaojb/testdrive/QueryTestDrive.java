package com.zhaojb.testdrive;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zhaojb.bean.User;

public class QueryTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String resource = "mybatis-conf.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession sqlSession = sqlSessionFactory.openSession(true);
			String queryStatement = "com.zhaojb.bean.userMapper.getUser";
			User user = sqlSession.selectOne(queryStatement, 1);
			sqlSession.close();
			System.out.println(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
