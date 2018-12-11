package action;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import dao.ApplicationContextUtil;
import entity.TimechoUser;
import service.LoginService;
import util.BaseAction;


@Controller
@Scope("prototype")
public class LoginAction extends BaseAction {
	private static final Logger logger = Logger.getLogger(LoginAction.class);
	
	// 自动注入属性
	@Autowired
	private LoginService loginService;
	private TimechoUser timechoUser;
	
	public TimechoUser getTimechoUser() {
		return timechoUser;
	}

	public void setTimechoUser(TimechoUser timechoUser) {
		this.timechoUser = timechoUser;
	}

	@Override
	public String execute() throws Exception {
		LoginAction uaction =(LoginAction) ApplicationContextUtil.getBean("loginAction");
		List login = uaction.loginService.selectByEmail(timechoUser);
		//System.out .println(login.get(0));
		System.out.println(timechoUser);
		if(login.size()>0) {
			try {
				//设置当前用户session记录用户信息
				ActionContext.getContext().getSession().put("currentUser",login.get(0));
			} catch (Exception e) {
				System.out.println("设置登录用户session失败");
				logger.error("设置登录用户session失败");
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
