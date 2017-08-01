<%-- 
    Document   : answerSurvey
    Created on : Jul 31, 2017, 4:09:31 PM
    Author     : H255735
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href='../resources/bootstrap-3.3.7-dist/css/bootstrap.min.css'/>
        <link rel="stylesheet" href="../resources/css/jquery-ui.css"/>
        <script src="../resources/js/jquery-3.2.1.min.js" ></script>
        <script src='../resources/bootstrap-3.3.7-dist/js/bootstrap.min.js'></script>
        <script src="../resources/js/jquery-ui.js"></script>
        <script src="../resources/js/jquery.rateyo.min.js"></script>
        <link rel="stylesheet" href="../resources/css/jquery.rateyo.min.css"/>
        <title>Answer Survey</title>
    </head>
    <body>
        <div class="container">
            <h1 class="page-header">Send New Survey</h1>
            <form class = "form-horizontal" role = "form" onsubmit="saveSurvey()" method="get">
                <c:set var="i" value="0"/>
                <c:forEach items="${categories}" var="cat">
                    <label for="grade">${cat.catGrade.category}</label>
                    <div class="jq-ry-group-wrapper">
                    </div>
                    <c:set var="i" value="${i+1}"/>
                </c:forEach>
            </form>
        </div>
    </body>
</html>
