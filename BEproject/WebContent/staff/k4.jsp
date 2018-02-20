<!DOCTYPE html>
<html>
  <head>
    <title>Navigation functions (heading)</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <style>
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #map {
        height: 100%;
      }
      #floating-panel {
        position: absolute;
        top: 10px;
        left: 25%;
        z-index: 5;
        background-color: #fff;
        padding: 5px;
        border: 1px solid #999;
        text-align: center;
        font-family: 'Roboto','sans-serif';
        line-height: 30px;
        padding-left: 10px;
      }
    </style>
  </head>
  <body>
    <div id="map"></div>
    
    <script>
      // This example requires the Geometry library. Include the libraries=geometry
      // parameter when you first load the API. For example:
      // <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=geometry">

      var marker1, marker2,marker3;
      var poly, geodesicPoly,kedar;

      function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 2000,
         center: {lat: 34, lng: -40.605}
        });

        map.controls[google.maps.ControlPosition.TOP_CENTER].push(
            document.getElementById('info'));

        marker1 = new google.maps.Marker({
          map: map,
          draggable: true,
          icon:'1.jpg',
          position: {lat : 23.095,
				lng : 72.5549}
        });

       /*accident place */ marker2 = new google.maps.Marker({
          map: map,
          draggable: true, 
          animation:google.maps.Animation.BOUNCE,
          position: {lat : 23.0903,
				lng : 72.5342}
        });
      
      
        marker3 = new google.maps.Marker({
            map: map,
            draggable: true,
            icon:'1.jpg',
            position: {lat : 23.097525,
				lng : 72.547673}
          });
        
        var bounds = new google.maps.LatLngBounds(
            marker1.getPosition(), marker2.getPosition(),marker3.getPosition());
        map.fitBounds(bounds);

        google.maps.event.addListener(marker1, 'position_changed', update);
        google.maps.event.addListener(marker2, 'position_changed', update);
        google.maps.event.addListener(marker3, 'position_changed', update);


        poly = new google.maps.Polyline({
          strokeColor: '#FF0000',
          strokeOpacity: 1.0,
          strokeWeight: 3,
          map: map,
        });

        geodesicPoly = new google.maps.Polyline({
          strokeColor: '#CC0099',
          strokeOpacity: 1.0,
          strokeWeight: 3,
          geodesic: true,
          map: map
        });
       

        update();
      }
    
      function update() {
        var path = [marker1.getPosition(), marker2.getPosition(), marker3.getPosition()];
        poly.setPath(path);
        geodesicPoly.setPath(path);
       
        var heading = google.maps.geometry.spherical.computeHeading(path[0],path[1],path[2]);
      }
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBRzQungf-oGnH1K3LaPc2CoqbLWu29814&libraries=geometry&callback=initMap"
></script>
  </body>
</html>