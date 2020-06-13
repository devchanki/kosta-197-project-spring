package org.aptogether.service;

import org.aptogether.domain.AptVO;
import org.aptogether.mapper.AptMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class AptServiceImpl implements AptService {

	private AptMapper aptMapper;

	@Override
	public int insertApt(AptVO apt) {
		if (aptMapper.aptCount(apt) == 0) {
			return aptMapper.insertApt(apt);
			
		} else {
			return aptMapper.insertApt(apt);
		}
	}

}
