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

                <title>Knowledge Base Theme</title>

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
                                <div class="row" id="row">

                                        <!-- start of page content -->
                                        <div class="span12 page-content">

                                                <!-- <ul class="breadcrumb">
                                                        <li><a href="#">分类</a><span class="divider">/</span></li>
                                                </ul> -->

                                                <article class=" type-post format-standard hentry clearfix">

                                                         <h1 class="post-title"></h1>

                                                        <div class="post-meta clearfix">
                                                                <span class="date"></span>
                                                                <span class="category"></span>
                                                                <span class="user"></span>
                                                        </div>
														<div class="contents"></div>
                                                </article>

                                                <div class="like-btn" id="like-it-form">
                                                                <span class="likes" style="display: inline-block;height: 20px;line-height: 20px;padding: 5px 13px;padding-left: 25px;background: #fafafa url('images/like-btn.png') no-repeat 10px -20px;cursor: pointer;-webkit-border-radius: 3px;-moz-border-radius: 3px;border-radius: 3px;color: #8cd24e;" onclick="comment()"></span>
                                                        <!-- <form id="like-it-form" action="#" method="post">
                                                                <input type="hidden" name="post_id" value="99">
                                                                <input type="hidden" name="action" value="like_it">
                                                        </form> -->
                                                </div>

                                                <section id="comments">

                                                        <ol class="commentlist">
                                                        </ol>

                                                        <div id="respond">

                                                                <h3>留言</h3>

                                                                <div class="cancel-comment-reply">
                                                                        <a rel="nofollow" id="cancel-comment-reply-link" href="#" style="display:none;">Click here to cancel reply.</a>
                                                                </div>


                                                                <form action="#" method="post" id="commentform" onsubmit="return checkcomment();">
                                                                        <div>
                                                                                <label for="comment"></label>
                                                                                <textarea class="span12" name="contents" id="comment" cols="75" rows="10"></textarea>
                                                                        </div>

                                                                        <p class="allowed-tags">你可以使用html标签填写 <small><code>&lt;a href="" title=""&gt; &lt;abbr title=""&gt; &lt;acronym title=""&gt; &lt;b&gt; &lt;blockquote cite=""&gt; &lt;cite&gt; &lt;code&gt; &lt;del datetime=""&gt; &lt;em&gt; &lt;i&gt; &lt;q cite=""&gt; &lt;strike&gt; &lt;strong&gt; </code></small></p>
																		<input type="hidden" name="contentsId" class="contentsId" value=""> 
                                                                        <div>
                                                                                <input class="btn" name="submit" type="submit" id="submit" onclick="commitsub()" value="提交">
                                                                        </div>

                                                                </form>

                                                        </div>

                                                </section><!-- end of comments -->

                                        </div>
                                        <!-- end of page content -->


                                        <!-- start of sidebar -->
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
                <script src="http://pv.sohu.com/cityjson?ie=utf-8"></script> 
<script type="text/javascript">
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}
var urlt = getQueryString("contentsId");
var time = getQueryString("time");
$("#row .date").html(time);
//alert(urlt);
$.ajax({
        type:"post",
        url:"singleArticlesa",
        data:{
        	contentsId : urlt
           //name : $("#name").val()
        },
        dataType:"json",
        success:function(result){
            
           var jsonresult = JSON.parse(result);
           //alert("使用ajax成功返回当前文章数据"+result);
           //alert("uid="+jsonresult[0].uid+" name="+jsonresult[0].name);
           //showUserInfo(jsonresult);
           //构造数据
           buildSingleArticles(jsonresult[0]);
        },
        error:function(){
        	toastr.info("获取热门文章失败");
        	window.location.href="/index.jsp";
        }
});

$.ajax({
    type:"post",
    url:"singleArticlescommentsa",
    data:{
    	contentsId : urlt
       //name : $("#name").val()
    },
    dataType:"json",
    success:function(result){
        
       var jsonresult = JSON.parse(result);
       //alert("使用ajax成功返回文章评论数据"+result);
       //alert("uid="+jsonresult[0].uid+" name="+jsonresult[0].name);
       //showUserInfo(jsonresult);
       //构造数据
       buildSingleArticleComments(jsonresult);
    },
    error:function(){
    	toastr.info("获取文章评论数据失败");
    	window.location.href="/index.jsp";
    }
});


