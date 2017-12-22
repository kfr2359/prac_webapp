<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Клиенты</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/">На главную</a>
    <br>
    Список клиентов
    <br>
    <table border = "1" class = "data">
        <tr>
            <td>ФИО</td>
        </tr>
        <c:if test="${!empty clientList}">
            <c:forEach items="${clientList}" var="client">
                <c:url var="showUrl" value="client_show?id=${client.id}" />
                <c:url var="deleteUrl" value="client_delete?id=${client.id}" />
                <tr>
                    <td><a href="${showUrl}">${client.getName()}</a></td>
                    <td><a href="${deleteUrl}">Удалить</a> </td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <a href="client_add">Добавить клиента</a>
    <br>
    <br>
    Фильтр
    <br>
    <form:form modelAttribute="clientFilter" method="post" action="filterClients">
        Задействованные работники
        <br>
        <table class="data" border="1">
            <c:forEach items="${employees}" var="employee">
                <tr><td><form:checkbox path="employeesId" value="${employee.id}" label="${employee.name}" /></td></tr>
            </c:forEach>
        </table>
        Использованные услуги
        <br>
        <table class="data" border="1">
            <c:forEach items="${serviceTypes}" var="serviceType">
                <tr><td><form:checkbox path="serviceTypesId" value="${serviceType.id}" label="${serviceType.name}" /></td></tr>
            </c:forEach>
        </table>
        <table class="data">
            <tr>
                <td>Дата начала</td>
                <td><form:input path="startDate" /></td>
            </tr>
            <tr>
                <td>Дата конца</td>
                <td><form:input path="endDate" /></td>
            </tr>
        </table>
        <br>
        <input type="submit" value="Применить" />
    </form:form>
    <br>
</body>
</html>
