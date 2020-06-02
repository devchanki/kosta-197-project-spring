package org.aptogether.service;




import org.aptogether.domain.ComplaintVO;

import static org.junit.Assert.assertNotNull;

import org.aptogether.domain.ComplaintCriteria;
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

	
	@Test
	public void testRegister(){
		ComplaintVO vo = new ComplaintVO();
		vo.setComptitle("제발 되줘");
		vo.setCompcontent("응?");
		service.registerComplaint(vo);
		log.info("생성된 게시글 번호:" + vo.getCompbno());
	}
	/*@Test
	public void testGetList() {
		service.getCompList().forEach(vo -> log.info(vo));
	}*/
	
	@Test
	public void testGetdetail() {
		log.info(service.getComplaint(81L));
	}
	
	@Test
	public void testDelete(){
		log.info("remove result:" + service.removeComplaint(44L));
	
	}
	
	@Test
	public void testUpdate(){
		ComplaintVO vo = service.getComplaint(62L);
		
		if (vo == null) {
			return;
		}
		vo.setComptitle("수정된 제목");
		log.info("Modify result:" + service.modifyComplaint(vo));
	}
	
	
}
