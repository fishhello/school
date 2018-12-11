package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{
	private static final long serialVersionUID = -4320398837758540242L;
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	//protected Logger logger = Logger.getLogger(this.class);
}
