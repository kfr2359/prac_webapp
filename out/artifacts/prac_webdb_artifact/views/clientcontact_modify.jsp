<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Редактировать контактное лицо клиента</title>
</head>
<body>
    <c:if test="${!empty clientContact}">
        <a href="/clientcontact_show?id=${clientContact.getId()}">Назад</a>
        <form:form method = "post" action = "/modifyClientContact?id=${clientContact.getId()}" modelAttribute="clientContact">
            <table border = "1" class = "data">
                <tr>
                    <td><form:label path="name">ФИО</form:label></td>
                    <td><form:input path="name" value="${clientContact.getName()}" /></td>
                </tr>
                <tr>
                    <td><form:label path="address">Адрес</form:label></td>
                    <td><form:input path="address" value="${clientContact.getAddress()}" /></td>
                </tr>
                <tr>
                    <td><input type = "submit" value = "Сохранить"></td>
                </tr>
            </table>
        </form:form>
    </c:if>
</body>
</html>
