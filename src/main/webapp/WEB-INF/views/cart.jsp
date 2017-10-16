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
            <!-- Shopping Cart-->
            <div class="table-responsive shopping-cart">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Product Name</th>
                            <th class="text-center">Quantity</th>
                            <th class="text-center">Subtotal</th>
                            <th class="text-center">Discount</th>
                            <th class="text-center"><a class="btn btn-sm btn-outline-danger" href="#">Clear Cart</a></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:choose>
                            <c:when test="${fn:length(userCartItems) > 0}">
                                <c:forEach var="userCartItem" items="${userCartItems}">
                                    <tr data-cart-id="${userCartItem.getId()}">
                                        <td>
                                            <div class="product-item"><a class="product-thumb" href="#"><img src="<c:url value='${bouquet.getCompressedImagePath()}'/>" alt="Product"></a>
                                                <div class="product-info">
                                                    <h4 class="product-title"><a href="#">${userCartItem.getBouquetID().getName()}</a></h4>
                                                </div>
                                            </div>
                                        </td>
                                        <td class="text-center">
                                            <div class="count-input">
                                                <select class="form-control">
                                                    <option>1</option>
                                                    <option>2</option>
                                                    <option>3</option>
                                                    <option>4</option>
                                                    <option>5</option>
                                                </select>
                                            </div>
                                        </td>
                                        <td class="text-center text-lg text-medium">$${userCartItem.getBouquetID().getPrice()}</td>
                                        <td class="text-center text-lg text-medium">$18.00</td>
                                        <td class="text-center"><a class="remove-from-cart" href="#" data-toggle="tooltip" title="Remove item" data-cart-id="${userCartItem.getId()}"><i class="icon-cross"></i></a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="shopping-cart-footer">
                        <div class="column">
                            <form class="coupon-form" method="post">
                                <input class="form-control form-control-sm" type="text" placeholder="Cart Text" required>
                                <button class="btn btn-outline-primary btn-sm" type="submit">Apply Text</button>
                            </form>
                        </div>
                        <div class="column text-lg">Subtotal: <span class="text-medium">$${userCartTotalPrice}</span></div>
                    </div>
                    <div class="shopping-cart-footer">
                        <div class="column"><a class="btn btn-outline-secondary" href="shop-grid-ls.html"><i class="icon-arrow-left"></i>&nbsp;Back to Shopping</a></div>
                        <div class="column"><a class="btn btn-primary" href="#" data-toast data-toast-type="success" data-toast-position="topRight" data-toast-icon="icon-circle-check" data-toast-title="Your cart" data-toast-message="is updated successfully!">Update Cart</a><a class="btn btn-success" href="checkout-address.html">Checkout</a></div>
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
<!--             Related Products Carousel
            <h3 class="text-center padding-top-2x mt-2 padding-bottom-1x">You May Also Like</h3>
             Carousel
            <div class="owl-carousel" data-owl-carousel="{ &quot;nav&quot;: false, &quot;dots&quot;: true, &quot;margin&quot;: 30, &quot;responsive&quot;: {&quot;0&quot;:{&quot;items&quot;:1},&quot;576&quot;:{&quot;items&quot;:2},&quot;768&quot;:{&quot;items&quot;:3},&quot;991&quot;:{&quot;items&quot;:4},&quot;1200&quot;:{&quot;items&quot;:4}} }">
                 Product
                <div class="grid-item">
                    <div class="product-card">
                        <div class="product-badge text-danger">22% Off</div><a class="product-thumb" href="shop-single.html"><img src="<c:url value='/assets/img/shop/products/09.jpg'/>" alt="Product"></a>
                        <h3 class="product-title"><a href="shop-single.html">Rocket Dog</a></h3>
                        <h4 class="product-price">
                            <del>$44.95</del>$34.99
                        </h4>
                        <div class="product-buttons">
                            <button class="btn btn-outline-secondary btn-sm btn-wishlist" data-toggle="tooltip" title="Whishlist"><i class="icon-heart"></i></button>
                            <button class="btn btn-outline-primary btn-sm" data-toast data-toast-type="success" data-toast-position="topRight" data-toast-icon="icon-circle-check" data-toast-title="Product" data-toast-message="successfuly added to cart!">Add to Cart</button>
                        </div>
                    </div>
                </div>
                 Product
                <div class="grid-item">
                    <div class="product-card">
                        <div class="rating-stars"><i class="icon-star filled"></i><i class="icon-star filled"></i><i class="icon-star filled"></i><i class="icon-star filled"></i><i class="icon-star"></i>
                        </div><a class="product-thumb" href="shop-single.html"><img src="<c:url value='/assets/img/shop/products/03.jpg'/>" alt="Product"></a>
                        <h3 class="product-title"><a href="shop-single.html">Oakley Kickback</a></h3>
                        <h4 class="product-price">$155.00</h4>
                        <div class="product-buttons">
                            <button class="btn btn-outline-secondary btn-sm btn-wishlist" data-toggle="tooltip" title="Whishlist"><i class="icon-heart"></i></button>
                            <button class="btn btn-outline-primary btn-sm" data-toast data-toast-type="success" data-toast-position="topRight" data-toast-icon="icon-circle-check" data-toast-title="Product" data-toast-message="successfuly added to cart!">Add to Cart</button>
                        </div>
                    </div>
                </div>
                 Product
                <div class="grid-item">
                    <div class="product-card"><a class="product-thumb" href="shop-single.html"><img src="<c:url value='/assets/img/shop/products/12.jpg'/>" alt="Product"></a>
                        <h3 class="product-title"><a href="shop-single.html">Vented Straw Fedora</a></h3>
                        <h4 class="product-price">$49.50</h4>
                        <div class="product-buttons">
                            <button class="btn btn-outline-secondary btn-sm btn-wishlist" data-toggle="tooltip" title="Whishlist"><i class="icon-heart"></i></button>
                            <button class="btn btn-outline-primary btn-sm" data-toast data-toast-type="success" data-toast-position="topRight" data-toast-icon="icon-circle-check" data-toast-title="Product" data-toast-message="successfuly added to cart!">Add to Cart</button>
                        </div>
                    </div>
                </div>
                 Product
                <div class="grid-item">
                    <div class="product-card">
                        <div class="rating-stars"><i class="icon-star filled"></i><i class="icon-star filled"></i><i class="icon-star filled"></i><i class="icon-star filled"></i><i class="icon-star filled"></i>
                        </div><a class="product-thumb" href="shop-single.html"><img src="<c:url value='/assets/img/shop/products/11.jpg'/>" alt="Product"></a>
                        <h3 class="product-title"><a href="shop-single.html">Top-Sider Fathom</a></h3>
                        <h4 class="product-price">$90.00</h4>
                        <div class="product-buttons">
                            <button class="btn btn-outline-secondary btn-sm btn-wishlist" data-toggle="tooltip" title="Whishlist"><i class="icon-heart"></i></button>
                            <button class="btn btn-outline-primary btn-sm" data-toast data-toast-type="success" data-toast-position="topRight" data-toast-icon="icon-circle-check" data-toast-title="Product" data-toast-message="successfuly added to cart!">Add to Cart</button>
                        </div>
                    </div>
                </div>
                 Product
                <div class="grid-item">
                    <div class="product-card"><a class="product-thumb" href="shop-single.html"><img src="<c:url value='/assets/img/shop/products/04.jpg'/>" alt="Product"></a>
                        <h3 class="product-title"><a href="shop-single.html">Waist Leather Belt</a></h3>
                        <h4 class="product-price">$47.00</h4>
                        <div class="product-buttons">
                            <button class="btn btn-outline-secondary btn-sm btn-wishlist" data-toggle="tooltip" title="Whishlist"><i class="icon-heart"></i></button>
                            <button class="btn btn-outline-primary btn-sm" data-toast data-toast-type="success" data-toast-position="topRight" data-toast-icon="icon-circle-check" data-toast-title="Product" data-toast-message="successfuly added to cart!">Add to Cart</button>
                        </div>
                    </div>
                </div>
                 Product
                <div class="grid-item">
                    <div class="product-card">
                        <div class="product-badge text-danger">50% Off</div><a class="product-thumb" href="shop-single.html"><img src="<c:url value='/assets/img/shop/products/01.jpg'/>" alt="Product"></a>
                        <h3 class="product-title"><a href="shop-single.html">Unionbay Park</a></h3>
                        <h4 class="product-price">
                            <del>$99.99</del>$49.99
                        </h4>
                        <div class="product-buttons">
                            <button class="btn btn-outline-secondary btn-sm btn-wishlist" data-toggle="tooltip" title="Whishlist"><i class="icon-heart"></i></button>
                            <button class="btn btn-outline-primary btn-sm" data-toast data-toast-type="success" data-toast-position="topRight" data-toast-icon="icon-circle-check" data-toast-title="Product" data-toast-message="successfuly added to cart!">Add to Cart</button>
                        </div>
                    </div>
                </div>
            </div>-->
</div>
</jsp:attribute>
<jsp:attribute name="js">
</jsp:attribute>
</t:master>
