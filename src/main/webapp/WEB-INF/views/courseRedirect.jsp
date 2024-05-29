<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Redirecting...</title>
    <script type="text/javascript">
        var courseLink = "${courseLink}";
        window.location.href =  courseLink;
    </script>
</head>
<body>
If you are not redirected automatically, click <a href="<c:url value='/'/>${courseLink}">here</a>.
</body>
</html>
