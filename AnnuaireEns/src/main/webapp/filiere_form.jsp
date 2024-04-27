<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
    <%@ page import="model.Departement" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertion nouvelle filiere</title>
</head>
<body>
<%@ include file="./header.html" %>
<section class="container my-3">
<div class="row"> 
<div class="col-md-12">
<h1>Insertion nouvelle Filiere :</h1>
<p> s'il vous plait inserer tous les champs ! </p>
</div>
<div class="col-md-6"> 
<form action="FiliereServlet" method="post">
<input type="hidden" id="id_filiere" name="id_filiere" >

<div class="mb-3">
    <label for="nom_filiere" class="form-label">Nom Filiere :</label>
    <input type="text" class="form-control" id="nom_filiere" name="nom_filiere" >
    
  </div>
  
  <div class="mb-3">
  
  <select name="id_departement" class="form-select">
  <option selected> choisir departement </option>
  <% List<Departement> departements = (List<Departement>) request.getAttribute("departements") ;
  
  for(Departement departement: departements){
  
  %>
   <option value="<%= departement.getIdDepartement() %>"> <%= departement.getNomDepartement() %> </option>
  
  <% } %>
  
  </select>
  </div>

<div class="mb-3">
<button type="submit" class="btn btn-primary">Ajouter</button>
</div>

</form>
</div>
</div>

</section>


<%@ include file="./footer.html" %>
</body>
</html>