        $( '#carousel' ).elastislide( {
            orientation : 'vertical'
        });

        $("#menu-toggle").click(function(e) {
            e.preventDefault();
            $("#wrapper").toggleClass("toggled");
        });

        jQuery(document).ready(function() { jQuery(".sit-preview").smartImageTooltip({previewTemplate: "caption", openOnClick: false, imageWidth: "320px", previewPosition: "relative"}); }); 