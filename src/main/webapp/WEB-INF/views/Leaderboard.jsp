<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Leaderboard</title>
    <! gold, silver and bronze colours used for top 3 ranked users css !>
    <style>
        
        table {
            margin: 0;
            width: 100%;
            border-radius: 5px;
            border: 1px solid #e5e7eb;
        }
        
        th,
        td {
            border: none;
            padding: 8px;
            box-sizing: border-box;
            text-align: left;
            margin: 0;
        }
        
        th {
            background-color: #e5e7eb;
        }

        tr{
            border: 1px solid black !important;
        }
        
        .table-header {
            width: 100%;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 0;
            box-sizing: border-box;
        }
        
        .table-header-left{
            display: flex;
            align-items: center;
            justify-content: flex-start;
            width: 70%;
        }

        .gold {
            background-color: gold;
        }
        .silver {
            background-color: silver;
        }
        .bronze {
            background-color: #cd7e32;
        }
    </style>
</head>
<body>

<h2 style="text-align: center;">Global Leaderboard</h2>
<table border="1">
    <tr>
        <! Leaderboard Headings !>
        <th>Rank</th> <! Rank uses index in table !>
        <th>Username</th> <! Uses users set username !>
        <th>Level</th> <! Uses the amount of courses completed !>
    </tr>
    <c:forEach items="${leaderboard}" var="user" varStatus="status">
        <! if 1st make gold, if second make silver, if third make bronze !>
        <tr class="${status.index < 3 ? (status.index == 0 ? 'gold' : (status.index == 1 ? 'silver' : 'bronze')) : ''}">
            <td>${status.index + 1}</td> <! rank uses index !>
            <td>${user.username}</td>
            <td>${user.score}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
