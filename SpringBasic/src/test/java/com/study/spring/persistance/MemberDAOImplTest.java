package com.study.spring.persistance;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.spring.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOImplTest {
	@Inject
	private MemberDAOImpl dao;
	@Test
	public void test(){System.out.println("TestDAO : "+dao);}
	@Test
	public void getNow(){System.out.println("TestDAO now = " + dao.getNow());}
	@Test
	public void insert() throws Exception{
			MemberVO vo = new MemberVO();
			vo.setUser_id("id"+System.currentTimeMillis());
			vo.setPw("pw");
			vo.setUser_name("name");
			vo.setEmail("email");
			dao.insertMember(vo);
		}
	@Test
	public void get() throws Exception{
			MemberVO vo = dao.get("id");
			System.out.println("¿Ã∏ß : " + vo.getUser_name());
		}
	@Test
	public void getList() throws Exception{
			List<MemberVO> list = dao.getList();
			Iterator<MemberVO> it = list.iterator();
			while(it.hasNext()){
				MemberVO vo = it.next();
				System.out.println("pw : " + vo.getPw());
			}
		}
	@Test
	public void update() throws Exception{
			MemberVO vo = new MemberVO();
			vo.setUser_id("id");
			vo.setPw("123");
			dao.update(vo);
		}
	@Test
	public void delete() throws Exception{
			dao.delete("123");
		}
}
