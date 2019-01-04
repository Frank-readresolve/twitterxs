<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title><spring:message code="tweet.create.title" /></title>
</head>
<body>
	<section>
		<h1>
			<spring:message code="tweet.create.title" />
		</h1>
		
		
		<form:form action="save" method="POST" modelAttribute="tweet">
			<input type="hidden" name="authorId" value="15" />
			<form:label path="content"><spring:message code="tweet.create.content" /></form:label>
			<form:textarea path="content" rows="5" /><form:errors element="div" path="content" />
			<form:button><spring:message code="tweet.create.save" /></form:button>
		</form:form>

	</section>
</body>
</html>