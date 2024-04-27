<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Filiere" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List des Filieres</title>
</head>
<body>
<%@include file="./header.html" %>
<section class="container">

<% if(request.getAttribute("success") != null) { %>
        <div class="alert alert-success">
            <%= request.getAttribute("success") %>
        </div>
    <% } %>
    
    <div class="row">
    <div class="col-md-12">
    <h1>List Des Filieres </h1>
    </div>
    <div class="col-md-12">
    <table class="table table-striped" >
    <tr> <td> id filiere </td> <td> nom filiere </td> <td> nom departement </td></tr>
    <% 
                List<Filiere> filieres = (List<Filiere>) request.getAttribute("filieres");
                for(Filiere filiere : filieres) { 
                %>
                    <tr>
                        <td><%= filiere.getIdFiliere() %></td>
                        <td><%= filiere.getNomFiliere() %></td>
                         <td><%= filiere.getDepartement().getNomDepartement() %></td>
                    </tr>
                <% } %>
    </table>
    </div>
    </div>
</section>

<%@include file="./footer.html" %>
</body>
</html>