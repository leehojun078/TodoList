<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<div class="container-wrapper">
	<div class="container">
		<h1>게시물 수정</h1>
		<p class="lead">게시물을 수정할 내용을 입력하세요.</p>
		
		<sf:form action="${pageContext.request.contextPath}/admin/postInventory/updatePost"
			method="post" modelAttribute="post">
			
			<sf:hidden path="id"/>
			
			<div class="form-group">
				<label for="title">Title</label>
				<sf:input path="title" id="title" class="form-control"/>
				<sf:errors path="title" cssStyle="color:#ff0000;"/>
			</div>
			
			<div class="form-group">
				<label for="priority">Priority : &nbsp;</label>
				<sf:radiobutton path="priority" id="priority" value="상"/> 상
				<sf:radiobutton path="priority" id="priority" value="중"/> 중
				<sf:radiobutton path="priority" id="priority" value="하"/> 하
			</div>
			
			<div class="form-group">
				<label for="deadline">Deadline</label>
				<sf:input type = "date" path="deadline" id="deadline" class="form-control" max="2099-12-31"/>
				<sf:errors path="deadline" cssStyle="color:#ff0000;"/>
			</div>
			
			<div class="form-group">
				<label for="state">State</label>
				<sf:input path="state" id="state" readonly="true" class="form-control"/>
			</div>
			
			<div class="form-group">
				<label for="description">Description</label>
				<sf:textarea path="description" id="description" class="form-control"/>
				<sf:errors path="description" cssStyle="color:#ff0000;"/>
			</div>
			
			<input type="submit" value="submit" class="btn btn-primary">
			<a href="<c:url value="/admin/postInventory"/>" class="btn btn-secondary">Cancel</a>
			
		</sf:form>
		<br />
	</div>
</div>

