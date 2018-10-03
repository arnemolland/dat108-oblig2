<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login failed</title>
  </head>
  <body>
    <div style="text-align: center; margin: 0 auto;">
        <p>Webshop</p>
        <p style="color: red">Wrong username, try again</p> 

        <form method="post" action="hello">  
        <h2>Username:</h2>
        <input type="text" id="say-hello-text-input" name="Username" />
        <input type="submit" id="say-hello-button" value="Login" />
        </form>
    </div>
  </body>
</html>