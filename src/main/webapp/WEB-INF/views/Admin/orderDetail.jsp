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
        <title>Dianella Flowers | ${checkoutRequest.getTrackId()} Detail</title>
        <sec:csrfMetaTags />
    </jsp:attribute>
    <jsp:attribute name="body">
        <div class="page-title">
            <div class="container">
                <div class="column">
                    <h1>${checkoutRequest.getTrackId()} Detail</h1>
                </div>
                <div class="column">
                    <ul class="breadcrumbs">
                        <li><a href="<c:url value='/'/>">Home</a></li>
                        <li class="separator">&nbsp;</li>
                        <li><a href="<c:url value='/Dashboard'/>">Customers' Order</a></li>
                        <li class="separator">&nbsp;</li>
                        <li>${checkoutRequest.getTrackId()} Detail</li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- Page Content-->
        <div class="container padding-bottom-3x mb-2">
            <div class="row">
                <!-- Checkout Adress-->
                <div class="col-xl-9 col-lg-8">
                    <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                    <h4>Billing Address</h4>
                    <hr class="padding-bottom-1x">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="checkout-fn">First Name</label>
                                <input class="form-control" name="firstName" type="text" id="checkout-fn" <c:if test="${checkoutRequest != null}">value="${checkoutRequest.getFirstName()}"</c:if> disabled>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="checkout-ln">Last Name</label>
                                    <input class="form-control" name="lastName" type="text" id="checkout-ln" <c:if test="${checkoutRequest != null}">value="${checkoutRequest.getLastName()}"</c:if> disabled>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="checkout-email">E-mail Address</label>
                                    <input class="form-control" name="email" type="text" id="checkout-email" <c:if test="${checkoutRequest != null}">value="${checkoutRequest.getEmail()}"</c:if> disabled>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="checkout-phone">Phone Number</label>
                                    <input class="form-control" name="phoneNumber" type="text" id="checkout-phone" <c:if test="${checkoutRequest != null}">value="${checkoutRequest.getPhoneNumber()}"</c:if> disabled>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="checkout-city">City</label>
                                    <input type="hidden" name="city" value="Beirut">
                                    <input class="form-control" name="city" type="text" value="Beirut" id="checkout-city" disabled>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="checkout-shippingDateTime">Shipping Date</label>
                                    <input class="form-control date-time" name="shippingDateTime" type="text" id="checkout-shippingDateTime" <c:if test="${checkoutRequest != null}">value="<fmt:formatDate type="date" pattern="MMM, dd YYYY" value="${checkoutRequest.getShippingDateTime()}" />"</c:if> disabled>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="steps d-flex flex-wrap flex-sm-nowrap justify-content-between">
                                    <div class="step <c:if test="${checkoutRequest.getShippingTime() == null || checkoutRequest.getShippingTime() == 1}">completed</c:if>" >
                                        <div class="step-icon-wrap">
                                            <div class="step-icon"><i class="fa fa-coffee"></i></div>
                                        </div>
                                        <h4 class="step-title">Morning</h4>
                                    </div>
                                    <div class="step <c:if test="${checkoutRequest.getShippingTime() != null && checkoutRequest.getShippingTime() == 2}">completed</c:if>" >
                                        <div class="step-icon-wrap">
                                            <div class="step-icon"><i class="fa fa-sun-o"></i></div>
                                        </div>
                                        <h4 class="step-title">Afternoon</h4>
                                    </div>
                                    <div class="step <c:if test="${checkoutRequest.getShippingTime() != null && checkoutRequest.getShippingTime() == 3}">completed</c:if>" >
                                        <div class="step-icon-wrap">
                                            <div class="step-icon"><i class="fa fa-moon-o"></i></div>
                                        </div>
                                        <h4 class="step-title">Evening</h4>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <label for="address">Text to set on card</label>
                                    <textarea style="resize: none;" class="form-control" rows="5" name="cardText" type="text" id="checkout-address1" disabled><c:if test="${checkoutRequest != null}">${checkoutRequest.getCardText()}</c:if></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="row padding-bottom-1x">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <label for="address">Address</label>
                                    <input class="form-control" name="address" type="text" id="checkout-address1" <c:if test="${checkoutRequest != null}">value="${checkoutRequest.getAddress()}"</c:if> disabled>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <label for="address">Additional Details</label>
                                    <textarea style="resize: none;" class="form-control" rows="5" name="additionalDetails" type="text" id="checkout-additionalDetails" disabled><c:if test="${checkoutRequest != null}">${checkoutRequest.getAdditionalDetails()}</c:if></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Sidebar          -->
                    <div class="col-xl-3 col-lg-4">
                        <aside class="sidebar">
                            <div class="padding-top-2x hidden-lg-up"></div>
                            <!-- Order Summary Widget-->
                            <section class="widget widget-order-summary">
                                <h3 class="widget-title">Order Summary</h3>
                                <table class="table">
                                    <tr>
                                        <td>Cart Subtotal:</td>
                                        <td class="text-medium">$${userCartTotalPriceByTrackId}</td>
                                </tr>
                                <tr>
                                    <td>Shipping:</td>
                                    <td class="text-medium">-</td>
                                </tr>
                                <tr>
                                    <td>Discount:</td>
                                    <td class="text-medium">-</td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td class="text-lg text-medium">$${userCartTotalPriceByTrackId}</td>
                                </tr>
                            </table>
                        </section>
                        <section class="widget widget-featured-products">
                            <h3 class="widget-title">Ordered Items</h3>
                            <c:choose>
                                <c:when test="${fn:length(userCartItems) > 0}">
                                    <c:forEach var="cart" items="${userCartItems}">
                                        <div class="entry">
                                            <div class="entry-thumb">
                                                <a class="product-thumb" title="${cart.getBouquetID().getName()}" data-gallery="" href="<c:url value='${cart.getBouquetID().getOriginalImage()}'/>">
                                                    <img src="<c:url value='${cart.getBouquetID().getCompressedImagePath()}'/>" alt="${cart.getBouquetID().getName()}">
                                                </a>
                                            </div>
                                            <div class="entry-content">
                                                <h4 class="entry-title"><a href="#">${cart.getBouquetID().getName()}</a></h4><span class="entry-meta">$${cart.getBouquetID().getPrice()} - Quantity: ${cart.getQuantity()}</span>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </c:when>
                            </c:choose>
                        </section>
                    </aside>
                </div>
                <!-- The Gallery as lightbox dialog, should be a child element of the document body -->
                <div id="blueimp-gallery" class="blueimp-gallery">
                    <div class="slides"></div>
                    <h3 class="title"></h3>
                    <a class="prev">‹</a>
                    <a class="next">›</a>
                    <a class="close">×</a>
                    <a class="play-pause"></a>
                    <ol class="indicator"></ol>
                </div>
            </div>
        </div>
    </jsp:attribute>

    <jsp:attribute name="js">

    </jsp:attribute>
</t:master>
