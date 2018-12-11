package action.needsession;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import dao.ApplicationContextUtil;
import entity.TimechoContents;
import net.sf.json.JSONArray;
import service.NewArticlesService;
import util.BaseAction;
import util.JsonUtils;

/**
 * 
* @ClassName: NewArticlesAction 
* @Description: TODO(获取最新文章) 
* @author shafish
* @date 2018年6月19日 上午11:31:54 
*
 */
@Controller
@Scope("prototype")
public class NewArticlesAction extends BaseAction{
	private static final Logger logger = Logger.getLogger(NewArticlesAction.class);
	
	@Autowired
	private NewArticlesService newArticlesService;
	
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
		NewArticlesAction newArticlesAction = (NewArticlesAction) ApplicationContextUtil.getBean("newArticlesAction");
		try {
			List<TimechoContents> lists = newArticlesAction.newArticlesService.getAllArticles();
			/*JSONArray jsonArray = JSONArray.fromObject(lists);
			 result = jsonArray.toString();*/
			String resu="";
			for(int i=0;i<lists.size();i++) {
				resu += JsonUtils.getJsonString(lists.get(i));
				
			}
			result=resu.replace("][",",");
			 System.out.println(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("获取全部最新文章失败");
			return ERROR;
		}
		return SUCCESS;
	}

}
