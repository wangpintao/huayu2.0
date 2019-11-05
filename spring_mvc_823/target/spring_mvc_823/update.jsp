<%--
  Created by IntelliJ IDEA.
  User: wpt
  Date: 2019/7/11
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/add.do" method="post">
    <input type="hidden" name="_method" value="put">
    学号:<input type="hidden" name="sid" value="${stu.sid}" ><br>
    姓名:<input type="text" name="stuname"  value="${stu.stuname}"  ><br>
    性别:男.<input type="radio"  name="sex" value="男" ${stu.sex=='男'?'checked':''} >
    女.<input type="radio" name="sex" value="女" ${stu.sex=='女'?'checked':''}><br>
    年龄:<input type="text" name="age"  value="${stu.age}"  ><br>
    年级：<select  name ="gid"><br>
    <c:forEach  var="s" items="${gradeList}">
        <option value="${s.gid}">${s.ganme}</option>
    </c:forEach>
          </select><br>
    <c:forEach items="${rolelist}" var="r" varStatus="c">
        ${r.rolename}<input type="checkbox" value="${r.rid}" name="roleid">
    </c:forEach><br>
    <input type="submit" value="确定修改">
</form>
</body>
</html>
