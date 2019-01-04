<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title><spring:message code="feed.title" /></title>
</head>
<body>
	<section>
		<h1>
			<spring:message code="feed.title" />
		</h1>
		<c:forEach items="${tweets.items}" var="tweet">
			<div>
				<h2>
					<spring:message code="feed.tweet.id" />: ${tweet.tweetId}, <spring:message code="feed.tweet.postDate" />: ${tweet.postDate}
				</h2>
				<p>${tweet.content}</p>
			</div>
		</c:forEach>
	</section>
</body>
</html>