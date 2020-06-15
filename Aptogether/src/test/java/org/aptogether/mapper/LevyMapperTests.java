package org.aptogether.mapper;

import org.aptogether.domain.LevyVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class LevyMapperTests {
	
	@Setter(onMethod_= @Autowired)
	private LevyMapper mapper;
	
	@Test
	public void testAddLevy(){
		
		LevyVO levy = new LevyVO();
		
		levy.setLevyDate("2020-06");
		levy.setStartCalDate("2020-06-01");
		levy.setEndCalDate("2020-06-30");
		levy.setDeadlineDate("2020-06-27");
		
		mapper.addLevy(levy);
		
	}

}
