<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>用户登录</title>

<link rel="stylesheet" type="text/css" href="css/styles.css">
<link href="toastr/toastr.min.css" rel="stylesheet" type="text/css" />
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>


<div class="wrapper">

	<div class="container">
		<h1>Welcome</h1>
		<h5 id="mge"></h5> 
		
 		<form class="form" action="userLogina" method="POST">
			<input name="timechoUser.mail" type="text" class="form-input" placeholder="帐号">
			
			<input name="timechoUser.password" type="password" class="form-input" placeholder="密码">
			<%-- <span><div id="c1" class="form-check"></div></span> --%>
			<button type="submit" onclick="return userLogin();">登录</button>
			<span class="form-mark">
		        <span style="float:left;"><input type="checkbox" id="checkpwd" style="margin-right: 8px;color:#7820c9；"><label>下次自动登录</label></span>
				<span style="float:right;"><a href="#" onclick="alert('未开发')" style="text-decoration:none;">忘记密码 &emsp;</a> 
		       <a href="#" data-toggle="modal" data-target="#myModal" style="text-decoration:none;">立即注册</a></span>
	    	</span>
	    	<s:token/>
		</form>
		
<%-- 	<s:form action="/login" method="POST">
         <s:textfield name="user.name" key="user"></s:textfield>
         <s:textfield name="user.password" key="pass"></s:textfield>
         <s:submit key="login"></s:submit>
    </s:form> 
--%>
		
	</div>

	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>

</div>

<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script src="toastr/toastr.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.dingxiang-inc.com/ctu-group/captcha-ui/index.js"></script>
<script type="text/javascript">
$('#login-button').click(function(event){
	event.preventDefault();
	$('form').fadeOut(500);
	$('.wrapper').addClass('form-success');
});

function userLogin(){
	//验证码验证
	var email = $(".form input[name='timechoUser.mail']").val().replace(/^\s+|\s+$/g,"");
	var passwd = $(".form input[name='timechoUser.password']").val().replace(/^\s+|\s+$/g,"");
	if(email != "") {
		 var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
		 isok= reg.test(email);
		 if (!isok) {
			toastr.info('请输入正确邮箱！')
		 	$(".form input[name='timechoUser.mail']").focus();
		 	return false;
		 }
	}
	if(email =="") {
		toastr.info("请输入帐号、密码");
		$(".form input[name='timechoUser.mail']").focus();
		return false;
	}
	if(passwd ==""){
		toastr.info("请输入帐号、密码");
		$(".form input[name='timechoUser.password']").focus();
		return false;
	}
	var objChk = document.getElementById("checkpwd");
	if (objChk.checked) {
		//添加cookie  
		addCookie("userName", email, 30, "/");
		addCookie("userPass", passwd, 30, "/");
		//alert("记住了你的密码登录。");
		getCookieValue();
		// window.location.href = "http://www.baidu.com";  
	} else {
		//alert("不记密码登录。");
		addCookie("userName", email, 0, "/");
		addCookie("userPass", passwd, 0, "/");
		deleteCookie();
		// window.location.href = "http://www.baidu.com";  
	}
	return true;
}

//添加设置cooki
function addCookie(name, value, days, path) {
	var name = escape(name);
	var value = escape(value);
	var expires = new Date();
	expires.setTime(expires.getTime() + days * 3600000 * 24);
	//path=/，表示cookie能在整个网站下使用，path=/temp，表示cookie只能在temp目录下使用  
	path = path == "" ? "" : ";path=" + path;
	//GMT(Greenwich Mean Time)是格林尼治平时，现在的标准时间，协调世界时是UTC  
	//参数days只能是数字型  
	var _expires = (typeof days) == "string" ? "" : ";expires="
	+ expires.toUTCString();
	document.cookie = name + "=" + value + _expires + path;
}
//获取cookie的值，根据cookie的键获取值
function getCookieValue(name) { //此处name是 userName,userPass
	//用处理字符串的方式查找到key对应value  
	var name = escape(name);
	//读cookie属性，这将返回文档的所有cookie  
	var allcookies = document.cookie;
	//查找名为name的cookie的开始位置  
	name += "=";
	var pos = allcookies.indexOf(name);
	//如果找到了具有该名字的cookie，那么提取并使用它的值  
	if (pos != -1) { //如果pos值为-1则说明搜索"version="失败  
	var start = pos + name.length; //cookie值开始的位置  
	var end = allcookies.indexOf(";", start); //从cookie值开始的位置起搜索第一个";"的位置,即cookie值结尾的位置  
	if (end == -1)
	end = allcookies.length; //如果end值为-1说明cookie列表里只有一个cookie  
	var value = allcookies.substring(start, end); //提取cookie的值  
	return (value); //对它解码        
	} else { //搜索失败，返回空字符串  
	return "";
	}
}

