package com.alone.special.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alone.special.admin.domain.Singo;
import com.alone.special.admin.service.AdminService;
import com.alone.special.noticeEvent.domain.PageInfo;
import com.alone.special.user.domain.User;
import com.alone.special.user.service.UserService;

@Controller
public class AdminController {

	@Autowired
	private AdminService aService;
	@Autowired
	private UserService uService;
	
	@RequestMapping(value="/member/list.do", method=RequestMethod.GET)
	public ModelAndView showMemberList(ModelAndView mv,
			@RequestParam(value="currentPage", required=false, defaultValue="1") Integer currentPage) {
		try {
			Integer totalCount = uService.getUserListCount();
			PageInfo pInfo = this.getPageInfo(totalCount, currentPage);
			List<User> mList = uService.selectUserList(pInfo);
			if(!mList.isEmpty()) {
				mv.addObject("mList", mList).addObject("pInfo", pInfo).setViewName("admin/manageMember");
			} else {
				mv.addObject("msg", "멤버 조회가 완료되지 않았습니다.");
				mv.addObject("url", "/index.jsp");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", "멤버 조회가 완료되지 않았습니다.");
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	
	@RequestMapping(value="/manageBoard/list.do", method=RequestMethod.GET)
	public ModelAndView showManageBoardList(ModelAndView mv) {
		
		mv.setViewName("admin/manageBoard");
		return mv;
	}
	
	@RequestMapping(value="/member/search.do", method=RequestMethod.GET)
	public ModelAndView showSearchMemberList(ModelAndView mv,
			@RequestParam("searchKeyword") String searchKeyword,
			@RequestParam(value="currentPage", required=false, defaultValue="1") Integer currentPage) {
		try {
			Integer totalCount = uService.getUserListCount(searchKeyword);
			PageInfo pInfo = this.getPageInfo(totalCount, currentPage);
			List<User> searchList = uService.selectUserList(pInfo, searchKeyword);
			if(!searchList.isEmpty()) {
				mv.addObject("searchKeyword", searchKeyword).addObject("pInfo", pInfo)
				.addObject("sList", searchList).setViewName("admin/manageMemberSearch");
			} else {
				mv.addObject("msg", "멤버검색 조회가 완료되지 않았습니다.");
				mv.addObject("url", "/index.jsp");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", "멤버검색 조회가 완료되지 않았습니다.");
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	
	@RequestMapping(value="/admin/singo.do", method=RequestMethod.POST)
	public ModelAndView insertSingo(ModelAndView mv) {
		try {
			//파라값들 받아서  singo 클래스에 넣어서 보내기-ajax로 받아서 String으로 리턴?
			Singo singo = new Singo();// 오라클에 singoLocationTitle 하나 더 만들기.

			int result = aService.insertSingo(singo);
		} catch (Exception e) {
			mv.addObject("msg", "신고 등록이 완료되지 않았습니다.");
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/singo/list.do", method=RequestMethod.GET)
	public ModelAndView showSingoList(ModelAndView mv,
			@RequestParam(value="currentPage", required=false, defaultValue="1") Integer currentPage) {
		try {
			Integer totalCount = aService.getSingoListCount();
			PageInfo pInfo = this.getPageInfo(totalCount, currentPage);
			List<Singo> singoList = aService.selectSingoList(pInfo);
			if(!singoList.isEmpty()) {
				mv.addObject("singoList", singoList).addObject("pInfo", pInfo).setViewName("admin/singo");
			} else {
				mv.addObject("msg", "신고 회원 조회가 완료되지 않았습니다.");
				mv.addObject("url", "/index.jsp");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", "신고 회원 조회가 완료되지 않았습니다.");
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/singo/search.do", method=RequestMethod.GET)
	public ModelAndView showSearchSingoList(ModelAndView mv,
			@RequestParam("searchKeyword") String searchKeyword,
			@RequestParam(value="currentPage", required=false, defaultValue="1") Integer currentPage) {
		try {
			Integer totalCount = aService.getSingoListCount(searchKeyword);
			PageInfo pInfo = this.getPageInfo(totalCount, currentPage);
			List<Singo> searchList = aService.selectSingoList(pInfo, searchKeyword);
			if(!searchList.isEmpty()) {
				mv.addObject("searchKeyword", searchKeyword).addObject("pInfo", pInfo)
				.addObject("singoList", searchList).setViewName("admin/singoSearch");
			} else {
				mv.addObject("msg", "신고회원 검색이 완료되지 않았습니다.");
				mv.addObject("url", "/singo/list.do");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", "신고회원 검색이 완료되지 않았습니다.");
			mv.addObject("url", "/singo/list.do");
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	
	@RequestMapping(value="/singo/delete.do", method=RequestMethod.GET)
	public ModelAndView deleteSingo(ModelAndView mv,
			@RequestParam("singoNo") Integer singoNo) {
		try {
			int result = aService.deleteSingo(singoNo);
			if(result > 0) {
				mv.setViewName("redirect:/singo/list.do");
			} else {
				mv.addObject("msg", "신고 취소 실패");
				mv.addObject("url", "/singo/list.do");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", "신고 취소가 완료되지 않았습니다.");
			mv.addObject("url", "/singo/list.do");
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	
	public PageInfo getPageInfo(int totalCount,int currentPage) {
		PageInfo page =null;
		int recordCountPerPage = 10;
		int naviCountPerPage = 10;
		int naviTotalCount;
		int startNavi;
		int endNavi;
		naviTotalCount =(int)((double)totalCount/recordCountPerPage + 0.9);
		startNavi = (((int)((double)currentPage/naviCountPerPage+0.9))-1)*naviCountPerPage+1;
		endNavi = startNavi + naviCountPerPage - 1;
		//endNavi는 startNavi에 무조건 naviCountPerPage에 값을 더하므로 실제 최대값 보다 무조건 클 수 있다.
		if(endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		page = new PageInfo(currentPage, totalCount, naviTotalCount, recordCountPerPage, naviCountPerPage, startNavi, endNavi);
				
		return page;
	}
}
