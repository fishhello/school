package service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionContext;

import dao.TimechoCommentsMapper;
import entity.TimechoComments;
import entity.TimechoUser;
import util.TimeUtils;

/**
 * 
* @ClassName: CommentsService 
* @Description: TODO(根据传入的文章id和文章内容结合用户session保存一条评论) 
* @author shafish
* @date 2018年6月20日 上午4:10:02 
*
 */
@ Repository
public class CommentsService {
	private static final Logger logger = Logger.getLogger(CommentsService.class);
	@Autowired
	private TimechoCommentsMapper timechoCommentsMapper; 
	
	public void save(int cid,String text) {
		//获取用户session信息
		TimechoUser user = (TimechoUser) ActionContext.getContext().getSession().get("currentUser");
		System.out.println(user);
		
		//更新操作
		//1为对象赋值
		TimechoComments comments = new TimechoComments();
		try {
			comments.setAuthor(user.getUid());
			comments.setCid(cid);
			comments.setMail(user.getMail());
			comments.setUrl(user.getUrl());
			comments.setText(text);
			comments.setCreated(TimeUtils.getCurrentTimeStr());
			System.out.println(comments);
		} catch (Exception e) {
			System.out.println("评论为对象赋值失败");
			logger.error("评论为对象赋值失败");
			e.printStackTrace();
		}
		
		//2根据条件插入数据库
		try {
			timechoCommentsMapper.insertSelective(comments);
			
		} catch (Exception e) {
			System.out.println("评论插入失败");
			logger.error("评论插入失败");
			e.printStackTrace();
		}
	}
}
