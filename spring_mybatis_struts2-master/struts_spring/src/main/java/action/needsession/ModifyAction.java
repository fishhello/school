package action.needsession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import dao.ApplicationContextUtil;
import entity.TimechoUser;
import service.ModifyService;
import util.BaseAction;

/**
 * 
* @ClassName: ModifyAction 
* @Description: TODO(保存修改的信息，更新用户信息session) 
* @author shafish
* @date 2018年6月19日 上午8:34:10 
*
 */
@Controller
@Scope("prototype")
public class ModifyAction extends BaseAction{
	private static final Logger logger = Logger.getLogger(ModifyAction.class);
	
	@Autowired
	private ModifyService modifyService;
	private TimechoUser timechoUser;
	
	public TimechoUser getTimechoUser() {
		return timechoUser;
	}

	public void setTimechoUser(TimechoUser timechoUser) {
		this.timechoUser = timechoUser;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println(timechoUser);
		ModifyAction mAction = (ModifyAction) ApplicationContextUtil.getBean("modifyAction");
		try {
			//对密码进行验证
			if(timechoUser.getPassword().trim() =="") {
				timechoUser.setPassword(null);
			}
			//错误没法输出  error
			else if(timechoUser.getPassword().trim().length()>0) {
				if(timechoUser.getPassword().trim().length()<8) {
					System.out.println("密码长度不符合");
					return ERROR;
				}
			}
			
			int count = mAction.modifyService.update(timechoUser);
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("更新用户信息失败");
			return ERROR;
		}
		
		//设置用户更新后的session
		TimechoUser newUser = mAction.modifyService.setUserSession(timechoUser.getUid());
		if(newUser==null) {
			System.out.println("更新用户session失败");
			return ERROR;
		}
		return SUCCESS;
	}

}
