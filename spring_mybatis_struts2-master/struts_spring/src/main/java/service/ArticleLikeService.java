package service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.TimechoCommentsMapper;
import dao.TimechoContentsMapper;
import entity.TimechoContents;
import entity.TimechoContentsExample;

@ Repository
public class ArticleLikeService {
	private static final Logger logger = Logger.getLogger(ArticleLikeService.class);
	@Autowired
	private TimechoContentsMapper timechoContentsMapper;
	
	public int save(int cid,int like) {
		TimechoContents timechoContents = new TimechoContents();
		timechoContents.setLikes(like);
		
		TimechoContentsExample timechoContentsExample = new TimechoContentsExample();
		timechoContentsExample.createCriteria().andCidEqualTo(cid);
		
		int count = timechoContentsMapper.updateByExampleSelective(timechoContents, timechoContentsExample);
		return count;
	}
}
