<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title><spring:message code="user.create.title" /></title>
</head>
<body>
	<section>
		<h1>
			<spring:message code="user.create.title" />
		</h1>
		<form:form action="save" method="POST" modelAttribute="user">
			<div>
				<form:label path="firstname"><spring:message code="user.create.firstname" /></form:label>
				<form:input path="firstname" maxlength="100" autocomplete="off" />
				<form:errors element="span" path="firstname" />
			</div>
			<div>
				<form:label path="lastname"><spring:message code="user.create.lastname" /></form:label>
				<form:input path="lastname" maxlength="100" autocomplete="off" />
				<form:errors element="span" path="lastname" />
			</div>
			<div>
				<form:label path="email"><spring:message code="user.create.email" /></form:label>
				<form:input path="email" maxlength="255" autocomplete="off" />
				<form:errors element="span" path="email" />
			</div>
			<div>
				<form:label path="birthDate"><spring:message code="user.create.birthDate" /></form:label>
				<form:input path="birthDate" maxlength="10" autocomplete="off" />
				<form:errors element="span" path="birthDate" />
			</div>
			<div>
				<form:label path="regionId"><spring:message code="user.create.region" /></form:label>
				<form:select path="regionId">
					<form:option value=""><spring:message code="user.create.region.choose" /></form:option>
					<form:options items="${regions}" itemValue="value" itemLabel="label" />
				</form:select>
				<form:errors element="span" path="regionId" />
			</div>
			<div>
				<form:label path="security.username"><spring:message code="user.create.security.username" /></form:label>
				<form:input path="security.username" maxlength="50" autocomplete="off" />
				<form:errors element="span" path="security.username" />
			</div>
			<div>
				<form:label path="security.password"><spring:message code="user.create.security.password" /></form:label>
				<form:password path="security.password" maxlength="10" autocomplete="off" />
				<form:errors element="span" path="security.password" />
			</div>
			<form:button><spring:message code="user.create.save" /></form:button>
		</form:form>

	</section>
</body>
</html>