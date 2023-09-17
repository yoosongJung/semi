package com.alone.special.user.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.alone.special.noticeEvent.domain.PageInfo;
import com.alone.special.user.domain.User;
import com.alone.special.user.store.UserStore;

@Repository
public class UserStoreLogic implements UserStore{
	
	// 회원가입
	@Override
	public int insertUser(SqlSession session, User user) {
		int result = session.insert("UserMapper.insertUser", user);
		return result;
	}
	// 회원정보수정
	@Override
	public int updateUser(SqlSession session, User user) {
		int result = session.update("UserMapper.updateUser", user);
		return result;
	}
	// 회원로그인
	@Override
	public int loginUser(SqlSession session, User user) {
		int result = session.selectOne("UserMapper.loginUser", user);
		return result;
	}
	// 회원정보
	@Override
	public User selectUserByNo(SqlSession session, Integer userNo) {
		return null;
	}
	@Override
	public int getUserListCount(SqlSession session) {
		int result = session.selectOne("UserMapper.getUserListCount");
		return result;
	}
	@Override
	public List<User> selectUserList(SqlSession session, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage()-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<User> uList = session.selectList("UserMapper.selectUserList", null, rowBounds);
		return uList;
	}
	@Override
	public int getUserListCount(SqlSession session, String searchKeyword) {
		int result = session.selectOne("UserMapper.getUserListCountByKeyword", searchKeyword);
		return result;
	}
	@Override
	public List<User> selectUserList(SqlSession session, PageInfo pInfo, String searchKeyword) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage()-1)*limit;
		RowBounds rowBounds = new RowBounds(offset,limit);
		List<User> sList = session.selectList("UserMapper.searchUserByKeyword", searchKeyword, rowBounds);
		return sList;
	}

}