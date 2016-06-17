package com.study.springrest.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.study.springrest.domain.RestVO;
import com.study.springrest.persistance.RestDAO;

@Service
public class RestServiceImpl implements RestService {
	
	@Inject //inject는 이름에 상관없이 타입만 맞으면 @Resource  @Autowired는 이름이 동일해야한다
	private RestDAO dao;
	
	@Override
	public RestVO get(int board_no) {
		// TODO Auto-generated method stub
		return dao.get(board_no);
	}

	@Override
	public List<RestVO> getList() {
		// TODO Auto-generated method stub
		return dao.getList();
	}

	@Override
	public void insert(RestVO vo) {
		// TODO Auto-generated method stub
		dao.insert(vo);
	}

	@Override
	public void update(RestVO vo) {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void delete(int board_no) {
		// TODO Auto-generated method stub
		dao.delete(board_no);
	}

	@Override
	public void increaseReply(int board_no) {
		// TODO Auto-generated method stub
		dao.increaseReply(board_no);
	}

}
