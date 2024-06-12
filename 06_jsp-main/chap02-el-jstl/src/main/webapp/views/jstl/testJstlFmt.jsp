<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSTL FMT</title>
</head>
<body>
	<h1>JSTL FMT Library Tag Test</h1>
	
	<h2>fmt:formatNumber �±� - ���ڿ� ������ ����</h2>
	
	<c:set var="number" value="123456789"/>
	
	<fmt:formatNumber value="${ number }" groupingUsed="true"/><br>
	
	<fmt:formatNumber value="1.23456" pattern="#.###"/><br>
	<fmt:formatNumber value="1.2" pattern="#.##"/><br>
	<fmt:formatNumber value="1.2" pattern="#.00"/><br>
	
	<fmt:formatNumber value="0.12" type="percent"/><br>
	
	<fmt:formatNumber value="${ number }" type="currency"/><br>
	<fmt:formatNumber value="${ number }" type="currency" currencySymbol="$"/><br>
	
	<hr/>
	<h2>fmt:formatDate �±� - ��¥�� �ð��� ������ ����</h2>
	
	<c:set var="today" value="<%= new java.util.Date() %>"/>
	
	���� ��¥ : <fmt:formatDate value="${ today }" type="date"/><br> 
	���� �ð� : <fmt:formatDate value="${ today }" type="time"/><br>
	���� ��¥�� �ð� : <fmt:formatDate value="${ today }" type="both"/>
	
	<h3>��¥�� �ð��� �����Ǵ� ���� ����</h3>
	[default] <fmt:formatDate value="${ today }" type="both" dateStyle="default" timeStyle="default"/><br>
	[short] <fmt:formatDate value="${ today }" type="both" dateStyle="short" timeStyle="short"/><br>
	[medium] <fmt:formatDate value="${ today }" type="both" dateStyle="medium" timeStyle="medium"/><br>
	[long] <fmt:formatDate value="${ today }" type="both" dateStyle="long" timeStyle="long"/><br>
	[full] <fmt:formatDate value="${ today }" type="both" dateStyle="full" timeStyle="full"/><br>
	
	<h3> ���ϴ� �������� pattern �����ϱ�</h3>
	��¥ : <fmt:formatDate value="${ today }" type="date" pattern="yyyy/MM/dd (E)"/><br>
	�ð� : <fmt:formatDate value="${ today }" type="time" pattern="(a) hh:mm:ss"/><br>
	
</body>
</html>