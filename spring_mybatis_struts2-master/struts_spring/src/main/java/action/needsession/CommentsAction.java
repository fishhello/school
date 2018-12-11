package action.needsession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import dao.ApplicationContextUtil;
import net.sf.json.JSONArray;
import service.CommentsService;
import util.BaseAction;

@Controller
@Scope("prototype")
public class CommentsAction  extends BaseAction{
	private static final Logger logger = Logger.getLogger(CommentsAction.class);
	@Autowired
	private CommentsService commentsService;
	private int contentsId;
	private String contents;
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

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(contents+"  ------ "+contentsId);
		String mark ;
		CommentsAction commentsAction = (CommentsAction) ApplicationContextUtil.getBean("commentsAction");
		try {
			commentsAction.commentsService.save(contentsId, contents);
		} catch (Exception e) {
			System.out.println("保存评论失败");
			logger.error("保存评论失败");
			e.printStackTrace();
			mark="[{\"mark\":\"保存评论失败\"}]";
			JSONArray jsonArray = JSONArray.fromObject(mark);
			 result = jsonArray.toString();
			return ERROR;
		}
		mark="[{\"mark\":\"评论成功\"}]";
		JSONArray jsonArray = JSONArray.fromObject(mark);
		 result = jsonArray.toString();
		return SUCCESS;
	}
	
}
