package com.study.springrest.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.springrest.domain.Criteria;
import com.study.springrest.domain.ReplyVO;
import com.study.springrest.persistance.ReplyDAO;
import com.study.springrest.persistance.RestDAO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Inject
	private ReplyDAO dao;
	
	@Inject
	private RestDAO restDao;
	
	@Override
	public ReplyVO get(int reply_no) {
		// TODO Auto-generated method stub
		return dao.get(reply_no);
	}

	@Override
	public List<ReplyVO> getList(int board_no) {
		// TODO Auto-generated method stub
		return dao.getList(board_no);
	}
	
	@Override
	public List<ReplyVO> getListPage(int board_no, Criteria criteria) {
		// TODO Auto-generated method stub
		return dao.getListPage(board_no, criteria);
	}
	
	@Override
	public int getTotalCount(int board_no) {
		// TODO Auto-generated method stub
		return dao.getTotalCount(board_no);
	}
	
	@Transactional
	@Override
	public void insert(ReplyVO vo) {
		// TODO Auto-generated method stub
		dao.insert(vo);
		restDao.increaseReply(vo.getBoard_no());
	}

	@Override
	public void update(ReplyVO vo) {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void delete(int reply_no) {
		// TODO Auto-generated method stub
		dao.delete(reply_no);
	}
	
	@Override
	public void delete_Board(int board_no) {
		// TODO Auto-generated method stub
		dao.delete_Board(board_no);
	}

	

	
}
