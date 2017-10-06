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
        <title>Dianella Flowers | Home</title>
        <sec:csrfMetaTags />
    </jsp:attribute>
    <jsp:attribute name="body">
        <!-- Main Slider-->
        <section class="hero-slider">
            <div id="bootstrap-touch-slider" class="carousel bs-slider fade  control-round indicators-line" data-ride="carousel" data-pause="hover" data-interval="6000">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#bootstrap-touch-slider" data-slide-to="0" class="active"></li>
                    <li data-target="#bootstrap-touch-slider" data-slide-to="1"></li>
                    <li data-target="#bootstrap-touch-slider" data-slide-to="2"></li>
                </ol>
                <!-- Wrapper For Slides -->
                <div class="carousel-inner" role="listbox">
                    <!-- Third Slide -->
                    <div class="item active">
                        <!-- Slide Background -->
                                      
                        <img src="<c:url value='/assets/img/flowers/1.jpg'/>" alt="Bootstrap Touch Slider" class="slide-image">
                        <div class="bs-slider-overlay"></div>

                        <div class="container">
                            <div class="row">
                                <!-- Slide Text Layer -->
                                <div class="slide-text slide_style_left">
                                    <h1 data-animation="animated zoomInRight" class="">Something</h1>
                                    <p data-animation="animated fadeInLeft" class="">Something.</p>
                                    <a href="#" class="btn btn-primary" data-animation="animated fadeInLeft">select two</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End of Slide -->
                    <!-- Second Slide -->
                    <div class="item">
                        <!-- Slide Background -->
                        <img src="<c:url value='/assets/img/flowers/2.jpg'/>" alt="Bootstrap Touch Slider" class="slide-image">
                        <div class="bs-slider-overlay"></div>
                        <!-- Slide Text Layer -->
                        <div class="slide-text slide_style_center">
                            <h1 data-animation="animated flipInX">Something</h1>
                            <p data-animation="animated lightSpeedIn">Something.</p>
                            <a href="#" class="btn btn-primary" data-animation="animated fadeInDown">Something</a>
                        </div>
                    </div>
                    <!-- End of Slide -->
                    <!-- Third Slide -->
                    <div class="item">
                        <!-- Slide Background -->
                        <img src="<c:url value='/assets/img/flowers/3.jpg'/>" alt="Bootstrap Touch Slider" class="slide-image">
                        <div class="bs-slider-overlay"></div>
                        <!-- Slide Text Layer -->
                        <div class="slide-text slide_style_right">
                            <h1 data-animation="animated zoomInLeft">Something</h1>
                            <p data-animation="animated fadeInRight">Something .</p>
                            <a href="#" class="btn btn-primary" data-animation="animated fadeInRight">Something</a>
                        </div>
                    </div>
                    <!-- End of Slide -->
                </div>
                <!-- End of Wrapper For Slides -->
                <!-- Left Control -->
                <a class="left carousel-control" href="#bootstrap-touch-slider" role="button" data-slide="prev">
                    <span class="fa fa-angle-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <!-- Right Control -->
                <a class="right carousel-control" href="#bootstrap-touch-slider" role="button" data-slide="next">
                    <span class="fa fa-angle-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </section>
        <!-- Top Categories-->
        <section class="container padding-top-2x">
            <h3 class="text-center mb-30">Top Categories</h3>
            <div class="row">
                <div class="col-md-4 col-sm-6">
                    <div class="card mb-30">
                        <a class="card-img-tiles" href="#">
                            <div class="inner">
                                <div class="main-img">
                                    <img class="img-category-1" src="<c:url value='/assets/img/shop/categories/011.jpg'/>" alt="Category">
                                </div>
                                <div class="thumblist">
                                    <img class="img-category-2" src="<c:url value='/assets/img/shop/categories/022.jpg'/>" alt="Category">
                                    <img class="img-category-2" src="<c:url value='/assets/img/shop/categories/033.jpg'/>" alt="Category">
                                </div>
                            </div>
                        </a>
                        <div class="card-body text-center">
                            <h4 class="card-title">Something</h4>
                            <p class="text-muted">Starting from $49.99</p>
                            <a class="btn btn-outline-primary btn-sm" href="<c:url value='/products/wedding'/>">View Products</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6">
                    <div class="card mb-30">
                        <a class="card-img-tiles" href="#">
                            <div class="inner">
                                <div class="main-img">
                                    <img class="img-category-1" src="<c:url value='/assets/img/shop/categories/44.jpg'/>" alt="Category">
                                </div>
                                <div class="thumblist">
                                    <img class="img-category-2" src="<c:url value='/assets/img/shop/categories/55.jpg'/>" alt="Category">
                                    <img class="img-category-2" src="<c:url value='/assets/img/shop/categories/66.jpg'/>" alt="Category">
                                </div>
                            </div>
                        </a>
                        <div class="card-body text-center">
                            <h4 class="card-title">Something</h4>
                            <p class="text-muted">Starting from $56.00</p>
                            <a class="btn btn-outline-primary btn-sm" href="<c:url value='/products/wedding'/>">View Products</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6">
                    <div class="card mb-30">
                        <a class="card-img-tiles" href="#">
                            <div class="inner">
                                <div class="main-img">
                                    <img class="img-category-1" src="<c:url value='/assets/img/shop/categories/77.jpg'/>" alt="Category">
                                </div>
                                <div class="thumblist">
                                    <img class="img-category-2" src="<c:url value='/assets/img/shop/categories/88.jpg'/>" alt="Category">
                                    <img class="img-category-2" src="<c:url value='/assets/img/shop/categories/99.jpg'/>" alt="Category">
                                </div>
                            </div>
                        </a>
                        <div class="card-body text-center">
                            <h4 class="card-title">Something</h4>
                            <p class="text-muted">Starting from $27.00</p>
                            <a class="btn btn-outline-primary btn-sm" href="<c:url value='/products/wedding'/>">View Products</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="text-center"><a class="btn btn-outline-secondary margin-top-none" href="#">All Categories</a></div>
        </section>
        <!-- Promo #1-->
        <section class="container-fluid padding-top-1x">
            <div class="row justify-content-center">
                <div class="col-xl-5 col-lg-6 mb-30">
                    <div class="rounded bg-faded position-relative padding-top-3x padding-bottom-3x">
                        <span class="product-badge text-danger" style="top: 24px; left: 24px;">Limited Offer</span>
                        <div class="text-center">
                            <h3 class="h2 text-normal mb-1">New</h3>
                            <h2 class="display-2 text-bold mb-2">Something</h2>
                            <h4 class="h3 text-normal mb-4">collection at discounted price!</h4>
                            <div class="countdown mb-3" data-date-time="12/18/2017 06:00:00">
                                <div class="item">
                                    <div class="days">00</div>
                                    <span class="days_ref">Days</span>
                                </div>
                                <div class="item">
                                    <div class="hours">00</div>
                                    <span class="hours_ref">Hours</span>
                                </div>
                                <div class="item">
                                    <div class="minutes">00</div>
                                    <span class="minutes_ref">Mins</span>
                                </div>
                                <div class="item">
                                    <div class="seconds">00</div>
                                    <span class="seconds_ref">Secs</span>
                                </div>
                            </div>
                            <br>
                            <a class="btn btn-primary margin-bottom-none" href="#">View Offers</a>
                        </div>
                    </div>
                </div>
                <div class="col-xl-5 col-lg-6 mb-30" style="min-height: 270px;">
                    <div class="img-cover rounded" style="background-image: url(<c:url value='/assets/img/banners/home01.jpg'/>);"></div>
                </div>
            </div>
        </section>
        <!-- Promo #2-->
        <!--        <section class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-xl-10 col-lg-12">
                    <div class="fw-section rounded padding-top-4x padding-bottom-4x" style="background-image: url(img/banners/home02.jpg);">
                        <span class="overlay rounded" style="opacity: .35;"></span>
                        <div class="text-center">
                            <h3 class="display-4 text-normal text-white text-shadow mb-1">Old Collection</h3>
                            <h2 class="display-2 text-bold text-white text-shadow">HUGE SALE!</h2>
                            <h4 class="d-inline-block h2 text-normal text-white text-shadow border-default border-left-0 border-right-0 mb-4">at our outlet stores</h4>
                            <br>
                            <a class="btn btn-primary margin-bottom-none" href="#">Locate Stores</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>-->
        <!-- Featured Products Carousel-->
        <section class="container padding-top-1x padding-bottom-1x">
            <h3 class="text-center mb-30">Featured Products</h3>
            <div class="owl-carousel" data-owl-carousel="{ &quot;nav&quot;: false, &quot;dots&quot;: true, &quot;margin&quot;: 30, &quot;responsive&quot;: {&quot;0&quot;:{&quot;items&quot;:1},&quot;576&quot;:{&quot;items&quot;:2},&quot;768&quot;:{&quot;items&quot;:3},&quot;991&quot;:{&quot;items&quot;:4},&quot;1200&quot;:{&quot;items&quot;:4}} }">
                <!-- Product-->
                <div class="grid-item">
                    <div class="product-card">
                        <a class="product-thumb" href="#">
                            <img style="height: 168px" src="<c:url value='/assets/img/shop/products/011.jpg'/>" alt="Product"></a>
                        <h3 class="product-title"><a href="#">Something</a></h3>
                        <h4 class="product-price">
                            <del class="text-danger text-center" style="font-weight: 500; letter-spacing: .07em; text-transform: uppercase;">$99.99</del>$49.99
                        </h4>
                        <div class="product-buttons">
