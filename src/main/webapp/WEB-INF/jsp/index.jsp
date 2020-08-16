
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<body>
<div id="register">
	<h3 class="text-center text-white pt-5">register form</h3>
	<div class="container">
		<div id="register-row" class="row justify-content-center align-items-center">
			<div id="register-column" class="col-md-6">
				<div id="register-box" class="col-md-12">
					<h1 class="text-center text-info">Hello! I'm Elif Hilal. Its my Spring Project for Subscreasy.${firstname}</h1>
					<form action="logout" method="post">

						<a href="/login.html" type="submit"  class="btn btn-info btn-md" value="Login Page" > Logout </a>

						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>