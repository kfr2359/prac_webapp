<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Клиент</title>
</head>
<body>
    <a href="/clients">Назад</a>
    <table border = "1" class = "data">
        <tr>
            <form:form method = "post" action = "/modifyClient?id=${client.getId()}" modelAttribute="client">
                <td><form:label path="name">ФИО</form:label></td>
                <td><form:input path="name" value="${client.getName()}" /></td>
                <td><input type="submit" value="Сохранить"/></td>
            </form:form>
        </tr>
    </table>
    <br>
    Список контактных лиц
    <table border = "1" class = "data">
        <c:forEach items="${clientContactList}" var="clientContact">
            <tr>
                <td>
                    <c:url var="showUrl" value="/clientcontact_show?id=${clientContact.getId()}" />
                    <a href="${showUrl}">${clientContact.getName()}</a>
                </td>
                <td><a href="/clientcontact_delete?id=${clientContact.getId()}">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="/clientcontact_add?id=${client.getId()}">Добавить контактное лицо</a>
</body>
</html>
