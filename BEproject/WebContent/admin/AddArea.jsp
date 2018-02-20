<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="slick, flat, dashboard, bootstrap, admin, template, theme, responsive, fluid, retina">
    <link rel="shortcut icon" href="javascript:;" type="image/png">

    <title>form validation</title>

    <!--right slidebar-->
    <link href="css/slidebars.css" rel="stylesheet">

    <!--switchery-->
    <link href="js/switchery/switchery.min.css" rel="stylesheet" type="text/css" media="screen" />

    <!--iCheck-->
    <link href="js/icheck/skins/all.css" rel="stylesheet">

    <!--common style-->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    
    <script type="text/javascript">
    
    function loadCity() {
    	
		var stateId=document.getElementById("state");
		
		var xmlhttp=new XMLHttpRequest();
		
		removeAllState();
		
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4) 
			{
				var jsonObj = JSON.parse(xmlhttp.responseText);
				
				for(i=0 ; i<jsonObj.length ; i++)
				{
					var createOption=document.createElement("option");
					
					createOption.value=jsonObj[i].cityId;
					createOption.text=jsonObj[i].cityName;
					
					document.addArea.city.options.add(createOption);
					
				}
			}
			
		}

		xmlhttp.open("get", "${pageContext.request.contextPath}/AreaController?flag=loadCity&stateId="+stateId.value, true);
		xmlhttp.send();
		/* jQuery(".chosen-select1").chosen({'width':'100%','white-space':'nowrap'}); */
		/* Holds the status of the XMLHttpRequest. Changes from 0 to 4:
			0: request not initialized
			1: server connection established
			2: request received
			3: processing request
			4: request finished and response is ready */
	}
	
	function removeAllState()
	{
		var removeState=document.city.stateId.options.length;
		for(i=removeState ; i>0 ; i-- )
		{
			document.addArea.city.remove(i);
		}
	}

		
	
    
    </script>
    
</head>


<body class="sticky-header">

    <!-- page head start-->
        
    <jsp:include page="header.jsp"></jsp:include>
            <!-- page head end-->

            <!--body wrapper start-->

            <!-- header section start-->
                        <!-- page head start-->
           <div class="page-head">
                <h3 class="m-b-less">
                    Add Area
                </h3>
                <!--<span class="sub-title">Welcome to Static Table</span>-->
                <div class="state-information">
                    <ol class="breadcrumb m-b-less bg-less">
                        <li><a href="#">Home</a></li>
                        <li><a href="#">Form</a></li>
                        <li class="active"> Form Validation </li>
                    </ol>
                </div>

            </div>
            <!-- page head end-->

            <!--body wrapper start-->
            <div class="wrapper">

              <div class="row">
                    <div class="col-lg-12">
                        <section class="panel">
                            <header class="panel-heading">
                                Add Area
                            </header>
                            <div class="panel-body">
                                <div class=" form">
                                    <form class="cmxform form-horizontal tasi-form" name="addArea"  method="post" action="<%=request.getContextPath()%>/AreaController">
									 <div class="form-group">
												<label class="col-sm-2 control-label col-lg-2" for="inputSuccess">State</label>
													<div class="col-lg-10">
														
													<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
													<select class="form-control input-sm m-b-10" id="state" name="state" onchange="return loadCity()">
													<c:forEach items="${sessionScope.loadState}" var="i">
														<option value="${i.stateId}">${i.stateName}</option>
													</c:forEach>
															
					
														</select>
													</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label col-lg-2" for="inputSuccess">City</label>
													<div class="col-lg-10">
													
														<select class="form-control input-sm m-b-10" name="city">
														
														</select>
													</div>
											</div>
                                        <div class="form-group ">
                                            <label for="cemail" class="control-label col-lg-2">Area name*</label>
                                            <div class="col-lg-10">
                                                <input class="form-control " id="cemail" type="text" name="area" required />
                                            </div>
                                        </div>
                                         <div class="form-group ">
                                            <label for="cemail" class="control-label col-lg-2">Pincode*</label>
                                            <div class="col-lg-10">
                                                <input class="form-control " id="cemail" type="text" name="pincode" required />
                                            </div>
                                        </div>
										<div class="form-group ">
                                            <label for="cemail" class="control-label col-lg-2">Description*</label>
                                            <div class="col-lg-10">
                                                <input class="form-control " id="cemail" type="text" name="des" required />
                                            </div>
                                        </div>
                                        
                 
                                       
                                        <div class="form-group">
                                            <div class="col-lg-offset-2 col-lg-10">
                                            	<input type="hidden" name="flag" value="insert">
                                                <button class="btn btn-success" type="submit">Submit</button>
                                                <button class="btn btn-default" type="button">Cancel</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>

                         </div>
                        </section>
                    </div>
                </div>


            </div>
            

<jsp:include page="footer.jsp"></jsp:include>
            <!-- Right Slidebar start -->
            

<!-- Placed js at the end of the document so the pages load faster -->
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/jquery-migrate.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.min.js"></script>

<!--Nice Scroll-->
<script src="js/jquery.nicescroll.js" type="text/javascript"></script>

<!--right slidebar-->
<script src="js/slidebars.min.js"></script>

<!--switchery-->
<script src="js/switchery/switchery.min.js"></script>
<script src="js/switchery/switchery-init.js"></script>

<!--Sparkline Chart-->
<script src="js/sparkline/jquery.sparkline.js"></script>
<script src="js/sparkline/sparkline-init.js"></script>

<!--form validation-->
<script type="text/javascript" src="js/jquery.validate.min.js"></script>

<!--form validation init-->
<script src="js/form-validation-init.js"></script>

<!--Icheck-->
<script src="js/icheck/skins/icheck.min.js"></script>

<!--common scripts for all pages-->
<script src="js/scripts.js"></script>

    <script>
        $(document).ready(function(){
            $('.iCheck').iCheck({
                checkboxClass: 'icheckbox_minimal',
                radioClass: 'iradio_minimal',
                increaseArea: '20%' // optional
            });
            $('.iCheck-square').iCheck({
                checkboxClass: 'icheckbox_square',
                radioClass: 'iradio_square',
                increaseArea: '20%' // optional
            });
            $('.iCheck-flat').iCheck({
                checkboxClass: 'icheckbox_flat',
                radioClass: 'iradio_flat',
                increaseArea: '20%' // optional
            });
            $('.iCheck-polaris').iCheck({
                checkboxClass: 'icheckbox_polaris',
                radioClass: 'iradio_polaris',
                increaseArea: '20%' // optional
            });


        });
    </script>
</body>
</html>
