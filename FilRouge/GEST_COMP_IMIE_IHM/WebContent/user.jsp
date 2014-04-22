<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
	<div id="updateSkillTreeUserModal" title="Affectation de compétences">
		rechercher une compétence <input type="text" id="searchSkillTree">
		<div id="updateSkillTreeUser">
		</div>

	</div>
	<div id="proposeSkillUser" title="Proposer une nouvelle compétences">
		Proposer une nouvelle compétence à : <br /><span id="nameSkillParent"></span><br/><input type="text" id="inputProposeSkill"><br /><br /><input type="button" value="Envoyer" id="buttonProposeSkill">
	</div>
	<section id="content">
		<section id="arianne">
			<img src="./img/flag.png" class="arianne_flag"> <a href="dashboard.php">Accueil</a> <img src="img/right.png" class="arianne_arrow"> <a>Informations personnelles</a>
		</section>
		<div id="title">
			<h1>Modification de vos informations personnelles</h1>
		</div>
		<div class="sectionContent">
			<h2>Votre compte</h2>
			<section id="contentLeft">
				<div id="divUpdateSkillUser" style="margin-left:400px;position:absolute">
					<img src="img/update.png" id="openformUpdateUser" class="imgButton" style="width:30px" title="Modifier votre profil" alt="Modifier votre profil">
				</div>
				<div class="formTitle">Nom :</div>
				<div class="formValue" id="userFirstName"></div><div class="stopFloat"> </div>

				<div class="formTitle">Prénom :</div>
				<div class="formValue" id="userLastName"></div><div class="stopFloat"> </div>

				<div class="formTitle">Adresse e-mail :</div>
				<div class="formValue" id="userMail"></div><div class="stopFloat"> </div>

				<div class="formTitle">Promotion :</div>
				<div class="formValue" id="userYearName">
				</div><div class="stopFloat"> </div>

				<div class="formTitle">Disponibilié :</div>
				<div class="formValue" id="userAvailability">
				</div><div class="stopFloat"></div>
			</section>
		</div>
		<div class="sectionContent">
			<h2>Vos compétences</h2>
			<section id="contentRight">
				<div id="divUpdateSkillUser" style="margin-left:400px;position:absolute">
					<img src="img/update.png" id="openUpdateSkillTreeUser" class="imgButton" style="width:30px" title="Modifier vos compétences" alt="Modifier vos compétences">
				</div>
				<ul class="ulMarginLeft" id="DisplayUserSkill">
				</ul>
			</section>
		</div>
		<div class="stopFloat">
		</div>
	</section>
<script type="text/javascript" src="./js/user.js"></script>
<script type="text/javascript">
	thisUser.init();
</script>


<%@ include file="footer.jsp"%>