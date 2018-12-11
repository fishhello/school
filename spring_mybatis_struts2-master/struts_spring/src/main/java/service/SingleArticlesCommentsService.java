package service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.TimechoCommentsPlusMapper;

/**
 * 
* @ClassName: SingleArticlesCommentsService 
* @Description: TODO(根据传递的文章id查找该文章所有的评论) 
* @author shafish
* @date 2018年6月20日 下午12:19:36 
*
 */
@ Repository
public class SingleArticlesCommentsService {
	private static final Logger logger = Logger.getLogger(SingleArticlesCommentsService.class);
	@Autowired
	private TimechoCommentsPlusMapper timechoCommentsPlusMapper;
	
	public List getCurrentComments(int cid) {
		//
		return timechoCommentsPlusMapper.selectCommentsById(cid);
	}
	
}