//获取cookie的值，根据cookie的键获取值
function getCookieValue(name) { //此处name是 userName,userPass
	//用处理字符串的方式查找到key对应value  
	var name = escape(name);
	//读cookie属性，这将返回文档的所有cookie  
	var allcookies = document.cookie;
	//查找名为name的cookie的开始位置  
	name += "=";
	var pos = allcookies.indexOf(name);
	//如果找到了具有该名字的cookie，那么提取并使用它的值  
	if (pos != -1) { //如果pos值为-1则说明搜索"version="失败  
	var start = pos + name.length; //cookie值开始的位置  
	var end = allcookies.indexOf(";", start); //从cookie值开始的位置起搜索第一个";"的位置,即cookie值结尾的位置  
	if (end == -1)
	end = allcookies.length; //如果end值为-1说明cookie列表里只有一个cookie  
	var value = allcookies.substring(start, end); //提取cookie的值  
	return (value); //对它解码        
	} else { //搜索失败，返回空字符串  
	return "";
	}
}

function deleteCookie(name, path) {
	//根据cookie的键，删除cookie，其实就是设置其失效
	var name = escape(name);
	var expires = 0;
	//alert(expires)
	path = path == "" ? "" : ";path=" + path;
	document.cookie = name + "=" + ";expires="
	+ expires.toUTCString() + path;
}
//实现功能，保存用户的登录信息到cookie中。当登录页面被打开时，就查询cookie

window.onload = function() {
	$.getUrlParam = function(name)
       {
           var reg = new RegExp("(^|&)"+name +"=([^&]*)(&|$)");
           var r= window.location.search.substr(1).match(reg);
           if (r!=null) return unescape(r[2]); return null;
       };
       //alert($.getUrlParam('t')!=null);
       if($.getUrlParam('t')!=null){
			toastr.error(decodeURI(decodeURI($.getUrlParam('t'))));//也可以取出地址栏传递的key所代表的值
       }

	var userNameValue = getCookieValue("userName");
	//document.getElementById("name").value = userNameValue; //取出cookies的name赋给文本框
	$(".form input[name='timechoUser.mail']").val(userNameValue);
	var userPassValue = getCookieValue("userPass");
	//document.getElementById("pwd").value = userPassValue;
	$(".form input[name='timechoUser.password']").val(userPassValue)
	//alert(" "+document.getElementById("name").value+" "+userPassValue);
}

/* var myCaptcha = _dx.Captcha(document.getElementById('c1'), {
	appId: 'b29412470833f26b5b36043a8859b21a',
	style: 'inline',
	width:	'250',
	language: 'cn', // 语言为英语
    customStyle: {
        bgColor: '#cccc00' // <-- 自定义控件背景色
    },
	success: function (token) {
	        // console.log('token:', token)
	        token = 1;
	        alert("验证成功  "+token);
	}
}) */

function register() {
	var name = $(".teModal-content .login-wrap input[name='timechoUser.name']").val().replace(/^\s+|\s+$/g,"");
	var email = $(".teModal-content .login-wrap input[name='timechoUser.mail']").val().replace(/^\s+|\s+$/g,"");
	var password = $(".teModal-content .login-wrap input[name='timechoUser.password']").val().replace(/^\s+|\s+$/g,"");
	//alert(name+" "+email+" "+password);
	if(email != "") {
		 var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
		 isok= reg.test(email);
		 if (!isok) {
			toastr.info('请输入正确邮箱！')
		 	$(".teModal-content .login-wrap input[name='timechoUser.email']").focus();
		 	return false;
		 }
	}
	if(name=='') {
		toastr.info("请输入有效昵称");
		$(".teModal-content .login-wrap input[name='timechoUser.name']").focus();
		return false;
	}
	if(email=='') {
		toastr.info("请输入有效邮箱");
		$(".teModal-content .login-wrap input[name='timechoUser.email']").focus();
		return false;
	}
	if(password=='' ) {
		toastr.info("请输入有效密码");
		$(".teModal-content .login-wrap input[name='timechoUser.password']").focus();
		return false;
	}
	if(password.length<=8) {
		toastr.info("请输入大于8位的密码");
		$(".teModal-content .login-wrap input[name='timechoUser.password']").focus();
		return false;
	}
	
	return true;
}

</script>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header" style="background-color: rgb(243, 243, 243);border-top-left-radius: 6px;border-top-right-radius: 6px;overflow: hidden;">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel" >
					注册
				</h4>
			</div>
			<div class="modal-body">
<div class="teModal-content">
    <div class="row bg-white login-modal">
        <div class="col-md-12 login-wrap">
            <form action="registera" method="POST" role="form" class="mt15">
                <div class="form-group">
                    <label for="name" class="control-label">你的名字</label>
                    <input type="text" class="form-control" name="timechoUser.name" required="" placeholder="真实姓名或常用昵称">
                </div>
                
                <div class="form-group">
                    <label for="mail" class="control-label">Email（使用email帐号登录）</label>
                    <input type="text" class="form-control" id="login-name" name="timechoUser.mail" required="" placeholder="正确的邮箱地址">
                </div>
                
                <div class="form-group">
                    <label for="password" class="control-label">密码</label>
                    <input type="password" class="form-control" name="timechoUser.password" required="" placeholder="不少于 8 位的密码">
                </div>
                <div class="form-group clearfix">
                    <button type="submit" class="btn-block btn btn-primary pl20 pr20 pull-right" onclick="return register();">注册
                    </button>
                </div>

				<div class="form-group clearfix">
		    		<a class="btn-block btn btn-default pull-right pl20 pr20 SFRegister "  data-dismiss="modal">
		                    已有账号登录
		            </a>
				</div>
            </form>
        </div>
    </div>
</div>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
</body>
</html>
