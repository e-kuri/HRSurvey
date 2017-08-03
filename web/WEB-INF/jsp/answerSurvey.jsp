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
        <script>
            $(document).ready(function(){
                var wdth = $('#surveyForm').width() / 10;
                
                $(".rate").rateYo({
                    starWidth: wdth + "px"
                });
                
                $("#comments").width(wdth*5);
            });
        </script>
        <title>Answer Survey</title>
    </head>
    <body>
        <div class="container">
        <h1 class="page-header"> Please rate the following aspects during your communication with ${survey.evaluated.firstName} ${survey.evaluated.lastName}</h1>
     
        <form id="surveyForm" class = "form-horizontal" role = "form" onsubmit="saveSurvey()" method="get" style="margin: 5rem">

            <c:forEach items="${survey.grades}" var="grade">
                <div class="form-group row">
                    <h4><label for="grade_${grade.catGrade.id}">${grade.catGrade.description}</label></h4>
                    <div class="col-10 rate" id="grade_${grade.catGrade.id}" data-rateyo-rating="${rating}" ></div>
                </div>
            </c:forEach>
            <div class="form-group">
                <h4><label for="comments">Comments</label></h4><br>
                <textarea id="comments" name="comments" rows="6"></textarea>
            </div>
            <button type="button" class="btn-primary btn-lg">Send</button>
        </form>
        </div>
    </body>
</html>
