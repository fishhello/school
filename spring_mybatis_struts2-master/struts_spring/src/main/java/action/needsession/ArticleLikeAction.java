package action.needsession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import dao.ApplicationContextUtil;
import service.ArticleLikeService;
import util.BaseAction;

@Controller
@Scope("prototype")
public class ArticleLikeAction extends BaseAction{
	private static final Logger logger = Logger.getLogger(ArticleLikeAction.class);
	@Autowired
	private ArticleLikeService articleLikeService;
	private String result;
	private int contentsId;
	private int likes;
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
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	@Override
	public String execute() throws Exception {
		ArticleLikeAction articleLikeAction = (ArticleLikeAction) ApplicationContextUtil.getBean("articleLikeAction");
		try {
			int count = articleLikeAction.articleLikeService.save(contentsId, likes);
			result="[{success:'更新like成功'}]";
			System.out.println(count);
		} catch (Exception e) {
			logger.debug("更新文章like失败");
			result="[{error:'更新like失败'}]";
		}
		return SUCCESS;
	}
	
}
