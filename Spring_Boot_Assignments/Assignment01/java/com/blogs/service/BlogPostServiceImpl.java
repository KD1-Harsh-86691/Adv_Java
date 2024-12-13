package com.blogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.dao.BlogPostDao;
import com.blogs.pojos.BlogPost;

@Service
@Transactional
public class BlogPostServiceImpl implements BlogPostService {
	@Autowired
	private BlogPostDao postDao;
	
	@Override
	public List<BlogPost> getAllBlogPosts() {
		
		return postDao.findAll();
	}

}
