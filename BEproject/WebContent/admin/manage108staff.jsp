<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="slick, flat, dashboard, bootstrap, admin, template, theme, responsive, fluid, retina">
    <link rel="shortcut icon" href="javascript:;" type="image/png">

    <title>data table</title>

    <!--right slidebar-->
    <link href="css/slidebars.css" rel="stylesheet">

    <!--switchery-->
    <link href="js/switchery.min.css" rel="stylesheet" type="text/css" media="screen" />

    <!--Data Table-->
    <link href="css/jquery.dataTables.css" rel="stylesheet">
    <link href="css/dataTables.tableTools.css" rel="stylesheet">
    <link href="css/dataTables.colVis.min.css" rel="stylesheet">
    <link href="css/dataTables.responsive.css" rel="stylesheet">
    <link href="css/dataTables.scroller.css" rel="stylesheet">
    <!-- Base Styles -->

    <!--common style-->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
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
                    Manage 108 Staff
                </h3>
                <!--<span class="sub-title">Welcome to Static Table</span>-->
                <div class="state-information">
                    <ol class="breadcrumb m-b-less bg-less">
                        <li><a href="#">Home</a></li>
                        <li><a href="#">Data Table</a></li>
                        <li class="active">Dynamic Data Table</li>
                    </ol>
                </div>
            </div>
            <!-- page head end-->

            <!--body wrapper start-->
            <div class="wrapper">

              <div class="row">
                    <div class="col-sm-12">
                        <section class="panel">
                            <header class="panel-heading ">
                                Manage 108 Staff
                                <span class="tools pull-right">
                                    <a class="fa fa-repeat box-refresh" href="javascript:;"></a>
                                    <a class="t-close fa fa-times" href="javascript:;"></a>
                                </span>
                            </header>
                            <jsp:include page="errorNotify.jsp"></jsp:include>
                            <table class="table colvis-data-table data-table">
                            <thead>
                            <tr>
								<th>
                                    ID
                                </th>
                                <th>
                                    FirstName
                                </th>
                                <th>
                                    LastName
                                </th>
                                <th>
                                    MiddleName
                                </th>
                                <th>
                                    Post
                                </th>
								<th>
                                    Mobile Number
                                </th>
								<th>
                                    Email ID
                                </th>
                                <th>
                                    AddressLine1
                                </th>
                                <th>
                                   	AddressLine2
                                </th>
                                <th>
                                    State
                                </th>
                                <th>
                                    City
                                </th>
                                <th>
									Pincode
                                </th>
								<th>
									Delete/Edit
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <%session.removeAttribute("errorMsg"); %>
                            <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
							<c:forEach items="${sessionScope.staff}" var="i">
                            <tr>
                                <td>
                                   	${i.staffId}
                                </td>
                                <td>
                                     	${i.firstName}
                                </td>
                                <td>
                                    ${i.lastName}
                                </td>
                                <td>
                                    ${i.middleName}
                                </td>
                                <td>
                                    ${i.postVO.postName}
                                </td>
                                <td>
                                     ${i.mobileNumber}
                                </td>
								<td>
                                   ${i.email}
                                </td>
                                <td>
                                    ${i.addressLine1}
                                </td>
                                <td>
                                     ${i.addressLine2}
                                </td>
                                <td>
                                    ${i.stateVO.stateName}
                                </td>
                                <td>
                                    ${i.cityVO.cityName}
                                </td>
								<td>
                                     ${i.pincode}
                                </td>
								<td>
                                    <a href="<%=request.getContextPath()%>/StaffController?flag=delete&id=${i.staffId}">Delete</a>/<a href="<%=request.getContextPath()%>/StaffController?flag=edit&id=${i.staffId}">Edit</a>
                                </td>
                            </tr>
                            </c:forEach>
                            </tbody>
                            </table>
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
<script src="js/switchery.min.js"></script>
<script src="js/switchery-init.js"></script>

<!--Sparkline Chart-->
<script src="js/jquery.sparkline.js"></script>
<script src="js/sparkline-init.js"></script>


<!--Data Table-->
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/dataTables.tableTools.min.js"></script>
<script src="js/bootstrap-dataTable.js"></script>
<script src="js/dataTables.colVis.min.js"></script>
<script src="js/dataTables.responsive.min.js"></script>
<script src="js/dataTables.scroller.min.js"></script>
<!--data table init-->
<script src="js/data-table-init.js"></script>


<!--common scripts for all pages-->
<script src="js/scripts.js"></script>


</body>
</html>
