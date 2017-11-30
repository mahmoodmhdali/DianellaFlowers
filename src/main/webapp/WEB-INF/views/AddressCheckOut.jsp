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
        <link href="<c:url value='/assets/datepicker/css/bootstrap-datetimepicker.min.css'/>" rel="stylesheet">
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
                    <c:if test="${errorMessage != null}">
                        <div class="alert alert-danger alert-dismissible fade show text-center" style="margin-bottom: 30px;">
                            Purchase failed. Status message: <strong>${errorMessage}</strong>.<br>
                            For any question feel free to <a href="<c:url value='/contactUs'/>">Contact Us</a>
                        </div>
                    </c:if>
                    <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                    <div class="checkout-steps">
                        <a href="#">4. Success</a>
                        <a href="#"><span class="angle"></span>3. Payment</a>
                        <a class="active" href="#"><span class="angle"></span>2. Shipping</a>
                        <a href="<c:url value='/cart'/>" class="completed"><span class="angle"></span><span class="step-indicator icon-circle-check"></span>1. Cart</a>
                    </div>
                    <h4>Billing Address</h4>
                    <hr class="padding-bottom-1x">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="checkout-fn">First Name</label>
                                <input class="form-control" name="firstName" type="text" id="checkout-fn" <c:if test="${checkoutRequest != null}">value="${checkoutRequest.getFirstName()}"</c:if> >
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="checkout-ln">Last Name</label>
                                    <input class="form-control" name="lastName" type="text" id="checkout-ln" <c:if test="${checkoutRequest != null}">value="${checkoutRequest.getLastName()}"</c:if>>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="checkout-email">E-mail Address</label>
                                    <input class="form-control" name="email" type="text" id="checkout-email" <c:if test="${checkoutRequest != null}">value="${checkoutRequest.getEmail()}"</c:if>>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="checkout-phone">Phone Number</label>
                                    <input class="form-control" name="phoneNumber" type="text" id="checkout-phone" <c:if test="${checkoutRequest != null}">value="${checkoutRequest.getPhoneNumber()}"</c:if>>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="checkout-city">City</label>
                                    <!--                                <select class="form-control" name="city" id="checkout-city">
                                                                        <option>Choose city</option>
                                                                        <option>Amsterdam</option>
                                                                        <option>Berlin</option>
                                                                        <option>Geneve</option>
                                                                        <option>New York</option>
                                                                        <option>Paris</option>
                                                                    </select>-->
                                    <input type="hidden" name="city" value="Beirut">
                                    <input class="form-control" name="city" type="text" value="Beirut" id="checkout-city" disabled>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="checkout-shippingDateTime">Shipping Date</label>
                                    <input class="form-control date-time" name="shippingDateTime" type="text" id="checkout-shippingDateTime" <c:if test="${checkoutRequest != null}">value="<fmt:formatDate type="date" pattern="MMM, dd YYYY" value="${checkoutRequest.getShippingDateTime()}" />"</c:if>>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="steps d-flex flex-wrap flex-sm-nowrap justify-content-between">
                                    <div class="step <c:if test="${checkoutRequest.getShippingTime() == null || checkoutRequest.getShippingTime() == 1}">completed</c:if>" style="cursor: pointer" data-time="1">
                                        <div class="step-icon-wrap">
                                            <div class="step-icon"><i class="fa fa-coffee"></i></div>
                                        </div>
                                        <h4 class="step-title">Morning</h4>
                                    </div>
                                    <div class="step <c:if test="${checkoutRequest.getShippingTime() != null && checkoutRequest.getShippingTime() == 2}">completed</c:if>" style="cursor: pointer" data-time="2">
                                        <div class="step-icon-wrap">
                                            <div class="step-icon"><i class="fa fa-sun-o"></i></div>
                                        </div>
                                        <h4 class="step-title">Afternoon</h4>
                                    </div>
                                    <div class="step <c:if test="${checkoutRequest.getShippingTime() != null && checkoutRequest.getShippingTime() == 3}">completed</c:if>" style="cursor: pointer" data-time="3">
                                        <div class="step-icon-wrap">
                                            <div class="step-icon"><i class="fa fa-moon-o"></i></div>
                                        </div>
                                        <h4 class="step-title">Evening</h4>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">  
                            <div class="col-xl-12 col-lg-12">
                                <div class="alert alert-warning alert-dismissible fade show text-center" style="margin-bottom: 30px;">
                                    For a specific time or more details please feel free to add specified time in <br>
                                    <strong class="toSlideAttional" style="cursor: pointer">additional detail</strong> section.
                                </div>
                            </div>    
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <label for="address">Text to set on card</label>
                                    <textarea style="resize: none;" class="form-control" rows="5" name="cardText" type="text" id="checkout-address1"><c:if test="${checkoutRequest != null}">${checkoutRequest.getCardText()}</c:if></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="row padding-bottom-1x">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <label for="address">Address</label>
                                    <input class="form-control" name="address" type="text" id="checkout-address1" <c:if test="${checkoutRequest != null}">value="${checkoutRequest.getAddress()}"</c:if>>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <label for="address">Additional Details</label>
                                    <textarea style="resize: none;" class="form-control additionalInput" rows="5" name="additionalDetails" type="text" id="checkout-additionalDetails"><c:if test="${checkoutRequest != null}">${checkoutRequest.getAdditionalDetails()}</c:if></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="checkout-footer">
                            <div class="column"><a class="btn btn-outline-secondary" href="<c:url value='/cart'/>"><i class="icon-arrow-left"></i><span class="hidden-xs-down">&nbsp;Back To Cart</span></a></div>
                        <div class="column"><button class="btn btn-primary submitFormBtn" type="submit"><span class="hidden-xs-down">Continue&nbsp;</span><i class="icon-arrow-right"></i></button></div>
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
                <form method="post" action="https://checkout.payfort.com/FortAPI/paymentPage" id="payfortForm" name="form1" style="display: none">
                    <button type="submit" class="btn btn-primary"> Submit Form</button>
                </form>
            </div>
        </div>
    </jsp:attribute>
    <jsp:attribute name="js">
        <script src="<c:url value='/assets/datepicker/js/moment.min.js'/>"></script>
        <script src="<c:url value='/assets/datepicker/js/bootstrap-datetimepicker.min.js'/>"></script>
        <script>
            $('document').ready(function () {


                $('body').on('click', '.toSlideAttional', function () {
                    $('.additionalInput').focus();
                    $('html, body').animate({scrollTop: $('.additionalInput').offset().top - 200}, 'slow');
                });

                var time = '1';

                var nowTemp = new Date();
                var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), nowTemp.getHours(), nowTemp.getMinutes(), nowTemp.getSeconds(), nowTemp.getMilliseconds());

                $('.date-time').datetimepicker({
                    format: 'MMM, DD YYYY',
                    minDate: now
                });

                $('body').on('click', '.step', function () {
                    $('.step').removeClass('completed');
                    $(this).addClass('completed');
                    time = $(this).attr('data-time');
                });

                $('#shippingForm').on('submit', function (e) {
                    e.preventDefault();
                    $('.submitFormBtn').lockBtn('');
                    $.ajax({
                        url: '<c:url value="/cart/orderDetail"/>',
                        data: $(this).serialize() + '&time=' + time,
                        type: 'post',
                        success: function (data) {
                            if (data.statusCode == '0')
                            {
                                formCreation(data.responseObject);
                                $('#payfortForm').submit();
                                //window.location.href = '<c:url value="/cart/successPayment/"/>' + data.statusMessage;
                            } else {
                                $.handleAjaxRequest(data, $('#shippingForm'));
                            }
                        },
                        error: function (error) {
                        },
                        complete: function () {
                            $('.submitFormBtn').unLockBtn();
                        }
                    });
                });

                function formCreation(data) {
                    $.each(data, function (key, value) {
                        $('#payfortForm').append('<input type="hidden" name="' + key + '" value="' + value + '">');
                    });
                }


            });
        </script>
    </jsp:attribute>
</t:master>
