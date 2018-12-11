package action.needsession;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import dao.ApplicationContextUtil;
import entity.TimechoBlock;
import net.sf.json.JSONArray;
import service.ClassifiesaService;
import util.BaseAction;
import util.JsonUtils;

/**
 * 
* @ClassName: ClassifiesaAction 
* @Description: TODO(该类用于获取论坛的所有分类)
* @author shafish
* @date 2018年6月20日 下午1:38:06 
*
 */
@Controller
@Scope("prototype")
public class ClassifiesaAction extends BaseAction{
	private static final Logger logger = Logger.getLogger(ClassifiesaAction.class);
	@Autowired
	ClassifiesaService classifiesaService;
	private String result;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String execute() throws Exception {
		ClassifiesaAction classifiesaAction = (ClassifiesaAction) ApplicationContextUtil.getBean("classifiesaAction");
		try {
			List<TimechoBlock> lists = classifiesaAction.classifiesaService.getAllTag();
			String resu="";
			for(int i=0;i<lists.size();i++) {
				JSONArray jsonArray = JSONArray.fromObject(lists.get(i));
				resu += jsonArray.toString();
			}
			result=resu.replace("][",",");
			 System.out.println(result);
		} catch (Exception e) {
			logger.debug("获取论坛的所有分类失败");
			result = JsonUtils.getJsonString("获取论坛的所有分类失败");
		}
		
		return SUCCESS;
	}
}
