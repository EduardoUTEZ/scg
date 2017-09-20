<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<nav class="navbar navbar-transparent navbar-absolute">
                <div class="container-fluid">
                    <div class="navbar-minimize">
                        <button id="minimizeSidebar" class="btn btn-round btn-white btn-fill btn-just-icon">
                            <i class="material-icons visible-on-sidebar-regular">more_vert</i>
                            <i class="material-icons visible-on-sidebar-mini">view_list</i>
                        </button>
                    </div>
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        
                        <a class="navbar-brand" href="#"> <tiles:insertAttribute name="title" /> </a>
                        
                       
                    </div>
                    
                    
                     <div class="collapse navbar-collapse">
                        <ul class="nav navbar-nav navbar-right">
                            
                            <li>
                                <a href="#pablo" class="dropdown-toggle">
                                    <i class="material-icons">person</i>
                                    <span class="hidden-xs hidden-s">@admin</span>
                                    
                                </a>
                            </li>
                            <li>
                                <a href='<c:url value="/j_spring_security_logout"/>'>
                                    <i class="material-icons">exit_to_app</i>
                                    <p class="hidden-lg hidden-md">Cerrar Sesión</p>
                                </a>
                            </li>
                            <li class="separator hidden-lg hidden-md"></li>
                        </ul> 
                        
                                       
                    </div>

                </div>
            </nav>