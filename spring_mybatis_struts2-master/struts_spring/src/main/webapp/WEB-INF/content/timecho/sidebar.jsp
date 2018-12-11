<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
  if(session.getAttribute("currentUser")==null)
  {
		response.sendRedirect(request.getContextPath()+"/index.jsp");
    	return;
   }
%>
<aside class="span4 page-sidebar">

                                                <section class="widget">
                                                        <div class="support-widget">
                                                                <h3 class="title">hello</h3>
                                                                <p class="intro">TIMECHO论坛</p>
                                                        </div>
                                                </section>

                                                <section class="widget">
                                                        <div class="quick-links-widget">
                                                                <h3 class="title">论坛分类</h3>
                                                                <ul id="menu-quick-links" class="menu clearfix">
                                                                </ul>
                                                        </div>
                                                </section>

                                                <section class="widget">
                                                        <h3 class="title">论坛内容标签</h3>
                                                        <div class="tagcloud" id="tagcloud">
                                                        </div>
                                                </section>

                                        </aside>
                                        <%@ include file="foot.jsp" %>
<script type="text/javascript">
showclassifies();
showNewArticles();
//获取论坛的所有分类
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
	targetC.html("");
	for(var i=0;i<resu.length;i++) {
	 	var str = "<li><a onclick=\"alert('待开发')\">"
	 			+resu[i].bname
	 			+"</a></li>"
	 	targetC.append(str);
	}
}
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
          	//buildNewArticles(jsonresult);
          	//设置论坛内容标签
          	buildTag(jsonresult);
        },
        error:function(){
        	toastr.info("获取最新文章失败");
        	window.location.href="/index.jsp";
        }
    });
}
function buildTag(resu) {
	var targetTagcloud = $("#tagcloud");
	$("#tagcloud").html("");
	for(var i=0;i<resu.length;i++) {
		if(resu[i].tag==null){
			continue; 
		}
		var str = "<a onclick=\"alert('待开发')\" class=\"btn btn-mini\">"
				+ resu[i].tag
				+"</a>"
		targetTagcloud.append(str);
	}
	
}
</script>                                        