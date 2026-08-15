<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp" %>

<div class="form-container">
    <h1>Connexion</h1>
    <c:if test="${param.error != null}">
        <p class="error-message">Nom d'utilisateur ou mot de passe incorrect.</p>
    </c:if>
    <form:form method="POST" modelAttribute="user">
        <label>Nom d'utilisateur :</label>
        <input type="text" name="username"/>

        <label>Mot de passe :</label>
        <input type="password" name="password"/>

        <label>
            <input type="checkbox" name="remember-me" />
            Se souvenir de moi
        </label>

        <input type="submit" value="Se connecter"/>

        <a href="<spring:url value='/inscription'/>">Pas encore inscrit ?</a>
    </form:form>
</div>
