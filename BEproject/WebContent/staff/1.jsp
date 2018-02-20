<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script
src="http://maps.googleapis.com/maps/api/js">
</script>
<script>
//var lati=["23.0139191","23.0143165"];
//var longi=["72.6388229","72.6430178"];
//var obj5={array1:lati};
//var obj6={array2:longi};
var myCenter=new google.maps.LatLng(23.0165633,72.6414626);
var myCenter1=new google.maps.LatLng(23.0139191,72.6388229);
var myCenter2=new google.maps.LatLng(23.0143165,72.6430178);

var marker;
var marker1;
var marker2;


function initialize()
{
var mapProp = {
  center:myCenter,
  center:myCenter1,
  center:myCenter2,
  zoom:15,
  mapTypeId:google.maps.MapTypeId.ROADMAP
  };


var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);


var marker=new google.maps.Marker({
  position:myCenter,
  animation:google.maps.Animation.BOUNCE
  });
var marker1=new google.maps.Marker({
	  position:myCenter1,
	  icon:'1.jpg'
	  });
var marker2=new google.maps.Marker({
	  position:myCenter2,
	  icon:'1.jpg'
	  });

marker.setMap(map);
marker1.setMap(map);
marker2.setMap(map);

var infowindow = new google.maps.InfoWindow({
	  content:"Accident place!"
	  });

	infowindow.open(map,marker);
}

google.maps.event.addDomListener(window, 'load', initialize);

</script>
</head>
<body>
<div id="googleMap" style="width:1500px;height:500px;"></div>
</body>
</html>