<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertion Departement</title>

</head>
<body>
<%@include file="./header.html" %>

<section>
<div class="container">
<div class="row">
<div class="col-md-12"> 
<h1>Formulaire ajouter une nouvelle Departement</h1>
</div>
</div>
<div class="row">
<div class="col-md-6">
<form action="DepartementServlet" method="post">
<input type="hidden" id="id_departement" name="id_departement" >
<div class="mb-3">
    <label for="nom_departement" class="form-label">Nom Departement :</label>
    <input type="text" class="form-control" id="nom_departement" name="nom_departement" >
    
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