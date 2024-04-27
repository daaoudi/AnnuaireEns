
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page import="java.util.List" %>
 <%@ page import="model.Departement" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Departements</title>



</head>
<body>
<%@include file="./header.html" %>

<section class="container">

 <% if(request.getAttribute("success") != null) { %>
        <div class="alert alert-success">
            <%= request.getAttribute("success") %>
        </div>
    <% } %>
<h1>List Departements</h1>
<div class="row">
<div class="col-md-12">

<table class="table table-striped">
<tr>
<th>Id</th><th>Nom Departement</th>
</tr>

 <%
    String msg = "";
    List<Departement> departments = (List<Departement>) request.getAttribute("departements");
    if (departments == null || departments.isEmpty()) {
        msg = "s'il vous plait insérer les données avant d'afficher cette page";
    }
%>

<% if (!msg.isEmpty()) { %>
    <tr>
        <td colspan="2" style="color:red;" ><%= msg %></td>
    </tr>
<% } else { %>
    <% for (Departement departement : departments) { %>
        <tr>
            <td><%= departement.getIdDepartement() %></td>
            <td><%= departement.getNomDepartement() %></td>
        </tr>
    <% } %>
<% } %>

  

   
</table>
</div>
</div>

</section>



<%@include file="./footer.html" %>
</body>
</html>
</body>
</html>