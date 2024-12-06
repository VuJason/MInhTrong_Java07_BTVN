<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="16x16" href="plugins/images/favicon.png">
    <title>Pixel Admin</title>
    <!-- Bootstrap Core CSS -->
    <link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
    <!-- animation CSS -->
    <link href="css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/style.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="css/colors/blue-dark.css" id="theme" rel="stylesheet">
</head>

<body>
    <!-- Preloader -->
    <div class="preloader">
        <div class="cssload-speeding-wheel"></div>
    </div>

    <div id="wrapper">
        <!-- Navigation -->
       		<nav class="navbar navbar-default navbar-static-top m-b-0">
			<div class="navbar-header">
				<a class="navbar-toggle hidden-sm hidden-md hidden-lg "
					href="javascript:void(0)" data-toggle="collapse"
					data-target=".navbar-collapse"> <i class="fa fa-bars"></i>
				</a>
				<div class="top-left-part">
					<a class="logo" href="/crm_app07"> <b> <img
							src="plugins/images/pixeladmin-logo.png" alt="home" />
					</b> <span class="hidden-xs"> <img
							src="plugins/images/pixeladmin-text.png" alt="home" />
					</span>
					</a>
				</div>
				<ul class="nav navbar-top-links navbar-left m-l-20 hidden-xs">
					<li>
						<form role="search" class="app-search hidden-xs">
							<input type="text" placeholder="Search..." class="form-control">
							<a href=""> <i class="fa fa-search"></i>
							</a>
						</form>
					</li>
				</ul>
				<ul class="nav navbar-top-links navbar-right pull-right">
					<li>
						<div class="dropdown">
							<a class="profile-pic dropdown-toggle" data-toggle="dropdown"
								href="#"> <img src="plugins/images/users/varun.jpg"
								alt="user-img" width="36" class="img-circle" /> <b
								class="hidden-xs">Cybersoft</b>
							</a>
							<ul class="dropdown-menu">
								<li><a href="/crm_app07/profile">Thông tin cá nhân</a></li>
								<li><a href="#">Thống kê công việc</a></li>
								<li class="divider"></li>
								<li><a href="/crm_app07/logout">Đăng xuất</a></li>
							</ul>
						</div>
					</li>
				</ul>
			</div>
			<!-- /.navbar-header -->
			<!-- /.navbar-top-links -->
			<!-- /.navbar-static-side -->
		</nav>

        <!-- Left navbar-header -->
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse slimscrollsidebar">
                <ul class="nav" id="side-menu">
                    <li><a href="/crm_app07" class="waves-effect"><i class="fa fa-clock-o fa-fw"></i><span class="hide-menu">Dashboard</span></a></li>
                    <li><a href="/crm_app07/users" class="waves-effect"><i class="fa fa-user fa-fw"></i><span class="hide-menu">Thành viên</span></a></li>
                    <li><a href="/crm_app07/roles" class="waves-effect"><i class="fa fa-modx fa-fw"></i><span class="hide-menu">Quyền</span></a></li>
                    <li><a href="/crm_app07/tasks" class="waves-effect"><i class="fa fa-table fa-fw"></i><span class="hide-menu">Công việc</span></a></li>
                    <li><a href="/crm_app07/jobs" class="waves-effect"><i class="fa fa-table fa-fw"></i><span class="hide-menu">Dự án</span></a></li>
                </ul>
            </div>
        </div>

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Cập nhật công việc</h4>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-2 col-12"></div>
                    <div class="col-md-8 col-xs-12">
                        <div class="white-box">
                            <form class="form-horizontal form-material" action="profile-edit" method="post">
                                <!-- Giữ giá trị của taskId -->
                                <input type="hidden" name="id" value="${task.id}" /> 

                                <!-- Dự án -->
                                <div class="form-group">
                                    <label class="col-md-12">Dự án</label>
                                    <div class="col-md-12">
                                        <select name="job" class="form-control form-control-line">
                                            <c:forEach items="${listJob}" var="item">
                                                <option value="${item.id}">${item.jobName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <!-- Tên công việc -->
                                <div class="form-group">
                                    <label class="col-md-12">Tên công việc</label>
                                    <div class="col-md-12">
                                        <input name="taskName" type="text" value="${task.taskName}" placeholder="Tên công việc" class="form-control form-control-line">
                                    </div>
                                </div>

                                <!-- Người thực hiện -->
                                <div class="form-group">
                                    <label class="col-md-12">Người thực hiện</label>
                                    <div class="col-md-12">
                                        <select name="user" class="form-control form-control-line">
                                            <c:forEach items="${listUser}" var="user">
                                                <option value="${user.id}" >${user.fullname}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <!-- Ngày bắt đầu -->
                                <div class="form-group">
                                    <label class="col-md-12">Ngày bắt đầu</label>
                                    <div class="col-md-12">
                                        <input name="startDate" type="text" value="${task.startDate}" placeholder="yyyy-MM-dd" class="form-control form-control-line">
                                    </div>
                                </div>

                                <!-- Ngày kết thúc -->
                                <div class="form-group">
                                    <label class="col-md-12">Ngày kết thúc</label>
                                    <div class="col-md-12">
                                        <input name="endDate" type="text" value="${task.endDate}" placeholder="yyyy-MM-dd" class="form-control form-control-line">
                                    </div>
                                </div>

                                <!-- Trạng thái -->
                                <div class="form-group">
                                    <label class="col-md-12">Trạng thái</label>
                                    <div class="col-md-12">
                                        <select name="status" class="form-control form-control-line">
                                            <c:forEach items="${listStatus}" var="item">
                                                <option value="${item.id}">${item.statusName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <!-- Nút cập nhật -->
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <button type="submit" class="btn btn-success">Cập nhật</button>
                                        <a href="javascript:history.back()" class="btn btn-primary">Quay lại</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-2 col-12"></div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="plugins/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="js/custom.min.js"></script>
</body>

</html>
