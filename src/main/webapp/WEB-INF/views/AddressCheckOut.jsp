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
        <title>Dianella Flowers | Shipping</title>
        <sec:csrfMetaTags />
    </jsp:attribute>
    <jsp:attribute name="body">
        <!-- Page Title-->
        <div class="page-title">
            <div class="container">
                <div class="column">
                    <h1>Shipping</h1>
                </div>
                <div class="column">
                    <ul class="breadcrumbs">
                        <li><a href="<c:url value='/cart'/>">Cart</a>
                        </li>
                        <li class="separator">&nbsp;</li>
                        <li>Shipping</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="container padding-bottom-3x mb-2">
            <div class="row">
                <!-- Checkout Adress-->
                <form id="shippingForm" class="col-xl-9 col-lg-8">
                    <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                    <div class="checkout-steps">
                        <a href="#">4. Review</a>
                        <a href="#"><span class="angle"></span>3. Payment</a>
                        <a class="active" href="#"><span class="angle"></span>2. Shipping</a>
                        <a href="<c:url value='/cart'/>"><span class="angle"></span>1. Cart</a>
                    </div>
                    <h4>Billing Address</h4>
                    <hr class="padding-bottom-1x">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="checkout-fn">First Name</label>
                                <input class="form-control" name="firstName" type="text" id="checkout-fn">
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="checkout-ln">Last Name</label>
                                <input class="form-control" name="lastName" type="text" id="checkout-ln">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="checkout-email">E-mail Address</label>
                                <input class="form-control" name="emailAddress" type="email" id="checkout-email">
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="checkout-phone">Phone Number</label>
                                <input class="form-control" name="phoneNumber" type="text" id="checkout-phone">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="checkout-city">City</label>
                                <select class="form-control" name="city" id="checkout-city">
                                    <option>Choose city</option>
                                    <option>Amsterdam</option>
                                    <option>Berlin</option>
                                    <option>Geneve</option>
                                    <option>New York</option>
                                    <option>Paris</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label for="address">Text to set on card</label>
                                <textarea class="form-control" rows="5" name="cardText" type="text" id="checkout-address1"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="row padding-bottom-1x">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label for="address">Address</label>
                                <input class="form-control" name="address" type="text" id="checkout-address1">
                            </div>
                        </div>
                    </div>
                    <div class="checkout-footer">
                        <div class="column"><a class="btn btn-outline-secondary" href="<c:url value='/cart'/>"><i class="icon-arrow-left"></i><span class="hidden-xs-down">&nbsp;Back To Cart</span></a></div>
                        <div class="column"><button class="btn btn-primary" type="submit"><span class="hidden-xs-down">Continue&nbsp;</span><i class="icon-arrow-right"></i></button></div>
                    </div>
                </form>
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
                                    <td class="text-medium">$${userCartTotalPrice}</td>
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
                                    <td class="text-lg text-medium">$${userCartTotalPrice}</td>
                                </tr>
                            </table>
                        </section>
                    </aside>
                </div>
            </div>
        </div>
    </jsp:attribute>
    <jsp:attribute name="js">
        <script>
            $('document').ready(function () {
                $('#shippingForm').on('submit', function (e) {
                    e.preventDefault();
                    $.ajax({
                        url: '<c:url value="/cart/orderDetail"/>',
                        data: $(this).serialize(),
                        type: 'post',
                        success: function (data) {
                            window.location.href = '<c:url value="/cart/successPayment"/>';
                        },
                        error: function (error) {
                            console.log(error);
                        },
                        complete: function () {
                        }
                    });
                });
            });
        </script>
    </jsp:attribute>
</t:master>
