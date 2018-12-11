package action.needsession;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import dao.ApplicationContextUtil;
import entity.TimechoContents;
import service.HotArticlesService;
import util.BaseAction;
import util.JsonUtils;

@Controller
@Scope("prototype")
public class HotArticlesAction extends BaseAction {
	private static final Logger logger = Logger.getLogger(HotArticlesAction.class);
	@Autowired
	private HotArticlesService hotArticlesService;
	
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
		HotArticlesAction hotArticlesAction = (HotArticlesAction) ApplicationContextUtil.getBean("hotArticlesAction");
		try {
			List<TimechoContents> lists = hotArticlesAction.hotArticlesService.getHotArticles();
			String resu="";
			for(int i=0;i<lists.size();i++) {
				resu += JsonUtils.getJsonString(lists.get(i));
				
			}
			result=resu.replace("][",",");
			 System.out.println(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("获取全部最热文章失败");
			return ERROR;
		}
		return SUCCESS;
	}
	
}
