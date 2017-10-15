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
        <title>Dianella Flowers | 404 Not Found</title>
        <link href="<c:url value='/assets/blueimp/css/blueimp-gallery.css'/>" rel="stylesheet" />
        <link href="<c:url value='/assets/blueimp/css/blueimp-gallery-indicator.css'/>" rel="stylesheet" />
        <sec:csrfMetaTags />
    </jsp:attribute>
    <jsp:attribute name="body">
        <h2>Lightbox image gallery</h2>
        <!-- The container for the list of example images -->
        <div id="links4" class="links">
            <a href="https://farm5.static.flickr.com/4465/37625953516_3e6627f06d_b.jpg" title="Shimmering Moods" data-gallery="">
                <img src="https://farm5.static.flickr.com/4465/37625953516_3e6627f06d_s.jpg">
            </a>
            <a href="https://farm5.static.flickr.com/4509/37678835831_c1724116b8_b.jpg" title="Red-Shouldered Hawk" data-gallery=""><img src="https://farm5.static.flickr.com/4509/37678835831_c1724116b8_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4488/23820065158_dae41de5db_b.jpg" title="Buzzard (Wild) - Claws to die for" data-gallery=""><img src="https://farm5.static.flickr.com/4488/23820065158_dae41de5db_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4514/36967515034_c57782d71b_b.jpg" title="Neist Point Sunrise" data-gallery=""><img src="https://farm5.static.flickr.com/4514/36967515034_c57782d71b_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4463/37635992902_a350c4289f_b.jpg" title="Through Steall" data-gallery=""><img src="https://farm5.static.flickr.com/4463/37635992902_a350c4289f_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4512/37619714526_c9f9cfe3df_b.jpg" title="male kingfisher alcedinidae" data-gallery=""><img src="https://farm5.static.flickr.com/4512/37619714526_c9f9cfe3df_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4465/37625953516_3e6627f06d_b.jpg" title="Shimmering Moods" data-gallery=""><img src="https://farm5.static.flickr.com/4465/37625953516_3e6627f06d_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4509/37678835831_c1724116b8_b.jpg" title="Red-Shouldered Hawk" data-gallery=""><img src="https://farm5.static.flickr.com/4509/37678835831_c1724116b8_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4488/23820065158_dae41de5db_b.jpg" title="Buzzard (Wild) - Claws to die for" data-gallery=""><img src="https://farm5.static.flickr.com/4488/23820065158_dae41de5db_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4514/36967515034_c57782d71b_b.jpg" title="Neist Point Sunrise" data-gallery=""><img src="https://farm5.static.flickr.com/4514/36967515034_c57782d71b_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4463/37635992902_a350c4289f_b.jpg" title="Through Steall" data-gallery=""><img src="https://farm5.static.flickr.com/4463/37635992902_a350c4289f_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4512/37619714526_c9f9cfe3df_b.jpg" title="male kingfisher alcedinidae" data-gallery=""><img src="https://farm5.static.flickr.com/4512/37619714526_c9f9cfe3df_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4465/37625953516_3e6627f06d_b.jpg" title="Shimmering Moods" data-gallery=""><img src="https://farm5.static.flickr.com/4465/37625953516_3e6627f06d_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4509/37678835831_c1724116b8_b.jpg" title="Red-Shouldered Hawk" data-gallery=""><img src="https://farm5.static.flickr.com/4509/37678835831_c1724116b8_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4488/23820065158_dae41de5db_b.jpg" title="Buzzard (Wild) - Claws to die for" data-gallery=""><img src="https://farm5.static.flickr.com/4488/23820065158_dae41de5db_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4514/36967515034_c57782d71b_b.jpg" title="Neist Point Sunrise" data-gallery=""><img src="https://farm5.static.flickr.com/4514/36967515034_c57782d71b_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4463/37635992902_a350c4289f_b.jpg" title="Through Steall" data-gallery=""><img src="https://farm5.static.flickr.com/4463/37635992902_a350c4289f_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4512/37619714526_c9f9cfe3df_b.jpg" title="male kingfisher alcedinidae" data-gallery=""><img src="https://farm5.static.flickr.com/4512/37619714526_c9f9cfe3df_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4465/37625953516_3e6627f06d_b.jpg" title="Shimmering Moods" data-gallery=""><img src="https://farm5.static.flickr.com/4465/37625953516_3e6627f06d_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4509/37678835831_c1724116b8_b.jpg" title="Red-Shouldered Hawk" data-gallery=""><img src="https://farm5.static.flickr.com/4509/37678835831_c1724116b8_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4488/23820065158_dae41de5db_b.jpg" title="Buzzard (Wild) - Claws to die for" data-gallery=""><img src="https://farm5.static.flickr.com/4488/23820065158_dae41de5db_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4514/36967515034_c57782d71b_b.jpg" title="Neist Point Sunrise" data-gallery=""><img src="https://farm5.static.flickr.com/4514/36967515034_c57782d71b_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4463/37635992902_a350c4289f_b.jpg" title="Through Steall" data-gallery=""><img src="https://farm5.static.flickr.com/4463/37635992902_a350c4289f_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4512/37619714526_c9f9cfe3df_b.jpg" title="male kingfisher alcedinidae" data-gallery=""><img src="https://farm5.static.flickr.com/4512/37619714526_c9f9cfe3df_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4465/37625953516_3e6627f06d_b.jpg" title="Shimmering Moods" data-gallery=""><img src="https://farm5.static.flickr.com/4465/37625953516_3e6627f06d_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4509/37678835831_c1724116b8_b.jpg" title="Red-Shouldered Hawk" data-gallery=""><img src="https://farm5.static.flickr.com/4509/37678835831_c1724116b8_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4488/23820065158_dae41de5db_b.jpg" title="Buzzard (Wild) - Claws to die for" data-gallery=""><img src="https://farm5.static.flickr.com/4488/23820065158_dae41de5db_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4514/36967515034_c57782d71b_b.jpg" title="Neist Point Sunrise" data-gallery=""><img src="https://farm5.static.flickr.com/4514/36967515034_c57782d71b_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4463/37635992902_a350c4289f_b.jpg" title="Through Steall" data-gallery=""><img src="https://farm5.static.flickr.com/4463/37635992902_a350c4289f_s.jpg"></a>
            <a href="https://farm5.static.flickr.com/4512/37619714526_c9f9cfe3df_b.jpg" title="male kingfisher alcedinidae" data-gallery=""><img src="https://farm5.static.flickr.com/4512/37619714526_c9f9cfe3df_s.jpg"></a>
        </div>
        <!-- The Gallery as lightbox dialog, should be a child element of the document body -->
        <div id="blueimp-gallery" class="blueimp-gallery">
            <div class="slides"></div>
            <h3 class="title"></h3>
            <a class="prev">‹</a>
            <a class="next">›</a>
            <a class="close">×</a>
            <a class="play-pause"></a>
            <ol class="indicator"></ol>
        </div>
    </jsp:attribute>

    <jsp:attribute name="js">
        <script src="<c:url value='/assets/blueimp/js/blueimp-helper.js'/>"></script>
        <script src="<c:url value='/assets/blueimp/js/blueimp-gallery.js'/>"></script>
        <script src="<c:url value='/assets/blueimp/js/blueimp-gallery-fullscreen.js'/>"></script>
        <script src="<c:url value='/assets/blueimp/js/blueimp-gallery-indicator.js'/>"></script>
        <script src="<c:url value='/assets/blueimp/js/jquery.blueimp-gallery.js'/>"></script>
    </jsp:attribute>
</t:master>
