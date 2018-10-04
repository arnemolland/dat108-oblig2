<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
  </head>
  <body>
    <c:choose>
      <c:when test="${requiresLoginRedirect == true || invalidUsernameRedirect == true}">
          <p style="color: red;">${requiresLoginRedirect
              ? "Request requires login" : "Invalid or missing username"}</p>
      </c:when>
    </c:choose>
    <form action="login" method="post">
      <fieldset>
        <legend>Login</legend>
        <p>Name: <input type="text" name="username"/></p>
        <p><input type="submit" value="Log in"/></p>
      </fieldset>
    </form>
  </body>
</html>