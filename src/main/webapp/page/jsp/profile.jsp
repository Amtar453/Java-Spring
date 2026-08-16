<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp" %>

<div class="form-container">
    <form:form method="POST" modelAttribute="currentUser" action="${pageContext.request.contextPath}/profil">

        <div class="profil-header">
            <h2>Profil</h2>

            <button type="button" id="editButton" class="profil-button">
                <img alt="Modifier" src="<spring:url value='/image/editButton.png'/>"/>
            </button>
        </div>

        <label> Nom </label>
<%--        <label> <c:out value='${currentUser.name}'/> </label>--%>
        <form:input path="name" readonly="true"/>
        <form:errors class="error-message" path="name"/>

        <label> Prenom </label>
<%--        <label> <c:out value="${currentUser.firstName}"/> </label>--%>
        <form:input path="firstName" readonly="true"/>
        <form:errors class="error-message" path="firstName"/>

        <label> numero de telephone </label>
<%--        <label> <c:out value="${currentUser.phoneNumber}"/> </label>--%>
        <form:input path="phoneNumber" readonly="true"/>
        <form:errors class="error-message" path="phoneNumber"/>

        <label> email </label>
<%--        <label> <c:out value="${currentUser.email}"/> </label>--%>
        <form:input path="email" readonly="true"/>
        <form:errors class="error-message" path="email"/>

        <label> genre </label>
<%--        <label> <c:out value="${currentUser.gender}"/> </label>--%>
        <form:input path="gender" readonly="true"/>
        <form:errors class="error-message" path="gender"/>

        <label> ville </label>
<%--        <label> <c:out value="${currentUser.locality.city}"/> </label>--%>
        <form:input path="address.locality.city" readonly="true"/>
        <form:errors class="error-message" path="address.locality.city"/>

        <label> code postal </label>
<%--        <label> <c:out value="${currentUser.locality.postalCode}"/> </label>--%>
        <form:input path="address.locality.postalCode" readonly="true"/>
        <form:errors class="error-message" path="address.locality.postalCode"/>

        <label> rue </label>
<%--        <label> <c:out value="${currentUser.locality.address.street}"/> </label>--%>
        <form:input path="address.street" readonly="true"/>
        <form:errors class="error-message" path="address.street"/>

        <label> numero </label>
<%--        <label> <c:out value="${currentUser.locality.address.number}"/> </label>--%>
        <form:input path="address.number" readonly="true"/>
        <form:errors class="error-message" path="address.number"/>

        <label> identifiant </label>
<%--        <label> <c:out value="${currentUser.username}"/> </label>--%>
        <form:input path="username" readonly="true"/>
        <form:errors class="error-message" path="username"/>

        <label> password </label>
<%--        <label> <c:out value="${currentUser.password}"/> </label>--%>
        <form:input path="password" type="password" readonly="true"/>
        <form:errors class="error-message" path="password"/>

        <button type="submit" id="saveButton" class="profil-button" disabled>
            Confimer
        </button>
    </form:form>
</div>

<script src="<spring:url value='/script/profil.js'/>"></script>