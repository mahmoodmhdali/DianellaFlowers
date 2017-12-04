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
                    <h1>Contact Us</h1>
                </div>
                <div class="column">
                    <ul class="breadcrumbs">
                        <li><a href="<c:url value='/'/>">Home</a>
                        </li>
                        <li class="separator">&nbsp;</li>
                        <li>Contact Us</li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- Page Content-->
        <div class="container padding-bottom-2x mb-2">
            <div class="row">
                <div class="col-md-7">
                    <div class="display-3 text-muted opacity-75 mb-30">Customer Service</div>
                </div>
                <div class="col-md-5">
                    <ul class="list-icon">
                        <li> <i class="icon-mail"></i><a class="navi-link" href="mailto:dianellaflowers@gmail.com">dianellaflowers@gmail.com</a></li>
                        <li> <i class="fa fa-phone"></i>+961 70 068 057</li>
                    </ul>
                </div>
            </div>
            <hr class="margin-top-2x">
            <div class="col-md-12">
                <h3 class="padding-top-2x">Have troubles? Ask us.</h3>
                <p class="text-muted mb-30">We normally respond within 1 business days.</p>
                <form class="row contact-us-form">
                    <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="help_name">Your Name</label>
                            <input class="form-control form-control-rounded" name="name" type="text" id="help_name">
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="help_email">Your Email</label>
                            <input class="form-control form-control-rounded" name="email" type="email" id="help_email">
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="help_subject">Subject</label>
                            <input class="form-control form-control-rounded" name="subject" type="text" id="help_subject">
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="help_category">Category</label>
                            <select class="form-control form-control-rounded" name="category" id="help_category">
                                <option>Account Management</option>
                                <option>Refund Policy</option>
                                <option>Payment Procedure</option>
                                <option>Shipping Info</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-12">
                        <div class="form-group">
                            <label for="help_question">Question </label>
                            <textarea style="resize: none;" class="form-control form-control-rounded" name="question" id="help_question" rows="8"></textarea>
                        </div>
                    </div>
                    <div class="col-12 text-right">
                        <button class="btn btn-outline-primary submit-form-btn-contact" type="submit">Submit Question</button>
                    </div>
                </form>
            </div>
        </div>
    </jsp:attribute>

    <jsp:attribute name="js">
        <script>

            $('document').ready(function () {
                $('.contact-us-form').on('submit', function (e)
                {
                    e.preventDefault();
                    $('.submit-form-btn-contact').lockBtn('');
                    $.ajax({
                        url: '<c:url value="/addNewContactUs"/>',
                        type: 'post',
                        data: $(this).serialize(),
                        success: function (data) {
                            if (data.statusCode == '0')
                            {
                                $('.validationSpanError').remove();
                                $('.parsley-error').removeClass('parsley-error');
                                $.notify('success', 'Success', 'Your request has been sent!.', 'topRight');
                                $('.contact-us-form')[0].reset();
                            } else {
                                $.handleAjaxRequest(data, $('.contact-us-form'));
                            }
                        },
                        error: function (error) {
                            $.notify('danger', 'Error', 'Internal server error!.', 'topRight');
                        },
                        complete: function () {
                            $('.submit-form-btn-contact').unLockBtn();
                        }
                    });
                });
            });
        </script>
    </jsp:attribute>
</t:master>
