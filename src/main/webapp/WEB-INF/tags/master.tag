<%@tag description="Dianella Flowers master page" pageEncoding="UTF-8"%>
<%@attribute name="css" fragment="true" %>
<%@attribute name="body" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="js" fragment="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <!-- SEO Meta Tags-->
        <meta name="description" content="Unishop - Universal E-Commerce Template">
        <meta name="keywords" content="shop, e-commerce, modern, flat style, responsive, online store, business, mobile, blog, bootstrap 4, html5, css3, jquery, js, gallery, slider, touch, creative, clean">
        <meta name="author" content="Rokaux">
        <!-- Mobile Specific Meta Tag-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <!-- Favicon and Apple Icons-->
        <link rel="icon" href="<c:url value='/assets/img/logo/logo2.png'/>">
        <!-- Bootstrap-->
        <link href="<c:url value='/assets/css/bootstrap.css'/>" rel="stylesheet" />
        <!-- Font Awesome-->
        <link href="<c:url value='/assets/css/font-awesome.min.css'/>" rel="stylesheet" />
        <!-- Vendor Styles including: Bootstrap, Font Icons, Plugins, etc.-->
        <link rel="stylesheet" media="screen" href="<c:url value='/assets/css/vendor.min.css'/>">
        <!-- Main Template Styles-->
        <link id="mainStyles" rel="stylesheet" media="screen" href="<c:url value='/assets/css/styles.css'/>">
        <!-- Customizer Styles-->
        <link rel="stylesheet" media="screen" href="<c:url value='/assets/customizer/customizer.min.css'/>">
        <!-- Animate css-->
        <link href="<c:url value='/assets/css/animate.css'/>" rel="stylesheet" />
        <!-- touch slider-->
        <link href="<c:url value='/assets/css/bootstrap-touch-slider.css'/>" rel="stylesheet" />
        <!-- Custom Updates-->
        <link href="<c:url value='/assets/css/CustomUpdated.css'/>" rel="stylesheet" />
        <!-- LightBox-->
        <link href="<c:url value='/assets/lightbox2/css/lightbox.css'/>" rel="stylesheet" />
        <jsp:invoke fragment="css"/>
        <style>
            .successStyle{
                border-color: #43d9a3 !important;
            }
            .successStyle:hover{
                border-color: #43d9a3 !important;
            }
            .notFound{
                display: inline-block;
                margin-left: 5px;
                padding: 5px 0;
                color: #9da9b9;
                font-size: 14px;
                cursor: default;
                vertical-align: middle;
            }
        </style>
    </head>
    <body>
        <!-- Off-Canvas Mobile Menu-->
        <div class="offcanvas-container" id="mobile-menu">
            <nav class="offcanvas-menu">
                <ul class="menu">
                    <li class="active homeLi"><a href="<c:url value='/'/>"><span>Home</span></a>
                    </li>
                    <li class="categoriesLi has-children"><span><a href="#">Categories</a><span class="sub-menu-toggle"></span></span>
                        <ul class="offcanvas-submenu">
                            <li><a href="<c:url value='/products/wedding'/>">Wedding</a></li>
                            <li><a href="<c:url value='/products/valentine'/>">Valentine</a></li>
                            <li><a href="<c:url value='/products/other'/>">Other</a></li>
                        </ul>
                    </li>
                    <li class="has-children"><span><a href="#">Something</a><span class="sub-menu-toggle"></span></span>
                        <ul class="offcanvas-submenu">
                            <li><a href="#">Sub Something</a></li>
                            <li><a href="#">Sub Something</a></li>
                            <li><a href="#">Sub Something</a></li>
                            <li><a href="#">Sub Something</a></li>
                            <li><a href="#">Sub Something</a></li>
                            <li><a href="#">Sub Something</a></li>
                        </ul>
                    </li>
                    <li class="contactUsLi"><a href="<c:url value='/contactUs'/>"><span>Contact Us</span></a>
                    </li>
                    <li class="aboutUsLi"><a href="<c:url value='/aboutUs'/>"><span>About Us</span></a>
                    </li>
                </ul>
            </nav>
        </div>
        <!-- Topbar-->
        <div class="topbar">
            <div class="topbar-column">
                <a class="hidden-md-down" style="color: white" href="mailto:dianellaflowers@gmail.com"><i class="icon-mail"></i>&nbsp; dianellaflowers@gmail.com</a><a class="hidden-md-down" style="color: white" href="tel:0096170880252"><i class="fa fa-phone"></i>&nbsp; +961 70 880 252</a><a class="social-button sb-facebook shape-none" style="color: white" href="#" target="_blank"><i class="socicon-facebook"></i></a><a class="social-button sb-twitter shape-none sb-dark" style="color: white" href="#" target="_blank"><i class="socicon-twitter"></i></a><a class="social-button sb-instagram shape-none sb-dark" style="color: white" href="#" target="_blank"><i class="socicon-instagram"></i></a><a class="social-button sb-pinterest shape-none sb-dark" style="color: white" href="#" target="_blank"><i class="socicon-pinterest"></i></a>
            </div>
        </div>
        <!-- Navbar-->
        <!-- Remove ".navbar-sticky" class to make navigation bar scrollable with the page.-->
        <header class="navbar navbar-sticky headerUpdate">
            <!-- Search-->
            <div class="site-branding">
                <div class="inner">
                    <!-- Off-Canvas Toggle (#shop-categories)-->
                    <!-- Off-Canvas Toggle (#mobile-menu)-->
                    <a class="offcanvas-toggle menu-toggle" href="#mobile-menu" data-toggle="offcanvas"></a>
                    <!-- Site Logo-->
                    <a class="site-logo" href="#">
                        <img src="<c:url value='/assets/img/logo/logo2.png'/>" alt="Dianella Flowers"></a>
                </div>
            </div>
            <!-- Main Navigation-->
            <nav class="site-menu">
                <ul>
                    <li class="homeLi"><a href="<c:url value='/'/>"><span>Home</span></a>
                    </li>
                    <li class="categoriesLi"><a href="#"><span>Categories</span></a>
                        <ul class="sub-menu">
                            <li><a href="<c:url value='/products/wedding'/>">Wedding</a></li>
                            <li><a href="<c:url value='/products/valentine'/>">Valentine</a></li>
                            <li><a href="<c:url value='/products/other'/>">Other</a></li>
                        </ul>
                    </li>
                    <li><a href="#"><span>Something</span></a>
                        <ul class="sub-menu">
                            <li><a href="#">Sub Something</a></li>
                            <li><a href="#">Sub Something</a></li>
                            <li><a href="#">Sub Something</a></li>
                            <li><a href="#">Sub Something</a></li>
                            <li><a href="#">Sub Something</a></li>
                            <li><a href="#">Sub Something</a></li>
                        </ul>
                    </li>
                    <li class="contactUsLi"><a href="<c:url value='/contactUs'/>"><span>Contact Us</span></a>
                    </li>
                    <li class="aboutUsLi"><a href="<c:url value='/aboutUs'/>"><span>About Us</span></a>
                    </li>
                </ul>
            </nav>
            <!-- Toolbar-->
            <div class="toolbar">
                <div class="inner">
                    <div class="tools">
                        <div class="cart cartDataDiv">
                            <a href="#"></a><i class="icon-bag"></i><span class="count countCart">${fn:length(userCartItems)}</span><span class="subtotal totalCart1">$${userCartTotalPrice}</span>
                                <c:choose>
                                    <c:when test="${fn:length(userCartItems) > 0}">
                                    <div class="toolbar-dropdown cartData">
                                        <c:forEach var="userCartItem" items="${userCartItems}">
                                            <div class="dropdown-product-item" data-cart-id="${userCartItem.getId()}">
                                                <span class="dropdown-product-remove remove-from-cart-btn" data-cart-id="${userCartItem.getId()}"><i class="icon-cross"></i></span>
                                                <a class="dropdown-product-thumb" href="#">
                                                    <img src="<c:url value='/products/cardImage/${userCartItem.getBouquetID().getId()}'/>" alt="Product">
                                                </a>
                                                <div class="dropdown-product-info"><a class="dropdown-product-title" href="#">${userCartItem.getBouquetID().getName()}</a><span class="dropdown-product-details">$${userCartItem.getBouquetID().getPrice()}</span></div>
                                            </div>
                                        </c:forEach>
                                        <div class="toolbar-dropdown-group">
                                            <div class="column"><span class="text-lg">Total:</span></div>
                                            <div class="column text-right"><span class="text-lg text-medium totalCart">$${userCartTotalPrice}</span></div>
                                        </div>
                                        <div class="toolbar-dropdown-group">
                                            <div class="column"><a class="btn btn-sm btn-block btn-secondary" href="<c:url value='/cart'/>">View Cart</a></div>
                                            <div class="column"><a class="btn btn-sm btn-block btn-primary" href="#">Checkout</a></div>
                                        </div>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="toolbar-dropdown noCartFoundDiv">
                                        <div class="toolbar-dropdown-group notFound text-center">
                                            Cart is Empty
                                        </div>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <!-- Off-Canvas Wrapper-->
        <div class="offcanvas-wrapper">
            <!-- page content -->
            <jsp:invoke fragment="body"/>
            <!-- /page content -->
            <!-- Site Footer-->
            <footer class="site-footer">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4 col-md-12">
                            <!-- Contact Info-->
                            <section class="widget widget-light-skin">
                                <h3 class="widget-title">Get In Touch With Us</h3>
                                <p class="text-white">Phone: (961) 70 880 252</p>
                                <ul class="list-unstyled text-sm text-white">
                                    <li><span class="opacity-50">Monday-Friday:</span>9.00 am - 8.00 pm</li>
                                    <li><span class="opacity-50">Saturday:</span>10.00 am - 6.00 pm</li>
                                </ul>
                                <p><a class="navi-link-light" href="mailto:dianellaflowers@gmail.com">dianellaflowers@gmail.com</a></p>
                                <a class="social-button shape-circle sb-facebook sb-light-skin" href="#"><i class="socicon-facebook"></i></a><a class="social-button shape-circle sb-twitter sb-light-skin" href="#"><i class="socicon-twitter"></i></a><a class="social-button shape-circle sb-instagram sb-light-skin" href="#"><i class="socicon-instagram"></i></a><a class="social-button shape-circle sb-google-plus sb-light-skin" href="#"><i class="socicon-googleplus"></i></a>
                            </section>
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <!-- About Us-->
                            <section class="widget widget-links widget-light-skin">
                                <h3 class="widget-title">About Us</h3>
                                <ul>
                                    <li><a href="#">Careers</a></li>
                                    <li><a href="#">About flowers</a></li>
                                    <li><a href="#">Our Story</a></li>
                                    <li><a href="#">Services</a></li>
                                </ul>
                            </section>
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <!-- Account / Shipping Info-->
                            <section class="widget widget-links widget-light-skin">
                                <h3 class="widget-title">Something</h3>
                                <ul>
                                    <li><a href="#">Sub Something</a></li>
                                    <li><a href="#">Sub Something</a></li>
                                    <li><a href="#">Sub Something</a></li>
                                    <li><a href="#">Sub Something</a></li>
                                    <li><a href="#">Sub Something</a></li>
                                    <li><a href="#">Sub Something</a></li>
                                </ul>
                            </section>
                        </div>
                    </div>
                    <hr class="hr-light mt-2 margin-bottom-2x">
                    <div class="row">
                        <div class="col-md-7 padding-bottom-1x">
                            <!-- Payment Methods-->
                            <div class="margin-bottom-1x" style="max-width: 615px;">
                                <img src="<c:url value='/assets/img/payment_methods1.png'/>" alt="Payment Methods">
                            </div>
                        </div>
                        <div class="col-md-5 padding-bottom-1x">
                            <div class="margin-top-1x hidden-md-up"></div>
                            <!--Subscription-->
                            <form class="subscribe-form">
                                <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                                <div class="clearfix">
                                    <div class="input-group input-light">
                                        <input class="form-control" type="text" name="email" autocomplete="off" placeholder="Your e-mail">
                                        <span class="input-group-addon"><i class="icon-mail"></i></span>
                                    </div>
                                    <button class="btn btn-primary submit-form-btn" type="submit"><i class="icon-check"></i></button>
                                </div>
                                <span class="form-text text-sm text-white opacity-50">Subscribe to our Newsletter to receive early discount offers, latest news, sales and promo information.</span>
                            </form>
                        </div>
                    </div>
                    <!-- Copyright-->
                    <p class="footer-copyright">© All rights reserved. Made with&nbsp;<i class="icon-heart" style="color: #a8328c"></i>&nbsp;by<a href="mailto:mahmoudmhdali@gmail.com" target="_blank">&nbsp;Mahmoud Mohamed Ali</a></p>
                </div>
            </footer>
        </div>
        <!-- Back To Top Button-->
        <a class="scroll-to-top-btn" href="#"><i class="icon-arrow-up"></i></a>
        <!-- Backdrop-->
        <div class="site-backdrop"></div>
        <!-- JavaScript (jQuery) libraries, plugins and custom scripts-->
        <script src="<c:url value='/assets/js/vendor.min.js'/>"></script>
        <script src="<c:url value='/assets/js/scripts.js'/>"></script>

        <script src="<c:url value='/assets/js/jquery3-2-1.min.js'/>"></script>
        <script src="<c:url value='/assets/js/bootstrap.min.js'/>"></script>
        <script src="<c:url value='/assets/js/bootstrap-touch-slider.js'/>"></script>
        <script src="<c:url value='/assets/js/main.js'/>"></script>
        <!-- Modernizr-->
        <script src="<c:url value='/assets/js/modernizr.min.js'/>"></script>
        <!-- Customizer scripts-->
        <script src="<c:url value='/assets/customizer/customizer.js'/>"></script>
        <script src="<c:url value='/assets/js/custom.js'/>"></script>
        <!-- LightBox-->
        <script src="<c:url value='/assets/lightbox2/js/lightbox.js'/>"></script>
        <jsp:invoke fragment="js"/>
        <script>
            $('document').ready(function () {

                $('.carousel-indicators').addClass('text-center');

                var URLPath = window.location.pathname.toLowerCase();
                if (URLPath.indexOf('aboutus') >= 0) {
                    $('.aboutUsLi').addClass('active');
                } else if (URLPath.indexOf('contactus') >= 0) {
                    $('.contactUsLi').addClass('active');
                } else if (URLPath.indexOf('products') >= 0) {
                    $('.categoriesLi').addClass('active');
                } else {
                    $('.homeLi').addClass('active');
                }
                $('.subscribe-form').on('submit', function (e)
                {
                    e.preventDefault();
                    $('.submit-form-btn').lockBtn('');
                    $.ajax({
                        url: '<c:url value="/addNewSubscription"/>',
                        type: 'post',
                        data: $(this).serialize(),
                        success: function (data) {
                            if (data.statusCode == '0')
                            {
                                $('.subscribe-form').HandleFormSuccess('email');
                                $('.subscribe-form').find('[name=email]').addClass('successStyle');
                                $('.subscribe-form').find('.input-group-addon').css('top', '33%');
                                $('.subscribe-form')[0].reset();
                            } else if (data.statusCode == '1')
                            {
                                $.notify('danger', 'Error', 'Not well formated email address.', 'topRight');
                            } else {
                                $.handleAjaxRequest(data, $('.subscribe-form'));
                            }
                        },
                        error: function (error) {
                            $.notify('danger', 'Error', 'Internal server error!.', 'topRight');
                        },
                        complete: function () {
                            $('.submit-form-btn').unLockBtn();
                        }
                    });
                });

                $('.subscribe-form').find('[name=email]').focusin(function () {
                    $(this).parent().removeClass('has-success');
                    $('.form-control-feedback').remove();
                    $(this).removeClass('form-control-success');
                    $(this).removeClass('successStyle');
                    $('.subscribe-form').find('.input-group-addon').css('top', '50%');
                });

                $('body').on('click', '.add-to-cart-btn', function () {
                    var currentBtn = $(this);
                    var bouquetId = currentBtn.attr("data-bouquet-id");
                    var csrfObj = $.getCSRFObj();
                    currentBtn.lockBtn('');
                    var ajaxData = {
                        'id': bouquetId,
                        '_csrf': csrfObj.value
                    };
                    $.ajax({
                        url: '<c:url value="/cart/add"/>',
                        data: ajaxData,
                        type: 'post',
                        success: function (data) {
                            $.notify('success', 'Success', 'Product added successfully to your cart', 'topRight')
                            var bouquetData = $.parseJSON(data.responseObject);
                            $('.countCart').html(Number($('.countCart').html()) + 1);
                            $('.totalCart1').html('$' + (data.statusMessage).split("-")[1]);
                            if ($('.cartData').length == 0) {
                                $('.noCartFoundDiv').remove();
                                $('.cartDataDiv').append('<div class="toolbar-dropdown cartData"><div class="dropdown-product-item" data-cart-id="' + (data.statusMessage).split("-")[0] + '">\n\
                                                        <span class="dropdown-product-remove remove-from-cart-btn" data-cart-id="' + (data.statusMessage).split("-")[0] + '">\n\
                                                        <i class="icon-cross"></i></span>\n\
                                                        <a class="dropdown-product-thumb" href="#"><img src="<c:url value='/products/cardImage/'/> ' + bouquetData.id + '" alt="Product">\n\
                                                        </a><div class="dropdown-product-info"><a class="dropdown-product-title" href="#">' + bouquetData.name + '</a>\n\
                                                        <span class="dropdown-product-details">$' + bouquetData.price + '</span></div></div>\n\
                                                        <div class="toolbar-dropdown-group">\n\
                                                            <div class="column"><span class="text-lg">Total:</span></div>\n\
                                                            <div class="column text-right"><span class="text-lg text-medium totalCart">$' + bouquetData.price + '</span></div>\n\
                                                        </div>\n\
                                                        <div class="toolbar-dropdown-group">\n\
                                                            <div class="column"><a class="btn btn-sm btn-block btn-secondary" href="<c:url value='/cart'/>">View Cart</a></div>\n\
                                                            <div class="column"><a class="btn btn-sm btn-block btn-primary" href="#">Checkout</a></div>\n\
                                                        </div>\n\
                                                        </div>');
                            } else {
                                $('.totalCart').html('$' + (data.statusMessage).split("-")[1]);
                                $('.cartData').prepend('<div class="dropdown-product-item" data-cart-id="' + (data.statusMessage).split("-")[0] + '"><span class="dropdown-product-remove remove-from-cart-btn" data-cart-id="' + (data.statusMessage).split("-")[0] + '"><i class="icon-cross"></i></span><a class="dropdown-product-thumb" href="#"><img src="<c:url value='/products/cardImage/'/> ' + bouquetData.id + '" alt="Product"></a><div class="dropdown-product-info"><a class="dropdown-product-title" href="#">' + bouquetData.name + '</a><span class="dropdown-product-details">$' + bouquetData.price + '</span></div></div>');
                            }
                        },
                        error: function (error) {
                        },
                        complete: function () {
                            currentBtn.unLockBtn();
                        }
                    });
                });

                $('body').on('click', '.remove-from-cart-btn', function (e) {
                    e.preventDefault();
                    console.log('asdasfasfasfa');
                    var currentBtn = $(this);
                    var cartId = currentBtn.attr("data-cart-id");
                    var userCartDiv = $('div[data-cart-id="' + cartId + '"]');
                    var csrfObj = $.getCSRFObj();
                    currentBtn.lockBtn('');
                    console.log(cartId);
                    var ajaxData = {
                        'id': cartId,
                        '_csrf': csrfObj.value
                    };
                    $.ajax({
                        url: '<c:url value="/cart/remove"/>',
                        data: ajaxData,
                        type: 'post',
                        success: function (data) {
                            console.log(data);
                            $.notify('success', 'Success', 'Product removed successfully from your cart', 'topRight');
                            $('.countCart').html(Number($('.countCart').html()) - 1);
                            userCartDiv.remove();
                            if ($('.dropdown-product-item').length == 0) {
                                $('.totalCart1').html('$0.0');
                                $('.cartData').replaceWith('<div class="toolbar-dropdown noCartFoundDiv">\n\
                                        <div class="toolbar-dropdown-group notFound text-center">\n\
                                            Cart is Empty\n\
                                        </div>\n\
                                    </div>');
                            } else {
                                $('.totalCart1').html('$' + data.responseObject);
                                $('.totalCart').html('$' + data.responseObject);
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
    </body>
</html>
