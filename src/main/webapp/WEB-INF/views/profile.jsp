<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html>

        <head>
            <title>User Profile</title>
            <style>
                @import url('https://fonts.googleapis.com/css2?family=Inter:wght@100..900&display=swap');

                h1 {
                    color: black;
                    margin: 0;
                    font-size: 22px;
                }

                body {
                    margin: 0;
                    font-family: 'Inter', sans-serif;
                }

                .badgeContainer {
                    position: relative;
                    padding: 10px;
                    box-sizing: border-box;
                    border-radius: 20px;
                    border: 1px solid #e5e7eb;
                }

                /* All code for the tooltip below */
                .badgeContainer:hover .tooltip {
                    visibility: visible;
                }

                .tooltip {
                    position: absolute;
                    top: 50%;
                    left: calc(100% + 10px);
                    transform: translateY(-50%);
                    background-color: rgba(0, 0, 0, 0.8);
                    color: #fff;
                    padding: 10px;
                    border-radius: 5px;
                    visibility: hidden;
                    width: 150px;
                    text-align: center;
                    z-index: 999;
                }

                .tooltip::after {
                    content: '';
                    position: absolute;
                    top: 50%;
                    right: 100%;
                    transform: translateY(-50%);
                    border-width: 5px;
                    border-style: solid;
                    border-color: transparent transparent transparent rgba(0, 0, 0, 0.8);
                }

                footer {
                    position: fixed;
                    bottom: 0;
                    width: 100%;
                    padding: 10px;
                    text-align: center;
                }

                div {
                    display: flex;
                    align-items: center;
                    justify-content: center;
                }

                button,
                input,
                select,
                option {
                    font-family: 'Inter', sans-serif;
                    padding: 3px 8px;
                    box-sizing: border-box;
                    outline: none;
                    border: 1px solid transparent;
                    border-radius: 5px;
                    cursor: pointer;
                    background-color: transparent;
                }

                button {
                    transition: border 0.2s ease, background-color 0.2s ease, font-weight 0.2s ease;
                }

                button:hover {
                    border: 1px solid #d9dff0;
                    background-color: #e5e7eb;
                    font-weight: 400;
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
                    padding: 0;
                    font-family: 'Inter', sans-serif;
                    /* overflow-x: hidden; */
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

                .profile-wrapper {
                    width: 100%;
                    padding: 60px 5%;
                    box-sizing: border-box;
                }

                .profile {
                    width: 100%;
                    padding: 10px;
                    box-sizing: border-box;
                    border: 1px solid #e5e7eb;
                    display: flex;
                    flex-direction: column;
                    align-items: flex-start;
                    gap: 10px;
                    position: relative;
                }

                .user-info {
                    display: flex;
                    flex-direction: column;
                    justify-content: flex-start;
                    align-items: flex-start;
                    gap: 3px;

                }

                .user-info p {
                    box-sizing: border-box;
                    font-weight: 500;
                    margin: 0;

                }


                .action-btns {
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    gap: 5px;
                    padding: 3px;
                    box-sizing: border-box;
                    border: 1px solid #e5e7eb;
                    border-radius: 5px;
                    position: absolute;
                    top: 10px;
                    right: 10px;
                }

                .action-btns form {
                    margin: 0;
                }

                .badge-section{
                    width: 100%;
                    padding: 10px 0;
                    box-sizing: border-box;
                    border-top: 1px solid #e5e7eb;
                    flex-direction: column;
                    align-items: flex-start;
                }
            </style>

        </head>

        <body>
            <header>
                <div class="logo">
                    <img src="https://skillsbuild.org/favicon-32x32.png" />
                    IBM SkillsBuild
                </div>
                <div class="nav">
                    <a href="/">Dashboard</a>
                    <a href="Leaderboard">Leaderboard</a>
                    <a href="Reviewpage">Reviews</a>
                    <a href="profile">Profile</a>
                    <a href="logout">Log Out</a>
                </div>
            </header>
            <div class="profile-wrapper">

                <div class="profile">
                    <div>
                        <c:if test="${not empty avatarUrl}">
                            <img src="${avatarUrl}" alt="Avatar"
                                style="max-width: 100px; max-height: 100px; border-radius: 25px;">
                        </c:if>
                    </div>
                    <h1>Profile</h1>

                    <div class="user-info">
                        <p><strong>Username:</strong> ${user.username}</p>
                        <p><strong>Email:</strong> ${user.email}</p>
                        <p><strong>Level:</strong> ${user.score}</p>
                    </div>


                    <div class="action-btns">
                        <!-- Takes user to edit profile page -->
                        <form action="/profile/edit" method="get">
                            <button type="submit">Edit Profile</button>
                        </form>
                    </div>



                    <%-- Display success message --%>
                        <div class="badge-section">
                            <c:if test="${not empty successMessage}">
                                <div class="alert alert-success" role="alert">${successMessage}</div>
                            </c:if>

                            <h1>Badges</h1>
                            <div style="display: flex; gap: 10px; margin-top: 10px;">
                                <c:forEach items="${badges}" var="badge">
                                    <div class="badgeContainer">
                                        <img src="${badge.imgUrl}" style="max-width: 75px; max-height: 75px">
                                        <div class="tooltip">${badge.badgeDescription}</div>
                                    </div>
                                </c:forEach>

                            </div>
                        </div>

                </div>
            </div>


        </body>

        <%-- Move this footer to bottom of page --%>
            <footer>
                <a href="https://www.flaticon.com/icons">All badges are from Flaticon.</a>
                <a>All avatars are AI generated.</a>
            </footer>

        </html>