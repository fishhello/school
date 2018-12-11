package service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.TimechoContentsPlusMapper;
import entity.TimechoContentsPlus;

@ Repository
public class SingleArticlesService {
	private static final Logger logger = Logger.getLogger(SingleArticlesService.class);
	@Autowired
	private TimechoContentsPlusMapper timechoContentsPlusMapper;
	
	public TimechoContentsPlus getCurrentContent(int cid) {
		return timechoContentsPlusMapper.selectContentsById(cid);
	}
}
