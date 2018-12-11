<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Start of Header -->
                <div class="header-wrapper">
                        <header>
                                <div class="container">

                                        <div class="logo-container">
                                                <!-- Website Logo -->
                                                <a href="#"  title="TIMECHO">
                                                        <img src="images/logo.png" alt="TIMECHO">
                                                </a>
                                                <span class="tag-line">TIMECHO论坛</span>
                                        </div>


                                        <!-- Start of Main Navigation -->
                                        <nav class="main-nav">
                                                <div class="menu-top-menu-container">
                                                        <ul id="menu-top-menu" class="clearfix">
                                                        		
                                                                <li class="current-menu-item"><a href="indexa">首页</a></li>
                                                                <li><a href="#" onclick="location.href = 'summita';">发表文章</a></li>
                                                        		<li><a href="#" data-toggle="modal" data-target="#mytake" style="text-decoration:none;">介绍</a></span></li>
                                                                <li><a href="#" onclick="location.href = 'userInfoshowa';">个人信息</a></li>
                                                                <li><a href="loginouta">登出</a></li>
                                                        </ul>
                                                </div>
                                        </nav>
                                        <!-- End of Main Navigation -->

                                </div>
                        </header>
                </div>
                <!-- End of Header -->
                <!-- 介绍 模态框start -->
                <!-- 模态框（Modal） -->
<div class="modal fade" id="mytake" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header" style="background-color: rgb(243, 243, 243);border-top-left-radius: 6px;border-top-right-radius: 6px;overflow: hidden;">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel" >
					介绍
				</h4>
			</div>
			<div class="modal-body">
<div class="teModal-content">
    <div class="bg-white login-modal">
        <div class="col-md-12 login-wrap">
            <p>用户注册昵称、邮箱 没有唯一验证</p>
        </div>
    </div>
</div>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
                <!-- 介绍模态框end -->