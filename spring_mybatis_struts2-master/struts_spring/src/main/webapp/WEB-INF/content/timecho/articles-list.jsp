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

                <title>文章列表</title>

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
               <%-- <jsp:include   page="searchwrapper.jsp" flush="true"/> --%>
                <!-- End of Search Wrapper -->

                <!-- Start of Page Container -->
                <div class="page-container">
                        <div class="container">
                                <div class="row">

                                        <!-- start of page content -->
                                        <div class="span8 main-listing">

                                                <!-- <article class="format-standard type-post hentry clearfix">

                                                        <header class="clearfix">

                                                                <h3 class="post-title">
                                                                        <a href="single.html">Using Javascript</a>
                                                                </h3>

                                                                <div class="post-meta clearfix">
                                                                        <span class="date">25 Feb, 2013</span>
                                                                        <span class="category"><a href="#" title="View all posts in Advanced Techniques">Advanced Techniques</a></span>
                                                                        <span class="comments"><a href="#" title="Comment on Using Javascript">0 Comments</a></span>
                                                                        <span class="like-count">18</span>
                                                                </div>end of post meta

                                                        </header>

                                                        <p>Many of us work in an endless stream of tasks, browser tasks, social media, emails, meetings, rushing from one thing to another, never pausing and never ending.&nbsp;Then the day is over, and we are exhausted, and we often have very little to show for it. And we start the next . . . <a class="readmore-link" href="http://knowledgebase.inspirythemes.com/using-javascript/">Read more</a></p>

                                                </article> -->

                                                <div id="pagination">
                                                        <a href="#" class="btn active">1</a>
                                                        <a href="#" class="btn">2</a>
                                                        <a href="#" class="btn">3</a>
                                                        <a href="#" class="btn">下一页</a>
                                                        <a href="#" class="btn">最后一页</a>
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
<script type="text/javascript">
//显示搜索出的文章
showSearch();
 
function showSearch() {
	var s = getQueryString("s");
	
	 $.ajax({
        type:"post",
        url:"searchArticlesa",
        data:{
            search:s
           
        },
        dataType:"json",
        success:function(result){
            
            var jsonresult = JSON.parse(result);
            //var jsonresult = eval('(' + result + ')');
          	alert("使用ajax成功返回搜索数据"+result);
           //alert("uid="+jsonresult[0].uid+" name="+jsonresult[0].name);
           //showUserInfo(jsonresult);
          	//buildNewArticles(jsonresult);
          	//设置论坛内容标签
          	//buildsearch(jsonresult);
        },
        error:function(){
        	toastr.info("获取最新文章失败");
        	window.location.href="/index.jsp";
        }
    }); 
}

function buildsearch(resu){
	for(var i=0;i<resu.length;i++) {
		var str ="<article class=\"format-standard type-post hentry clearfix\"><header class=\"clearfix\"><h3 class=\"post-title\"><a>"
		+resu[i].title
		+"</a></h3><div class=\"post-meta clearfix\"><span class=\"date\">"
		+resu[i].created
		+"</span><span class=\"category\"><a>"
		+ resu[i].tag
		+ "</a></span><span class=\"like-count\">"
		+ resu[i].likes
		+ "</span></div></header><p>"
		+ resu[i].text
		+ "</p></article>"
	}
}

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}
</script>
        </body>
</html>
