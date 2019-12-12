package com.neuedu.demo.domain;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class NewSession {
	private static SqlSession session=null;
	public static SqlSession getSession(){
		String resource = "mybatis-config.xml";
    	InputStream inputStream = null;
    	SqlSessionFactory sqlSessionFactory=null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
		return session;
	}
	
}
