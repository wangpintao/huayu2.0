<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <script type="text/javascript">
        function showtr(tr_id) {
            var tr1=document.getElementById(tr_id);
            if(tr1.style.display==='none'){
                tr1.style.display='block';
            }else{
                tr1.style.display='none';
            }
        }
        <!--异步-->
        var a = function(){
            var t =document.getElementsByName("sid");
            for(var i=0;i<t.length;i++){
                t[i].checked = "checked";
            }
        }
        var b =function(){
            var g =document.getElementsByName("sid");
            for(var i=0;i<g.length;i++){
                if(g[i].checked){
                    g[i].checked ="";
                }else{
                    g[i].checked ="checked";
                }
            }
        }
        function dele(sid) {
            var myform = document.getElementById(sid);
            myform.submit();
        }
    </script>
</head>
<body align="center">

<a href="<%=request.getContextPath()%>/toadd.do">添加</a>
<a href="user/studentAction_getgrade">班级页面</a>
<form action="user/studentAction_getlist" method="post" >
    <!--模糊查询-->
</form>
<form action="wholedelete.do" method="post">
<table border="2" align="center">
    <tr>
        <th>
            <input type ="button" onclick ="a()" value = "选中">
            <input type ="button" onclick ="b()" value = "反选">
            <input type="submit" value="删除">
        </th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>班级</th>
        <th>角色</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${list}" var="i" varStatus="in">

        <tr>
            <td>
                <input type ="checkbox" value=${i.sid} name="sid" >
            </td>
            <td><a href="#" onclick="showtr(${in.index+1})">${i.stuname}</a></td>
            <td>${i.sex}</td>
            <td>${i.age}</td>
            <td>${i.gd.ganme}</td>
            <th><c:forEach items="${i.rolelist}" var="role">
                ${role.rolename}
            </c:forEach></th>
            <td>
                <form action="/${i.sid}.do" method="post" id="del_${in.index+1}">
                    <input type="hidden" name="_method" value="DELETE">
                    <a onclick="dele('del_${in.index+1}')">[删除]</a>&nbsp;&nbsp;
                    <a href="<%=request.getContextPath()%>/toupdate.do?sid=${i.sid}">[修改]</a>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</form>
<a href="/maven_730_war/user/studentAction_getlist?currentpage=1">首页</a>
<c:if test="${currentpage>1}">
    <a href="/maven_730_war/user/studentAction_getlist?currentpage=${currentpage-1}">上一页</a>
</c:if>
第${currentpage}页&nbsp;&nbsp;
<c:if test="${currentpage!=altogether}">
    <a href="/maven_730_war/user/studentAction_getlist?currentpage=${currentpage+1}">下一页</a>
</c:if>
<a href="/maven_730_war/user/studentAction_getlist?currentpage=${currentpage=altogether}">尾页</a>
共${altogether}页
</body>
</html>
