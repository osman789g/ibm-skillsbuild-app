<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <style>

        h1{text-align: center;color: grey}

        table {border-radius: 10px;
            border: 1px solid;
            width: 95%;}

        th,
        td {box-sizing: content-box;
            text-align: left;
            border: none;
            padding: 5px;}

        th {background-color: darkgrey;}
        tr {border: 2px solid}
    </style>
</head>

<h1>Review Section</h1>
<br/>
<br/>

<table>
    <tr>
        <th> Course name</th>
        <th> Comment </th>
        <th> Rating </th>
    </tr>
<c:forEach items="${reviews}" var="review">
    <tr>
        <td>${review.coursenames}</td>
        <td>${review.comment}</td>
        <td>${review.rating}</td>

    </tr>

</c:forEach>
</table>


<a href="/"><button>Back</button></a>
</html>