function buildSingleArticleComments(resu){
	var targetComName = $("#comments .commentlist");
	for(var i=0;i<resu.length;i++){
		var str = "<li class=\"comment even thread-odd thread-alt depth-1\" id=\"li-comment-4\"><article id=\"comment-4\">"
                + "<div class=\"comment-meta\"><h5 class=\"author\"> <cite class=\"fn\"><a href=\"#\" rel=\"external nofollow\" class=\"url\">"
                + resu[i].authorName      
                + "</a></cite></h5><p class=\"date\"><time datetime=\"datetime\">"
                + resu[i].created    
                + "</time></p></div><div class=\"comment-body\">"        
                + "第"+(i+1)+"楼&emsp;"+resu[i].text
                + "</div></article></li> "
        targetComName.append(str);     
	}
	
}
function buildSingleArticles(resu) {
	$("#commentform .contentsId").val(resu.cid);
	$("#row .contents").html(resu.text);
	$("#row .post-title").html(resu.title);
	$("#row .category").html(resu.tag);
	$("#like-it-form .likes").html(resu.likes);
	$("#row .user").html(resu.authorName);
}

function checkcomment() {
	var con = $("#comment").val().replace(/^\s+|\s+$/g,"");
	if(con=='') {
		alert("请输入评论");
		return false;
	}
	return true;
}
function commitsub() {
	$.ajax({
        type:"post",
        url:"commentsa",
        data:{
        	//contentsId : urlt
           //name : $("#name").val()
        	contents:$("#comment").val(),
        	contentsId:$("#commentform .contentsId").val()
        },
        dataType:"json",
        success:function(result){
            
           alert("使用ajax成功返回当前评论结果"+result);
           var jsonresult = JSON.parse(result);
           //alert("uid="+jsonresult[0].uid+" name="+jsonresult[0].name);
           //showUserInfo(jsonresult);
           //构造数据
           //buildSingleArticles(jsonresult[0]);
        },
        error:function(){
        	toastr.info("获取热门文章失败");
        	window.location.href="/index.jsp";
        }
});
}

//文章点赞功能
//设置cookie  
function setCookie(key, value) {  
        document.cookie = key + "=" + escape(value);  
}  
//获取cookie的值  
function getCookie(key) {  
    if (document.cookie.length) {  
        var cookies = ' ' + document.cookie;  
        var start = cookies.indexOf(' ' + key + '=');  
        if (start == -1) { return null; }  
        var end = cookies.indexOf(";", start);  
        if (end == -1) { end = cookies.length; }  
        end -= start;  
        var cookie = cookies.substr(start,end);  
        return unescape(cookie.substr(cookie.indexOf('=') + 1, cookie.length - cookie.indexOf('=') + 1));  
    }  
    else { return null; }  
} 

function comment(){  
	
	/* var likeButton = $(this);
    var likeHtml = likeButton.html();
    var likeNum = parseInt(likeHtml, 10);
    likeNum++;
    likeButton.html(likeNum); */
    var num = $("#like-it-form .likes").html();
    //alert(num);
	//alert(num);
	//alert(returnCitySN["cip"]+','+returnCitySN["cname"])  
	var id= returnCitySN["cip"]+$("#commentform .contentsId").val();
	//setCookie(id,"传的网站"); 
	//alert(id);
	//alert(returnCitySN["cip"]);
	//delCookie(id);
      if(getCookie(id)==null){  
           setCookie(id,"传的网站");        
           //alert("设置cookie成功"); 
          //alert(num++);
           $("#like-it-form .likes").html(++num);
       }else{
           if(getCookie(id)=="传的网站"){     
               //alert("您已经点评过了");  
               //setCookie(id,null);
               delCookie(id);
               //alert(num--);
               $("#like-it-form .likes").html(--num);
               
            }
        } 
	 //设置当前文章likes
	 var newLike = $("#like-it-form .likes").html();
	 var currentArticleId = $("#commentform .contentsId").val();
	 setCurrentArticleLike();
 
}
function delCookie(name){
	 var exp = new Date();
	 exp.setTime(exp.getTime() - 1);
	 var cval=getCookie(name);
	 if(cval!=null)
	 document.cookie= name + "="+cval+";expires="+exp.toGMTString();
}
function setCurrentArticleLike() {
	$.ajax({
        type:"post",
        url:"articleLikea",
        data:{
        	contentsId : $("#commentform .contentsId").val(),
        	likes:$("#like-it-form .likes").html()
        },
        dataType:"json",
        success:function(result){
            
           //alert("使用ajax成功返回当前文章like结果"+result);
           var jsonresult = JSON.parse(result);
           //alert("uid="+jsonresult[0].uid+" name="+jsonresult[0].name);
           //showUserInfo(jsonresult);
           //构造数据
           //buildSingleArticles(jsonresult[0]);
        },
        error:function(){
        	toastr.info("返回当前文章like失败");
        	//window.location.href="/index.jsp";
        }
});
}
</script>
        </body>
</html>
