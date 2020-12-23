<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="./client/static/css/login.css">
</head>
<body>
    <div class="container">
        <h1>Đăng nhập</h1>
        <form class="form">
            <input type="text" placeholder="Email">
            <input type="password" placeholder="Mật khẩu">
            <button type="submit"><a href="./register.jsp">Đăng nhập</a></button>
        </form>
        <a href="register.jsp" class="register">Đăng kí</a>
        <a href="#" class="forget">Quên mật khẩu ?</a>
    </div>
</body>
</html>