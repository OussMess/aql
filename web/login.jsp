

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page d'authentification</title>
    </head>
    <body>
    <center><h1><u>Page d'authentification</u></h1></center>
    <center>

        <form action="Login" method="POST">
            <table align="center">
                <tr>
                    <th align="right">Nom d'utilisateur:</th>
                    <td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <th align="right">Mot de passe:</th>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td colspan="2" align="right"><input type="submit" value="Connexion"/></td>
                </tr>
            </table>
        </form>

    </center>

</body>
</html>
