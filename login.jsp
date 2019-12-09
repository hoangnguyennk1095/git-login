<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png"
	href="../static/images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../static/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../static/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../static/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../static/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../static/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../static/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../static/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../static/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="../static/css/util.css">
<link rel="stylesheet" type="text/css" href="../static/css/main.css">
<!--===============================================================================================-->
<style>
span.psw {
	float: right;
}

span.canbtn {
	float: left;
}
</style>

</head>
<body>


	<div class="container-contact100">
		<div class="wrap-contact100">
			<form class="contact100-form validate-form" action="login"
				method="POST">

				<span style="font-size: 60px" style="font-family: Helvetica, Arial"
					style="text-align: center">Đăng Nhập</span> <br>
				<div class="wrap-input100 validate-input"
					data-validate="Name is required">
					<label class="label-input100" for="name">Tài khoản</label> <input
						id="name" class="input100" type="text" name="userName"
						placeholder="Enter your name..."> <span
						class="focus-input100"></span>
				</div>


				<div class="wrap-input100 validate-input"
					data-validate="Password is required">
					<label class="label-input100" for="email">Mật khẩu</label> <input
						id="email" class="input100" type="password" name="password"
						placeholder="Enter your password..."> <span
						class="focus-input100"></span>
				</div>


				<div class="container-contact100-form-btn">
					<button class="contact100-form-btn">Đăng Nhập</button>
				</div>
				<br> <span class="canbtn"><a href="../account/create">
						Đăng Ký </a></span> <span class="psw">Quên <a href="#">mật khẩu?</a></span>
				<br>
				<div class="contact100-form-social flex-c-m">
					<a href="#" class="contact100-form-social-item flex-c-m bg1 m-r-5">
						<i class="fa fa-facebook-f" aria-hidden="true"></i>
					</a> <a href="#" class="contact100-form-social-item flex-c-m bg2 m-r-5">
						<i class="fa fa-twitter" aria-hidden="true"></i>
					</a> <a href="#" class="contact100-form-social-item flex-c-m bg3">
						<i class="fa fa-youtube-play" aria-hidden="true"></i>
					</a>
				</div>
			</form>

			<div class="contact100-more flex-col-c-m"
				style="background-image: url('../static/images/bg-01.jpg');">


			</div>
		</div>
	</div>





	<!--===============================================================================================-->
	<script src="../static/vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="../static/vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="../static/vendor/bootstrap/js/popper.js"></script>
	<script src="../static/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="../static/vendor/select2/select2.min.js"></script>
	<script>
		$(".js-select2").each(function() {
			$(this).select2({
				minimumResultsForSearch : 20,
				dropdownParent : $(this).next('.dropDownSelect2')
			});
		})
		$(".js-select2").each(function() {
			$(this).on('select2:open', function(e) {
				$(this).parent().next().addClass('eff-focus-selection');
			});
		});
		$(".js-select2").each(function() {
			$(this).on('select2:close', function(e) {
				$(this).parent().next().removeClass('eff-focus-selection');
			});
		});
	</script>
	<!--===============================================================================================-->
	<script src="../static/vendor/daterangepicker/moment.min.js"></script>
	<script src="../static/vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="../static/vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="../static/js/main.js"></script>
	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async
		src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
	<script>
		window.dataLayer = window.dataLayer || [];
		function gtag() {
			dataLayer.push(arguments);
		}
		gtag('js', new Date());

		gtag('config', 'UA-23581568-13');
	</script>
</body>
</html>
