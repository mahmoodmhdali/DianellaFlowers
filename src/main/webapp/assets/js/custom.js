(function ($) {
    //this method to lock a btn
    $.fn.lockBtn = function (lockText, faSize) {
        return $(this).each(function () {
            $(this).attr('disabled', 'disabled');
            $(this).attr('data-old-text', $(this).html());
            var i = typeof faSize != typeof undefined ? faSize : '';
            i = '<i class="fa  fa-refresh fa-pulse fa-fw ' + i + '"></i>';
            $(this).html(lockText + ' ' + i);
        });
    };
    //this method to unlock a btn
    $.fn.unLockBtn = function () {
        return $(this).each(function () {
            $(this).removeAttr('disabled');
            $(this).html($(this).attr('data-old-text'));
            $(this).removeAttr('data-old-text');
        });
    };
    $.fn.serializeObject = function ()
    {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name] !== undefined) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };
    $.fn.HandleFormErrors = function (errors) {
        var currentForm = this;
        $('.validation-error').remove();
        $.each(errors.responseObject, function (index, element) {
            console.log(index + '====' + element);
            var currentInput = $(currentForm).find('[name=' + index + ']');
            if (currentInput.length > 0) {
                currentInput.addClass('parsley-error');
                currentInput.after('<span class="validation-error text-danger validationSpanError" id="' + index + '">' + element + '</span>');
            } else {
                currentInput = $(currentForm).find('[data-error-index=' + index + ']');
                if (currentInput.length > 0) {
                    currentInput.addClass('parsley-error');
                    currentInput.after('<span class="validation-error text-danger validationSpanError" id="' + index + '">' + element + '</span>');
                }
            }
        });
    };
    $.fn.HandleFormSuccess = function (index) {
        var currentForm = this;
        var currentInput = $(currentForm).find('[name=' + index + ']');
        if (currentInput.length > 0) {
            currentInput.parent().addClass('has-success');
            currentInput.after('<div class="form-control-feedback">Success! You\'ve done it.</div>');
            currentInput.addClass('form-control-success');
        }
    };

    $.handleAjaxRequest = function (response, formToHandle) {
        console.log(response);
        if (response.statusCode === 1) {
            formToHandle.HandleFormErrors(response);
        } else if (response.statusCode === 2) {
            $.notify('warning', 'Warning', response.statusMessage, 'topRight');
        } else if (response.statusCode === 3) {
            $.notify('error', 'Error', response.statusMessage, 'topRight');
        }
    }

    $.getCSRFObj = function () {
        if ($('meta[name=_csrf_parameter]').length > 0) {
            return {
                name: $('meta[name=_csrf_parameter]').attr('content'),
                value: $('meta[name=_csrf]').attr('content')
            }
        }
    }

    $.getAlert = function (type, message) {
        var alert = '<div class="alert alert-' + type + ' alert-dismissable fade in">\n\
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>\n\
                        ' + message + '\n\
                      </div>';
        return alert;
    }

    $.parseJSON = function (jsonMessage) {
        var returnedData = jsonMessage.replace(/\n/g, "\\n")
                .replace(/\r/g, "\\r")
                .replace(/\t/g, "\\t")
                .replace(/\f/g, "\\f");
        return JSON.parse(returnedData);
    }


    $.notify = function (type, title, message, position) {
        var icon = 'check';
        if (type == 'danger') {
            icon = 'cross';
        }
        iziToast.show({
            title: title,
            class: 'iziToast-' + type, //iziToast-warning     iziToast-danger       iziToast-success
            //titleColor: 'black',
            //titleSize: '',
            message: message,
            //messageColor: 'black',
            //messageSize: '',
            //backgroundColor: '',
            icon: 'icon-circle-' + icon,
            //iconText: '',
            //iconColor: '',
            //image: '',
            //imageWidth: 50,
            maxWidth: null,
            zindex: null,
            layout: 1,
            //balloon: false,
            close: true,
            rtl: false,
            position: position, // bottomRight, bottomLeft, , topLeft, topCenter, bottomCenter, center
            //target: '',
            targetFirst: true,
            toastOnce: false,
            timeout: 5000,
            drag: true,
            pauseOnHover: true,
            resetOnHover: false,
            progressBar: true,
            progressBarColor: '#ca70b4',
            animateInside: true,
            buttons: {},
            transitionIn: 'fadeInUp',
            transitionOut: 'fadeOut',
            transitionInMobile: 'fadeInUp',
            transitionOutMobile: 'fadeOutDown',
            onOpening: function () {},
            onOpened: function () {},
            onClosing: function () {},
            onClosed: function () {}
        });
    }

})(jQuery);

$(document).ready(function () {

});