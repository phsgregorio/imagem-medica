<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>IMédica - Login</title>
	    <!-- Core CSS - Include with every page -->
	    <link href="css/bootstrap.min.css" rel="stylesheet">
	    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">
	    <!-- SB Admin CSS - Include with every page -->
	    <link href="css/sb-admin.css" rel="stylesheet">
	</head>
	<body>
	    <div class="container">
	        <div class="row">
	            <div class="col-md-4 col-md-offset-4">
	                <div class="login-panel panel panel-default">
	                    <div class="panel-heading">
	                        <h3 class="panel-title">IMédica - Login</h3>
	                    </div>
	                    <div class="panel-body">
	                    	<form id="frm-login" name="frm-login" action="Login.do" method="POST" class="crud-frm">
	                            <fieldset>
	                                <div class="form-group">
	                                    <input class="form-control" placeholder="E-mail" name="str_email" type="email" autofocus>
	                                </div>
	                                <div class="form-group">
	                                    <input class="form-control" placeholder="Senha" name="str_senha" type="password" value="">
	                                </div>
	                                <button type="submit" class="btn btn-lg btn-success btn-block">Login</button>
	                            </fieldset>
                            </form>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	    <!-- Core Scripts - Include with every page -->
	    <script src="js/jquery-1.10.2.js"></script>
	    <script src="js/bootstrap.min.js"></script>
	    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
	    <!-- SB Admin Scripts - Include with every page -->
	    <script src="js/sb-admin.js"></script>
	</body>
</html>
