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
        <title>Dianella Flowers | Cart</title>
        <sec:csrfMetaTags />
    </jsp:attribute>
    <jsp:attribute name="body">
        <!-- Page Title-->
        <div class="page-title">
            <div class="container">
                <div class="column">
                    <h1>Cart</h1>
                </div>
                <div class="column">
                    <ul class="breadcrumbs">
                        <li><a href="<c:url value='/'/>">Home</a>
                        </li>
                        <li class="separator">&nbsp;</li>
                        <li>Cart</li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- Page Content-->
        <div class="container padding-bottom-3x mb-1">
            <div class="checkout-steps">
                <a href="#">4. Success</a>
                <a href="#"><span class="angle"></span>3. Payment</a>
                <a href="#"><span class="angle"></span>2. Shipping</a>
                <a class="active" href="#"><span class="angle"></span>1. Cart</a>
            </div>
            <!-- Shopping Cart-->
            <div class="table-responsive shopping-cart">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Product Name</th>
                            <th class="text-center">Quantity</th>
                            <th class="text-center">Price / piece</th>
                            <th class="text-center">Old Price / piece</th>
                            <th class="text-center"><a class="btn btn-sm btn-outline-danger clearCart" href="#">Clear Cart</a></th>
                        </tr>
                    </thead>
                    <tbody class="cartBody">
                        <c:choose>
                            <c:when test="${fn:length(userCartItems) > 0}">
                                <c:forEach var="userCartItem" items="${userCartItems}">
                                    <tr class="carItem" data-cart-id="${userCartItem.getId()}">
                                        <td>
                                            <div class="product-item"><a class="product-thumb" href="#"><img src="<c:url value='${userCartItem.getBouquetID().getCompressedImagePath()}'/>" alt="${userCartItem.getBouquetID().getName()}"></a>
                                                <div class="product-info">
                                                    <h4 class="product-title"><a href="#">${userCartItem.getBouquetID().getName()}</a></h4>
                                                </div>
                                            </div>
                                        </td>
                                        <td class="text-center">
                                            <div class="count-input">
                                                <input class="form-control quantityId" name="cardID" type="hidden" value="${userCartItem.getId()}">
                                                <input class="form-control quantityItem" name="quantity" type="text" value="${userCartItem.getQuantity()}" placeholder="Quantity" required>
                                            </div>
                                        </td>
                                        <td class="text-center text-lg text-medium">$${userCartItem.getBouquetID().getPrice()}</td>
                                        <td class="text-center text-lg text-medium"><c:if test="${userCartItem.getBouquetID().getOldPrice() != null}"><del class="text-danger text-center" style="font-weight: 500; letter-spacing: .07em; text-transform: uppercase;">$${userCartItem.getBouquetID().getOldPrice()}</del></c:if><c:if test="${userCartItem.getBouquetID().getOldPrice() == null}">-</c:if></td>
                                        <td class="text-center"><a class="remove-from-cart remove-from-cart-btn" data-cart-id="${userCartItem.getId()}" href="#" data-toggle="tooltip" title="Remove item" data-cart-id="${userCartItem.getId()}"><i class="icon-cross"></i></a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="shopping-cart-footer">
                        <div class="column text-lg">Subtotal: <span class="text-medium totalCartPrice">$${userCartTotalPrice}</span></div>
                    </div>
                    <div class="shopping-cart-footer">
                        <div class="column"><a class="btn btn-outline-secondary" href="<c:url value='/'/>"><i class="icon-arrow-left"></i>&nbsp;Back to Shopping</a></div>
                        <div class="column">
                            <a class="btn btn-primary updateCart" href="#">Update Cart</a>
                            <a class="btn btn-success" href="<c:url value='/cart/shipping'/>">Continue</a>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <th colspan="5" class="text-center text-lg">
                        <br>
                        Cart is Empty
                    </th>
                </tbody>
            </table>
        </div>
    </c:otherwise>
</c:choose>

</div>
</jsp:attribute>
<jsp:attribute name="js">
    <script>
        $('document').ready(function () {
            $('body').on('click', '.updateCart', function (e) {
                e.preventDefault();
                var IDs = $('input:hidden.quantityId').serialize();
                var quantity = $('input:text.quantityItem').serialize();
                var currentBtn = $(this);
                var csrfObj = $.getCSRFObj();
                currentBtn.lockBtn('');
                var ajaxData = {
                    '_csrf': csrfObj.value
                };
                $.ajax({
                    url: '<c:url value="/cart/updateCart"/>?' + IDs + '&' + quantity,
                    data: ajaxData,
                    type: 'post',
                    success: function (data) {
                        if (data.statusCode == '0') {
                            location.reload();
                        } else {
                            $.handleAjaxRequest(data, null);
                        }
                    },
                    error: function (error) {
                    },
                    complete: function () {
                        currentBtn.unLockBtn();
                    }
                });
            });
        });
    </script>
</jsp:attribute>
</t:master>
