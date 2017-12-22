<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Сотрудники</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/">На главную</a>
    <br>
    Список сотрудников
    <br>
    <table border = "1" class="data">
        <tr>
            <td>ФИО</td>
            <td>Адрес</td>
        </tr>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td><a href="employee_show?id=${employee.id}">${employee.getName()}</a></td>
                <td>${employee.getAddress()}</td>
                <td><a href="employee_delete?id=${employee.id}">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="employee_add">Добавить сотрудника</a>
    <br>
    <br>
    Фильтр
    <br>
    <form:form modelAttribute="employeeFilter" method="post" action="filterEmployees">
        Задействованные клиенты
        <br>
        <table class="data" border="1">
            <c:forEach items="${clients}" var="client">
                <tr><td><form:checkbox path="clientsId" value="${client.id}" label="${client.name}" /></td></tr>
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
