package service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.TimechoContentsMapper;
import entity.TimechoContents;
import entity.TimechoContentsExample;

@ Repository
public class HotArticlesService {
	private static final Logger logger = Logger.getLogger(HotArticlesService.class);
	@Autowired
	private TimechoContentsMapper timechoContentsMapper;
	
	public List<TimechoContents> getHotArticles() {
		TimechoContentsExample contentsExample = new TimechoContentsExample();
		contentsExample.setOrderByClause("likes desc");
		contentsExample.setDistinct(false);
		contentsExample.createCriteria().andTitleIsNotNull().andLikesGreaterThan(0);
		
		//分页查询
		RowBounds rowBounds = new RowBounds(0, 20);
		 List<TimechoContents> lists = timechoContentsMapper.selectByExampleWithBLOBsWithRowbounds(contentsExample,rowBounds);
		 return lists;
	}
}
