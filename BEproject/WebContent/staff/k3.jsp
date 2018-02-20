<!DOCTYPE html>
<%@page import="java.sql.*"%>
<html>
<head>
<title>Navigation functions (heading)</title>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<!-- <script>
var longitute;
var latitude;
  function loadState()
	{
		var xmlhttp=new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4) 
			{
				var jsonArr = JSON.parse(xmlhttp.responseText);
				alert(JSON.stringify(jsonArr));
				for(i=0 ; i<jsonObj.length ; i++)
				{
					longitute=jsonArr[i].longi;
					latitude=jsonObj[i].lati;
					
					
				}
			}
			
		}

		xmlhttp.open("get", "${pageContext.request.contextPath}value?flag=search", true);
		xmlhttp.send();
		/* jQuery(".chosen-select1").chosen({'width':'100%','white-space':'nowrap'}); */
		/* Holds the status of the XMLHttpRequest. Changes from 0 to 4:
			0: request not initialized
			1: server connection established
			2: request received
			3: processing request
			4: request finished and response is ready */
	}
	
	
</script>
 -->

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
	font-family: 'Roboto', 'sans-serif';
	line-height: 30px;
	padding-left: 10px;
}
</style>
</head>
<body onload="loadState()">
	<div id="map"></div>

	<script>
		var longi, lati;
		function loadState() {
			//alert("ajaxcall");
			var xmlhttp = new XMLHttpRequest();

			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4) {
					//alert("reached inside readystate==4")// ahiya jatu nathi alert("hii");
					var jsonArr = JSON.parse(xmlhttp.responseText);
					//alert(JSON.stringify(jsonArr));
					for (i = 0; i < jsonArr.length; i++) {
						longi = jsonArr[i].longi;
						lati = jsonArr[i].lati;
						//alert(">>>long/lati ::" + longi + lati);
					}
					initMap();
				}
			}

			xmlhttp.open("get",
					"${pageContext.request.contextPath}/value?flag=search",
					true);
			xmlhttp.send();
		
			/* jQuery(".chosen-select1").chosen({'width':'100%','white-space':'nowrap'}); */
			/* Holds the status of the XMLHttpRequest. Changes from 0 to 4:
				0: request not initialized
				1: server connection established
				2: request received
				3: processing request
				4: request finished and response is ready */

		}

		//       // This example requires the Geometry library. Include the libraries=geometry
		//       // parameter when you first load the API. For example:
		//       // <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=geometry">

		var marker1, marker2, marker3;
		var poly, geodesicPoly, kedar;

		function initMap() {

			alert("Init");
			alert("init map latitude" + lati);
			alert("init map longitute" + longi);

			var map = new google.maps.Map(document.getElementById('map'), {
				zoom : 4,
				center : {
					lat : 34,
					lng : -40.605
				}
			});

			map.controls[google.maps.ControlPosition.TOP_CENTER].push(document
					.getElementById('info'));

			marker1 = new google.maps.Marker({
				map : map,
				draggable : true,
				icon : '1.jpg',
				position : {
					lat : 23.095,
					lng : 72.5449
				}
			});

			/*accident place */marker2 = new google.maps.Marker({
				map : map,
				draggable : true,
				animation : google.maps.Animation.BOUNCE,
				position : {
					lat : 23.0903,
					lng : 72.5342
				}
			});

			marker3 = new google.maps.Marker({
				map : map,
				draggable : true,
				icon : '1.jpg',
				position : {
					lat : 23.097525,
					lng : 72.547673
				}
			});

			var bounds = new google.maps.LatLngBounds(marker1.getPosition(),
					marker2.getPosition(), marker3.getPosition());
			map.fitBounds(bounds);

			google.maps.event.addListener(marker1, 'position_changed', update);
			google.maps.event.addListener(marker2, 'position_changed', update);
			google.maps.event.addListener(marker3, 'position_changed', update);

			poly = new google.maps.Polyline({
				strokeColor : '#FF0000',
				strokeOpacity : 1.0,
				strokeWeight : 3,
				map : map,
			});

			geodesicPoly = new google.maps.Polyline({
				strokeColor : '#CC0099',
				strokeOpacity : 1.0,
				strokeWeight : 3,
				geodesic : true,
				map : map
			});
			update();
		}

		function update() {
			var path = [ marker1.getPosition(), marker2.getPosition(),
					marker3.getPosition() ];
			poly.setPath(path);
			geodesicPoly.setPath(path);

			var heading = google.maps.geometry.spherical.computeHeading(
					path[0], path[1], path[2]);
		}
	</script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBRzQungf-oGnH1K3LaPc2CoqbLWu29814&libraries=geometry&callback=initMap">
		
	</script>

</body>
</html>