package action.needsession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import dao.ApplicationContextUtil;
import entity.TimechoContents;
import entity.TimechoContentsPlus;
import net.sf.json.JSONArray;
import service.SingleArticlesService;
import util.BaseAction;
import util.JsonUtils;

@Controller
@Scope("prototype")
public class SingleArticlesAction extends BaseAction  {
	private static final Logger logger = Logger.getLogger(SingleArticlesAction.class);
	@Autowired
	SingleArticlesService singleArticlesService;
	
	private int contentsId;
	private String result;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getContentsId() {
		return contentsId;
	}

	public void setContentsId(int contentsId) {
		this.contentsId = contentsId;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(contentsId);
		SingleArticlesAction singleArticlesAction = (SingleArticlesAction) ApplicationContextUtil.getBean("singleArticlesAction");
		TimechoContentsPlus timechoContentsPlus = null;
		try {
			timechoContentsPlus = singleArticlesAction.singleArticlesService.getCurrentContent(contentsId);
			//result = JsonUtils.getJsonString(timechoContentsPlus);
			JSONArray jsonArray = JSONArray.fromObject(timechoContentsPlus);
			 result = jsonArray.toString();
		} catch (Exception e) {
			e.printStackTrace();
			result = JsonUtils.getJsonString("获取当前文章内容失败");
			System.out.println("获取当前文章内容失败");
			//return ERROR;
		}
		
		return SUCCESS;
		
	}
	
}
