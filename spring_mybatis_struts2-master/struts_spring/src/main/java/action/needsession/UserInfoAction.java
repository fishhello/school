package action.needsession;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import entity.TimechoUser;
import util.BaseAction;
import util.JsonUtils;

/**
 * 
* @ClassName: UserInfoAction 
* @Description: TODO(论坛首页点击个人信息显示本类查询内容) 
* @author shafish
* @date 2018年6月14日 下午3:30:57 
*
 */
@Controller
@Scope("prototype")
public class UserInfoAction extends BaseAction {
	private static final Logger logger = Logger.getLogger(UserInfoAction.class);
    /**
     * ajax返回结果，也可是其他类型的，这里以String类型为例
     */
    private String result;
    
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String execute() throws Exception {
		
		Map session = ActionContext.getContext().getSession();
		try {
			TimechoUser user = (TimechoUser) session.get("currentUser");
			result = JsonUtils.getJsonString(user);
			//result = user.toString();
			System.out.println(result);
		} catch (Exception e) {
			String error = "获取用户session失败";
			System.out.println(error);
			logger.debug(error);
			result += error;
			e.printStackTrace();
			return ERROR;
		} 
		//跳转用户信息jsp
		
		return SUCCESS;
	}

}
