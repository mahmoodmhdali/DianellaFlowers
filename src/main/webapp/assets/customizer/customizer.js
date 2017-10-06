﻿/*
 * Template Customizer
 * Copyright 2017 rokaux
 */
jQuery(document).ready(function (s) {
    "use strict";
    s(".customizer-toggle").on("click", function () {
        s(".customizer").toggleClass("open")
    }), s(".customizer-color-switch > a").on("click", function () {
        s(".customizer-color-switch > a").removeClass("active"), s(this).addClass("active"), s(".customizer-backdrop").addClass("active"), setTimeout(function () {
            s(".customizer-backdrop").removeClass("active")
        }, 1e3);
        var t = s(this).data("color"),
            o = s("#mainStyles").attr("href"),
            c = s(".site-logo > img").attr("src"),
            e = o.split("/"),
            a = c.split("/"),
            i = s(e).get(-1),
            n = s(a).get(-1);
        switch (t) {
            case "2ecc71":
                i = "styles-2ecc71.min.css", n = "logo-2ecc71.png";
                break;
            case "f39c12":
                i = "styles-f39c12.min.css", n = "logo-f39c12.png";
                break;
            case "e74c3c":
                i = "styles-e74c3c.min.css", n = "logo-e74c3c.png";
                break;
            default:
                i = "styles.min.css", n = "logo.png"
        }
        e.pop(), a.pop();
        var r = s.map(e, function (s, t) {
            var o = s;
            return o
        }).join("/"),
            l = s.map(a, function (s, t) {
                var o = s;
                return o
            }).join("/");
        o = r + "/" + i, c = l + "/" + n, s("#mainStyles").attr("href", o), s(".site-logo > img").attr("src", c)
    }), s("#header-option").on("change", function () {
        var t = s(this).find("option:selected").val(),
            o = s(".navbar"),
            c = s(".topbar").outerHeight(),
            e = o.outerHeight(),
            a = s("body");
        "static" === t ? (o.removeClass("navbar-stuck"), s(window).on("scroll", function () {
            s(this).scrollTop() > c && (o.removeClass("navbar-stuck"), a.css("padding-top", 0))
        })) : (o.addClass("navbar-stuck"), s(window).on("scroll", function () {
            s(this).scrollTop() > c ? (o.addClass("navbar-stuck"), a.css("padding-top", e)) : (o.removeClass("navbar-stuck"), a.css("padding-top", 0))
        }))
    })
});