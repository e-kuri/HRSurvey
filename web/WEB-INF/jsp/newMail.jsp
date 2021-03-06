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
        <link rel="stylesheet" href="../resources/css/jquery-ui.css"/>
        <script src="../resources/js/jquery-3.2.1.min.js" ></script>
        <script src='../resources/bootstrap-3.3.7-dist/js/bootstrap.min.js'></script>
        <script src="../resources/js/jquery-ui.js"></script>
        <script>
            
            function onEmployeeNumberChange(){
                if( $(this).val() == "H255735" ){
                    $("#name").val("Eugenio Kuri Sainz");
                    $("#email").val("Eugenio.Kuri@Honeywell.com");
                }else{
                    $("#name").val("");
                    $("#email").val("");
                } 
             }
            
            function createSurvey(){
                alert('createSurvey');
                $.ajax({
                   url: "create.do" 
                }).done(function(){
                    alert('success!');
                });
            }
            
            /*function(request, response){
                     $.ajax({
                        url: "../employee/emplist/" + request.term,
                        method: "GET",
                        dataType: "json",
                     }).done(function(data){
                         console.log(data);
                         var ids = [data.length];
                         for(var i=0; i<data.length; i++){
                             ids[i] = data[i]['employeeId'];
                         }
                         response(ids);
                     });
             */
            
            $(document).ready(function(){
                
                var papas = ["H255735"];
                
                $("#body").width($("#subject").width());
                
                $("#employeeNumber").autocomplete({
                    source: papas,
                   /* source: function(request, response){
                        $.ajax({
                           url: "../employee/emplist/" + request.term,
                           method: "GET",
                           dataType: "json",
                        }).done(function(data){
                            console.log(data);
                            var ids = [data.length];
                            for(var i=0; i<data.length; i++){
                                ids[i] = data[i]['employeeId'];
                            }
                            response(ids);
                        });
                    },*/
                   change: function(event, ui){
                       if( $(this).val() == "H255735" ){
                            $("#firstName").val("Eugenio");
                            $("#lastName").val("Kuri");
                            $("#email").val("Eugenio.Kuri@Honeywell.com");
                        }else{
                            $("#firstName").val("");
                            $("#emailBody").val("");
                        } 
                   },
                   delay: 500,
                   minLength: 3
                });
                
            });
            
        </script>
        <meta name = "viewport" content = "width = device-width, initial-scale = 1.0">
    </head>
    <body>
        <div class="container">
            <h1 class="page-header">Send New Survey</h1>
            <form class = "form-horizontal" role = "form" action="new.do" method="post">
                
                <div class="form-group">
                    <label for="employeeNumber" class = "col-sm-2 control-label">Employee Number</label>
                    <div class = "col-sm-10">
                      <input type = "text" class = "form-control" id = "employeeNumber" name="employeeNumber" placeholder = "Employee number">
                   </div>
                </div>
                
                <div class="form-group">
                    <label for="firstName" class = "col-sm-2 control-label">First Name</label>
                    <div class = "col-sm-10">
                      <input type = "text" class = "form-control" id = "firstName" name="firstName" placeholder = "Name" >
                   </div>
                </div>
                
                <div class="form-group">
                    <label for="lastName" class = "col-sm-2 control-label">Last Name</label>
                    <div class = "col-sm-10">
                      <input type = "text" class = "form-control" id = "lastName" name="lastName" placeholder = "Last Name" >
                   </div>
                </div>
                
                <div class = "form-group">
                   <label for = "email" class = "col-sm-2 control-label">Email</label>

                   <div class = "col-sm-10">
                      <input type = "text" class = "form-control" id = "email" name="email" placeholder = "Email">
                   </div>
                </div>
                
                <div class = "form-group">
                   <label for = "subject" class = "col-sm-2 control-label">Subject</label>

                   <div class = "col-sm-10">
                      <input type = "text" class = "form-control" id = "subject" name="subject" placeholder = "Subject">
                   </div>
                </div>
                
                <div class="form-group">
                    <label for="body" class = "col-sm-2 control-label">Body</label>
                    <div class = "col-sm-10">
                        <textarea id="body" name="body" rows="5"></textarea>
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
