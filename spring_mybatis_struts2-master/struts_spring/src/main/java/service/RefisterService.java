package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.TimechoUserMapper;
import entity.TimechoUser;
import entity.TimechoUserExample;
import util.TimeUtils;

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
public class RefisterService {
	@Autowired
	private TimechoUserMapper timechoUserMapper;
	
	public int save(TimechoUser user) {
		user.setCreated(TimeUtils.getCurrentTimestamp());
		int count = timechoUserMapper.insert(user);
		return count;
	}
	
	public List get(TimechoUser user) {
		TimechoUserExample userExample = new TimechoUserExample();
		userExample.createCriteria().andNameEqualTo(user.getName()).andMailEqualTo(user.getMail());
		List<TimechoUser> currentUser = timechoUserMapper.selectByExample(userExample);
		
		return currentUser;
	}
}
