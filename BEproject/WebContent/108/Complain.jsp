<jsp:include page="header.jsp"></jsp:include>
    <div class="custom-wrapper color-green" style="width: 100%">
            <div class="container">
                <div class="newsletter_wrapper text-center">
                    <h3 style="margin-left: -560px">Post Complain</h3>
                    <div class="row" style="width:100%; align:center; margin-left: 184px;">
                        <form id="loginform" method="post" action="<%=request.getContextPath()%>/ComplainController">
                            
                            <div class="col-md-4" style="clear:left;">
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                                        <input type="hidden" name="flag" value="insert">
                                        <input type="email" class="form-control border-radius" name="email"  placeholder="Email Address">
                                    </div>
                                </div>
                            </div> 
                      
                            <div class="col-md-4" style="clear:left;">
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                        <input type="hidden" name="flag" value="insert">
                                        <input type="text" class="form-control border-radius" name="title"  placeholder="Title">
                                    </div>
                                </div>
                            </div> 
                      
                            <div class="col-md-4" style="clear:left;">
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                        <textarea rows="10" cols="10" name="des" class="form-control " placeholder="Descripion" style="width: 315px; height: 124px;"></textarea>
                                    </div>
                                </div>
                            </div>         
                               
                            <div class="clearfix"></div><br>
                           <input type="hidden" name="flag" value="insert">
                            <button class="btn btn-default btn-lg border-radius" style="margin-left: -954px;" type="submit">Submit</button>
                        </form> 
                            </div>    
                        
                    </div>
                </div><!-- end newsletter_wrapper -->
            </div><!-- end container -->
        </div>
        
        <!-- end builder -->

       <jsp:include page="footer.jsp"></jsp:include>

        <section class="copyrights text-center">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <h4>Copyrights © 2014 All Rights Reserved by JollyThemes Inc.</h4>
                    </div><!-- end col -->
                </div><!-- end row -->
            </div><!-- end container -->
        </section><!-- end conpyrights -->

        <!-- DEMO SWITCHER -->
        <a href="#menu-toggle" class="btn btn-primary border-radius" id="menu-toggle">SHOW DEMOS</a>
        <div id="sidebar-wrapper">
            <div class="swit-title">
            <h1>Available</h1>
            <h3>Creativ Demos</h3>
            <img src="images/logo.png" alt="" class="img-responsive">
            </div>
            <div id="demo-2">
                <ul id="carousel" class="elastislide-list">
                    <li><a class="sit-preview" href="../default/index.html"><img alt="Default Version" src="images/demo_01.png" data-preview-url="images/demo_01.png"></a></li>
                    <li><a class="sit-preview" href="../shop/index.html"><img alt="Shop Version" src="images/demo_02.png" data-preview-url="images/demo_02.png"></a></li>
                    <li><a class="sit-preview" href="../portfolio/index.html"><img alt="Portfolio Version" src="images/demo_03.png" data-preview-url="images/demo_03.png"></a></li>
                    <li><a class="sit-preview" href="../freelancer/index.html"><img alt="Freelancer Version" src="images/demo_04.png" data-preview-url="images/demo_04.png"></a></li>
                    <li><a class="sit-preview" href="../photography/index.html"><img alt="Photography Version" src="images/demo_05.png" data-preview-url="images/demo_05.png"></a></li>
                    <li><a class="sit-preview" href="../medical/index.html"><img alt="Medical Version" src="images/demo_06.png" data-preview-url="images/demo_06.png"></a></li>
                    <li><a class="sit-preview" href="../restaurant/index.html"><img alt="Restaurant Version" src="images/demo_07.png" data-preview-url="images/demo_07.png"></a></li>
                    <li><a class="sit-preview" href="../onepage/index.html"><img alt="OnePage Version" src="images/demo_08.png" data-preview-url="images/demo_08.png"></a></li>
                    <li><a class="sit-preview" href="../leftside/index.html"><img alt="Left Side Version" src="images/demo_09.png" data-preview-url="images/demo_09.png"></a></li>
                </ul>
            </div>
        </div>
        <!-- END DEMO SWITCHER -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/retina.js"></script>
    <script src="js/text-rotate.js"></script>
    <script src="js/wow.min.js"></script>
    <script src="js/jquery.stellar.js"></script>
    <script src="js/home-scripts.js"></script>
    <!-- Portfolio -->
    <script src="js/jquery.isotope.min.js"></script>
    <script src="js/portfolio_01.js"></script>
    <!-- Carousel -->
    <script src="js/owl.carousel.js"></script>
    <script src="js/owl-scripts.js"></script>
    <!-- Map Scripts-->
    <script src="http://maps.google.com/maps/api/js?sensor=false"></script>
    <!-- Google Map -->
    <script type="text/javascript">
        (function($) {
          "use strict";
            var locations = [
            ['<div class="infobox"><h3 class="title"><a href="about-1.html">OUR USA OFFICE</a></h3><span>NEW YORK CITY 2045 / 65</span><br>+90 555 666 77 88</p></div></div></div>', -37.801578, 145.060508, 2]
            ];
        
            var map = new google.maps.Map(document.getElementById('map'), {
              zoom: 15,
                scrollwheel: false,
                navigationControl: true,
                mapTypeControl: false,
                scaleControl: false,
                draggable: false,
                styles: [ { "stylers": [ { "hue": "#000" },  {saturation: -200},
                    {gamma: 0.50} ] } ],
                center: new google.maps.LatLng(-37.801578, 145.060508),
              mapTypeId: google.maps.MapTypeId.ROADMAP
            });
        
            var infowindow = new google.maps.InfoWindow();
        
            var marker, i;
        
            for (i = 0; i < locations.length; i++) {  
          
                marker = new google.maps.Marker({ 
                position: new google.maps.LatLng(locations[i][1], locations[i][2]), 
                map: map ,
                icon: 'images/marker.png'
                });
        
        
              google.maps.event.addListener(marker, 'click', (function(marker, i) {
                return function() {
                  infowindow.setContent(locations[i][0]);
                  infowindow.open(map, marker);
                }
              })(marker, i));
            }
        })(jQuery);
    </script>
    <script src="js/jigowatt.js"></script>
    
    <!-- DEMO ONLY -->
    <script src="js/jquery.elastislide.js"></script>
    <script src="js/imagetooltip.min.js"></script>
    <script src="js/switcher.js"></script>

</body>
</html>