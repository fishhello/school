package service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import dao.TimechoUserMapper;
import entity.TimechoUser;

/**
 * 1.启动spring容器
 * 2.获取dao bean对象
* @ClassName: UserService 
* @Description: TODO(业务逻辑接口层) 
* @author shafish
* @date 2018年6月10日 上午10:06:53 
*
 */
@Service
public class UserService {
	@Autowired
	private TimechoUserMapper timechoUserMapper;
	
	public void save(TimechoUser user) {
		timechoUserMapper.insert(user);
	}
	
	public  TimechoUser selectById(Integer id) {
		TimechoUser user = timechoUserMapper.selectByPrimaryKey(id);
		return user;
	}
}
