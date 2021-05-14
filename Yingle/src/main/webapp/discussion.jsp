  <!-- Bootstrap core CSS -->
<link href="resources/bootstrap.min.css" type="text/css" rel="stylesheet">
		<!-- Swipe core CSS -->
		<link href="resources/swipe.min.css" type="text/css" rel="stylesheet">

<%@page import="com.niit.controller.DataBase"%>
<%@page import="java.sql.ResultSet"%>
<!-- Start of Discussions -->
<%ResultSet rs1;%>
<%
DataBase obj1=new DataBase();
rs1=obj1.getnewchat();
%>                                                                
								<div id="discussions" class="tab-pane fade active show">
									<div class="search">
										<form class="form-inline position-relative">
											<input type="search" class="form-control" id="conversations" placeholder="Search for conversations...">
											<button type="button" class="btn btn-link loop"><i class="material-icons">search</i></button>
										</form>
										<button class="btn create" data-toggle="modal" data-target="#startnewchat"><i class="material-icons">create</i></button>
									</div>
									<div class="list-group sort">
										<button class="btn filterDiscussionsBtn active show" data-toggle="list" data-filter="all">All</button>
										<button class="btn filterDiscussionsBtn" data-toggle="list" data-filter="read">Read</button>
										<button class="btn filterDiscussionsBtn" data-toggle="list" data-filter="unread">Unread</button>
									</div>						
									<div class="discussions">
                                                                            <h1>Discussions</h1>
                                                                            <%while(rs1.next()) {%>
										<div class="list-group" id="chats" role="tablist">
               <a href="chatBox.jsp" target="frame1" class="filterDiscussions all unread single active" id="list-chat-list"> <!--   data-toggle="list" role="tab" -->
												<img class="avatar-md" src="resources/avatar-female-1.jpg" data-toggle="tooltip" data-placement="top" title="Janette" alt="avatar">
												<div class="status">
													<i class="material-icons online">fiber_manual_record</i>
												</div>
												<div class="new bg-yellow">
													<span>+7</span>
												</div>
												<div class="data">
                                                                                                    <h5><%=rs1.getString("receiver")%></h5>
                                                                                                    <span><%=rs1.getString("strdate")%></span>
                                                                                                    <p><%=rs1.getString("message")%></p>
												</div>
											</a>									
											<%}%>
										</div>
									</div>
								</div>
								<!-- End of Discussions -->