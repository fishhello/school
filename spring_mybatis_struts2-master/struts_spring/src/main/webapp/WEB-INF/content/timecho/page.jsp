<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
  if(session.getAttribute("currentUser")==null)
  {
		response.sendRedirect(request.getContextPath()+"/index.jsp");
    	return;
   }
%>
<!doctype html>
        <!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en-US"> <![endif]-->
        <!--[if IE 7]>    <html class="lt-ie9 lt-ie8" lang="en-US"> <![endif]-->
        <!--[if IE 8]>    <html class="lt-ie9" lang="en-US"> <![endif]-->
        <!--[if gt IE 8]><!--> <html lang="en-US"> <!--<![endif]-->
        <head>
                <!-- META TAGS -->
                <meta charset="UTF-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1.0">

                <title>个人信息</title>

                <link rel="shortcut icon" href="images/favicon.png" />




                <!-- Style Sheet-->
                <%@ include file="head.jsp" %>


                <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
                <!--[if lt IE 9]>
                <script src="js/html5.js"></script></script>
                <![endif]-->

        </head>

        <body>

          <!-- Start of Header -->
           <jsp:include   page="Timechoheader.jsp" flush="true"/>
           <!-- End of Header -->
                <!-- Start of Search Wrapper -->

                <!-- End of Search Wrapper -->

                <!-- Start of Page Container -->
                               <div class="page-container">
                        <div class="container">
                                <div class="row">

                                        <!-- start of page content -->
                                        <div class="span8 page-content" id="responsecontent">

                                                <article class=" type-page  hentry clearfix">
                                                        <h1 class="post-title"><a href="#">个人介绍</a></h1>

                                                        <hr>

                                                        <!--<p>一句自我介绍</p>-->

                                                        <blockquote>
                                                                <p class="introduce">一句话自我介绍</p>
                                                        </blockquote>

                                                        <!--<p>…or something like this:</p>

                                                        <blockquote>
                                                                <p>The XYZ Doohickey Company was founded in 1971, and has been providing quality doohickeys to the public ever since. Located in Gotham City, XYZ employs over 2,000 people and does all kinds of awesome things for the Gotham community.</p>
                                                        </blockquote>

                                                        -->
                                                </article>

                                                <div id="respond">

                                                        <h3>个人信息</h3>

                                                        <!--<div class="cancel-comment-reply">
                                                                <a rel="nofollow" id="cancel-comment-reply-link" href="#" style="display:none;">Click here to cancel reply.</a>
                                                        </div>-->


                                                        <form action="MPIa" method="post" id="commentform" onsubmit="return MPInformation()">

                                                                <!--<p class="comment-notes">Your email address will not be published. Required fields are marked <span class="required">*</span></p>-->
																<input type="hidden" name="timechoUser.uid" id="uid" value=""> 
                                                                <div>
                                                                        <label for="author">昵称</label>
                                                                        <input class="span4" type="text" name="timechoUser.name" id="author" value="" size="22">
                                                                </div>

                                                                <div>
                                                                        <label for="email">邮箱地址</label>
                                                                        <input class="span4" type="text" name="timechoUser.mail" id="email" value="" size="22" readonly="readonly">
                                                                </div>

                                                                <div>
                                                                        <label for="url">个人网站</label>
                                                                        <input class="span4" type="text" name="timechoUser.url" id="url" value="" size="22">
                                                                </div>

                                                                <div>
                                                                        <label for="phone">电话号码</label>
                                                                        <input class="span4" type="text" name="timechoUser.phone" id="phone" value="" size="22">
                                                                </div>

																<div>
                                                                        <label for="passwd">密码</label>
                                                                        <input class="span4" type="password" name="timechoUser.password" id="passwd" value="" size="22">
                                                                </div>
                                                                
                                                                <div>
                                                                        <label for="time">注册时间</label>
                                                                        <input class="span4" type="text" name="time" id="time" value="" size="22" readonly="readonly">
                                                                </div>
                                                                
                                                                <div>
                                                                        <label for="introduce">个人介绍</label>
                                                                        <textarea class="span8" style="resize: none;" name="timechoUser.introduce" id="introduce" cols="58" rows="6"></textarea>
                                                                </div>

                                                                <div>
                                                                        <button class="btn" name="submit" type="submit" id="submit" >确认修改</button>
                                                                </div>

                                                        </form>

                                                </div>
                                        </div>
                                        <!-- end of page content -->

                                        <!-- start of sidebar -->
                                        <jsp:include   page="sidebar.jsp" flush="true"/>
                                        <!-- end of sidebar -->
                                </div>
                        </div>
                </div>
                <!-- End of Page Container -->


                <!-- Start of Footer -->
                
                        <!-- end of #footer -->

                        <!-- Footer Bottom -->
                        
                        <!-- End of Footer Bottom -->
