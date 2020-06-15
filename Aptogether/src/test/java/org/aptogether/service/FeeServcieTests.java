package org.aptogether.service;

import static org.junit.Assert.assertNotNull;

import org.aptogether.domain.FeeVO;
import org.aptogether.domain.TenantVO;
import org.aptogether.mapper.FeeMapperTests;
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
public class FeeServcieTests {

	@Setter(onMethod_= {@Autowired})
	private FeeService service;
	
//	@Test
//	public void test(){
//		
//		log.info(service);
//		assertNotNull(service);
//	}
	

//	@Test
//	public void testFindMember(){
//		
//		UserVO user = new UserVO();
//		user.setAptSeq(6);
//		user.setDong("101");
//		user.setHo("1101");
//		
//		service.findMember(user);
//		
//		log.info(user);
//	}
	
//	@Test
//	public void testInsertFee(){
//		
//		FeeVO fee = new FeeVO();
//		fee.setMemberSeq(30);
//		fee.setGeneralFee(1);
//		fee.setSecurityFee(1);
//		fee.setCleaningFee(1);
//		fee.setFumigationFee(1);
//		fee.setLiftMaintenanceFee(1);
//		fee.setElectricityFee(1);
//		fee.setWaterFee(1);
//		fee.setHeatingFee(1);
//		fee.setPayDate("2020-07-31");		
//		
//		service.insertFee(fee);
//		
//		log.info(fee);
//	}
	
//	@Test
//	public void testListFee(){
//		
//		UserVO user = new UserVO();
//		user.setAptSeq(6);
//		user.setMemberSeq(30);		
//		
//		service.listFee(user).forEach(fee -> log.info(fee));
//	}
	
//	@Test
//	public void testListFeeRowNum(){
//		
//		UserVO user = new UserVO();
//		user.setAptSeq(6);
//		user.setMemberSeq(30);		
//		
//		service.listFeeRowNum(user).forEach(feeRowNume -> log.info(feeRowNume));
//	}
}
