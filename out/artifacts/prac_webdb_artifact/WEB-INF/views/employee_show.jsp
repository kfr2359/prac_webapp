<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Сотрудник</title>
</head>
<body>
    <a href="/employees">Назад</a>
        <form:form method = "post" action = "/modifyEmployee?id=${employee.getId()}" modelAttribute="employee">
            <table border = "1" class = "data">
                <tr>
                    <td><form:label path="name">ФИО</form:label></td>
                    <td><form:input path="name" value="${employee.getName()}" /></td>
                </tr>
                <tr>
                    <td><form:label path="address">Адрес</form:label></td>
                    <td><form:input path="address" value="${employee.getAddress()}" /></td>
                </tr>
                <tr>
                    <td><form:label path="education">Образование</form:label></td>
                    <td><form:input path="education" value="${employee.getEducation()}" /></td>
                </tr>
                <tr>
                    <td><form:label path="job">Должность</form:label></td>
                    <td><form:select path="job" items="${jobList}" itemValue="id" itemLabel="name"/></td>
                </tr>
            </table>
            <input type="submit" value="Сохранить" />
        </form:form>
    <br>
    <table class = "data">
        <tr valign = "top">
            <td>
                <table border = "1" class = "data">
                    <tr><td>Список email'ов</td></tr>
                    <c:forEach items="${emailList}" var="email">
                        <tr>
                            <c:url var="modifyUrl" value="/modify_e_email?id=${email.getId()}"/>
                            <c:url var="deleteUrl" value="/delete_e_email?id=${email.getId()}"/>
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
                            <c:url var="modifyUrl" value="/modify_e_phone?id=${phone.getId()}"/>
                            <c:url var="deleteUrl" value="/delete_e_phone?id=${phone.getId()}"/>
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
    <a href = "/employeelink_add?id=${employee.getId()}">Добавить контактные данные</a>
</body>
</html>
