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
        <title>Dianella Flowers | Login</title>
        <sec:csrfMetaTags />
    </jsp:attribute>
    <jsp:attribute name="body">
        <div class="page-title">
            <div class="container">
                <div class="column">
                    <h1>Login</h1>
                </div>
                <div class="column">
                    <ul class="breadcrumbs">
                        <li><a href="<c:url value='/'/>">Home</a>
                        </li>
                        <li class="separator">&nbsp;</li>
                        <li>Login</li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- Page Content-->
        <div class="container padding-bottom-2x mb-2">
            <div class="row">
                <div class="col-md-3">
                </div>
                <div class="col-md-6">
                    <c:url var="loginUrl" value="/login" />
                    <form class="login-box loginForm" action="${loginUrl}" method="post" >
                        <sec:csrfInput/>
                        <h4 class="margin-bottom-1x text-center">Login with your admin email</h4>
                        <div class="form-group input-group">
                            <input class="form-control" type="email" placeholder="Email" name="email" required=""><span class="input-group-addon"><i class="icon-mail"></i></span>
                        </div>
                        <div class="form-group input-group">
                            <input class="form-control" type="password" placeholder="Password" name="password" required=""><span class="input-group-addon"><i class="icon-lock"></i></span>
                        </div>
                        <div class="d-flex flex-wrap justify-content-between padding-bottom-1x">
                            <label class="custom-control custom-checkbox">
                                <input class="custom-control-input" type="checkbox" checked=""><span class="custom-control-indicator"></span><span class="custom-control-description">Remember me</span>
                            </label><a class="navi-link" href="account-password-recovery.html">Forgot password?</a>
                        </div>
                        <c:if test="${param.error != null}">
                            <div class="alert alert-danger error-div">
                                <span>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</span>
                            </div>
                        </c:if>
                        <div class="text-center text-sm-right">
                            <button class="btn btn-primary margin-bottom-none loginBtn" type="submit">Login</button>
                        </div>
                    </form>
                </div>
                <div class="col-md-3">
                </div>
            </div>
        </div>
    </jsp:attribute>

    <jsp:attribute name="js">
        <script>
            $('document').ready(function ()
            {
                $('.loginForm').on('submit', function (e) {
                    $('.loginBtn').lockBtn('');
                    $('.error-div').hide();
                });
            });
        </script>
    </jsp:attribute>
</t:master>
