package com.study.spring.persistance;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.study.spring.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.study.spring.mappers.memberMapper";
	
	@Override
	public String getNow(){
		return sqlSession.selectOne(namespace+".getNow");
	}
	
	@Override
	public void insertMember(MemberVO vo){
		sqlSession.insert(namespace+".insertMember",vo);
	}

	@Override
	public MemberVO get(String user_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".get", user_id);
	}

	@Override
	public List<MemberVO> getList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".getList");
	}
	
	@Override
	public void update(MemberVO vo){
		sqlSession.update(namespace+".update",vo);
	}
	
	@Override
	public void delete(String user_id){
		sqlSession.delete(namespace+".delete",user_id);
	}
}
