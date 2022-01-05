<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                var obj = new Object();
                obj.name = "여자친구"
                obj.members = ["소원", "예린", "은하", "유주", "신비", "엄지"];
                obj.albums = {"EP 1집": "Season of Glass", "EP 2집": "Flower Bud",
                              "EP 3집": "Snowflake",       "정규 1집": "LOL"};
 
                var obj_s = JSON.stringify(obj);
 
                $("#json_output").html(obj_s);
            });
        </script>
        <title>JSON Generate with jQuery</title>
    </head>
 
    <body>
        <pre id="json_output"></pre>
    </body>
</html>