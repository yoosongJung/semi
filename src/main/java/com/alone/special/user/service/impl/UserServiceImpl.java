package com.alone.special.user.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alone.special.noticeEvent.domain.PageInfo;
import com.alone.special.user.domain.User;
import com.alone.special.user.service.UserService;
import com.alone.special.user.store.UserStore;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private SqlSession session;
	@Autowired
	private UserStore uStore;
	
	// 회원가입
	@Override
	public int insertUser(User user) {
		int result = uStore.insertUser(session, user);
		return result;
	}
	// 회원정보수정
	@Override
	public int updateUser(User user) {
		int result = uStore.updateUser(session, user);
		return result;
	}
	// 회원로그인
	@Override
	public int loginUser(User user) {
		int result = uStore.loginUser(session, user);
		return result;
	}
	@Override
	public User selectUserByNo(Integer userNo) {
		User user = uStore.selectUserByNo(session, userNo);
		return user;
	}
	@Override
	public Integer getUserListCount() {
		int result = uStore.getUserListCount(session);
		return result;
	}
	@Override
	public List<User> selectUserList(PageInfo pInfo) {
		List<User> uList = uStore.selectUserList(session, pInfo);
		return uList;
	}
	@Override
	public Integer getUserListCount(String searchKeyword) {
		int result = uStore.getUserListCount(session, searchKeyword);
		return result;
	}
	@Override
	public List<User> selectUserList(PageInfo pInfo, String searchKeyword) {
		List<User> sList = uStore.selectUserList(session, pInfo, searchKeyword);
		return sList;
	}

}