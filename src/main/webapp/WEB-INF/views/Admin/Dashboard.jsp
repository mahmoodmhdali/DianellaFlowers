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
        <title>Dianella Flowers | Customers' Order</title>
        <sec:csrfMetaTags />
    </jsp:attribute>
    <jsp:attribute name="body">
        <div class="page-title">
            <div class="container">
                <div class="column">
                    <h1>Customers' Order</h1>
                </div>
                <div class="column">
                    <ul class="breadcrumbs">
                        <li><a href="<c:url value='/'/>">Home</a>
                        </li>
                        <li class="separator">&nbsp;</li>
                        <li>Customers' Order</li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- Page Content-->
        <div class="container padding-bottom-2x mb-2">
            <div class="table-responsive">
                <table class="table table-hover margin-bottom-none">
                    <thead>
                        <tr>
                            <th>Track ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Phone Number</th>
                            <th>Shipping Date</th>
                            <th>Shipping Time</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:choose>
                            <c:when test="${fn:length(orders) > 0}">
                                <c:forEach var="order" items="${orders}">
                                    <tr>
                                        <td><a style="color: #a8328c" class="text-medium navi-link" href="<c:url value='/Admin/orderDetail/${order.getTrackId()}'/>">${order.getTrackId()}</a></td>
                                        <td>${order.getFirstName()}&nbsp;${order.getLastName()}</td>
                                        <td>${order.getEmail()}</td>
                                        <td>${order.getPhoneNumber()}</td>
                                        <td><fmt:formatDate type="date" pattern="MMM dd, yyyy" value="${order.getShippingDateTime()}" /></td>
                                        <c:if test="${order.getShippingTime() == '1'}"><td>Morning</td></c:if>
                                        <c:if test="${order.getShippingTime() == '2'}"><td>Afternoon</td></c:if>
                                        <c:if test="${order.getShippingTime() == '3'}"><td>Evening</td></c:if>
                                    </tr>
                                </c:forEach>
                            </c:when>
                        </c:choose>
                    </tbody>
                </table>
            </div>
        </div>
    </jsp:attribute>

    <jsp:attribute name="js">

    </jsp:attribute>
</t:master>
