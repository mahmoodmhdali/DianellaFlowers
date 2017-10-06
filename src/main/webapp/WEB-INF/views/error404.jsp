<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:master>
    <jsp:attribute name="css">
        <title>Dianella Flowers | 404 Not Found</title>
        <sec:csrfMetaTags />
    </jsp:attribute>
    <jsp:attribute name="body">
        <div class="container padding-top-3x padding-bottom-3x mb-1"><img class="d-block m-auto" src="<c:url value='/assets/img/404_art.jpg'/>" style="width: 100%; max-width: 550px;" alt="404">
            <div class="padding-top-1x mt-2 text-center">
                <h3>Page Not Found</h3>
                <p>It seems we can’t find page you are looking for. <a href="<c:url value='/'/>">Go back to Homepage</a></p>
            </div>
        </div>
    </jsp:attribute>

    <jsp:attribute name="js">

    </jsp:attribute>
</t:master>
