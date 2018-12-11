package service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionContext;

import dao.TimechoContentsMapper;
import entity.TimechoContents;
import entity.TimechoUser;
import util.TimeUtils;

@ Repository
public class SubmmitContentsService {
	private static final Logger logger = Logger.getLogger(SubmmitContentsService.class);
	@Autowired
	private TimechoContentsMapper timechoContentsMapper;
	
	//
	public int save(String title,int blockid,String text,String tag) {
		TimechoUser user = (TimechoUser) ActionContext.getContext().getSession().get("currentUser");;
		TimechoContents timechoContents  = new TimechoContents();
		
		try {
			timechoContents.setBlockid(blockid);
			timechoContents.setTitle(title);
			timechoContents.setText(text);
			if(tag.equals("")) {
				timechoContents.setTag(null);
			}
			timechoContents.setAuthorid(user.getUid());
			timechoContents.setCreated(TimeUtils.getCurrentTimestamp());
		} catch (Exception e) {
			System.out.println("设置文章内容失败");
			// TODO: handle exception
		}
		
		int count = timechoContentsMapper.insertSelective(timechoContents);
		return count;
	}
}
