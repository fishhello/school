package action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import dao.ApplicationContextUtil;
import entity.TimechoUser;
import service.RefisterService;
import util.BaseAction;

@Controller
@Scope("prototype")
public class RegisterAction extends BaseAction {
	private static final Logger logger = Logger.getLogger(RegisterAction.class);
	
	// 自动注入属性
	@Autowired
	private RefisterService refisterService;
	
	private TimechoUser timechoUser;
	
	public TimechoUser getTimechoUser() {
		return timechoUser;
	}

	public void setTimechoUser(TimechoUser timechoUser) {
		this.timechoUser = timechoUser;
	}

	@Override
	public String execute() throws Exception {
		RegisterAction raction =(RegisterAction) ApplicationContextUtil.getBean("registerAction");
		int count = raction.refisterService.save(timechoUser);
		System.out.println(timechoUser);
		//设置当前注册用户session,查询用户表获取完整用户信息
		List currentUser = raction.refisterService.get(timechoUser);		
		if(count==1) {
			try {
				ActionContext.getContext().getSession().put("currentUser",currentUser.get(0));
			} catch (Exception e) {
				System.out.println("设置注册用户session失败");
				logger.error("设置注册用户session失败");
				e.printStackTrace();
			}
			return SUCCESS;
		}else {
			return ERROR;
		}
		
	}
	
	
/*	public String toAddUser(HttpServletRequest request) {
		 return "/addUser";
	}*/
	/* 	
    @RequestMapping("/addUser")
    public String addUser(TimechoUser user, HttpServletRequest request) {
        service.save(user);
        return "redirect:/user/getAllUser";
    }
    
   public String updateUser(TimechoUser user, HttpServletRequest request) {
        if (service.update(user)) {
            user = service.findById(user.getUid());
            request.setAttribute("user", user);
            return "redirect:/user/getAllUser";
        } else {
            return "/error";
        }
    }
    
    public void delUser(int id, HttpServletRequest request, HttpServletResponse response) {
        String result = "{\"result\":\"error\"}";
        if (service.delete(id)) {
            result = "{\"result\":\"success\"}";
        }
        response.setContentType("application/json");
        try {
            PrintWriter out = response.getWriter();
            out.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String getUser(int id, HttpServletRequest request) {
        request.setAttribute("user", service.findById(id));
        return "/editUser";
    }
    
    public String getAllUser(HttpServletRequest request) {
        List<TimechoUser> findAll = service.findAll();
        request.setAttribute("userList", findAll);
        return "/allUser";
    }*/
}
