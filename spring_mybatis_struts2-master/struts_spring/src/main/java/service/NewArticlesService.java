package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.TimechoContentsMapper;
import entity.TimechoContents;
import entity.TimechoContentsExample;

@ Repository
public class NewArticlesService {
	private static final Logger logger = Logger.getLogger(NewArticlesService.class);
	@Autowired
	private TimechoContentsMapper timechoContentsMapper;
	
	public List<TimechoContents> getAllArticles() {
		TimechoContentsExample contentsExample = new TimechoContentsExample();
		contentsExample.createCriteria().andTitleIsNotNull();
		contentsExample.setOrderByClause("created DESC");
		//contentsExample.
		//RowBounds rowBounds = new RowBounds(0, 10);
		List<TimechoContents> lists = timechoContentsMapper.selectByExampleWithBLOBs(contentsExample);
		// List<TimechoContents> lists = timechoContentsMapper.selectByExampleWithBLOBsWithRowbounds(contentsExample,rowBounds);
		 return lists;
	}
}
