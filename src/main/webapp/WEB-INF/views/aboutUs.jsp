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
        <title>Dianella Flowers | About Us</title>
        <sec:csrfMetaTags />
    </jsp:attribute>
    <jsp:attribute name="body">
        <div class="page-title">
            <div class="container">
                <div class="column">
                    <h1>About Us</h1>
                </div>
                <div class="column">
                    <ul class="breadcrumbs">
                        <li><a href="<c:url value='/'/>">Home</a>
                        </li>
                        <li class="separator">&nbsp;</li>
                        <li>About Us</li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- Page Content-->
        <div class="container padding-bottom-2x mb-2">
            <div class="row align-items-center padding-bottom-2x">
                <div class="col-md-5"><img class="d-block w-270 m-auto" src="<c:url value='/assets/img/features/01.jpg'/>" alt="Online Shopping"></div>
                <div class="col-md-7 text-md-left text-center">
                    <div class="mt-30 hidden-md-up"></div>
                    <h2>Select and Buy Online.</h2>
                    <p>Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something .</p><a class="text-medium text-decoration-none" href="shop-grid-ls.html">View Products&nbsp;<i class="icon-arrow-right"></i></a>
                </div>
            </div>
            <hr>
            <div class="row align-items-center padding-top-2x padding-bottom-2x">
                <div class="col-md-5 order-md-2"><img class="d-block w-270 m-auto" src="<c:url value='/assets/img/features/02.jpg'/>" alt="Delivery"></div>
                <div class="col-md-7 order-md-1 text-md-left text-center">
                    <div class="mt-30 hidden-md-up"></div>
                    <h2>Fast Delivery.</h2>
                    <p>Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something Something .</p><a class="text-medium text-decoration-none" href="#">Shipping Details&nbsp;<i class="icon-arrow-right"></i></a>
                </div>
            </div>
            <hr>
        </div>
    </jsp:attribute>

    <jsp:attribute name="js">

    </jsp:attribute>
</t:master>
