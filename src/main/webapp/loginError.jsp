<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Login failed</title>
  </head>
  <body>
    <p style="color: red;">${requiresLoginRedirect
       ? "Request requires login" : "Invalid or missing username"}</p>
    <form action="login" method="post">
      <fieldset>
        <legend>Login</legend>
        <p>Name: <input type="text" name="username"/></p>
        <p><input type="submit" value="Log in"/></p>
      </fieldset>
    </form>
  </body>
</html>