<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp" %>

<div>
    <h1>Inscription</h1>
    <form:form method="POST" modelAttribute="user" action="${pageContext.request.contextPath}/inscription">

            <label for="name">Nom :</label>
            <form:input path="name" required="true"/>

            <label for="first_name">Prénom :</label>
            <form:input path="first_name" required="true"/>

            <label for="email">Email :</label>
            <form:input path="email" type="email" required="true"/>

            <label for="phone_number">Numéro de téléphone :</label>
            <form:input path="phone_number" required="true"/>

            <label for="gender">Genre :</label>
            <form:select path="gender">
                <form:option value="Homme">Homme</form:option>
                <form:option value="Femme">Femme</form:option>
                <form:option value="Autre">Autre</form:option>
            </form:select>

            <label for="username">Nom d'utilisateur :</label>
            <form:input path="username" required="true"/>

            <label for="password">Mot de passe :</label>
            <form:password path="password" required="true"/>

            <input type="submit" value="S'inscrire"/>
            <a href="${pageContext.request.contextPath}/login">Déjà inscrit ?</a>

    </form:form>
</div>