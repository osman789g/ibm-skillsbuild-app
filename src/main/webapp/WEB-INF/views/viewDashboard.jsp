<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="icon" type="image/png" sizes="32x32" href="https://skillsbuild.org/favicon-32x32.png">
    <style>
        /* Style for the search input bar */
        @import url('https://fonts.googleapis.com/css2?family=Inter:wght@100..900&display=swap');

        .search-form {
            background-color: #ffffff;
            border-radius: 5px;
            /* Makes edges curved */
            display: flex;
            align-items: center;
            position: relative;
            /* Needed for the clear icon */
            width: 70%;
            max-width: 650px;
        }

        /* Style for magnifying glass icon */
        .search-icon {
            display: flex;
            align-items: center;
            justify-content: center;
            color: #555;
            font-size: 18px;
            margin: 0 10px;
        }

        /* Style for "x" clear icon */
        .clear-icon {
            cursor: pointer;
            color: #ccc;
            font-size: 15px;
            position: absolute;
            right: 120px;
            /* Adjust the right positioning */
            top: 50%;
            /* Center vertically */
            transform: translateY(-50%);
        }

        .search-form input[type="text"] {
            flex: 1;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 3px;
            font-size: 14px;
        }

        .search-form input[type="submit"] {
            background-color: #4562a0;
            color: #fff;
            border: none;
            padding: 10px 15px;
            border-radius: 3px;
            cursor: pointer;
            font-size: 14px;
            margin-left: 10px;
        }

        /* Hover effect on search button */
        .search-form input[type="submit"]:hover {
            background-color: #59739f;
            /* Makes colour of search button lighter to give hover effect */
        }

        /* Style for the headings */
        h2 {
            color: black;
            margin: 0;
        }

        /* Style for the table */
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

        label,
        select,
        input[type="submit"] {
            margin: 10px;
        }

        header {
            width: 100vw;
            height: 60px;
            border-bottom: 1px solid #e5e7eb;
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 20px;
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: 'Inter', sans-serif;
            overflow-x: hidden;
        }

        summary {
            font-family: 'Inter', sans-serif;

        }

        .main {
            padding: 10px;
            box-sizing: border-box;
        }

        .logo {
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 5px;
            font-weight: 700;
        }

        .nav {
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 20px;
            font-weight: 600;
        }

        .nav a {
            cursor: pointer;
            color: inherit;
            text-decoration: none;
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

        .filter-wrapper {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #e0e0e0;
            border-radius: 5px;
            margin-left: 5px;
            padding: 0 5px;
            box-sizing: border-box;
            gap: 8px;
        }

        .filter-div{
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .user-history {
            padding: 10px;
            box-sizing: border-box;
            background-color: #e0e0e0;
            border-radius: 5px;
        }

        button,
        input,
        select,
        option {
            font-family: 'Inter', sans-serif;
            padding: 3px 8px;
            box-sizing: border-box;
            outline: none;
            border: 1px solid black;
            border-radius: 5px;
            cursor: pointer;
        }

        button{
            transition: border 0.2s ease, background-color 0.2s ease, font-weight 0.2s ease;
        }

        button:hover{
            border: 1px solid #d9dff0;
            background-color: #e5e7eb;
            font-weight: 400;
        }

        .Top3CoursesDisplay{
            display: flex;
            justify-content: flex-start;
            align-items: center;
            flex-wrap: wrap;
            gap: 10px;
            padding: 10px;
            box-sizing: border-box;
        }

        .card{
            width: 325px;
            background-color:#f0f0f0;
            border-radius: 8px;
            padding: 5px;
            box-sizing: border-box;
        }
    </style>
    <title>Dashboard Page</title>
</head>
<body>
<header>
    <div class="logo">
        <img src="https://skillsbuild.org/favicon-32x32.png" />
        IBM SkillsBuild
    </div>
    <div class="nav">
        <a href="Leaderboard">Leaderboard</a>
        <a href="Reviewpage">Reviews</a>
        <a href="profile">Profile</a>
        <a href="logout">Log Out</a>
        <a>Daily Streak: ${streak}</a>
    </div>
</header>
<section class="main">
    <div>
        <h2>Top 3 Popular Courses</h2>
        <div class="Top3CoursesDisplay">
            <c:forEach items="${topCourses}" var = "element" varStatus="counter">
                <div class = "card">
                        <%--Image section of course should go here(Extra)--%>
                    <div class="card-content">
                        <h3>${counter.index + 1}. ${element.coursename}</h3>
                            <%--description of course goes here(Extra)--%>
                            <%--Link to Course goes here(Extra)--%>
                        <button onclick="redirectToCourse('${element.link}')">Go to course</button>
                        <button onclick="startCourse('${element.coursename}', '${element.link}')">Start
                            Course</button>
                        <button onclick="finishCourse('${element.coursename}')">Finish Course</button>




                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <div class ="uncategorizedFeatures">
        <h2 class="center">Available Courses</h2>
        <div class="table-header">
            <div class="table-header-left">
                <form style="background-color: lightgrey" class="search-form" action="/" method="get">
                    <! Search-icon uses html entity "&#128269" for a search icon found
                    using "https://stackoverflow.com/questions/22202890/what-is-the-html-entity-for-a-search-icon"
                    !>
                    <div class="search-icon">&#128269;</div>

                    <! Uses searchInput as variable for users search !>
                    <input type="text" id="search" name="search" placeholder="Enter course name... ">

                    <! In second div class we put under the class clear-icon and then use the function
                    clearSearch which quickly removes the users current entered search and onclick
                    allows this to be done when it is clicked on. We use " &times; " as the html entity
                    for an X. !>
                    <div class="clear-icon" onclick="clearSearch()">&#10006;</div>

                    <! The enter button for user to make the search !>
                    <input type="submit" value="Search">
                </form>
                <div class="filter-wrapper">
                    <form action="/" method="get" class="filter-div">
                        <select id="topics" name="topics">
                            <option value=""> -- Select a topic --</option>
                            <c:forEach items="${topics}" var="topic">
                                <option value="${topic}">${topic}</option>
                            </c:forEach>
                        </select>
                        <button type="submit" value="Submit"> Submit </button>
                    </form>
                    <form action=" " th:action=" ">
                        <button type="submit" value="Clear"> Clear </button>
                    </form>
                </div>
            </div>

            <div class="user-history">
                <button onclick="showHistory()">Show User History</button>
            </div>
        </div>
        <table class="center">
            <tr>
                <th><b>Topic:</b></th>
                <th><b>Course Name:</b></th>
                <th><b>Access this course:</b></th>
            </tr>
            <c:forEach items="${courselist}" var="clist">
                <tr>
                    <td>${clist.topic}</td>
                    <td>${clist.coursename}</td>
                    <td>
                        <button onclick="startCourse('${clist.coursename}', '${clist.link}')">Start
                            Course</button>
                        <a href="${clist.link}"><button>Go to course</button></a>
                        <button onclick="finishCourse('${clist.coursename}')">Finish Course</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <script>
        function clearSearch() {
            document.getElementById('search').value = '';
            <!-- changes input to "" to clear search input -->
        }

    </script>
</section>

<script>
    function showHistory() {
        window.location.href = ('http://localhost:8080/courseAttempts')
    }

    function startCourse(courseName, courseLink) {
        window.open("http://localhost:8080/startCourse?courseName=" + courseName + '&courseLink=' + courseLink);
        }

    function finishCourse(courseName) {
        const xhr = new XMLHttpRequest();
        xhr.open('GET', 'http://localhost:8080/finishCourse?courseName=' + courseName, true);
        xhr.send();
        window.location.href = ("http://localhost:8080")
    }

    <%--Added as part of top 3 Trending courses feature--%>
    <%--redirect only: redirects user to course without saving as courseAttempt--%>
    function redirectToCourse(courseLink){
        // Redirect to the course link
        window.location.href = courseLink;
    }

</script>
</body>
</html>