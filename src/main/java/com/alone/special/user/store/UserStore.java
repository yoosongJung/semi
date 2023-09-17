package com.alone.special.user.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.alone.special.noticeEvent.domain.PageInfo;
import com.alone.special.user.domain.User;

public interface UserStore {
	/**
	 * 회원가입 store
	 * @param session
	 * @param user
	 * @return
	 */
	int insertUser(SqlSession session, User user);
	/**
	 * 회원정보수정 store
	 * @param session
	 * @param user
	 * @return
	 */
	int updateUser(SqlSession session, User user);
	/**
	 * 회원로그인 store
	 * @param session
	 * @param user
	 * @return
	 */
	int loginUser(SqlSession session, User user);
	/**
	 * 회원정보 store
	 * @param session
	 * @param userNo
	 * @return
	 */
	User selectUserByNo(SqlSession session, Integer userNo);
	/**
	 * 회원 전체 수 store
	 * @param session
	 * @return
	 */
	int getUserListCount(SqlSession session);
	/**
	 * 회원 전체 리스트 store
	 * @param session
	 * @param pInfo
	 * @return
	 */
	List<User> selectUserList(SqlSession session, PageInfo pInfo);
	/**
	 * 검색 회원 수 store
	 * @param session
	 * @param searchKeyword
	 * @return
	 */
	int getUserListCount(SqlSession session, String searchKeyword);
	/**
	 * 회원 검색 리스트 store
	 * @param session
	 * @param pInfo
	 * @param searchKeyword
	 * @return
	 */
	List<User> selectUserList(SqlSession session, PageInfo pInfo, String searchKeyword);

}