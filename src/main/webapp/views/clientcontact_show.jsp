<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Контактное лицо клиента</title>
</head>
<body>
    <c:if test="${!empty clientContact}">
        <a href="client_show?id=${clientContact.getClient().getId()}">Назад</a>
        <table border = "1" class = "data">
            <tr>
                <td>ФИО</td>
                <td>${clientContact.getName()}</td>
            </tr>
            <tr>
                <td>Адрес</td>
                <td>${clientContact.getAddress()}</td>
            </tr>
            <tr><td><a href="clientcontact_modify?id=${clientContact.getId()}">Редактировать</a></td></tr>
        </table>
        <br>
        <table class = "data">
            <tr valign = "top">
                <td>
                    <table border = "1" class = "data">
                        <tr><td>Список email'ов</td></tr>
                        <c:forEach items="${emailList}" var="email">
                            <tr>
                                <c:url var="modifyUrl" value="modify_cc_email?id=${email.getId()}"/>
                                <c:url var="deleteUrl" value="delete_cc_email?id=${email.getId()}"/>
                                <form:form method="post" action="${modifyUrl}" modelAttribute="ccEmail">
                                    <td><form:input path="email" value="${email.getEmail()}" /></td>
                                    <td><input type = "submit" value = "Сохранить"/></td>
                                </form:form>
                                <td><a href="${deleteUrl}">Удалить</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
                <td>
                    <table border = "1" class = "data">
                        <tr><td>Список телефонов</td></tr>
                        <c:forEach items="${phoneList}" var="phone">
                            <tr>
                                <c:url var="modifyUrl" value="modify_cc_phone?id=${phone.getId()}"/>
                                <c:url var="deleteUrl" value="delete_cc_phone?id=${phone.getId()}"/>
                                <form:form method="post" action="${modifyUrl}" modelAttribute="ccPhone">
                                    <td><form:input path="phone" value="${phone.getPhone()}" /></td>
                                    <td><input type = "submit" value = "Сохранить"/></td>
                                </form:form>
                                <td><a href="${deleteUrl}">Удалить</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
        </table>
        <br>
        <a href = "clientcontactlink_add?id=${clientContact.getId()}">Добавить контактные данные</a>
    </c:if>
</body>
</html>
