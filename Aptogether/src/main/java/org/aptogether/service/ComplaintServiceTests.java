package org.aptogether.service;




import org.aptogether.domain.ComplaintVO;
import org.aptogether.domain.Criteria;
import org.aptogether.service.ComplaintService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ComplaintServiceTests {

	@Setter(onMethod_={@Autowired})
	private ComplaintService service;
	
	/*@Test
	public void testGetList() {
		service.getCompList().forEach(Complaint -> log.info(Complaint));
	}
	@Test
	public void testGetdetail() {
		log.info(service.getComp(1L));
	}*/
	
	/*@Test
	public void testDelete(){
		log.info("remove result:" + service.remove(67L));
	
	}*/
	
	/*@Test
	public void testUpdate(){
		ComplaintVO vo = service.getComp(62L);
		
		if (vo == null) {
			return;
		}
		vo.setTitle("수정된 제목");
		log.info("Modify result:" + service.modifyComp(vo));
	}*/
	
	
}
