package action.needsession;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import dao.ApplicationContextUtil;
import entity.TimechoCommentsPlus;
import net.sf.json.JSONArray;
import service.SingleArticlesCommentsService;
import util.BaseAction;
import util.JsonUtils;

/**
 * 
* @ClassName: SingleArticlesCommentsAction 
* @Description: TODO(该类用于获取指定文章的评论) 
* @author shafish
* @date 2018年6月20日 上午9:24:13 
*
 */
@Controller
@Scope("prototype")
public class SingleArticlesCommentsAction extends BaseAction {
	private static final Logger logger = Logger.getLogger(SingleArticlesCommentsAction.class);
	@Autowired
	SingleArticlesCommentsService singleArticlesCommentsService;
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
		//返回当前文章的所有评论数据
		System.out.println(contentsId);
		SingleArticlesCommentsAction singleArticlesCommentsAction = (SingleArticlesCommentsAction) ApplicationContextUtil.getBean("singleArticlesCommentsAction");
		TimechoCommentsPlus timechoCommentsPlus;
		try {
			List<TimechoCommentsPlus> lists = singleArticlesCommentsAction.singleArticlesCommentsService.getCurrentComments(contentsId);
			//result = JsonUtils.getJsonString(timechoContentsPlus);
			String resu="";
			for(int i=0;i<lists.size();i++) {
				// JsonUtils.getJsonString(lists.get(i));
				JSONArray jsonArray = JSONArray.fromObject(lists.get(i));
				resu += jsonArray.toString();
			}
			result=resu.replace("][",",");
			 System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
			result = JsonUtils.getJsonString("获取当前文章内容失败");
			System.out.println("获取当前文章内容失败");
			//return ERROR;
		}
		
		return SUCCESS;
	}
	
	
}
