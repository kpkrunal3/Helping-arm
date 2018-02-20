    <section>
        <!-- sidebar left start-->
        <div class="sidebar-left">
            <!--responsive view logo start-->
            <div class="logo dark-logo-bg visible-xs-* visible-sm-*">
                <a href="index.jsp">
                    <img src="img/logo-icon.png" alt="">
                    <!--<i class="fa fa-maxcdn"></i>-->
                    <span class="brand-name">SlickLab</span>
                </a>
            </div>
            <!--responsive view logo end-->

            <div class="sidebar-left-info">
                <!-- visible small devices start-->
                <div class=" search-field">  </div>
                <!-- visible small devices end-->

                <!--sidebar nav start-->
                <ul class="nav nav-pills nav-stacked side-navigation">
                    <li>
                        <h3 class="navigation-title">Navigation</h3>
                    </li>
                    <li class="active"><a href="index.jsp"><i class="fa fa-home"></i> <span>Dashboard</span></a></li>
                    <li class="menu-list">
                        <a href=""><i class="fa fa-laptop"></i>  <span>Manage Citizen</span></a>
                        <ul class="child-list">
                            <li><a href="<%=request.getContextPath()%>/CitizenController?flag=search">Search Citizen</a></li>
                        </ul>
                    </li>
                    <li class="menu-list"><a href=""><i class="fa fa-user"></i> <span>Manage 108 Staff</span></a>
                        <ul class="child-list">
                            <li><a href="<%=request.getContextPath()%>/StaffController?flag=Loadmenu">Add 108 Staff</a></li>
                            <li><a href="<%=request.getContextPath()%>/StaffController?flag=search">Search 108 Staff</a></li>
                        </ul>
                    </li>
					<li class="menu-list"><a href=""><i class="fa fa-headphones"></i> <span>Manage 108</span></a>
                        <ul class="child-list">
                            <li><a href="<%=request.getContextPath()%>/AmbulanceController?flag=Loadmenu">Add 108</a></li>
                            <li><a href="<%=request.getContextPath()%>/AmbulanceController?flag=search">Search 108</a></li>
                        </ul>
                    </li>
					<li class="menu-list"><a href=""><i class="fa fa-fire"></i> <span>Manage State</span></a>
                        <ul class="child-list">
                            <li><a href="AddState.jsp">Add State</a></li>
                            <li><a href="<%=request.getContextPath()%>/StateController?flag=search">Search State</a></li>
                        </ul>
                    </li>
					<li class="menu-list"><a href=""><i class="fa fa-bell"></i> <span>Manage City</span></a>
                        <ul class="child-list">
                            <li><a href="<%=request.getContextPath()%>/CityController?flag=LoadState">Add City</a></li>
                            <li><a href="<%=request.getContextPath()%>/CityController?flag=search">Search City</a></li>
                        </ul>
                    </li>
					<li class="menu-list"><a href=""><i class="fa fa-chain"></i> <span>Manage Area</span></a>
                        <ul class="child-list">
                            <li><a href="<%=request.getContextPath()%>/AreaController?flag=LoadState">Add Area</a></li>
                            <li><a href="<%=request.getContextPath()%>/AreaController?flag=search">Search Area</a></li>
                        </ul>
                    </li>
					<li class="menu-list"><a href=""><i class="fa fa-cloud"></i> <span>Manage Request</span></a>
                        <ul class="child-list">
                            <li><a href="managerequest.jsp">Search Request</a></li>
                        </ul>
                    </li>
                    <li class="menu-list"><a href=""><i class="fa fa-unlock"></i> <span>Manage Complain</span></a>
                        <ul class="child-list">
                            <li><a href="<%=request.getContextPath()%>/ComplainController?flag=search">Search Complain</a></li>
                        </ul>
                    </li>
                    <li class="menu-list"><a href=""><i class="fa fa-quote-left"></i> <span>Manage Feedback</span></a>
                        <ul class="child-list">
                            <li><a href="<%=request.getContextPath()%>/FeedbackController?flag=search">Search Feedback</a></li>
                        </ul>
                    </li>
                    <li class="menu-list"><a href=""><i class="fa fa-apple"></i> <span>Manage Post</span></a>
                        <ul class="child-list">
                            <li><a href="addpost.jsp">Add Post</a></li>
                            <li><a href="<%=request.getContextPath()%>/PostController?flag=search">Search Post</a></li>
                        </ul>
                    </li>
                     <li class="menu-list"><a href=""><i class="fa fa-dollar"></i> <span>Assign Area To Staff</span></a>
                        <ul class="child-list">
                            <li><a href="<%=request.getContextPath()%>/AssignAreaController?flag=Loadmenu">Assign Area</a></li>
                            <li><a href="<%=request.getContextPath()%>/AssignAreaController?flag=search"> Search Assign Area</a></li>
                        </ul>
                    </li>
                </ul>
                

            </div>
        </div>
        <!-- sidebar left end-->

        <!-- body content start-->
        <div class="body-content" >

            <!-- header section start-->
            <div class="header-section">

                <!--logo and logo icon start-->
                <div class="logo dark-logo-bg hidden-xs hidden-sm">
                    <a href="index.jsp">
                        <img src="img/logo-icon.png" alt="">
                        <!--<i class="fa fa-maxcdn"></i>-->
                        <span class="brand-name" style="color:red">HelpingArm</span>
                    </a>
                </div>

                <div class="icon-logo dark-logo-bg hidden-xs hidden-sm">
                    <a href="index.jsp">
                        <img src="img/logo-icon.png" alt="">
                        <!--<i class="fa fa-maxcdn"></i>-->
                    </a>
                </div>
                <!--logo and logo icon end-->

               

                <!--mega menu start-->
                <div id="navbar-collapse-1" class="navbar-collapse collapse yamm mega-menu">
                    <ul class="nav navbar-nav">
                        <!-- Classic list -->
                        

                        <!-- Classic dropdown -->
                        

                    </ul>
                </div>
                <!--mega menu end-->
                <div class="notification-wrap">
                <!--left notification start-->
                <div class="left-notification">
                <ul class="notification-menu">
                <!--mail info start-->
                <li class="d-none">
                    

                    <div class="dropdown-menu dropdown-title">
                        <div class="title-row">
                            <h5 class="title purple">
                                You have 6 Unread Mail
                            </h5>
                            <a href="javascript:;" class="btn-primary btn-view-all">View all</a>
                        </div>
                        <div class="notification-list mail-list">
                            <a href="javascript:;" class="single-mail">
                                <span class="icon bg-primary">
                                    S
                                </span>
                                <strong>Smith Doe</strong>
                                <small> Just Now</small>
                                <p>
                                    <small>Hello smith i have some query about your</small>
                                </p>
                                <span class="un-read tooltips" data-original-title="Mark as Read" data-toggle="tooltip" data-placement="left">
                                    <i class="fa fa-circle"></i>
                                </span>
                            </a>
                            <a href="javascript:;" class="single-mail">
                                <span class="icon bg-success">
                                    A
                                </span>
                                <strong>Anthony Jones </strong>
                                <small> 30 Mins Ago</small>
                                <p>
                                    <small>Hello this is an example message</small>
                                </p>
                                <span class="un-read tooltips" data-original-title="Mark as Read" data-toggle="tooltip" data-placement="left">
                                    <i class="fa fa-circle"></i>
                                </span>
                            </a>
                            <a href="javascript:;" class="single-mail">
                                <span class="icon bg-warning">
                                    B
                                </span> Billy Jones
                                <small> 2 Days Ago</small>
                                <p>
                                    <small>Slicklab is awesome Dashboard</small>
                                </p>
                                <span class="read tooltips" data-original-title="Mark as Unread" data-toggle="tooltip" data-placement="left">
                                    <i class="fa fa-circle-o"></i>
                                </span>
                            </a>
                            <a href="javascript:;" class="single-mail">
                                <span class="icon bg-dark">
                                    J
                                </span> John Doe
                                <small> 1 Week Ago</small>
                                <p>
                                    <small>Build with Twitter Bootstrap 3</small>
                                </p>
                                <span class="read tooltips" data-original-title="Mark as Unread" data-toggle="tooltip" data-placement="left">
                                    <i class="fa fa-circle-o"></i>
                                </span>
                            </a>
                            <a href="javascript:;" class="single-mail">
                                <span class="icon bg-danger">
                                    S
                                </span> Smith Doe
                                <small> Just Now</small>
                                <p>
                                    <small>No hassle, very easy to use</small>
                                </p>
                                <span class="read tooltips" data-original-title="Mark as Unread" data-toggle="tooltip" data-placement="left">
                                    <i class="fa fa-circle-o"></i>
                                </span>
                            </a>
                        </div>
                    </div>
                </li>
                <!--mail info end-->

                <!--task info start-->
                <li class="d-none">
                    
                    <div class="dropdown-menu dropdown-title">
                        <div class="title-row">
                            <h5 class="title green">
                                You have 9 task
                            </h5>
                            <a href="javascript:;" class="btn-success btn-view-all">View all</a>
                        </div>
                        <div class="notification-list task-list">
                            <a href="javascript:;">
                                <span class="icon ">
                                    <i class="fa fa-paw green-color"></i>
                                </span>
                                <span class="task-info">
                                Smith Doe
                                <small> Assigned new task 10 min ago</small>
                                    </span>
                            </a>
                            <a href="javascript:;">
                                <span class="icon ">
                                    <i class="fa fa-line-chart blue-color"></i>
                                </span>
                                <span class="task-info">Anthony Jones
                                <small> Done 60% of his task</small>

                                <div class="progress progress-striped">
                                    <div style="width: 66%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="66"
                                         role="progressbar" class="progress-bar progress-bar-info"></div>
                                </div>

                                </span>
                            </a>
                            <a href="javascript:;">
                                <span class="icon ">
                                    <i class="fa fa-heart purple-color"></i>
                                </span>
                                <span class="task-info">Tawseef
                                <small> Like your task 10 min ago</small>
                                    </span>

                            </a>
                            <a href="javascript:;">
                                <span class="icon ">
                                    <i class="fa fa-check green-color"></i>
                                </span>
                                <span class="task-info">Anjelina Gomez
                                <small>completed his task Yesterday</small>
                                    </span>
                            </a>
                            <a href="javascript:;">
                                <span class="icon ">
                                    <i class="fa fa-comments-o"></i>
                                </span>
                                <span class="task-info">Franklin Anderson
                                <small>commented on your task 3 Days ago</small>
                                </span>
                            </a>
                        </div>
                    </div>
                </li>
                <!--task info end-->

                <!--notification info start-->
                <li>
                    
                    <div class="dropdown-menu dropdown-title ">

                        <div class="title-row">
                            <h5 class="title yellow">
                                You have 4 New Notification
                            </h5>
                            <a href="javascript:;" class="btn-warning btn-view-all">View all</a>
                        </div>
                        <div class="notification-list-scroll sidebar">
                            <div class="notification-list mail-list not-list">
                                <a href="javascript:;" class="single-mail">
                                    <span class="icon bg-primary">
                                        <i class="fa fa-envelope-o"></i>
                                    </span>
                                    <strong>New User Registration</strong>

                                    <p>
                                        <small>Just Now</small>
                                    </p>
                                    <span class="un-read tooltips" data-original-title="Mark as Read" data-toggle="tooltip" data-placement="left">
                                        <i class="fa fa-circle"></i>
                                    </span>
                                </a>
                                <a href="javascript:;" class="single-mail">
                                    <span class="icon bg-success">
                                        <i class="fa fa-comments-o"></i>
                                    </span>
                                    <strong> Private message Send</strong>

                                    <p>
                                        <small>30 Mins Ago</small>
                                    </p>
                                    <span class="un-read tooltips" data-original-title="Mark as Read" data-toggle="tooltip" data-placement="left">
                                        <i class="fa fa-circle"></i>
                                    </span>
                                </a>
                                <a href="javascript:;" class="single-mail">
                                    <span class="icon bg-warning">
                                        <i class="fa fa-warning"></i>
                                    </span> Application Error
                                    <p>
                                        <small> 2 Days Ago</small>
                                    </p>
                                    <span class="read tooltips" data-original-title="Mark as Unread" data-toggle="tooltip" data-placement="left">
                                        <i class="fa fa-circle-o"></i>
                                    </span>
                                </a>
                                <a href="javascript:;" class="single-mail">
                                    <span class="icon bg-dark">
                                       <i class="fa fa-database"></i>
                                    </span> Database Overloaded 24%
                                    <p>
                                        <small>1 Week Ago</small>
                                    </p>
                                    <span class="read tooltips" data-original-title="Mark as Unread" data-toggle="tooltip" data-placement="left">
                                        <i class="fa fa-circle-o"></i>
                                    </span>
                                </a>
                                <a href="javascript:;" class="single-mail">
                                    <span class="icon bg-danger">
                                        <i class="fa fa-warning"></i>
                                    </span>
                                    <strong>Server Failed Notification</strong>

                                    <p>
                                        <small>10 Days Ago</small>
                                    </p>
                                    <span class="un-read tooltips" data-original-title="Mark as Read" data-toggle="tooltip" data-placement="left">
                                        <i class="fa fa-circle"></i>
                                    </span>
                                </a>

                            </div>
                        </div>
                    </div>
                </li>
                <!--notification info end-->
                </ul>
                </div>
                <!--left notification end-->


                <!--right notification start-->
                <div class="right-notification">
                    <ul class="notification-menu">
                        

                        <li>
                            <a href="javascript:;" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                <img src="img/avatar-mini.jpg" alt="">John Doe
                                <span class=" fa fa-angle-down"></span>
                            </a>
                            <ul class="dropdown-menu dropdown-usermenu purple pull-right">
                                
                                <li><a href="login.jsp"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                            </ul>
                        </li>
                        

                    </ul>
                </div>
                <!--right notification end-->
                </div>

            </div>
            <!-- header section end-->

        