<!--                            <button class="btn btn-outline-secondary btn-sm btn-wishlist" data-toggle="tooltip" title="Whishlist"><i class="icon-heart"></i></button>-->
                            <button class="btn btn-outline-primary btn-sm add-to-cart-btn">Add to Cart</button>
                        </div>
                    </div>
                </div>
                <!-- Product-->
                <div class="grid-item">
                    <div class="product-card">
                        <!--                        <div class="rating-stars">
                            <i class="icon-star filled"></i><i class="icon-star filled"></i><i class="icon-star filled"></i><i class="icon-star filled"></i><i class="icon-star"></i>
                        </div>-->
                        <a class="product-thumb" href="#">
                            <img style="height: 168px" src="<c:url value='/assets/img/shop/products/022.jpg'/>" alt="Product"></a>
                        <div class="text-danger text-center" style="font-weight: 500; letter-spacing: .07em; text-transform: uppercase;"></div>
                        <h3 class="product-title"><a href="#">Something</a></h3>
                        <h4 class="product-price">$155.00</h4>
                        <div class="product-buttons">
<!--                            <button class="btn btn-outline-secondary btn-sm btn-wishlist" data-toggle="tooltip" title="Whishlist"><i class="icon-heart"></i></button>-->
                            <button class="btn btn-outline-primary btn-sm add-to-cart-btn">Add to Cart</button>
                        </div>
                    </div>
                </div>
                <!-- Product-->
                <div class="grid-item">
                    <div class="product-card">
                        <a class="product-thumb" href="#">
                            <img style="height: 168px" src="<c:url value='/assets/img/shop/products/033.jpg'/>" alt="Product"></a>
                        <h3 class="product-title"><a href="#">Something</a></h3>
                        <h4 class="product-price">$49.50</h4>
                        <div class="product-buttons">
