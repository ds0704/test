package com.study.springrest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.study.springrest.domain.Criteria;
import com.study.springrest.domain.PageMaker;
import com.study.springrest.domain.ReplyVO;
import com.study.springrest.domain.RestVO;
import com.study.springrest.service.ReplyService;
import com.study.springrest.service.RestService;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value = "/reply")
public class Reply {
	
	private static final Logger logger = LoggerFactory.getLogger(Reply.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Inject
	private ReplyService service;
	
	// /����/ ���
	@RequestMapping(value = "/{board_no}", method = RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("board_no") Integer board_no) {
		
		ResponseEntity<List<ReplyVO>> entity = null;
		try{
			entity = new ResponseEntity<List<ReplyVO>>(service.getList(board_no), HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	// /����/ method = post
	@RequestMapping(value = "/{board_no}", method = RequestMethod.POST)
	public ResponseEntity<String> insert(@RequestBody ReplyVO vo, @PathVariable("board_no") Integer board_no, Model model) {
		System.out.println(board_no);
		ResponseEntity<String> entity = null;
		try{
			vo.setBoard_no(board_no);
			
			service.insert(vo);
			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	// /����/ method = post
	@RequestMapping(value = "/{reply_no}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("reply_no") Integer reply_no, Model model) {
		
		ResponseEntity<String> entity = null;
		try{
			System.out.println(reply_no);
			service.delete(reply_no);
			
			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	// /����/ �������¡
		@RequestMapping(value = "/{board_no}/{page}", method = RequestMethod.GET)
		public ResponseEntity<Map<String,Object>> listPage(
				@PathVariable("board_no") Integer board_no, 
				@PathVariable("page") Integer page) {
			
			ResponseEntity<Map<String,Object>> entity = null;
			try{
				//������ó���� ���� Criteria����
				Criteria criteria = new Criteria();
				criteria.setPage(page);
				
				//��� ���� ��������
				int replyTotal = service.getTotalCount(board_no);
				
				//��� ��������
				List<ReplyVO> list = service.getListPage(board_no,criteria);
				
				//������ ����Ŀ�� �� ��� ������ ���� �������� �ִ� Criteria�� �Ѱܼ� ����¡ ���� ����Ѵ�
				PageMaker pm = new PageMaker(criteria, replyTotal);
				
				//���������� ��� ��ϰ� ����¡ ó������ ��Ƽ�
				Map<String,Object> map = new HashMap<>();
				map.put("l", list);
				map.put("p", pm);
				
				//�������� ����
				entity = new ResponseEntity<>(map, HttpStatus.OK);
			}catch(Exception e){
				entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			return entity;
		}
	
}