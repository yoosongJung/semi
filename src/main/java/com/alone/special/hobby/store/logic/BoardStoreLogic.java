package com.alone.special.hobby.store.logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.alone.special.hobby.domain.Board;
import com.alone.special.hobby.domain.PageInfo;
import com.alone.special.hobby.store.BoardStore;

@Repository
public class BoardStoreLogic implements BoardStore {

	@Override
	public int insertBoard(SqlSession session, Board board) {
		int result = session.insert("BoardMapper.insertBoard", board);
		return result;
	}

	@Override
	public Board selectBoardByNo(SqlSession session, Integer hBoardNo) {
		Board boardOne = session.selectOne("BoardMapper.selectBoardByNo", hBoardNo);
		return boardOne;
	}

	@Override
	public int updateBoard(SqlSession session, Board board) {
		int result = session.update("BoardMapper.updateBoard", board);
		return result;
	}

	@Override
	public int deleteBoard(SqlSession session, Board board) {
		int result = session.update("BoardMapper.deleteBoard", board);
		return result;
	}

	@Override
	public List<Board> selectBoardList(SqlSession session, Map<String, Object> getListMap) {
		int limit = ((PageInfo)getListMap.get("pInfo")).getRecordCountPerPage();
	    int offset = (((PageInfo)getListMap.get("pInfo")).getCurrentPage()-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		String categoryName = (String) getListMap.get("refCategoryName");
		List<Board> bList = session.selectList("BoardMapper.selectBoardList", categoryName, rowBounds);
		return bList;
	}

	@Override
	public int getListCount(SqlSession session, String refCategoryName) {
		int result = session.selectOne("BoardMapper.getListCount", refCategoryName);
		return result;
	}

}