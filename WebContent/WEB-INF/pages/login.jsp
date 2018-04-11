<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>登录页面</title>
    <link type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" href="${pageContext.request.contextPath}/static/css/login.css" rel="stylesheet">
  </head>
  <body class="layout-boxed">
    <div class="container">
      <form class="form-signin" method="post" action="login">
        <h3 class="form-signin-heading">请登录</h3>
        <label class="sr-only">用户名</label>
        <input type="text" class="form-control" placeholder="用户名/邮箱/手机号" name="id" required autofocus>
       <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" class="form-control" placeholder="密码" name="password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" name="rememberMe">记住我
          </label>
        </div>
        <p class="bg-warning">${error}</p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>
    </div>
  </body>
</html>
