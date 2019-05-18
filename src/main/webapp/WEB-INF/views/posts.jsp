<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="container-wrapper">
	<div class="container">
		<h2>All Posts</h2>
		<p>모든 일정을 확인하세요.</p>
		<table class="table table-striped">
			<thead>
				<tr class="bg-info" style="font-size:120%;">
					<th>Title</th>
					<th>Priority</th>
					<th>Deadline</th>
					<th>State</th>
					<th>Description</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="post" items="${posts}">
					<tr>
						<td>${post.title}</td>
						<td>${post.priority}</td>
						<td>${post.deadline}</td>
						
						<c:set var="states" value="${post.state}"/>
						
						<td style="font-weight: bold">
						<c:if test="${fn:startsWith(states,'미')}"><p style="color:red">미완료</p></c:if>
						<c:if test="${fn:startsWith(states,'완')}"><p style="color:blue">완료</p></c:if>
						<c:if test="${fn:startsWith(states,'진')}"><p style="color:#008000">진행 중</p></c:if>
						</td>
						
						<td>${post.description}</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