<!--                            <button class="btn btn-outline-secondary btn-sm btn-wishlist" data-toggle="tooltip" title="Whishlist"><i class="icon-heart"></i></button>-->
                            <button class="btn btn-outline-primary btn-sm add-to-cart-btn">Add to Cart</button>
                        </div>
                    </div>
                </div>
                <!-- Product-->
                <div class="grid-item">
                    <div class="product-card">
                        <a class="product-thumb" href="#">
                            <img style="height: 168px" src="<c:url value='/assets/img/shop/products/044.jpg'/>" alt="Product"></a>
                        <h3 class="product-title"><a href="#">Something</a></h3>
                        <h4 class="product-price">$90.00</h4>
                        <div class="product-buttons">
<!--                            <button class="btn btn-outline-secondary btn-sm btn-wishlist" data-toggle="tooltip" title="Whishlist"><i class="icon-heart"></i></button>-->
                            <button class="btn btn-outline-primary btn-sm add-to-cart-btn">Add to Cart</button>
                        </div>
                    </div>
                </div>
                <!-- Product-->
                <div class="grid-item">
                    <div class="product-card">
                        <a class="product-thumb" href="#">
                            <img style="height: 168px" src="<c:url value='/assets/img/shop/products/055.jpg'/>" alt="Product"></a>
                        <h3 class="product-title"><a href="#">Something</a></h3>
                        <h4 class="product-price">$47.00</h4>
                        <div class="product-buttons">
