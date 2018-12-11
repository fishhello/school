package action;


import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import entity.TimechoUser;
import util.BaseAction;

/**
 * 
* @ClassName: LoginOutAction 
* @Description: TODO(删除当前用户session ) 
* @author shafish
* @date 2018年6月15日 下午1:21:15 
*
 */
@Controller
@Scope("prototype")
public class LoginOutAction extends BaseAction {
	private static final Logger logger = Logger.getLogger(LoginOutAction.class);

	@Override
	public String execute() throws Exception {
		try {
			Map session = ActionContext.getContext().getSession();
			/*TimechoUser user = (TimechoUser) session.get("currentUser");
			System.out.println(user);*/
			//删除当前用户session   成功与否都设置跳转到登录页
			session.remove("currentUser");
			
			TimechoUser user = (TimechoUser) session.get("currentUser");
			System.out.println(user);
			/*System.out.println("当前用户登出：--"+user1);*/
		} catch (Exception e) {
			System.out.println("删除当前用户session 失败");
			logger.error("删除当前用户session 失败");
			e.printStackTrace();
			return SUCCESS;
		}
		return SUCCESS;
		
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
