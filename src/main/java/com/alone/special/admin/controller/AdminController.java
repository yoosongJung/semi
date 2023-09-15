package com.alone.special.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alone.special.admin.service.AdminService;
import com.alone.special.noticeEvent.domain.PageInfo;

@Controller
public class AdminController {

	@Autowired
	private AdminService aService;
	
//	@RequestMapping(value="/member/list.do", method=RequestMethod.GET)
//	public ModelAndView showMemberList(ModelAndView mv,
//			@RequestParam(value="currentPage", required=false, defaultValue="1") Integer currentPage) {
//		try {
//			Integer totalCount = aService.getMemberListCount();
//			PageInfo pInfo = this.getPageInfo(totalCount, currentPage);
//			List<Member> mList = aService.selectMemberList(pInfo);
//			if(!mList.isEmpty()) {
//				mv.addObject("mList", mList).addObject("pInfo", pInfo).setViewName("admin/manageMember");
//			} else {
//				mv.addObject("msg", "멤버 조회가 완료되지 않았습니다.");
//				mv.addObject("url", "/index.jsp");
//				mv.setViewName("common/errorPage");
//			}
//		} catch (Exception e) {
//			mv.addObject("msg", "멤버 조회가 완료되지 않았습니다.");
//			mv.addObject("url", "/index.jsp");
//			mv.setViewName("common/errorPage");
//		}
//		
//		return mv;
//	}
	
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
