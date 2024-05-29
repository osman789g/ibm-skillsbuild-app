<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Top 3 IBMSkillsBuild Courses display</title>
    <meta charset="UTF-8">
    <title>Popularity Test</title>
    <style>
        .Top3CoursesDisplay{
            display: flex;
            flex-wrap: wrap;
        }

        .card{
            width: 325px;
            background-color:#f0f0f0;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0px 2px 4px rgba(0,0,0,0.2);
            margin:20px
        }
    </style>
</head>


<body>
<h2>Top 3 Popular Courses</h2>
<div class="Top3CoursesDisplay">
    <c:forEach items="${topCourses}" var = "element" varStatus="counter">
        <div class="card-container">
            <div class = "card">
                <%--Image section of course should go here(Extra)--%>
                <div class="card-content">
                    <h3>${counter.index + 1}. ${element}</h3>
                        <%--description of course goes here(Extra)--%>
                        <%--Link to Course goes here(Extra)--%>

                </div>
            </div>
        </div>
    </c:forEach>
</div>

<%--<ul>--%>
<%--    <c:forEach items="$${topCourses}" var = "element">--%>
<%--        <li>${element}</li>--%>
<%--    </c:forEach>--%>
<%--</ul>--%>
</body>
</html>
