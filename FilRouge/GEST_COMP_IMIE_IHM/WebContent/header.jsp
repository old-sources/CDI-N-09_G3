<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="fr">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Informations personnelles</title>
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<base href="http://localhost:8080/GEST_COMP_IMIE_IHM/">
<!--	
		<link rel="icon" type="image/png" href="favicon.png">
		<link rel="shortcut icon" type="image/x-icon" href="favicon.ico">		
		<link rel="apple-touch-icon" href="icon.png" />
-->
		<script type="text/javascript" src="./js/jquery.js"></script>
		<script type="text/javascript" src="./js/jquery-ui.min.js"></script>
		
		<script type="text/javascript" src="./js/script.js"></script>
		<script type="text/javascript" src="./js/noty.js"></script>
		<script src="./js/tree.jquery.js"></script>
		<script type="text/javascript" src="./js/tinymce.min.js"></script>
		<script>
			var idUser = 2;
			var idYear = 2;
		</script>

		
		<link type="text/css" rel="stylesheet" href="./css/style.css" />
		<link type="text/css" rel="stylesheet" href="./css/jquery-ui.min.css" />
		<link rel="stylesheet" href="./css/jqtree.css">
	</head>
	<body>
		<div id="dialog-confirm" style="display:none"></div>
	<header>
		<a href="dashboard"><div id="header_left_block" title="logo imie" class="floatLeft">
		</div></a>
		<div id="header_right_block" class="floatLeft">
			<p id="header_right_block1" class="blue"><a><img src="./img/logout.png" alt="deconnexion"  title="deconnexion" id="header_img_logout"></a> <a href="user.php" title="modifier son profil">Bouchard Gérard</a></p>
			<p id="header_right_block2"><a class="grey1" id="openNote"></a></p>
		</div>
		<div id="noteModal" title="">
			<ul>
			</ul>
		</div>
		<div class="stopFloat">
		</div>
	</header>