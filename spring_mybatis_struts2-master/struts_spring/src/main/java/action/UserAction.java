package action;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import dao.ApplicationContextUtil;
import entity.TimechoUser;
import service.UserService;
import util.BaseAction;

@Controller
public class UserAction extends BaseAction {
	// 自动注入属性
	@Autowired
	private UserService service;
	
	@Test
	public void testSelect() {
		//UserAction uaction =(UserAction) ApplicationContextUtil.getBean("userAction");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserAction uaction = (UserAction) context.getBean("userAction");
		TimechoUser user = uaction.service.selectById(1);
		System.out.println(user);
	}
	
	@Override
	public String execute() throws Exception {
		UserAction uaction =(UserAction) ApplicationContextUtil.getBean("userAction");
		TimechoUser user = uaction.service.selectById(1);
		System.out.println(user);
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
