package org.aptogether.controller;

import static org.junit.Assert.*;

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
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml","file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class NoticeControllerTests {

	@Setter(onMethod_=@Autowired)
	private WebApplicationContext ctx;
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();		
	}
	
	
//	@Test
//	public void testList()throws Exception {
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/keeper/list"))
//				.andReturn()
//				.getModelAndView()
//				.getModelMap());		
//	}

	
//	@Test
//	public void testRegister()throws Exception{
//		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/keeper/register")
//				.param("title", "테스트 새로운 글 제목")
//				.param("content","새로운 내용임당")
//				.param("category", "일반")
//				).andReturn().getModelAndView().getViewName();
//		log.info(resultPage);
//	}
	
//	@Test
//	public void testGet() throws Exception{
//		log.info(mockMvc.perform(MockMvcRequestBuilders
//				.get("/keeper/get")
//				.param("noticeSeq", "7"))
//				.andReturn()
//				.getModelAndView().getModelMap());
//	}
	
//	@Test
//	public void testModify()throws Exception{
//		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/keeper/modify")
//				.param("noticeSeq", "7")
//				.param("title", "수정의 수정을 거듭한다")
//				.param("content", "수정된 내용")
//				.param("category", "공지"))
//				.andReturn().getModelAndView().getViewName();
//				log.info(resultPage);
//				
//	}
	
	@Test
	public void testRemove()throws Exception{
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/keeper/removeNotice")
				.param("noticeSeq", "10"))
				.andReturn().getModelAndView().getViewName();
				log.info(resultPage);
	}
	

}
