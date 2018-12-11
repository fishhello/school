package service;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.TimechoUserMapper;
import entity.TimechoUser;
import entity.TimechoUserExample;

/**
 * 1.启动spring容器
 * 2.获取dao bean对象
* @ClassName: UserService 
* @Description: TODO(业务逻辑接口层) 
* @author shafish
* @date 2018年6月10日 上午10:06:53 
*
 */
@ Repository
public class LoginService {
	//private static final Logger logger = Logger.getLogger(LoginService.class);
	
	@Autowired
	private TimechoUserMapper timechoUserMapper;
	
	public int save(TimechoUser user) {
		int count = timechoUserMapper.insert(user);
		return count;
	}
	
	public  TimechoUser selectById(Integer id) {
		TimechoUser user = timechoUserMapper.selectByPrimaryKey(id);
		return user;
	} 
	
	public List selectByEmail(TimechoUser user) {
		TimechoUserExample userExample = new TimechoUserExample();
		userExample.createCriteria().andMailEqualTo(user.getMail()).andPasswordEqualTo(user.getPassword());
		List<TimechoUser> userList = timechoUserMapper.selectByExample(userExample);
		
		return userList;
	}
}
