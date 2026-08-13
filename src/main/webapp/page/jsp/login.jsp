<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp" %>
<div>

<form:form method="POST" modelAttribute="user">
    <label>Nom d'utilisateur :</label>
    <input type="text" name="username"/>

    <label>Mot de passe :</label>
    <input type="password" name="password"/>

    <a href="<spring:url value='/inscription'/>">Pas encore inscrit ?</a>

    <input type="submit" value="Se connecter"/>
</form:form>
</div>
