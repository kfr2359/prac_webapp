<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Добавить email</title>
</head>
<body>
    <c:if test="${!empty clientContact}">
        <a href="/clientcontact_show?id=${clientContact.getId()}">Назад</a>
        <br>
        <form:form method="post" action="/add_cc_email?id=${clientContact.getId()}" modelAttribute="ccEmail">
            <table border="1">
                <tr>
                    <td>Email:</td>
                    <td><form:input path="email" /></td>
                </tr>
                <tr><td><input type = "submit" value = "Добавить" /></td></tr>
            </table>
        </form:form>

        <br>
        <form:form method="post" action="/add_cc_phone?id=${clientContact.getId()}" modelAttribute="ccPhone">
            <table border="1">
                <tr>
                    <td>Телефон:</td>
                    <td><form:input path="phone" /></td>
                </tr>
                <tr><td><input type = "submit" value = "Добавить" /></td></tr>
            </table>
        </form:form>
    </c:if>
</body>
</html>
