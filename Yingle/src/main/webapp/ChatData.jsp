 <!-- Bootstrap core CSS -->
		<link href="resources/bootstrap.min.css" type="text/css" rel="stylesheet">
		<!-- Swipe core CSS -->
		<link href="resources/swipe.min.css" type="text/css" rel="stylesheet"> 
<!-- Start of Add Friends -->
				<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="requests">
							<div class="title">
								<h1>Add your friends</h1>
								<button type="button" class="btn" data-dismiss="modal" aria-label="Close"><i class="material-icons">close</i></button>
							</div>
							<div class="content">
                                                            <form action="AddFriends" method="post">
									<div class="form-group">
										<label for="user">Username:</label>
                                                                                <input type="text" name="adduser" class="form-control" id="user" placeholder="Add recipient..." required>
										<div class="user" id="contact">
											<img class="avatar-sm" src="dist/img/avatars/avatar-female-5.jpg" alt="avatar">
											<h5></h5>
											<button class="btn"><i class="material-icons">close</i></button>
										</div>
									</div>
									<div class="form-group">
										<label for="welcome">Message:</label>
                                                                                <textarea class="text-control" name="text" id="welcome" placeholder="Send your welcome message..."></textarea>
									</div>
									<input type="submit" class="btn button w-100">Send Friend Request</button>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!-- End of Add Friends -->
				<!-- Start of Create Chat -->
				<div class="modal fade" id="startnewchat" tabindex="-1" role="dialog" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="requests">
							<div class="title">
								<h1>Start new chat</h1>
								<button type="button" class="btn" data-dismiss="modal" aria-label="Close"><i class="material-icons">close</i></button>
							</div>
							<div class="content">
                                                            <form action="ccServlet" method="post">
									<div class="form-group">
										<label for="participant">Recipient:</label>
                                                                                <input type="text" name="createfriend" class="form-control" id="participant" placeholder="Add recipient..." required>
										<div class="user" id="recipient">
											<!--<img class="avatar-sm" src="dist/img/avatars/avatar-female-5.jpg" alt="avatar">
											<h5>Keith Morris</h5>
											<button class="btn"><i class="material-icons">close</i></button>-->
										</div>
									</div>
									<!--<div class="form-group">
										<label for="topic">Topic:</label>
										<input type="text" class="form-control" id="topic" placeholder="What's the topic?" required>
									</div>-->
									<div class="form-group">
										<label for="message">Message:</label>
                                                                                <textarea class="text-control" name="message" id="message" placeholder="Send your welcome message..."></textarea>
									</div>
									<input type="submit" class="btn button w-100">Start New Chat</button>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!-- End of Create Chat -->
                                <iframe name="frame1" src="chatBox.jsp" width="100%" height="550"></iframe>