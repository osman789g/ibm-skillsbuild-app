<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Edit Profile</title>
            <style>
                @import url('https://fonts.googleapis.com/css2?family=Inter:wght@100..900&display=swap');

                h1 {
                    color: black;
                    margin: 0;
                }

                body {
                    margin: 0;
                    font-family: 'Inter', sans-serif;

                }

                .badgeContainer {
                    position: relative;
                    margin: 10px;
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
                    z-index: 1;
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
                    /* display: flex;
                    align-items: center;
                    justify-content: center; */
                }

                button,
                input,
                select,
                option {
                    font-family: 'Inter', sans-serif;
                    padding: 3px 8px;
                    box-sizing: border-box;
                    outline: none;
                    border: 1px solid #e5e7eb;
                    border-radius: 5px;
                    background-color: transparent;
                }

                button{
                    cursor: pointer;
                }

                button {
                    transition: border 0.2s ease, background-color 0.2s ease, font-weight 0.2s ease;
                }

                button:hover {
                    border: 1px solid #d9dff0;
                    background-color: #e5e7eb;
                    font-weight: 400;
                }

                body {
                    padding: 10px;
                    box-sizing: border-box;
                }

                .heading {
                    display: flex;
                    align-items: flex-end;
                    justify-content: flex-start;
                    gap: 10px;
                    padding-bottom: 10px;
                    box-sizing: border-box;
                }

                .heading h1 {
                    font-weight: 600;
                }

                .heading p {
                    margin: 0;
                }

                .heading p a {
                    color: inherit;
                }



                h1 {
                    font-size: 28px;
                }

                .edit-wrapper {
                    display: flex;
                    flex-direction: column;
                }

                .avatar-section {
                    padding: 10px 0;
                    box-sizing: border-box;
                    border-top: 1px solid #e5e7eb;
                }

                .avatar-section h1 {
                    margin: 10px 0;
                    font-size: 20px;
                    font-weight: 500;
                }

                .avatar-images {
                    display: flex;
                    align-items: center;
                    justify-content: flex-start;
                    gap: 10px
                }

                .avatar-img {
                    max-width: 100px;
                    max-height: 100px;
                    border-radius: 25px;
                    cursor: pointer;
                    border: 3px solid transparent;
                    transition: border 0.4s ease;
                }

                .avatar-img:hover {
                    border: 3px solid #e5e7eb;
                }


                .update-username {
                    display: flex;
                    flex-direction: column;
                    align-items: flex-start;
                    justify-content: flex-start;
                    gap: 10px;
                    padding: 10px 0 20px 0;
                    box-sizing: border-box;
                }

                .edit-wrapper {
                    padding: 20px;
                    box-sizing: border-box;
                    border: 1px solid #e5e7eb;
                    border-radius: 15px;
                    position: relative;
                }

                .exit-btn {
                    position: absolute;
                    top: 15px;
                    right: 15px;
                }

                .exit-btn a {
                    color: inherit;
                }

                #newUsername{
                    outline: none;
                    border: 1px solid #e5e7eb;
                    border-radius: 5px;
                }
            </style>
        </head>

        <body>
            <div class="edit-wrapper">

                <div class="heading"> <!-- Link back to the profile page -->
                    <h1>Edit Profile</h1>
                </div>
                <div class="exit-btn"><a href="/profile">Back to profile</a></div>

                <!-- Text box for new username entry -->
                <div>
                    <form action="/profile/update" method="post" class="update-username">
                        <label for="newUsername">Enter a new username:</label>
                        <input type="text" id="newUsername" name="newUsername" value="${user.username}" required />
                        <button type="submit"> Update Profile </button> 
                    </form>
                    <!-- Displays error message -->
                    <c:if test="${not empty errorMessage}">
                        <div class="alert alert-danger" role="alert">${errorMessage}</div>
                    </c:if>
                </div>




                <!-- Display avatar images -->
                <div class="avatar-section">
                    <div style="margin: 10px 0;">
                        <h1>Choose a new avatar:</h1>
                        <text>Click on an avatar to update your profile.</text>
                    </div>

                    <div class="avatar-images">
                        <c:forEach var="avatarUrl" items="${avatarUrls}">
                            <img src="${avatarUrl}" alt="Avatar" class="avatar-img"
                                onclick="changeAvatar('${avatarUrl}')" href="/profile">
                        </c:forEach>
                    </div>

                </div>

            </div>

            <script>
                function changeAvatar(avatarUrl) {
                    // Make an AJAX request to changeUserAvatar endpoint
                    avatarUrl = encodeURIComponent(avatarUrl);
                    fetch("/changeUserAvatar?avatarUrl=" + avatarUrl, {
                        method: 'GET',
                        credentials: 'same-origin' // Include cookies in the request
                    })
                        .then(response => {
                            if (response.ok) {
                                // Handle successful response
                                console.log('Avatar changed successfully');
                                setTimeout(function () {
                                    // Redirect to "/profile" URL
                                    window.location.href = "/profile";
                                }, 500);
                                // Optionally, update UI to reflect the change
                            } else {
                                // Handle error response
                                console.error('Failed to change avatar');
                            }
                        })
                        .catch(error => {
                            // Handle fetch error
                            console.error('Error:', error);
                        });
                }
            </script>


        </body>

        </html>
