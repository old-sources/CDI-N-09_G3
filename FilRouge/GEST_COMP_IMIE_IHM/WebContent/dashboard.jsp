<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
	<section id="content">
		<section id="arianne">
			<img src="img/flag.png" class="arianne_flag"> <a>Accueil</a>
		</section>
		<div id="title">
			<h1>Tableau de bord</h1>
		</div>
		<div class="sectionContent">
			<h2>Projets</h2>
			<table id="dashboardProject">
				<tr id="dashboardProjectFirstTR"> 
					<th> Nom du projet <br><input type="text" class="searchProjectText" id="inputDashboardProjectName" style="width:80px;height:14px;">
					</th>
					<th> Chef de projet <br>
						<input type="text" class="searchProjectText" value="" id="inputDashboardProjectProjectManagerName" style="width:80px;height:14px;">
					</th>
					<th> Mes projets <br>
						<input type="checkbox" class="searchProjectcheckbox" value="" id="inputDashboardProjectProjectIsMyProject">
					</th>
					<th> Statut <br><select id="selectDashboardProjectStatus" class="searchProjectSelect" style="width:80px;">	
						<option value="">Tous</option>
						<option value="En cours">En cours</option>
						<option value="Cloturé">Cloturé</option>
						<option value="Créé">Créé</option>
						</select>
					</th>
					<th> Actions </th> 
				</tr>
			</table>
			<input type="button" value="créer un nouveau projet" id="buttonCreateProject">
			<div id="divCreateProject" title="Création d'un projet" style="display:none">
				<div class="formTitle">Nom du projet :</div>
				<div class="formValue" id="">
					<input type="text" id="createProjectName">
				</div>
				<div class="stopFloat"> </div>

				<div class="formTitle">Description :</div>
				<div class="formValue">
					<textarea id="createProjectDescription"></textarea>
				</div>
				<div class="stopFloat"> </div>

				<div class="formTitle">Chef de projet :</div>
				<div class="formValue" id="">
					<select id="createProjectManager">

					</select>
				</div>
				<div class="stopFloat"> </div>
				</div>
			</div>
		<div class="sectionContent">
			<h2>Utilisateurs</h2>
			<section id="contentRight">
				<table id="dashboardUser">
					<tr>
						<th>Nom<br><input type="text" class="searchUserText" id="inputDashboardUserFirstName" style="width:100px;height:14px;"></th>
						<th>Prénom<br><input type="text" class="searchUserText" id="inputDashboardUserLastName" style="width:100px;height:14px;"></th>
						
						<th> Promotion <br><select id="selectDashboardUserYearName" class="searchUserSelect" style="width:130px;">
							<option value="">Tous les utilisateurs</option>
							<option value="CDI03">CDI03</option>
							<option value="CDI02">CDI02</option>
							<option value="DL03">DL03</option>
							<option value="CDPN04">CDPN04</option>
							<option value="CDI04">CDI04</option>
							<option value="DL02">DL02</option>
							</select>
						</th>
						<th> Actif <br>
						<input type="checkbox" class="searchUsercheckbox" value="" id="inputDashboardUserActive">
					</th>
						<th>Actions</th> 
					</tr>
				</table>		
			</section>
		</div>
		<div class="stopFloat">
		</div>
	</section>
	<script type="text/javascript" src="./js/dashboardProject.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			tabProject.init();
			tabUser.init();
		});
	</script>
<%@ include file="footer.jsp"%>