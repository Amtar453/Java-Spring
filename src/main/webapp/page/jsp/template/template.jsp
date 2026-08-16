<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<%@ include file="../include/importTags.jsp" %>
<html>
<head>
    <title>AniShop</title>
    <link type="text/css" href="<spring:url value='/style/template.css'/>" rel="stylesheet" />

    <spring:url var="localeFr" value="">
        <spring:param name="locale" value="fr"/>
    </spring:url>
    <spring:url var="localeEn" value="">
        <spring:param name="locale" value="en"/>
    </spring:url>
</head>
<body>
    <nav>
        <div class="nav-top">
            <div class="nav-left">
                <div id="logo">
                    <a href="<spring:url value='/accueil'/>">AniShop</a>
                </div>
                <div class="flags">
                    <a href="${localeFr}">
                        <img alt="fr" src="<spring:url value='/image/fr.png'/>"/>
                    </a>
                    <a href="${localeEn}">
                        <img alt="en" src="<spring:url value='/image/en.png'/>"/>
                    </a>
                </div>
            </div>

            <div class="nav-center">
                <a href="<spring:url value='/accueil'/>">Accueil</a>
                <a href="<spring:url value='/achat'/>">Achat</a>
            </div>

            <div class="nav-right">
                <%--Si authentifie--%>
                <sec:authorize access="isAuthenticated()">
                    <a href="<spring:url value='/caddie'/>">
                        Caddie
                    </a>

                    <a class="icon-btn" href="<spring:url value='/logout'/>">
                        <img alt="Logout" src="<spring:url value='/image/logoutButton.png'/>"/>
                    </a>

                    <a class="icon-btn" href="<spring:url value='/profile'/>">
                        <img alt="Profil" src="<spring:url value='/image/profileButton.png'/>"/>
                    </a>
                </sec:authorize>

                <%--Si pas authentifie--%>
                <sec:authorize access="!isAuthenticated()">
                    <a href="<spring:url value='/login'/>">
                        Login
                    </a>

                    <a class="icon-btn" href="<spring:url value='/inscription'/>">
                        Inscris-toi !
                    </a>
                </sec:authorize>
            </div>
        </div>

        <div class="nav-bottom">
            <span class="welcome-message-template">
                Bienvenue sur AniShop ! Ici vous trouverez des figurines DragonBall, Naruto, Bleach, et bien d'autres.
            </span>
        </div>
    </nav>

    <div>
        <tiles:insertAttribute name="main-content" />
    </div>
    <footer>
        <a href="<spring:url value='/descriptionSociete'/>">
            Description de la societe
        </a>
    </footer>
</body>
</html>
