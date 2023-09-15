package com.alone.special.admin.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alone.special.admin.service.AdminService;
import com.alone.special.admin.store.AdminStore;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private AdminStore aStore;
}
