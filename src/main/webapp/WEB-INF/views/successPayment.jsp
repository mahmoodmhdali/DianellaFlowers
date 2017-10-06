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
        <title>Dianella Flowers | Payment Success</title>
        <sec:csrfMetaTags />
    </jsp:attribute>
    <jsp:attribute name="body">
        <div class="page-title">
            <div class="container">
                <div class="column">
                    <h1>Checkout</h1>
                </div>
                <div class="column">
                    <ul class="breadcrumbs">
                        <li><a href="index.html">Home</a>
                        </li>
                        <li class="separator">&nbsp;</li>
                        <li>Checkout</li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- Page Content-->
        <div class="container padding-bottom-3x mb-2">
            <div class="card text-center">
                <div class="card-block padding-top-2x">
                    <h3 class="card-title">Thank you for your order!</h3>
                    <p class="card-text">Your order has been placed and will be processed as soon as possible.</p>
                    <p class="card-text">Make sure you make note of your order number, which is <span class="text-medium">34VB5540K83</span></p>
                    <u>You can now:</u>
                    <div class="padding-top-1x padding-bottom-1x"><a class="btn btn-outline-secondary" href="<c:url value='/products/wedding'/>">Go Back Shopping</a><a class="btn btn-outline-primary" href="<c:url value='/contactUs'/>">Contact Us</a></div>
                </div>
            </div>
        </div>
    </jsp:attribute>

    <jsp:attribute name="js">

    </jsp:attribute>
</t:master>
