<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
  </head>
  <body>
    <c:choose>
      <c:when test="${requiresLoginRedirect == true || invalidPasswordRedirect == true}">
          <p style="color: red;">${requiresPasswordRedirect
              ? "Request requires login" : "Invalid or missing password"}</p>
      </c:when>
    </c:choose>
    <form action="login" method="post">
      <fieldset>
        <legend>Login</legend>
        <p>Name: <input type="text" name="password"/></p>
        <p><input type="submit" value="Log in"/></p>
      </fieldset>
    </form>
  </body>
</html>