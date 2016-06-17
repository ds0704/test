package com.study.springrest.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.study.springrest.domain.ReplyVO;
import com.study.springrest.domain.RestVO;
import com.study.springrest.service.ReplyService;
import com.study.springrest.service.RestService;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value = "/rest")
public class Rest {
	
	private static final Logger logger = LoggerFactory.getLogger(Rest.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Inject
	private RestService service;
	
	@Inject
	private ReplyService service2;
	
	// /¿Ø¥÷/ ∏Ò∑œ
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView list(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list");// = new ModelAndView("list")
		List<RestVO> rest_list = service.getList();
		model.addAttribute("rest_list",rest_list);//=mav.addObject("rest_list",rest_list);
		return mav;
	}
	
	// /¿Ø¥÷/ ∏Ò∑œ
	@RequestMapping(value = "/{board_no}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("board_no") Integer board_no, Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("detail");
		RestVO vo = service.get(board_no);
		model.addAttribute("vo",vo);
		return mav;
	}
	
	// /¿Ø¥÷/new ±€æ≤±‚∆‰¿Ã¡ˆ
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView write(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("write");
		return mav;
	}
	
	// /¿Ø¥÷/ method = post
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView insert(RestVO vo, Model model) {
		service.insert(vo);
		
		return new ModelAndView("redirect:/rest");
	}
	
	// /¿Ø¥÷/π¯»£ ªË¡¶
	@RequestMapping(value = "/{board_no}", method = RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable("board_no") Integer board_no) {
		service2.delete_Board(board_no);
		
		service.delete(board_no);
		
		return new ModelAndView("redirect:/rest");
	}
}
