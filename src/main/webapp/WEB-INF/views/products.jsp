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
        <title>Dianella Flowers | Products</title>
        <sec:csrfMetaTags />
    </jsp:attribute>
    <jsp:attribute name="body">
        <div class="page-title">
            <div class="container">
                <div class="column">
                    <h1 style="text-transform: capitalize;">${category}</h1>
                </div>
                <div class="column">
                    <ul class="breadcrumbs">
                        <li><a href="<c:url value='/'/>">Home</a>
                        </li>
                        <li class="separator">&nbsp;</li>
                        <li style="text-transform: capitalize;">${category}</li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- Page Content-->
        <div class="container padding-bottom-3x mb-1">
            <div class="row">
                <!-- Products-->
                <div class="col-xl-12 col-lg-12 order-lg-2">
                    <!-- Shop Toolbar-->
                    <div class="shop-toolbar padding-bottom-1x mb-2">
                        <div class="column">
                            <div class="shop-sorting">
                                <label for="sorting">Sort by:</label>
                                <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                                <select class="form-control" id="sorting">
                                    <option value="1" data-order="asc" <c:if test="${order == '1'}">selected</c:if>>A - Z Order</option>
                                    <option value="2" data-order="desc" <c:if test="${order == '2'}">selected</c:if>>Z - A Order</option>
                                    <option value="3" data-order="asc" <c:if test="${order == '3'}">selected</c:if>>Low - High Price</option>
                                    <option value="4" data-order="desc" <c:if test="${order == '4'}">selected</c:if>>High - Low Price</option>
                                    </select><span class="text-muted">Showing:&nbsp;</span><span>12 items</span>
                                </div>
                            </div>
                        </div>
                        <!-- Products Grid-->
                        <div class="isotope-grid cols-4 mb-2">
                            <div class="gutter-sizer"></div>
                            <div class="grid-sizer"></div>
                        <c:choose>
                            <c:when test="${fn:length(bouquetList) > 0}">
                                <c:forEach var="bouquet" items="${bouquetList}">
                                    <div class="grid-item">
                                        <div class="product-card">
                                            <a class="product-thumb" data-lightbox="set" data-title="Click the right half of the image to move forward." href="<c:url value='/products/originalImage/${bouquet.getId()}'/>"><img src="<c:url value='/products/compressedImage/${bouquet.getId()}'/>" alt="Product"></a>
                                            <h3 class="product-title"><a href="shop-single.html">${bouquet.getName()}</a></h3>
                                            <h4 class="product-price">
                                                <c:if test="${bouquet.getOldPrice() != null}">
                                                    <del class="text-danger text-center" style="font-weight: 500; letter-spacing: .07em; text-transform: uppercase;">$${bouquet.getOldPrice()}</del>
                                                </c:if>
                                                $${bouquet.getPrice()}
                                            </h4>
                                            <div class="product-buttons">
                                                <button class="btn btn-outline-primary btn-sm add-to-cart-btn" data-bouquet-id="${bouquet.getId()}">Add to Cart</button>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <div class="no-campaigns-div"> 
                                    <div class="text-center"> 
                                        <span><strong>No Products found</strong></span> 
                                    </div> 
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
    </jsp:attribute>

    <jsp:attribute name="js">
        <script>
            $('body').on('change', '#sorting', function (e) {
                e.preventDefault();
                window.location.href = '<c:url value="/products/${category}"/>?orderBy=' + $(this).val();
            });
        </script>
    </jsp:attribute>
</t:master>
