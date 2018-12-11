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
        
<%@ include file="head.jsp" %>
        <body>
				<!-- Start of Header -->
                <jsp:include   page="Timechoheader.jsp" flush="true"/>
				<!-- End of Header -->
                <!-- Start of Search Wrapper -->

                <%-- <jsp:include   page="searchwrapper.jsp" flush="true"/> --%>
                <!-- End of Search Wrapper -->
                <div class="copyrights">Collect from <a href="http://www.cssmoban.com/" title="æ¨¡æ¿ä¹å®¶">æ¨¡æ¿ä¹å®¶</a></div>

                <!-- Start of Page Container -->
                <div class="page-container">
                        <div class="container">
                                <div class="row">

                                        <!-- start of page content -->
                                        <div class="span8 page-content">

                                                <!-- Basic Home Page Template -->
                                                <div class="row separator">
                                                        <section class="span4 articles-list" id="hotArticles">
                                                                <h3>热门文章</h3>
                                                                <ul class="articles">
                                                                </ul>
                                                        </section>


                                                        <section class="span4 articles-list" id="newArticles">
                                                                <h3>最新文章</h3>
                                                                <ul class="articles">
                                                                </ul>
                                                        </section>
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
                <jsp:include   page="Timechofooter.jsp" flush="true"/>
                
                <!-- End of Footer -->

                <a href="#top" id="scroll-top"></a>
<%@ include file="foot.jsp" %>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	//显示最新文章
	showNewArticles();
	//显示热门文章
	showHotArticles();
	//显示论坛的所有分类
	showclassifies();
function showNewArticles() {
	$.ajax({
        type:"post",
        url:"newArticlesa",
        data:{
            //id : $("#id").val(),
           //name : $("#name").val()
        },
        dataType:"json",
        success:function(result){
            
            var jsonresult = JSON.parse(result);
            //var jsonresult = eval('(' + result + ')');
          	//alert("使用ajax成功返回最新文章数据"+result);
           //alert("uid="+jsonresult[0].uid+" name="+jsonresult[0].name);
           //showUserInfo(jsonresult);
          	buildNewArticles(jsonresult);
          	//设置论坛内容标签
          	//buildTag(jsonresult);
        },
        error:function(){
        	toastr.info("获取最新文章失败");
        	window.location.href="/index.jsp";
        }
    });
}
function buildNewArticles(resu){
	var targetN = $("#newArticles .articles");
	targetN.html("");
    
	for(var i=0;i<resu.length;i++) {
		if(resu[i].tag=='') {
			resu[i].tag="暂无分类";
		}
		var atom = "<li class='article-entry standard'>"
				+ "<h4><a href='oneArticlesa?contentsId="+resu[i].cid+"&time="+resu[i].created+"'>"+resu[i].title+"</a></h4>"
				+ "<span class='article-meta'>"+resu[i].created+" in <a href='#' title='"+resu[i].tag+"'>"+resu[i].tag+"</a></span>"
				+ "<span class='like-count'>"+resu[i].likes+"</span></li>"
		targetN.append(atom);
	}
}

/* function buildTag(resu) {
	var targetTagcloud = $("#tagcloud");
	for(var i=0;i<resu.length;i++) {
		var str = "<a onclick=\"alert('待开发')\" class=\"btn btn-mini\">"
				+ resu[i].tag
				+"</a>"
		targetTagcloud.append(str);
	}
	
} */

function showHotArticles(){
	$.ajax({
        type:"post",
        url:"hotArticlesa",
        data:{
            //id : $("#id").val(),
           //name : $("#name").val()
        },
        dataType:"json",
        success:function(result){
            
           var jsonresult = JSON.parse(result);
           //alert("使用ajax成功返回最热文章数据"+result);
           //alert("uid="+jsonresult[0].uid+" name="+jsonresult[0].name);
           //showUserInfo(jsonresult);
           //构造数据
           buildHotArticles(jsonresult);
        },
        error:function(){
        	toastr.info("获取热门文章失败");
        	window.location.href="/index.jsp";
        }
    });
}

function buildHotArticles(resu) {
	var targetN = $("#hotArticles .articles");
	targetN.html("");
    
	for(var i=0;i<resu.length;i++) {
		if(resu[i].tag=='') {
			resu[i].tag="暂无分类";
		}
		
		var atom = "<li class='article-entry standard'>"
				+ "<h4><a href='oneArticlesa?contentsId="+resu[i].cid+"&time="+resu[i].created+"'>"+resu[i].title+"</a></h4>"
				+ "<span class='article-meta'>"+resu[i].created+" in <a href='#' title='"+resu[i].tag+"'>"+resu[i].tag+"</a></span>"
				+ "<span class='like-count'>"+resu[i].likes+"</span></li>"
		targetN.append(atom);
	}
}
/* //获取论坛的所有分类
function showclassifies() {
	$.ajax({
        type:"post",
        url:"classifiesa",
        data:{
            //id : $("#id").val(),
           //name : $("#name").val()
        },
        dataType:"json",
        success:function(result){
            
           var jsonresult = JSON.parse(result);
           //alert("使用ajax成功获取论坛的所有分类"+result);
           //alert("uid="+jsonresult[0].uid+" name="+jsonresult[0].name);
           //showUserInfo(jsonresult);
           //构造数据
           buildclassifies(jsonresult);
        },
        error:function(){
        	toastr.info("获取论坛的所有分类失败");
        	window.location.href="/index.jsp";
        }
    });
}
function buildclassifies(resu) {
	var targetC = $(".page-sidebar #menu-quick-links");
	for(var i=0;i<resu.length;i++) {
	 	var str = "<li><a onclick=\"alert('待开发')\">"
	 			+resu[i].bname
	 			+"</a></li>"
	 	targetC.append(str);
	}
} */
</script>				
        </body>
</html>