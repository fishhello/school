package service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.TimechoBlockMapper;
import entity.TimechoBlock;
import entity.TimechoBlockExample;

@ Repository
public class ClassifiesaService {
	private static final Logger logger = Logger.getLogger(ClassifiesaService.class);
	@Autowired
	private TimechoBlockMapper timechoBlockMapper;
	
	public List<TimechoBlock> getAllTag(){
		TimechoBlockExample timechoBlockExample = new TimechoBlockExample();
		timechoBlockExample.createCriteria().andBnameIsNotNull();
		return timechoBlockMapper.selectByExample(timechoBlockExample);
	}
}
