<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="java.util.List" %>
    <%@ page import="model.Filiere" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


 <link rel="stylesheet" href="css/style.css">
<title>Ajouter nouveau etudiant </title>
</head>
<body>
<%@include file="./header.html" %>

<section>
<div class="container">
<div class="row">
<div class="col-md-12"> 
<h1>Formulaire ajouter une nouvelle etudiant</h1>
</div>
</div>
<div class="row">
<div class="col-md-6">
<form action="EtudiantServlet" method="post">
<input type="hidden" id="id_etudiant" name="id_etudiant" >
<div class="mb-3">
    <label for="CNE" class="form-label">CNE :</label>
    <input type="text" class="form-control" id="CNE" name="CNE" >
    
  </div>
  
  <div class="mb-3">
    <label for="nom" class="form-label">Nom</label>
    <input type="text" class="form-control" id="nom" name="nom" >
    
  </div>
	<div class="mb-3">
    <label for="prenom" class="form-label">Prenom</label>
    <input type="text" class="form-control" id="prenom" name="prenom" >
    
  	</div>
  	
  	<div class="mb-3">
    <label for="telephone" class="form-label">Telephone</label>
    <input type="text" class="form-control" id="telephone" name="telephone" >
    
  	</div>
  	<div class="mb-3">
  	<select class="form-select" name="id_filiere">
  	<option selected>Choisir filiere</option>
  	<% List<Filiere> filieres=(List<Filiere>) request.getAttribute("filieres");
    		for(Filiere filiere:filieres){
    		%>
    		<option value="<%= filiere.getIdFiliere() %>" ><%= filiere.getNomFiliere() %></option>
    		<% } %>
  	</select>
  	
  	</div>
  
  
  <button type="submit" class="btn btn-primary">Ajouter</button>


</form>
</div>
</div>
</div>



</section>





<%@include file="./footer.html" %>




</body>
</html>