package action.needsession;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import dao.ApplicationContextUtil;
import entity.TimechoContents;
import service.SearchArticlesService;
import util.BaseAction;
import util.JsonUtils;

@Controller
@Scope("prototype")
public class SearchArticlesAction extends BaseAction {
	private static final Logger logger = Logger.getLogger(HotArticlesAction.class);
	@Autowired
	private SearchArticlesService searchArticlesService;
	private String search;
	private String result;
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String execute() throws Exception {
		SearchArticlesAction searchArticlesAction = (SearchArticlesAction) ApplicationContextUtil.getBean("searchArticlesAction");
		try {
			List<TimechoContents> lists = searchArticlesAction.searchArticlesService.getSearchArticles(new String(search.getBytes("iso8859-1"),"utf-8"));
			if(lists.size()==0) {
				result = "[{\"mark\":\"没有搜索到结果\"}]";
				return SUCCESS;
			} 
			String resu="";
			for(int i=0;i<lists.size();i++) {
				resu += JsonUtils.getJsonString(lists.get(i));
			}
			resu += "[{\"mark\":\"搜索成功\"}]";
			result=resu.replace("][",",");
			 System.out.println(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("获取全部搜索文章失败");
		}
		return SUCCESS;
	}
	
	
}
