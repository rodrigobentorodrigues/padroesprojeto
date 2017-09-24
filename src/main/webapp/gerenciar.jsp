<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de Edicao</title>
    </head>
    <body>
        <table style="border: 1px solid black;">
            <tr>
                <td><b>Nome</b></td>
                <td><b>Email</b></td>
                <td><b>Matricula</b></td>
                <td><b>Papel</b></td>       
            </tr>
            <c:forEach var="usuario" items="${usuarios}">
                <tr>
                    <td>${usuario.nome}</td>
                    <td>${usuario.email}</td>
                    <td>${usuario.matricula}</td>
                    <td>${usuario.papel}</td>
                <form action="frontController" method="POST">
                    <input type="hidden" name="comando" value="Editar"/>
                    <input type="hidden" name="id" value="${usuario.id}"/>
                    <td><input type="submit" value="Editar"/></td>
                </form>
            </tr>
        </c:forEach>
    </table>
</body>
</html>