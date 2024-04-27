<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
    <%@ page import="model.Etudiant" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des etudiants</title>
</head>
<body>
<%@ include file="./header.html" %>
<section class="container" >
<% if(request.getAttribute("success") != null) { %>
        <div class="alert alert-success">
            <%= request.getAttribute("success") %>
        </div>
    <% } %>
    
    <div class="row" >
    <div class="col-md-12">
    <h1>Liste des etudiants</h1>
    </div>
    <div class="col-md-12" >
    <table class="table table-striped" >
    <tr> <th>Id Etudiant</th> <th> CNE </th> <th>Nom</th> <th>Prenom</th> <th>telephone</th> <th>Nom Filiere</th> </tr>
    
    <% List<Etudiant> etudiants = (List<Etudiant>) request.getAttribute("etudiants"); 
    
    for(Etudiant etudiant :etudiants){
    %>
    <tr>
    <td> <%= etudiant.getIdEtudiant() %> </td>
    <td> <%= etudiant.getCNE()  %> </td>
    <td> <%= etudiant.getNom()  %> </td><td> <%= etudiant.getPrenom()  %> </td>
    <td> <%= etudiant.getTelephone()  %> </td> <td> <%= etudiant.getFiliere().getNomFiliere()  %> </td>
    
    </tr>
    <% } %>
    </table>
    </div>
    </div>
</section>

<%@ include file="./footer.html" %>
</body>
</html>