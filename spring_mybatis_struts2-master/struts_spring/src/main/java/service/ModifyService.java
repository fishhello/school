package service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionContext;

import dao.TimechoUserMapper;
import entity.TimechoUser;
import entity.TimechoUserExample;

@ Repository
public class ModifyService {
	private static final Logger logger = Logger.getLogger(ModifyService.class);
	@Autowired
	private TimechoUserMapper timechoUserMapper;
	
	public int update(TimechoUser user) {
		TimechoUserExample userExample = new TimechoUserExample();
		userExample.createCriteria().andUidEqualTo(user.getUid());
		
		int count = timechoUserMapper.updateByExampleSelective(user, userExample);
		return count;
	}
	
	public TimechoUser setUserSession(int uid) {
		TimechoUser newUser = new TimechoUser();
		newUser = timechoUserMapper.selectByPrimaryKey(uid);
		if(newUser!=null) {
			try {
				//设置当前用户session记录用户信息
				ActionContext.getContext().getSession().put("currentUser",newUser);
			} catch (Exception e) {
				System.out.println("设置登录用户session失败");
				logger.error("设置登录用户session失败");
				e.printStackTrace();
			}
		}
		return newUser;
	}
}
