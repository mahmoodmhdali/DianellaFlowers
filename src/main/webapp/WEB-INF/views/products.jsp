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
                    <h1>Products</h1>
                </div>
                <div class="column">
                    <ul class="breadcrumbs">
                        <li><a href="<c:url value='/'/>">Home</a>
                        </li>
                        <li class="separator">&nbsp;</li>
                        <li>Products</li>
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
                                <select class="form-control" id="sorting">
                                    <option>A - Z Order</option>
                                    <option>Z - A Order</option>
                                    <option>Low - High Price</option>
                                    <option>High - Low Price</option>
                                </select><span class="text-muted">Showing:&nbsp;</span><span>12 items</span>
                            </div>
                        </div>
                        <!--              <div class="column">
                                        <div class="shop-view">
                                            <a class="grid-view active" href="shop-grid-ls.html"><span></span><span></span><span></span></a>
                                            <a class="list-view" href="shop-list-ls.html"><span></span><span></span><span></span></a>
                                        </div>
                                      </div>-->
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
                                            <a class="product-thumb" data-lightbox="set" data-title="Click the right half of the image to move forward." href="<c:url value='/originalImage/${bouquet.getId()}'/>"><img src="<c:url value='/compressedImage/${bouquet.getId()}'/>" alt="Product"></a>
                                            <h3 class="product-title"><a href="shop-single.html">${bouquet.getName()}</a></h3>
                                            <h4 class="product-price">
                                                <c:if test="${bouquet.getPriceAfterSale() != null}">
                                                    <del class="text-danger text-center" style="font-weight: 500; letter-spacing: .07em; text-transform: uppercase;">$${bouquet.getPrice()}</del>$${bouquet.getPriceAfterSale()}
                                                </c:if>
                                                <c:if test="${bouquet.getPriceAfterSale() == null}">
                                                    $${bouquet.getPrice()}
                                                </c:if>
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
                    <!-- Pagination-->
                    <!--                    <nav class="pagination">
                                            <div class="column">
                                                <ul class="pages">
                                                    <li class="active"><a href="#">1</a></li>
                                                    <li><a href="#">2</a></li>
                                                    <li><a href="#">3</a></li>
                                                    <li><a href="#">4</a></li>
                                                    <li>...</li>
                                                    <li><a href="#">12</a></li>
                                                </ul>
                                            </div>
                                            <div class="column text-right hidden-xs-down"><a class="btn btn-outline-secondary btn-sm" href="#">Next&nbsp;<i class="icon-arrow-right"></i></a></div>
                                        </nav>-->
                </div>
                <!-- Sidebar          -->
                <!--                <div class="col-xl-3 col-lg-4 order-lg-1">
                                    <aside class="sidebar">
                                        <div class="padding-top-2x hidden-lg-up"></div>
                                         Widget Categories
                                        <section class="widget widget-categories">
                                            <h3 class="widget-title">Shop Categories</h3>
                                            <ul>
                                                <li class="has-children expanded"><a href="#">Shoes</a><span>(1138)</span>
                                                    <ul>
                                                        <li><a href="#">Women's</a><span>(508)</span>
                                                            <ul>
                                                                <li><a href="#">Sneakers</a></li>
                                                                <li><a href="#">Heels</a></li>
                                                                <li><a href="#">Loafers</a></li>
                                                                <li><a href="#">Sandals</a></li>
                                                            </ul>
                                                        </li>
                                                        <li><a href="#">Men's</a><span>(423)</span>
                                                            <ul>
                                                                <li><a href="#">Boots</a></li>
                                                                <li><a href="#">Oxfords</a></li>
                                                                <li><a href="#">Loafers</a></li>
                                                                <li><a href="#">Sandals</a></li>
                                                            </ul>
                                                        </li>
                                                        <li><a href="#">Boy's Shoes</a><span>(97)</span></li>
                                                        <li><a href="#">Girl's Shoes</a><span>(110)</span></li>
                                                    </ul>
                                                </li>
                                                <li class="has-children"><a href="#">Clothing</a><span>(2356)</span>
                                                    <ul>
                                                        <li><a href="#">Women's</a><span>(1032)</span>
                                                            <ul>
                                                                <li><a href="#">Dresses</a></li>
                                                                <li><a href="#">Shirts &amp; Tops</a></li>
                                                                <li><a href="#">Swimwear</a></li>
                                                                <li><a href="#">Shorts</a></li>
                                                            </ul>
                                                        </li>
                                                        <li><a href="#">Men's</a><span>(937)</span>
                                                            <ul>
                                                                <li><a href="#">Shirts &amp; Tops</a></li>
                                                                <li><a href="#">Shorts</a></li>
                                                                <li><a href="#">Swimwear</a></li>
                                                                <li><a href="#">Pants</a></li>
                                                            </ul>
                                                        </li>
                                                        <li><a href="#">Kid's Clothing</a><span>(386)</span></li>
                                                    </ul>
                                                </li>
                                                <li class="has-children"><a href="#">Bags</a><span>(420)</span>
                                                    <ul>
                                                        <li><a href="#">Handbags</a><span>(180)</span></li>
                                                        <li><a href="#">Backpacks</a><span>(132)</span></li>
                                                        <li><a href="#">Wallets &amp; Accessories</a><span>(47)</span></li>
                                                        <li><a href="#">Luggage</a><span>(61)</span></li>
                                                    </ul>
                                                </li>
                                                <li class="has-children"><a href="#">Accessories</a><span>(874)</span>
                                                    <ul>
                                                        <li><a href="#">Sunglasses</a><span>(211)</span></li>
                                                        <li><a href="#">Hats</a><span>(195)</span></li>
                                                        <li><a href="#">Watches</a><span>(159)</span></li>
                                                        <li><a href="#">Jewelry</a><span>(203)</span></li>
                                                        <li><a href="#">Belts</a><span>(106)</span></li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </section>
                                         Widget Price Range
                                        <section class="widget widget-categories">
                                            <h3 class="widget-title">Price Range</h3>
                                            <form class="price-range-slider" method="post" data-start-min="250" data-start-max="650" data-min="0" data-max="1000" data-step="1">
                                                <div class="ui-range-slider"></div>
                                                <footer class="ui-range-slider-footer">
                                                    <div class="column">
                                                        <button class="btn btn-outline-primary btn-sm" type="submit">Filter</button>
                                                    </div>
                                                    <div class="column">
                                                        <div class="ui-range-values">
                                                            <div class="ui-range-value-min">$<span></span>
                                                                <input type="hidden">
                                                            </div>&nbsp;-&nbsp;
                                                            <div class="ui-range-value-max">$<span></span>
                                                                <input type="hidden">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </footer>
                                            </form>
                                        </section>
                                         Widget Brand Filter
                                        <section class="widget">
                                            <h3 class="widget-title">Filter by Brand</h3>
                                            <label class="custom-control custom-checkbox d-block">
                                                <input class="custom-control-input" type="checkbox"><span class="custom-control-indicator"></span><span class="custom-control-description">Adidas&nbsp;<span class="text-muted">(254)</span></span>
                                            </label>
                                            <label class="custom-control custom-checkbox d-block">
                                                <input class="custom-control-input" type="checkbox"><span class="custom-control-indicator"></span><span class="custom-control-description">Bilabong&nbsp;<span class="text-muted">(39)</span></span>
                                            </label>
                                            <label class="custom-control custom-checkbox d-block">
                                                <input class="custom-control-input" type="checkbox"><span class="custom-control-indicator"></span><span class="custom-control-description">Calvin Klein&nbsp;<span class="text-muted">(128)</span></span>
                                            </label>
                                            <label class="custom-control custom-checkbox d-block">
                                                <input class="custom-control-input" type="checkbox"><span class="custom-control-indicator"></span><span class="custom-control-description">Nike&nbsp;<span class="text-muted">(310)</span></span>
                                            </label>
                                            <label class="custom-control custom-checkbox d-block">
                                                <input class="custom-control-input" type="checkbox"><span class="custom-control-indicator"></span><span class="custom-control-description">Tommy Bahama&nbsp;<span class="text-muted">(42)</span></span>
                                            </label>
                                        </section>
                                         Widget Size Filter
                                        <section class="widget">
                                            <h3 class="widget-title">Filter by Size</h3>
                                            <label class="custom-control custom-checkbox d-block">
                                                <input class="custom-control-input" type="checkbox"><span class="custom-control-indicator"></span><span class="custom-control-description">XL&nbsp;<span class="text-muted">(208)</span></span>
                                            </label>
                                            <label class="custom-control custom-checkbox d-block">
                                                <input class="custom-control-input" type="checkbox"><span class="custom-control-indicator"></span><span class="custom-control-description">L&nbsp;<span class="text-muted">(311)</span></span>
                                            </label>
                                            <label class="custom-control custom-checkbox d-block">
                                                <input class="custom-control-input" type="checkbox"><span class="custom-control-indicator"></span><span class="custom-control-description">M&nbsp;<span class="text-muted">(485)</span></span>
                                            </label>
                                            <label class="custom-control custom-checkbox d-block">
                                                <input class="custom-control-input" type="checkbox"><span class="custom-control-indicator"></span><span class="custom-control-description">S&nbsp;<span class="text-muted">(213)</span></span>
                                            </label>
                                        </section>
                                         Promo Banner
                                        <section class="promo-box" style="background-image: url(img/banners/02.jpg);">
                                             Choose between .overlay-dark (#000) or .overlay-light (#fff) with default opacity of 50%. You can overrride default color and opacity values via 'style' attribute.<span class="overlay-dark" style="opacity: .45;"></span>
                                            <div class="promo-box-content text-center padding-top-3x padding-bottom-2x">
                                                <h4 class="text-light text-thin text-shadow">New Collection of</h4>
                                                <h3 class="text-bold text-light text-shadow">Sunglassess</h3><a class="btn btn-sm btn-primary" href="#">Shop Now</a>
                                            </div>
                                        </section>
                                    </aside>
                                </div>-->
            </div>
        </div>
    </jsp:attribute>

    <jsp:attribute name="js">
    </jsp:attribute>
</t:master>