<!--                            <button class="btn btn-outline-secondary btn-sm btn-wishlist" data-toggle="tooltip" title="Whishlist"><i class="icon-heart"></i></button>-->
                            <button class="btn btn-outline-primary btn-sm add-to-cart-btn">Add to Cart</button>
                        </div>
                    </div>
                </div>
                <!-- Product-->
                <div class="grid-item">
                    <div class="product-card">
                        <a class="product-thumb" href="#">
                            <img style="height: 168px" src="<c:url value='/assets/img/shop/products/066.jpg'/>" alt="Product"></a>
                        <h3 class="product-title"><a href="#">Something</a></h3>
                        <h4 class="product-price">
                            <del class="text-danger text-center" style="font-weight: 500; letter-spacing: .07em; text-transform: uppercase;">$99.99</del>$49.99
                        </h4>
                        <div class="product-buttons">
<!--                            <button class="btn btn-outline-secondary btn-sm btn-wishlist" data-toggle="tooltip" title="Whishlist"><i class="icon-heart"></i></button>-->
                            <button class="btn btn-outline-primary btn-sm add-to-cart-btn">Add to Cart</button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Product Widgets-->
        <section class="container">
            <div class="row">
                <div class="col-md-4 col-sm-6">
                    <div class="widget widget-featured-products">
                        <h3 class="widget-title">Top Sellers</h3>
                        <!-- Entry-->
                        <div class="entry">
                            <div class="entry-thumb">
                                <a href="#">
                                    <img src="<c:url value='/assets/img/shop/widget/01.jpg'/>" alt="Product"></a>
                            </div>
                            <div class="entry-content">
                                <h4 class="entry-title"><a href="#">Something</a></h4>
                                <span class="entry-meta">$155.00</span>
                            </div>
                        </div>
                        <!-- Entry-->
                        <div class="entry">
                            <div class="entry-thumb">
                                <a href="#">
                                    <img src="<c:url value='/assets/img/shop/widget/03.jpg'/>" alt="Product"></a>
                            </div>
                            <div class="entry-content">
                                <h4 class="entry-title"><a href="#">Something</a></h4>
                                <span class="entry-meta">$49.50</span>
                            </div>
                        </div>
                        <!-- Entry-->
                        <div class="entry">
                            <div class="entry-thumb">
                                <a href="#">
                                    <img src="<c:url value='/assets/img/shop/widget/04.jpg'/>" alt="Product"></a>
                            </div>
                            <div class="entry-content">
                                <h4 class="entry-title"><a href="#">Something</a></h4>
                                <span class="entry-meta">$29.99</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6">
                    <div class="widget widget-featured-products">
                        <h3 class="widget-title">New Arrivals</h3>
                        <!-- Entry-->
                        <div class="entry">
                            <div class="entry-thumb">
                                <a href="#">
                                    <img src="<c:url value='/assets/img/shop/widget/05.jpg'/>" alt="Product"></a>
                            </div>
                            <div class="entry-content">
                                <h4 class="entry-title"><a href="#">Something</a></h4>
                                <span class="entry-meta">$49.99</span>
                            </div>
                        </div>
                        <!-- Entry-->
                        <div class="entry">
                            <div class="entry-thumb">
                                <a href="#">
                                    <img src="<c:url value='/assets/img/shop/widget/06.jpg'/>" alt="Product"></a>
                            </div>
                            <div class="entry-content">
                                <h4 class="entry-title"><a href="#">Something</a></h4>
                                <span class="entry-meta">$200.00</span>
                            </div>
                        </div>
                        <!-- Entry-->
                        <div class="entry">
                            <div class="entry-thumb">
                                <a href="#">
                                    <img src="<c:url value='/assets/img/shop/widget/07.jpg'/>" alt="Product"></a>
                            </div>
                            <div class="entry-content">
                                <h4 class="entry-title"><a href="#">Something</a></h4>
                                <span class="entry-meta">$145.00</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6">
                    <div class="widget widget-featured-products">
                        <h3 class="widget-title">Best Rated</h3>
                        <!-- Entry-->
                        <div class="entry">
                            <div class="entry-thumb">
                                <a href="#">
                                    <img src="<c:url value='/assets/img/shop/widget/08.jpg'/>" alt="Product"></a>
                            </div>
                            <div class="entry-content">
                                <h4 class="entry-title"><a href="#">Something</a></h4>
                                <span class="entry-meta">$65.00</span>
                            </div>
                        </div>
                        <!-- Entry-->
                        <div class="entry">
                            <div class="entry-thumb">
                                <a href="#">
                                    <img src="<c:url value='/assets/img/shop/widget/09.jpg'/>" alt="Product"></a>
                            </div>
                            <div class="entry-content">
                                <h4 class="entry-title"><a href="#">Something</a></h4>
                                <span class="entry-meta">$36.99</span>
                            </div>
                        </div>
                        <!-- Entry-->
                        <div class="entry">
                            <div class="entry-thumb">
                                <a href="#">
                                    <img src="<c:url value='/assets/img/shop/widget/10.jpg'/>" alt="Product"></a>
                            </div>
                            <div class="entry-content">
                                <h4 class="entry-title"><a href="#">Something</a></h4>
                                <span class="entry-meta">$128.00</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Popular Brands-->
        <section class="bg-faded padding-top-2x padding-bottom-2x">
            <div class="container">
                <!--<h3 class="text-center mb-30 pb-2">Popular Flowers</h3>-->
                <div class="owl-carousel" data-owl-carousel="{ &quot;nav&quot;: false, &quot;dots&quot;: false, &quot;loop&quot;: true, &quot;autoplay&quot;: true, &quot;autoplayTimeout&quot;: 2000, &quot;responsive&quot;: {&quot;0&quot;:{&quot;items&quot;:2}, &quot;470&quot;:{&quot;items&quot;:3},&quot;630&quot;:{&quot;items&quot;:4},&quot;991&quot;:{&quot;items&quot;:5},&quot;1200&quot;:{&quot;items&quot;:6}} }">
                    <img class="d-block w-110 opacity-75 m-auto" style="height: 110px" src="<c:url value='/assets/img/brands/11.png'/>" alt="Flower">
                    <img class="d-block w-110 opacity-75 m-auto" style="height: 110px" src="<c:url value='/assets/img/brands/22.png'/>" alt="Flower">
                    <img class="d-block w-110 opacity-75 m-auto" style="height: 110px" src="<c:url value='/assets/img/brands/33.png'/>" alt="Flower">
                    <img class="d-block w-110 opacity-75 m-auto" style="height: 110px" src="<c:url value='/assets/img/brands/44.png'/>" alt="Flower">
                    <img class="d-block w-110 opacity-75 m-auto" style="height: 110px" src="<c:url value='/assets/img/brands/55.png'/>" alt="Flower">
                    <img class="d-block w-110 opacity-75 m-auto" style="height: 110px" src="<c:url value='/assets/img/brands/66.png'/>" alt="Flower">
                    <img class="d-block w-110 opacity-75 m-auto" style="height: 110px" src="<c:url value='/assets/img/brands/77.png'/>" alt="Flower">
                    <img class="d-block w-110 opacity-75 m-auto" style="height: 110px" src="<c:url value='/assets/img/brands/88.png'/>" alt="Flower">
                    <img class="d-block w-110 opacity-75 m-auto" style="height: 110px" src="<c:url value='/assets/img/brands/99.png'/>" alt="Flower">
                    <!--                    <img class="d-block w-110 opacity-75 m-auto" src="img/brands/66.png" alt="New Balance">
                    <img class="d-block w-110 opacity-75 m-auto" src="img/brands/77.png" alt="Dior">-->
                </div>
            </div>
        </section>
        <!-- Services-->
        <section class="container padding-top-2x padding-bottom-2x">
            <div class="row">
                <div class="col-md-4 col-sm-12 text-center mb-30">
                    <img class="d-block w-90 img-thumbnail rounded-circle mx-auto mb-3" src="<c:url value='/assets/img/services/02.png'/>" alt="Money Back">
                    <h6>Money Back Guarantee</h6>
                    <p class="text-muted margin-bottom-none">We return money within 30 days</p>
                </div>
                <div class="col-md-4 col-sm-12 text-center mb-30">
                    <img class="d-block w-90 img-thumbnail rounded-circle mx-auto mb-3" src="<c:url value='/assets/img/services/03.png'/>" alt="Support">
                    <h6>24/7 Customer Support</h6>
                    <p class="text-muted margin-bottom-none">Friendly 24/7 customer support</p>
                </div>
                <div class="col-md-4 col-sm-12 text-center mb-30">
                    <img class="d-block w-90 img-thumbnail rounded-circle mx-auto mb-3" src="<c:url value='/assets/img/services/04.png'/>" alt="Payment">
                    <h6>Secure Online Payment</h6>
                    <p class="text-muted margin-bottom-none">We posess SSL / Secure Certificate</p>
                </div>
            </div>
        </section>
    </jsp:attribute>

    <jsp:attribute name="js">

    </jsp:attribute>
</t:master>
