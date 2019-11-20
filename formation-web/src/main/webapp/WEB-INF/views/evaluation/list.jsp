<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des évaluations</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
</head>
<body>

	<div class="container">
		<div class="card mt-3">
			<div class="card-header bg-info text-white">
				<h2>Liste des évaluations</h2>
			</div>
			<div class="card-body">
				<table id="filiereTable" class="table table-striped">
					<thead>
						<tr>
							<th>Identifiant</th>
							<th>Version</th>
							<th>Comportementale</th>
							<th>Technique</th>
							<th>Commentaires</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${mesEvaluations}" var="eval">
							<tr>
								<td>${eval.id}</td>
								<td>${eval.version}</td>
								<td>${eval.comportementale}</td>
								<td>${eval.technique}</td>
								<td>${eval.commentaires}</td>
								<td><div class="btn-group btn-group-sm"><a class="btn btn-primary" href="evaluation?mode=edit&id=${eval.id}"><i class="fa fa-edit"></i></a><a class="btn btn-danger" href="evaluation?mode=delete&id=${eval.id}"><i class="fa fa-trash"></i></a></div></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="card-footer">
				<a href="evaluation?mode=add" class="btn btn-success btn-lg">
					<i class="fa fa-plus"></i>
				</a>
			</div>
		</div>
	</div>
</body>
</html>