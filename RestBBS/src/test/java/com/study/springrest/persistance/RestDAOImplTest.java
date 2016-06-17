package com.study.springrest.persistance;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.springrest.domain.RestVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class RestDAOImplTest {
	@Inject
	private RestDAO dao;
	
	@Test
	public void test(){System.out.println("TestDAO : "+dao);}
	
	@Test
	public void insert() throws Exception{
			RestVO vo = new RestVO();
			vo.setUser_name("id"+System.currentTimeMillis());
			vo.setContent("Content");
			vo.setTitle("Title");
			dao.insert(vo);
		}
	
	@Test
	public void get() throws Exception{
			RestVO vo = dao.get(7);
			System.out.println("¿Ã∏ß : " + vo.getUser_name());
		}
	
	@Test
	public void getList() throws Exception{
			List<RestVO> list = dao.getList();
			Iterator<RestVO> it = list.iterator();
			while(it.hasNext()){
				RestVO vo = it.next();
				System.out.println("user_name : " + vo.getUser_name()+"\ntitle : " + vo.getTitle());
			}
		}
	
	@Test
	public void update() throws Exception{
			RestVO vo = new RestVO();
			vo.setUser_name("aaaaaaaaa");
			vo.setContent("§§§©§∑");
			vo.setTitle("§§§©§§");
			vo.setBoard_no(2);
			dao.update(vo);
		}
	
	@Test
	public void delete() throws Exception{
			dao.delete(1);
		}
}
