/*package org.aptogether.mapper;


import java.util.List;

import org.aptogether.domain.ComplaintVO;
import org.aptogether.domain.ComplaintCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_=@Autowired)
	private ComplaintMapper mapper;
	
	@Test
	public void testPaging() {
		ComplaintCriteria cri = new ComplaintCriteria();
		cri.setPageNum(3);
		cri.setAmount(10);
		List<ComplaintVO> complist = mapper.getCompListWithPaging(cri);
		complist.forEach(vo -> log.info(vo.getCompbno()));
	}

}
*/