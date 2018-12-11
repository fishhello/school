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
<link rel="stylesheet" type="text/css" href="css/bootstrap-select.css">
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
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
                                                
                                                <section id="comments">

                                                        <ol class="commentlist">
                                                        </ol>

                                                        <div id="respond">

                                                                <form action="submmitContentsa" method="post" id="commentform" onsubmit="return checkcomment();">
                                                                <!-- <s:token/> -->
                                                                <h3>文章标题</h3>
																		<input name="title" id="title" type="text" class="span12 form-input " sytle="height:20px;" placeholder="文章标题">
																		<h3>文章内容</h3>
                                                                        <div>
                                                                                <label for="comment"></label>
                                                                                <textarea class="span12" name="contents" id="commenta" cols="75" rows="10"></textarea>
                                                                        </div>
                                                                        
																		<input type="hidden" name="blockId" id="cclass" value="-1">
																		
                                                                        <p class="allowed-tags">你可以使用html标签填写 <small><code>&lt;a href="" title=""&gt; &lt;abbr title=""&gt; &lt;acronym title=""&gt; &lt;b&gt; &lt;blockquote cite=""&gt; &lt;cite&gt; &lt;code&gt; &lt;del datetime=""&gt; &lt;em&gt; &lt;i&gt; &lt;q cite=""&gt; &lt;strike&gt; &lt;strong&gt; </code></small></p>
																		
																		<h3>文章的标签</h3>
																		<input name="tag" type="text" class="span12 form-input " sytle="height:20px;" placeholder="文章标签,多个标签使用英文逗号隔开">
																		
																		<h3>下拉框选择文章所属分类</h3>
																		<select id="id_select" class="selectpicker bla bla bli" multiple data-live-search="true" style="height:100px">
																		    
																		  </select>					
                                                                        <div><br/>
                                                                                <input class="btn" name="submit" type="submit" id="submit" onclick="commitsub()" value="提交">
                                                                        </div>
																		
                                                                </form>

                                                        </div>

                                                </section><!-- end of comments -->

                                        </div>
                                        <!-- end of page content -->
                                </div>
                        </div>
                </div>
                <!-- End of Page Container -->

                <!-- Start of Footer -->
                
                        <!-- end of #footer -->

                        <!-- Footer Bottom -->
                        
                        <!-- End of Footer Bottom -->

                <!-- End of Footer -->

                <a href="#top" id="scroll-top"></a>

                <!-- script -->
                <%@ include file="foot.jsp" %>
                <script src="http://pv.sohu.com/cityjson?ie=utf-8"></script> 
                <script type="text/javascript" src="js/bootstrap-select.js">
                
                <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script type="text/javascript">
//获取分类
showclassifies();
	        
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
           //构造数据 提供一个下拉列表 让文章选定一个分类
           buildclassifiesSelect(jsonresult);
        },
        error:function(){
        	toastr.info("获取论坛的所有分类失败");
        	window.location.href="/index.jsp";
        }
    });
}
function buildclassifiesSelect(resu) {
	var targetClass = $("#id_select");
	$("#id_select").html("");
	for(var i=0;i<resu.length;i++) {
		var str = "<option onclick='markselect("+resu[i].bid+")'>"
				+resu[i].bname
				+ "</option>"
		targetClass.append(str);
	}
}
function markselect(id) {
	//alert(id);
	$("#cclass").val(id);
	//alert($("#cclass").val());
}

function checkcomment() {
	var cla = $("#cclass").val();
	var text = $("#commenta").val().replace(/^\s+|\s+$/g,"");
	var title = $("#title").val().replace(/^\s+|\s+$/g,"");
	if(title=="") {
		alert("请输入文章标题");
		return false;
	}
	if(text == "") {
		alert("请输入文章");
		return false;
	}
	if(cla=="-1") {
		alert("请选择一个分类");
		return false;
	}
	return true;
}
</script>
        </body>
</html>
