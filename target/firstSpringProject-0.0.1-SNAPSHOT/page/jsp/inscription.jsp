<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp" %>

<div class="form-container">
    <h1>Inscription</h1>
    <c:if test="${not empty error}">
        <p class="error-message">${error}</p>
    </c:if>
    <form:form method="POST" modelAttribute="user" action="${pageContext.request.contextPath}/inscription">

        <h2>Informations personnelles</h2>
            <label for="name">Nom </label>
            <form:input path="name" required="true"/>
            <form:errors class="error-message" path="name"/>

            <label for="first_name">Prénom </label>
            <form:input path="first_name" required="true"/>
            <form:errors class="error-message" path="first_name"/>

            <label for="email">Email </label>
            <form:input path="email" type="email" required="true"/>
            <form:errors class="error-message" path="email"/>

            <label for="phone_number">Numéro de téléphone (04...) </label>
            <form:input path="phone_number" required="true"/>
            <form:errors class="error-message" path="phone_number"/>

            <label for="gender">Genre </label>
            <form:select path="gender">
                <form:option value="Homme">Homme</form:option>
                <form:option value="Femme">Femme</form:option>
                <form:option value="Non identifié">Non identifié</form:option>
            </form:select>

        <h2>Adresse</h2>
            <label for="locality.city">Ville </label>
            <form:input path="locality.city" required="true"/>
            <form:errors class="error-message" path="locality.city"/>
            <div class="addressNumber">
                <label id="postalCode" for="locality.postal_code">Code postal </label>
                <form:input path="locality.postal_code" required="true"/>
                <form:errors class="error-message" path="locality.postal_code"/>

                <label id="number" for="locality.address.number">Numéro </label>
                <form:input path="locality.address.number" required="true"/>
                <form:errors class="error-message" path="locality.address.number"/>
            </div>
            <label for="locality.address.street">Rue </label>
            <form:input path="locality.address.street" required="true"/>
            <form:errors class="error-message" path="locality.address.street"/>

        <h2>Identifiants</h2>
            <label for="username">Nom d'utilisateur </label>
            <form:input path="username" required="true"/>
            <form:errors class="error-message" path="username"/>

            <label for="password">Mot de passe </label>
            <form:password path="password" required="true"/>
            <form:errors class="error-message" path="password"/>

        <input type="submit" value="S'inscrire"/>
        <a href="${pageContext.request.contextPath}/login">Déjà inscrit ?</a>
    </form:form>
</div>