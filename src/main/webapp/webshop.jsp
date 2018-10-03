<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Webshop</title>
    </head>
    <body>
        <p>Du er innlogget som ${username}</p>
        <p>Din handlekurc:<br/></p>
        <table border="1">
            <tr>
                <th>Vare</th>
                <th>Pris</th>
            </tr>
            <c:forEach items="${cart}" var="item">
                <tr>
                <td><c:out value="${item.name}" /></td>
                <td align="right"><c:out value="${item.price}"/></td>
                </tr>
            </c:forEach>
        </table><br/>
        <form action="webshop" method="POST">
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