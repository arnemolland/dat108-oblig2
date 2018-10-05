<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Todo-app</title>
    </head>
    <body>
        <p>Du er innlogget som ${password}</p>
        <p>Your Todo-items<br/></p>
        <table border="1">
            <tr>
                <th>Vare</th>
                <th>Pris</th>
            </tr>
            <c:forEach items="${todoItems}" var="item">
                <tr>
                <td>${item.name}</td>
                </tr>
            </c:forEach>
        </table><br/>
        <form action="todoapp" method="POST">
            <fieldset>
                <legend>Handle</legend>
                <input type="checkbox" name="bukse"/>Bukse<br/>
                <input type="checkbox" name="genser"/>Genser<br/>
                <p>
                    <input type="submit" value="Legg i handlekurv"/>
                </p>
            </fieldset>
        </form>
        <form action="logout" method="GET">
            <fieldset>
                <p>
                    <input type="submit" value="Log out"/>
                </p>
            </fieldset>
        </form>
    </body>
</html>