<%--
  Created by IntelliJ IDEA.
  User: wpt
  Date: 2019/7/11
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<script type="text/javascript">
    var indexnum = 0
    <!--动态添加行数-->
   function add() {
      var netr = document.getElementById("tbody");
      var netd = netr.insertRow(netr.rows.length);
       for (var i=0;i<4;i++){
           var newtd = netd.insertCell(i)
           if(i == 0){
               newtd.innerHTML = "<input type='text' name='workList["+indexnum+"].wname'>"
           }else if(i == 1){
               newtd.innerHTML = "<input type='text' name='workList["+indexnum+"].newtdtime'>"
           }else if(i == 2){
               newtd.innerHTML = "<input type='text' name='workList["+indexnum+"].timetime'>"
           }else if(i == 3){
               newtd.innerHTML = "<input type='text' name='workList["+indexnum+"].duty'>"
           }
       }
       indexnum+1
   }
   <!--动态删除行数-->
   function subtract() {
       var netr = document.getElementById("tbody");
       var tr=netr.rows.length-1;
       if(tr>1){
           netr.deleteRow(tr);
       }else{
           alert("不能再删了");
       }
   }
    <!--判断用户名是否存在或有值-->

</script>
<head>
    <title>Title</title>
</head>
<body align="center">
<c:forEach var="error" items="${erros}">
    ${error.defaultMessage}
</c:forEach>
<form action="<%=request.getContextPath()%>/add.do" method="post">
    名字：<input type = "text" name= "stuname" id="sname"><br>
    性别：
    男   <input type = "radio" value="男" name = "sex">
    女   <input type = "radio" value="女" name = "sex"><br>
    邮箱：<input type="text" name="mailbox"><br>
    年龄：<input type = "text" name="age"><br>
    年级：<select  name ="gid"><br>
    <c:forEach  var="s" items="${gradeList}">
        <option value="${s.gid}">${s.ganme}</option>
    </c:forEach>
          </select><br>
    <c:forEach items="${rolelist}" var="r" varStatus="c">
        ${r.rolename}<input type="checkbox" value="${r.rid}">
    </c:forEach><br>
    <a href="#" onclick="add()">添加工作经历</a>
    <a href="#" onclick="subtract()">删除工作经历</a>
    <table border="1" id="tbody" align="center">
        <tr>
            <td>公司名称</td>
            <td>入职时间</td>
            <td>离职时间</td>
            <td>就业职位</td>
        </tr>
    </table>
    <input type ="submit" value = "添加">
</form>
</body>
</html>
