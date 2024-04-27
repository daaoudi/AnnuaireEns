<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
    <%@ page import="model.Etudiant" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search result !</title>
</head>
<body>
<%@ include file="./header.html" %>

<section class="container" >
<div class="row" >
<div class="col-md-12" >
<h1>Résultat de la recherche</h1>

</div>
<div class="col-md-12" >

 <% if (request.getAttribute("error") != null) { %>
       <div class="alert alert-danger" > <p><%= request.getAttribute("error") %></p></div>
    <% } else { %>

        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>CNE</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Téléphone</th>
                
            </tr>
            <% List<Etudiant> etudiants = (List<Etudiant>) request.getAttribute("etudiants");
            for(Etudiant etudiant : etudiants) { %>
                <tr>
                    <td><%= etudiant.getIdEtudiant() %></td>
                    <td><%= etudiant.getCNE() %></td>
                    <td><%= etudiant.getNom() %></td>
                    <td><%= etudiant.getPrenom() %></td>
                    <td><%= etudiant.getTelephone() %></td>
                  
                </tr>
            <% } %>
        </table>

    <% } %>

</div>

</div>
</section>





<%@ include file="./footer.html" %>

</body>
</html>