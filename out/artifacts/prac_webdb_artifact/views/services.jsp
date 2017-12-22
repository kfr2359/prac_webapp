<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Услуги</title>
</head>
<body>
    <a href="/">На главную</a>
    <br>
    Список услуг
    <br>
    <table border = "1" class="data">
        <tr>
            <td>Тип</td>
            <td>ФИО клиента</td>
            <td>Стоимость</td>
            <td>Начало оказания услуги</td>
            <td>Конец оказания услуги</td>
        </tr>
        <c:forEach items="${servicesList}" var="service">
            <tr>
                <td>${service.getType().getName()}</td>
                <td>${service.getClient().getName()}</td>
                <td>${service.getCost()}</td>
                <td><fmt:formatDate value="${service.getStartDate()}" pattern="dd.MM.YYYY" /></td>
                <td><fmt:formatDate value="${service.getEndDate()}" pattern="dd.MM.YYYY" /></td>
                <td><a href="/service_show?id=${service.getId()}">Редактировать</a></td>
                <td><a href="/service_delete?id=${service.getId()}">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="/service_add">Зарегистрировать услугу</a>
</body>
</html>
