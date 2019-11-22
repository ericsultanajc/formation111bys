<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edition du stagiaire</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
</head>
<body>

	<div class="container">
		<form action="save" method="post">
			<input type="hidden" name="id" value="${stagiaire.id}"> 
			<input type="hidden" name="version" value="${stagiaire.version}">
			<div id="filiereForm" class="card mt-3">
				<div class="card-header bg-info text-white">
					<h3>Edition du stagiaire</h3>
				</div>
				<div class="card-body">
					<div class="form-group">
						<label for="nom">Nom:</label> <input
							type="text" class="form-control" id="nom"
							name="nom" value="${stagiaire.nom}">
					</div>
					<div class="form-group">
						<label for="prenom">Prénom:</label> <input
							type="text" class="form-control" id="prenom"
							name="prenom" value="${stagiaire.prenom}">
					</div>
					<div class="form-group">
						<label for="email">Courriel:</label> <input
							type="text" class="form-control" id="email"
							name="email" value="${stagiaire.email}">
					</div>
					<div class="form-group">
						<label for="telephone">Téléphone:</label> <input
							type="text" class="form-control" id="telephone"
							name="telephone" value="${stagiaire.telephone}">
					</div>
					<div class="form-group">
						<label for="dtNaissance">Date de naissance:</label> <input
							type="date" class="form-control" id="dtNaissance"
							name="dtNaissance" value="${stagiaire.dtNaissance}">
					</div>
					<div class="form-group">
						<label for="niveauEtude">Niveau d'étude:</label> 
						
						<select  class="form-control" id="niveauEtude"
							name="niveauEtude">
							<option value="">Choisir un niveau d'étude</option>
							<c:forEach items="${niveauEtudes}" var="niv">
								<option value="${niv}" ${stagiaire.niveauEtude == niv ? 'selected' : ''}>${niv.label}</option>
							</c:forEach>
						</select>
						
					</div>
					<div class="form-group">
						<label for="rue">Rue:</label> <input
							type="text" class="form-control" id="rue"
							name="rue" value="${stagiaire.adresse.rue}">
					</div>
					<div class="form-group">
						<label for="complement">Complément:</label> <input
							type="text" class="form-control" id="complement"
							name="complement" value="${stagiaire.adresse.complement}">
					</div>
					<div class="form-group">
						<label for="codePostal">Code postal:</label> <input
							type="text" class="form-control" id="codePostal"
							name="codePostal" value="${stagiaire.adresse.codePostal}">
					</div>
					<div class="form-group">
						<label for="ville">Ville:</label> <input
							type="text" class="form-control" id="ville"
							name="ville" value="${stagiaire.adresse.ville}">
					</div>
					<div class="form-group">
						<label for="evaluation">Evaluation:</label> 
						
						<select  class="form-control" id="evaluation"
							name="evaluation">
							<option value="">Choisir une evaluation</option>
							<c:forEach items="${evaluations}" var="eval">
								<option value="${eval.id}" ${stagiaire.evaluation.id == eval.id ? 'selected' : ''}>${eval.id} - ${eval.commentaires}</option>
							</c:forEach>
						</select>
						
					</div>
				</div>
				<div class="card-footer">
					<div class="btn-group btn-group-lg float-right">
						<button type="submit" class="btn btn-success">
							<i class="fa fa-check"></i>
						</button>
						<a href="cancel" class="btn btn-warning"> <i
							class="fa fa-undo"></i>
						</a>
					</div>
				</div>

			</div>
		</form>

	</div>
</body>
</html>