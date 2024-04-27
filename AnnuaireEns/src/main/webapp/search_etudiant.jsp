<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Etudiant</title>
</head>
<body>
<%@ include file="./header.html" %>
<section class="container">
<div class="row" >
<div class="col-md-12" >
<h1>Chercher Par le Nom de L'etudiant !</h1>
</div>

<div class="col-md-6 my-5" >
<form action="SearchEtudiant" method="post"  >
 <div class="mb-3" >
 <label id="nom" >Chercher Par le Nom de l'etudiant :</label>
 <input type="search" class="form-control me-2" name="nom" id="nom"  >
  <button class="btn btn-outline-success my-1" type="submit">Search</button>
 
 </div>
</form>

</div>
</div>


</section>
<%@ include file="./footer.html" %>
</body>
</html>