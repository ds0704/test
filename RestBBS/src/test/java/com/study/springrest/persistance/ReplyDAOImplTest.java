package com.study.springrest.persistance;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.springrest.domain.ReplyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ReplyDAOImplTest {
	@Inject
	private ReplyDAO dao;
	
	@Test
	public void test(){System.out.println("TestDAO : "+dao);}
	
	@Test
	public void insert() throws Exception{
			ReplyVO vo = new ReplyVO();
			vo.setUser_name("id"+System.currentTimeMillis());
			vo.setContent("Content");
			vo.setBoard_no(7);
			dao.insert(vo);
		}
	
	@Test
	public void get() throws Exception{
			ReplyVO vo = dao.get(6);
			System.out.println("¿Ã∏ß : " + vo.getUser_name());
		}
	
	@Test
	public void getList() throws Exception{
			List<ReplyVO> list = dao.getList(1);
			Iterator<ReplyVO> it = list.iterator();
			while(it.hasNext()){
				ReplyVO vo = it.next();
				System.out.println("user_name : " + vo.getUser_name());
			}
		}
	
	@Test
	public void update() throws Exception{
			ReplyVO vo = new ReplyVO();
			vo.setUser_name("aaaaaaaaa");
			vo.setContent("aaaaaaaaa");
			vo.setReply_no(3);
			dao.update(vo);
		}
	
	@Test
	public void delete() throws Exception{
			dao.delete(5);
		}
}
