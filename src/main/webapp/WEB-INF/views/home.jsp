<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">
<title>Home</title>
</head>
<body>
	<div align="center">
		<h1>Hello world!</h1>

		<P>The time on the server is ${serverTime}.</P>

		<p style="color: red; display: none" id="message"></p>
		<form action="save" method="post" onsubmit="return submivalidate()">
			姓名：<input type="text" id="name" name="name" onkeyup="value=value.replace(/[\d]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[\d]/g,''))" />
			年龄：<input type="text" id="age" name="age" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"  />
			<input type="submit" />
			<input type="reset" />
		</form>
		<script type="text/javascript">
			function submivalidate() {
				var name = document.getElementById("name").value;
				var age = document.getElementById("age").value;
				var message = document.getElementById("message");
				if (name == '' || name == null) {
					message.innerText = "名字不能为空！";
					message.style.display = "block";
					return false;
				}
				if (age == '' || age == null) {
					message.innerText = "年龄不能为空！";
					message.style.display = "block";
					return false;
				}
				return true;
			}
		</script>
		<table border="1" width="50%">
			<thead><td>姓名</td><td>年龄</td><td>操作</td></thead>
			<tbody>
			<c:forEach items="${studentList}" var="student">
				<tr>
					<td>${student.name}</td>
					<td>${student.age}</td>
					<td><a href="<%=basePath%>/delete?id=${student.id}">删除</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
