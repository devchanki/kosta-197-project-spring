package org.aptogether.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.aptogether.domain.FeeVO;
import org.aptogether.domain.LevyVO;
import org.aptogether.domain.MemberVO;
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
public class FeeMapperTests {

	@Setter(onMethod_= @Autowired)
	private FeeMapper mapper;
	
//	@Test
//	public void testFindMember(){
//		
//		UserVO user = new UserVO();
//		user.setAptSeq(6);
//		user.setDong("101");
//		user.setHo("1101");
//		
//		mapper.findMember(user);
//		
//		log.info(user);
//	}
	
//	@Test
//	public void testInsert(){
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
//		fee.setPayDate("2020-06-01");
//		
//		mapper.insertFee(fee);
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
//		mapper.listFee(user).forEach(fee -> log.info(fee));
//	}
	
//	@Test
//	public void testListFeeRowNum(){
//		
//		MemberVO user = new MemberVO();
//		user.setAptSeq(6);
//		user.setMemberSeq(30);
//		
//		mapper.listFeeRowNum(user).forEach(feeRowNum -> log.info(feeRowNum));
//	}
	
	@Test
	public void testFeeList(){
		
		
				
		
		mapper.listFeeReg("2020/02/01", 1).forEach(feeVO -> log.info(feeVO));
	}

}
