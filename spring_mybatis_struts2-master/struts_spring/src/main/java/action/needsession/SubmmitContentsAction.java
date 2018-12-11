package action.needsession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import dao.ApplicationContextUtil;
import service.SubmmitContentsService;
import util.BaseAction;

/**
 * 
* @ClassName: SubmmitContentsAction 
* @Description: TODO(根据前台参数填写文章) 
* @author shafish
* @date 2018年6月21日 上午3:22:27 
*
 */
@Controller
@Scope("prototype")
public class SubmmitContentsAction extends BaseAction{
	private static final Logger logger = Logger.getLogger(SubmmitContentsAction.class);
	@Autowired
	private SubmmitContentsService submmitContentsService;
	private String contents;
	private int blockId;
	private String tag;
	private String title;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getBlockId() {
		return blockId;
	}
	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	@Override
	public String execute() throws Exception {
		SubmmitContentsAction submmitContentsAction = (SubmmitContentsAction) ApplicationContextUtil.getBean("submmitContentsAction");
		try {
			System.out.println(blockId+"  "+tag+"  "+title+"  "+contents);
			int couont = submmitContentsAction.submmitContentsService.save(title,blockId,contents,tag);
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.debug("新建文章失败");
			System.out.println("新建文章失败");
			return ERROR;
		}
		return SUCCESS;
	}
	
}
