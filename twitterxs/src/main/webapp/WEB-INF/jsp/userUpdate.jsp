<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title><spring:message code="user.update.title" /></title>
</head>
<body>
	<section>
		<h1>
			<spring:message code="user.update.title" />
		</h1>
		
		<form:form action="save" method="POST" modelAttribute="user">
		<form:hidden path="id"/>
			<div>
				<form:label path="firstname"><spring:message code="user.update.firstname" /></form:label>
				<form:input path="firstname" maxlength="100" autocomplete="off" />
				<form:errors element="span" path="firstname" />
			</div>
			<div>
				<form:label path="lastname"><spring:message code="user.update.lastname" /></form:label>
				<form:input path="lastname" maxlength="100" autocomplete="off" />
				<form:errors element="span" path="lastname" />
			</div>
			<div>
				<form:label path="email"><spring:message code="user.update.email" /></form:label>
				<form:input path="email" maxlength="255" autocomplete="off" />
				<spring:hasBindErrors name="user">
		            <c:forEach items="${errors.globalErrors}" var="globalError">
		            	<c:if test="${globalError.code eq 'UniqueUpdateEmail'}">
		                	<span><c:out value="${globalError.defaultMessage}" /></span>
		                </c:if>
		            </c:forEach>
		    	</spring:hasBindErrors>
			</div>
			<div>
				<form:label path="birthDate"><spring:message code="user.update.birthDate" /></form:label>
				<form:input path="birthDate" maxlength="10" autocomplete="off" />
				<form:errors element="span" path="birthDate" />
			</div>
			<div>
				<form:label path="regionId"><spring:message code="user.update.region" /></form:label>
				<form:select path="regionId">
					<form:options items="${regions}" itemValue="value" itemLabel="label" />
				</form:select>
				<form:errors element="span" path="regionId" />
			</div>
			<form:button><spring:message code="user.update.save" /></form:button>
		</form:form>

	</section>
</body>
</html>