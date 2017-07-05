<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
	<c:url var="url_base" value="/"/>
	
	<!-- Bootstrap Core CSS -->
    <link href="${url_base}css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${url_base}font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- Custom Style -->
    <link rel="stylesheet" href="${url_base}css/style.css">
</head>
<body>
<div class="omb_login">
    	<h3 class="omb_authTitle"><a href="#" id="login">Login</a> or <a id="signup" href="#">Sign up</a></h3>
		<div class="row omb_row-sm-offset-3 omb_socialButtons">
    	    <div class="col-xs-4 col-sm-2">
		        <a href="#" class="btn btn-lg btn-block omb_btn-facebook">
			        <i class="fa fa-facebook visible-xs"></i>
			        <span class="hidden-xs">Facebook</span>
		        </a>
	        </div>
        	<div class="col-xs-4 col-sm-2">
		        <a href="#" class="btn btn-lg btn-block omb_btn-twitter">
			        <i class="fa fa-twitter visible-xs"></i>
			        <span class="hidden-xs">Twitter</span>
		        </a>
	        </div>	
        	<div class="col-xs-4 col-sm-2">
		        <a href="#" class="btn btn-lg btn-block omb_btn-google">
			        <i class="fa fa-google-plus visible-xs"></i>
			        <span class="hidden-xs">Google+</span>
		        </a>
	        </div>	
		</div>

		<div class="row omb_row-sm-offset-3 omb_loginOr">
			<div class="col-xs-12 col-sm-6">
				<hr class="omb_hrOr">
				<span class="omb_spanOr">or</span>
			</div>
		</div>

		<div class="row omb_row-sm-offset-3">
			<div class="col-xs-12 col-sm-6">	
			    <form class="omb_loginForm" action="/login" autocomplete="off" method="POST">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user"></i></span>
						<input type="text" class="form-control" name="username" required placeholder="Username">
					</div>
					<span class="help-block"></span>
										
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-lock"></i></span>
						<input  type="password" class="form-control" name="password" required placeholder="Password">
					</div>
                    <span class="help-block">${error}</span>

					<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
				</form>
			</div>
    	</div>
		<div class="row omb_row-sm-offset-3">
			<div class="col-xs-12 col-sm-3">
				<label class="checkbox">
					<input type="checkbox" value="remember-me">Remember Me
				</label>
			</div>
			<div class="col-xs-12 col-sm-3">
				<p class="omb_forgotPwd">
					<a href="#">Forgot password?</a>
				</p>
			</div>
		</div>	 

        <div class="row omb_row-sm-offset-3 register">
			<div class="col-xs-12 col-sm-6">	
			    <form class="omb_loginForm" action="/signup" autocomplete="off" method="POST">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user"></i></span>
						<input type="text" class="form-control" name="username" required placeholder="Username">
					</div>
					<span class="help-block"></span>

                     <div class="input-group">
						<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
						<input  type="email" class="form-control" name="email" required placeholder="Email">
					</div>			
                    <span class="help-block"></span>

					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-lock"></i></span>
						<input type="password" class="form-control" name="password" required placeholder="Password">
					</div>
                    <span class="help-block"></span>

					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-lock"></i></span>
						<input type="password" class="form-control" required placeholder="Password">
					</div>
                    <span class="help-block msg"></span>
                    
					<button id="btn-register" disabled class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
				</form>
			</div>
    	</div>   	
	</div>
    
    <script src="${url_base}js/jquery.js"></script>
    <script>
        var b = true;
        var q = $(".omb_row-sm-offset-3");
        var register = $(".register");
        $("#signup").click(function(){
            q.css("display","none");
            register.css("display","block");            
        });

        $("#login").click(function(){
            q.css("display","block");
            register.css("display","none");   
        });

        var passwordInputs = $(".register input[type='password']");
        passwordInputs.keyup(function(){
                if(passwordInputs[0].value == passwordInputs[1].value){
                    $(".register .msg").text("");
                    $("#btn-register").prop("disabled",false);
                }else{
                    $(".register .msg").text("Passwords Diferentes");
                    $("#btn-register").prop("disabled",true);
                }
        });
    </script>
</body>
</html>