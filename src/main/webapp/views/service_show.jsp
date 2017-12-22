<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <title>Услуга</title>
</head>
<body>
    <a href="services">Назад</a>
        <form:form method = "post" action = "modifyService?id=${service.getId()}" modelAttribute="service">
            <table border = "1" class = "data">
                <tr>
                    <td><form:label path="type">Тип услуги</form:label></td>
                    <td><form:select path="type" items="${typeList}" itemValue="id" itemLabel="name"/></td>
                </tr>
                <tr>
                    <td><form:label path="client">Клиент</form:label></td>
                    <td><form:select path="client" items="${clientList}" itemValue="id" itemLabel="name"/></td>
                </tr>
                <tr>
                    <td><form:label path="cost">Стоимость</form:label></td>
                    <td><form:input path="cost" value="${service.getCost()}" /></td>
                </tr>
                <tr>
                    <td><form:label path="startDate">Дата начала</form:label></td>
                    <fmt:formatDate value="${service.getStartDate()}" var="startDateStr" pattern="dd.MM.yyyy" />
                    <td><form:input path="startDate" value="${startDateStr}" /></td>
                </tr>
                <tr>
                    <td><form:label path="endDate">Дата конца</form:label></td>
                    <fmt:formatDate value="${service.getEndDate()}" var="endDateStr" pattern="dd.MM.yyyy" />
                    <td><form:input path="endDate" value="${endDateStr}" /></td>
                </tr>
                <tr>
                    <td><form:label path="employees">Задействованные сотрудники</form:label></td>
                    <td><form:checkboxes path="employees" items="${employeeList}" itemValue="id" itemLabel="name" delimiter="<br>"/></td>
                </tr>
            </table>
            <input type="submit" value="Сохранить" />
        </form:form>
    <br>
</body>
</html>
