<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>404</title>
  <%@ include file="/WEB-INF/common/cssLib.jsp" %>
</head>
<body>
		<div style="min-height: 550px;">
        <!-- Main content -->
        <section class="content">
          <div class="error-page">
            <h2 class="headline text-yellow"> 404</h2>
            <div class="error-content">
              <h3><i class="fa fa-warning text-yellow"></i> 哎呦! 页面没有找到.</h3>
<!--               <p> -->
<!--                无法找到您正在寻找的页面 -->
<%--                ,你可以 <a href="<c:url value='/index.jsp'/>">返回</a>首页或重新搜索. --%>
<!--               </p> -->
<!--               <form class="search-form"> -->
<!--                 <div class="input-group"> -->
<!--                   <input type="text" name="search" class="form-control" placeholder="搜索"> -->
<!--                   <div class="input-group-btn"> -->
<!--                     <button type="submit" name="submit" class="btn btn-warning btn-flat"><i class="fa fa-search"></i></button> -->
<!--                   </div> -->
<!--                 </div>/.input-group -->
<!--               </form> -->
            </div><!-- /.error-content -->
          </div><!-- /.error-page -->
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
      <!-- <footer class="main-footer">
        <div class="pull-right hidden-xs">
          <b>Version</b> 2.3.0
        </div>
        <strong>Copyright &copy; 2014-2015 <a href="http://sys.dongtian.com">冬天</a>.</strong> All rights reserved.
      </footer> -->
</body>
 <%@ include file="/WEB-INF/common/jsLib.jsp"%>
</html>