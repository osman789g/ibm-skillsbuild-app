<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add review</title>
        <style>
            h1{
                text-align: center;
                color: grey
            }
    
            body{
                justify-content: center;
                align-items: center;
                align-content: center;
                text-align: center;
                
                padding-top: 40px;
                padding-bottom: 40px;
                font-family: 'Inter', sans-serif;
            }

            

            .container {
                display: flex;
                justify-content: center;
                align-items: flex-start;
                height: 100vh;
                padding-top: 40px;
                padding-bottom: 40px;
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
        <div>
            <h1> Here you can fill out your review form:</h1>
            <form:form action="/addReview?course=${coursename}" modelAttribute="review">
            <br/>
            <form:label path="comment">Add your comment:</form:label>
            <form:input path="comment"/>
            <br/>
            Add your rating(highest = 5):
            <form:select path="rating">
                <option value=1>1 - One</option>
                <option value=2>2 - Two</option>
                <option value=3>3 - Three</option>
                <option value=4>4 - Four</option>
                <option value=5>5 - Five</option>
            </form:select>
            <br/>
            <input type="submit"/>
            </form:form>
            <br/>
                <a href="courseAttempts"><button> Back</button></a>
        </div>
    </body>
</html>
