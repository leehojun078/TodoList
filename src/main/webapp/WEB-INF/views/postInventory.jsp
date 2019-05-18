<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="container-wrapper">
	<div class="container">
		<h2>Posts Inventory</h2>
		<p>To do list 목록입니다.</p>
		<table class="table table-striped">
			<thead>
				<tr class="bg-info" style="font-size:120%;">
					<th>Title</th>
					<th>Priority</th>
					<th>Deadline</th>
					<th>State</th>
					<th>Description</th>
					<th><i class="fa fa-cog fa-spin fa-lg fa-fw" aria-hidden="true"></i>Settings
					<span class="sr-only">Saving. Hang tight!</span>
					</th>
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
						<td>
							<a href="<c:url value="/admin/postInventory/completePost/${post.id}"/>"> <i class="fa fa-check-circle fa-lg"></i> </a>
							<a href="<c:url value="/admin/postInventory/updatePost/${post.id}"/>"> <i class="fa fa-edit fa-lg"></i> </a>
							<a href="<c:url value="/admin/postInventory/deletePost/${post.id}"/>"> <i class="fa fa-times fa-lg"></i> </a>
						</td>
			
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<a href="<c:url value="/admin/postInventory/addPost"/>" class="btn btn-primary" >Add Post</a>
		
	</div>
</div>
