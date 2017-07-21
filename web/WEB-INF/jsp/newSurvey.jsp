<%-- 
    Document   : newSurvey
    Created on : Jul 20, 2017, 2:07:15 PM
    Author     : H255735
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>New Survey</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" href='../resources/bootstrap-3.3.7-dist/css/bootstrap.min.css'/>
        <script src="../resources/js/jquery-3.2.1.min.js" ></script>
        <script src='../resources/bootstrap-3.3.7-dist/js/bootstrap.min.js'></script>
        <script>
            $(document).ready(function(){
                alert('jquery working');
            });
            
            function createSurvey(){
                alert('createSurvey');
                $.ajax({
                   url: "create.do" 
                }).done(function(){
                    alert('success!');
                }).fail(function(){
                    alert('error');
                });
            }
        </script>
        <meta name = "viewport" content = "width = device-width, initial-scale = 1.0">
    </head>
    <body>
        <div class="container">
            <h1 class="page-header">Send New Survey</h1>
            <form class = "form-horizontal" role = "form" onsubmit="createSurvey()" method="get">
                
                <div class="form-group">
                    <label for="Email.body" class='col-sm-2 control-label'>Email body</label>
                    <div class="col-sm-10">
                        <textarea class='form-control' rows="6"></textarea>
                    </div>
                </div>
                
                <div class = "form-group">
                   <label for = "Employee.email" class = "col-sm-2 control-label">Employee's email</label>

                   <div class = "col-sm-10">
                      <input type = "text" class = "form-control" id = "firstname" placeholder = "Enter employee's email">
                   </div>
                </div>

                <div class = "form-group">
                   <div class = "col-sm-offset-2 col-sm-10">
                      <button type = "submit" class = "btn btn-default">Send</button>
                   </div>
                </div>

             </form>
        </div>
    </body>
</html>
