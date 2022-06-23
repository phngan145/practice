package com.kits.ngan.service;

import java.util.List;

import com.kits.ngan.dao.BlogUserDao;
import com.kits.ngan.entity.BlogUser;

public class BlogWebService extends BlogService{

	BlogUserDao blogUserDao = new BlogUserDao();
	public void addUser(BlogUser user) {
		// TODO Auto-generated method stub
		
		blogUserDao.insert(user);
	}
	
	public List<BlogUser> getAllUser(){
		return blogUserDao.findAll();
		
	}

	
	
	

}