<jsp:include   page="Timechofooter.jsp" flush="true"/>
                <!-- End of Footer -->

                <a href="#top" id="scroll-top"></a>

                <!-- script -->
<%@ include file="foot.jsp" %>               
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
window.onload=function(){ 
/* 	$.getUrlParam = function(name)
    {
        var reg = new RegExp("(^|&)"+name +"=([^&]*)(&|$)");
        var r= window.location.search.substr(1).match(reg);
        if (r!=null) return unescape(r[2]); return null;
    };
    //alert($.getUrlParam('t')!=null);
    if($.getUrlParam('t')!=null){
			toastr.error(decodeURI(decodeURI($.getUrlParam('t'))));//也可以取出地址栏传递的key所代表的值
    } */
	$.ajax({
        type:"post",
        url:"userInfoa",
        data:{
            //id : $("#id").val(),
           //name : $("#name").val()
        },
        dataType:"json",
        success:function(result){
            //var obj = eval ("(" + data + ")");
            //alert(obj.id);
            // var obj = $.parseJSON(result); //使用这个方法解析json
            // var state_value = obj; //result是和action中定义的result变量的get方法对应的
             //alert(state_value);
            var jsonresult = JSON.parse(result);
           //alert("使用ajax成功返回个人数据"+result);
            //alert("uid="+jsonresult[0].uid+" name="+jsonresult[0].name);
            showUserInfo(jsonresult);
        },
        error:function(){
        	toastr.info("获取个人信息失败，请登录");
        	window.location.href="/index.jsp";
        }
    });
	
}

function showUserInfo(jsonresult){
	//alert(jsonresult[0].name);
	$("#responsecontent #uid").val(jsonresult[0].uid);
	//个人介绍
	$("#responsecontent .introduce").html(jsonresult[0].introduce);
	//昵称
	$("#responsecontent #author").val(jsonresult[0].name);
	//email
	$("#responsecontent #email").val(jsonresult[0].mail);
	//个人网站 
	$("#responsecontent #url").val(jsonresult[0].url);
	//电话
	$("#responsecontent #phone").val(jsonresult[0].phone);
	//注册时间
	$("#responsecontent #time").val(jsonresult[0].created);
	//个人介绍 
	$("#responsecontent #introduce").val(jsonresult[0].introduce);
}
function MPInformation() {
	//检验输入是否正确
	var author = $("#responsecontent #author").val().replace(/^\s+|\s+$/g,"");
	var url = $("#responsecontent #email").val().replace(/^\s+|\s+$/g,"");
	var phone = $("#responsecontent #phone").val().replace(/^\s+|\s+$/g,"");
	if(author==''){
		toastr.info("请输入有效昵称");
		$("#responsecontent #author").focus();
		return false;
	}
	if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(phone))){
		toastr.info("请输入有效电话号码");
		$("#responsecontent #phone").focus();
		return false;
	}
	
	return true;
}
</script>
        </body>
</html>
