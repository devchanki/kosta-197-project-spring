package org.aptogether.controller;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.aptogether.domain.ComplaintVO;
import org.aptogether.domain.Criteria;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class ComplaintControllerTests1 {
	@Setter(onMethod_= {@Autowired})
	private WebApplicationContext ctx;
	private MockMvc mockMvc;

	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	/*@Test
	public void testList() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/tenant/complist"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
	@Test
	public void testRegister()throws Exception{
		
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/tenant/compregister")
				.param("title", "�׽�Ʈ ����")
				.param("content", "�� ����"))
				.andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}
	@Test
	public void testGet() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/tenant/compget")
				.param("seq", "71"))
				.andReturn()
				.getModelAndView().getModelMap());
	}
	@Test
	public void testRemove()throws Exception{
		String resultPage=mockMvc.perform(MockMvcRequestBuilders.post("/tenant/compremove")
				.param("seq", "61"))
				.andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}*/
	@Test
	public void testListPaging() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/tenant/list")
				.param("pageNum", "2")
				.param("amount", "50"))
				.andReturn().getModelAndView().getModelMap());
	}
	
}
