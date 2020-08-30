<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar User panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
                     class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p><security:authentication property="principal.username"/></p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>
            <li id="admin-index"><a
                    href="${pageContext.request.contextPath}/main"><i
                    class="fa fa-dashboard"></i> <span>首页</span></a></li>
            <security:authorize access="hasRole('ADMIN')">
                <li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
                    <span>系统管理</span> <span class="pull-right-container"> <i
                            class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                    <ul class="treeview-menu">


                        <li><a
                                href="${pageContext.request.contextPath}/userList">
                            <i class="fa fa-circle-o"></i> 用户管理
                        </a></li>
                        <li><a
                                href="${pageContext.request.contextPath}/blacklist"> <i
                                class="fa fa-circle-o"></i> 黑名单
                        </a></li>
                    </ul>
                </li>
            </security:authorize>
           <%-- <security:authorize access="hasRole('USER')">
                <li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
                    <span>系统管理</span> <span class="pull-right-container"> <i
                            class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                    <ul class="treeview-menu">

                        <li>
                            <a href="${pageContext.request.contextPath}/user/findAll.do">
                                <i class="fa fa-circle-o"></i> 用户管理
                            </a>
                        </li>
                        <li><a
                                href="${pageContext.request.contextPath}/role/findAll.do"> <i
                                class="fa fa-circle-o"></i> 角色管理
                        </a></li>
                        <li><a
                                href="${pageContext.request.contextPath}/permission/findAll.do">
                            <i class="fa fa-circle-o"></i> 资源权限管理
                        </a></li>
                        <li><a
                                href="${pageContext.request.contextPath}/sysLog/findAll.do"> <i
                                class="fa fa-circle-o"></i> 访问日志
                        </a></li>
                    </ul>
                </li>
            </security:authorize>--%>
            <security:authorize access="hasRole('ADMIN')">
            <li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
                <span>图书</span> <span class="pull-right-container"> <i
                        class="fa fa-angle-left pull-right"></i>
				</span>
            </a>
                <ul class="treeview-menu">
            </security:authorize>
                    <li><a href="${pageContext.request.contextPath}/getBooks">
                        <i class="fa fa-circle-o"></i> 图书列表
                    </a></li>
                    <security:authorize access="hasRole('USER')">
                        <li><a href="${pageContext.request.contextPath}/history">
                            <i class="fa fa-circle-o"></i> 借阅历史
                        </a></li>
                    </security:authorize>
                    <security:authorize access="hasRole('ADMIN')">
                        <li><a href="${pageContext.request.contextPath}/aHistory">
                            <i class="fa fa-circle-o"></i> 借阅历史
                        </a></li>
                    </security:authorize>
                    <security:authorize access="hasRole('ADMIN')">
                        <li>
                            <a href="${pageContext.request.contextPath}/book-add"> <i
                                class="fa fa-circle-o"></i> 图书添加
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/goBook">
                                <i class="fa fa-circle-o"></i> 借阅
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/toBook"> <i
                                class="fa fa-circle-o"></i> 归还
                            </a>
                        </li>
                    </security:authorize>
                </ul>
            </li>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>