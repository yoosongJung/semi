package com.alone.special.moim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MoimController {

	
	@RequestMapping(value="/moim/workingSchedule.do", method=RequestMethod.GET)
	public ModelAndView showWorkingSchedule(ModelAndView mv) {
		
		mv.setViewName("moim/workingSchedule");
		return mv;
	}
	
	@RequestMapping(value="/moim/moimSide.do", method=RequestMethod.GET)
	public ModelAndView showMoimSide(ModelAndView mv) {
		
		mv.setViewName("moim/moimSide");
		return mv;
	}
}
