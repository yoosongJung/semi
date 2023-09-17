package com.alone.special.user.service;

import java.util.List;

import com.alone.special.noticeEvent.domain.PageInfo;
import com.alone.special.user.domain.User;

public interface UserService {
	/**
	 * 회원가입 service
	 * @param user
	 * @return
	 */
	int insertUser(User user);
	/**
	 * 회원정보수정 service
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	/**
	 * 회원로그인 service
	 * @param user
	 * @return
	 */
	int loginUser(User user);
	/**
	 * 회원정보 service
	 * @param userNo
	 * @return
	 */
	User selectUserByNo(Integer userNo);
	/**
	 * 회원 전체 수 service
	 * @return
	 */
	Integer getUserListCount();
	/**
	 * 회원 전체 리스트 조회 service
	 * @param pInfo
	 * @return
	 */
	List<User> selectUserList(PageInfo pInfo);
	/**
	 * 검색된 회원 수 service
	 * @param searchKeyword
	 * @return
	 */
	Integer getUserListCount(String searchKeyword);
	/**
	 * 회원 검색 리스트 service
	 * @param pInfo
	 * @param searchKeyword
	 * @return
	 */
	List<User> selectUserList(PageInfo pInfo, String searchKeyword);

}