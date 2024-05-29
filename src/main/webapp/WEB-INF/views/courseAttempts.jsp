<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Course Attempts</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Inter:wght@100..900&display=swap');
        body{
            font-family: 'Inter', sans-serif;
        }
        table {
            width: 50%;
            border-collapse: collapse;
            margin: 20px auto;
            text-align: left;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

<h2>Course Attempts</h2>
<table>
    <tr>
        <th>Course Name</th>
        <th>Start Time</th>
        <th>Duration (in seconds)</th>
        <th>Finish time</th>
        <th>Review</th>
    </tr>

    <c:forEach items="${courseAttempts}" var="courseAttempt">
        <tr>
            <td>${courseAttempt.courseName}</td>
            <td><span id="${courseAttempt.courseName}.${courseAttempt.startTime}" class="formattedStartDate"></span></td>
            <td>${courseAttempt.durationInSeconds}</td>
            <td><span id="${courseAttempt.courseName}.${courseAttempt.finishTime}" class="formattedFinishDate"></span></td>
            <td><a href="newReview?course=${courseAttempt.courseName}">Add review</a> </td>
        </tr>

        <script>
            function formatDateTime(dateTimeString) {
                var date = new Date(dateTimeString);
                var formattedDate = date.toLocaleString('en-US', {hour12: false}).replace(',', '');
                return formattedDate;
            }

            // Get the date strings
            var startDateTimeString = "${courseAttempt.startTime}";
            var finishDateTimeString = "${courseAttempt.finishTime}";

            // Call the formatDateTime function for start time and update the HTML element
            var formattedStartDate = formatDateTime(startDateTimeString);
            document.getElementById("${courseAttempt.courseName}.${courseAttempt.startTime}").textContent = formattedStartDate;

            // Call the formatDateTime function for finish time and update the HTML element
            var formattedFinishDate = formatDateTime(finishDateTimeString);
            document.getElementById("${courseAttempt.courseName}.${courseAttempt.finishTime}").textContent = formattedFinishDate;
        </script>
    </c:forEach>






</table>

</body>
</html>
