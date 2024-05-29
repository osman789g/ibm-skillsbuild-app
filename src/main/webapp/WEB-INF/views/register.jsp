<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
    <style>
        h2 {
            text-align: center;
            font-size: 50px;
            color: black;
            padding: 20px 0;
            margin: 0;
        }
        body {
            margin: 0;
            font-family: 'Inter', sans-serif;
        }

        .error-list {
            list-style-type: none;
            padding: 0;
        }

        input[type="submit"] {
            display: block;
            margin: 0 auto;
            padding-top: 12px;
            padding-bottom: 12px;
            width: 50%;
            text-align: center;
            background-color: #4562a0;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            font-size: 14px;
            margin-left: 10px;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            box-sizing: border-box;
            margin-bottom: 10px;
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: center;
            flex: 1;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 3px;
            font-size: 14px;
        }

        .container {
            display: flex;
            justify-content: center;
            align-items: flex-start;
            height: 100vh;
            padding-top: 40px;
            padding-bottom: 40px;
        }

        .error {
            color: red;
        }

        .form-container {
            width: 300px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
<h2>User Registration</h2>
<div class="container">
    <div class="form-container">
        <form:form modelAttribute="user" action="/register/save?user=${user}">
            <form:label path="username"> Username</form:label>
            <form:input path="username"/>
            <form:errors path="username"/><br/>

            <form:label path="password"> Password </form:label>
            <form:input path="password"/>
            <form:errors path="password"/><br/>

            <form:label path="email"> Email </form:label>
            <form:input path="email"/>
            <form:errors path="email"/><br/>

            <!--<input type="submit"/>-->
            <div style="text-align: center;">
                <input type="submit" style="display:block;margin: 0 auto;"/>
            </div>

        </form:form>
    </div>
</div>
</body>
</html>
