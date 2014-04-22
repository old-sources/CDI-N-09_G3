/********************************	GESTION PROJET	***************************************/

var tabProject = {
	tab : [],
	init : function(){
		//fonction qui va chercher tous les projets en agax (JSON) puis les affiche
		/*$.ajax({
			type: "GET",
			url: "projects/",
			dataType: "JSON",
			success: function(json)
			{
				this.tab = json;
				this.allocateProject();
				$('#inputDashboardProjectProjectIsMyProject').prop('checked', true);
				this.displayProject();
				
			},
			error: function(){
                noty({timeout: 3000,text: "Un problème est apparu, l'action n'a pas été sauvegardée",type: 'error'});
            } 
		});*/

		//à retirer quand le getJson fonctionnera
		this.tab = [{name:'projet1',id:1,projectManagerName:'Gérard Bouchard',statusName:'En cours',isMyProject:false},
					{name:'projet2',id:2,projectManagerName:'michel Bouchard',statusName:'Cloturé',isMyProject:false},
					{name:'projet3',id:3,projectManagerName:'jean-luc Bouchard',statusName:'Créé',isMyProject:false}];
		this.allocateProject();
		$('#inputDashboardProjectProjectIsMyProject').prop('checked', true);
		this.displayProject();
		$('.searchProjectSelect').change(function(){tabProject.displayProject();});
		$('.searchProjectText').keyup(function(){tabProject.displayProject();});
		$('.searchProjectcheckbox').click(function(){tabProject.displayProject();});

		$('#buttonCreateProject').click(function(){
			
			for(var i in tabUser.tab)
			{
				if(tabUser.tab[i].active)
				{
					$("#createProjectManager").append('<option value="'+tabUser.tab[i].id+'">'+tabUser.tab[i].firstName+' '+tabUser.tab[i].lastName+'</option>');
				}
			}			
			$("#divCreateProject").dialog({
                    autoOpen: true,
                    show: {effect: "blind", duration: 1000}, 
                    hide: {effect: "explode", duration: 1000},
                    modal: true,
                    height: 800,
                    width: 800,
                    buttons: {
								"Créer ce projet": function() {
									$( this ).dialog( "close" );
									$.ajax({
										type: "PUT",
										url: "project/",
										data: projectCreate,
										success: function()
										{
											noty({timeout: 3000,text: "Le projet a été créer",type: 'success'});
											location.href="";
										},
										error: function(){
							                noty({timeout: 3000,text: "Un problème est apparu, l'action n'a pas été sauvegardée",type: 'error'});
							            } 
									});
								},
								"Annuler": function() {
									$( this ).dialog( "close" );
								}
							},
					open: function() {
						tinymce.init({
						    selector: "#createProjectDescription",
						    width:600,
						    height:300
						 });
					},
					beforeClose: function() {
						var projectCreate = new project({description:$("#createProjectDescription").val(),name:$("#createProjectName").val(),projectManager:$("#createProjectManager").val()});
					}
            });
		});
		
	},
	allocateProject : function()
	{
		/*$.ajax({
			type: "GET",
			url: "project/user/"+idUser,
			dataType: "JSON",
			async : false,//pour l'afficher ensuite avec les bonnes valeurs
			success: function(json)
			{
				for(var i in this.tab)
				{
					for(var j in json)
					{
						if(this.tab[i].id == json[j])
						{
							this.tab[i].isMyProject = true;
						}
					}
				}
			},
			error: function(){
                noty({timeout: 3000,text: "Un problème est apparu, l'action n'a pas été sauvegardée",type: 'error'});
            } 
		});*/
		var json = [2];
		for(var i in this.tab)
		{
			for(var j in json)
			{
				if(this.tab[i].id == json[j])
				{
					this.tab[i].isMyProject = true;
				}
			}
		}
	},
	addProjet : function(e){
		this.tab.push(e);
	},
	updateProjet : function(ind,e){
		this.tab[ind] = e;
	},
	remove : function(e){
		var idProjectDelete = e;
		$( "#dialog-confirm" ).dialog({
			resizable: false,
			height:140,
			modal: true,
			buttons: {
				"Supprimer ce projet": function() {
					$( this ).dialog( "close" );
					var tabTempt = [];
					for (key in tabProject.tab) {
						if(tabProject.tab[key].id != idProjectDelete)
						{
							tabTempt.push(tabProject.tab[key]);
						}
					}
					tabProject.tab = tabTempt;
					tabProject.displayProject();
					$.ajax({
						type: "DELETE",
						url: "project/"+idProjectDelete,
						success: function()
						{
							noty({timeout: 3000,text: "Le projet a été supprimer",type: 'success'});
						},
						error: function(){
			                noty({timeout: 3000,text: "Un problème est apparu, l'action n'a pas été sauvegardée",type: 'error'});
			            } 
					});
				},
				"Annuler": function() {
					$( this ).dialog( "close" );
				}
			}
		});
	},
	getName : function(ind){return this.tab[ind].name;},
	displayProject : function(){
		//affichage des projets dans le tableau suivant les criteres de recherche

		$(".displayProjectTemp").remove();
		for (key in this.tab) {
			var bool = true;
			var s=this.tab[key].name.toLowerCase();
			if($('#inputDashboardProjectName').val() != '')
			{
				if(s.indexOf($('#inputDashboardProjectName').val().toLowerCase()) == -1)
				{
					bool = false;
				}	
			}
			var s=this.tab[key].projectManagerName.toLowerCase();
			if($('#inputDashboardProjectProjectManagerName').val() != '')
			{
				if(s.indexOf($('#inputDashboardProjectProjectManagerName').val().toLowerCase()) == -1)
				{
					bool = false;
				}	
			}
			var s=this.tab[key].statusName;
			if($('#selectDashboardProjectStatus').val() != '')
			{
				if(s.indexOf($('#selectDashboardProjectStatus').val()) == -1)
				{
					bool = false;
				}	
			}
			if($('#inputDashboardProjectProjectIsMyProject').is(':checked'))
			{
				if(this.tab[key].isMyProject == false)
				{
					bool = false;
				}	
			}
			if(bool)
			{
				$("#dashboardProject").append('<tr class="displayProjectTemp" id="displayProjectTemp'+this.tab[key].id+'">');
				$('#displayProjectTemp'+this.tab[key].id).append($('<td>').text(this.tab[key].name));
				$('#displayProjectTemp'+this.tab[key].id).append($('<td>').text(this.tab[key].projectManagerName));
				if(this.tab[key].isMyProject)
				{
					$('#displayProjectTemp'+this.tab[key].id).append($('<td style="text-align:center">').html('<img src="img/approve.png" width="15px" class="cursorPointer">'));	
				}
				else
				{
					$('#displayProjectTemp'+this.tab[key].id).append($('<td>').text(''));	
				}
				$('#displayProjectTemp'+this.tab[key].id).append($('<td>').text(this.tab[key].statusName));
				$('#displayProjectTemp'+this.tab[key].id).append($('<td class="tdAction">').html('<img src="img/zoom.png" style="width:20px" class="cursorPointer projectModal" title="Visualiser ce projet" data-ind="'+key+'"><img src="img/add.png" class="cursorPointer projectAddMe" title="Candidater à ce projet" data-id="'+this.tab[key].id+'" style="width:20px"><img src="img/update.png" style="width:20px" class="cursorPointer UpdateProject" data-id="'+this.tab[key].id+'" title="Gérer ce projet" ><img src="img/close.png" style="width:20px" class="cursorPointer deleteProject" data-id="'+this.tab[key].id+'" title="Supprimer ce projet" >'));

				$('.projectModal').click(function(){tabProject.projectModal($(this).attr('data-ind'));});
				$('.projectAddMe').click(function(){tabProject.projectAddMe($(this).attr('data-id'),$(this).attr('data-name'));});
				
				//$(".UpdateProject").click(function(){location.href='project/'+$(this).attr('data-id')});
				$(".UpdateProject").click(function(){location.href='project.php?id='+$(this).attr('data-id');});

				$(".deleteProject").click(function(){
					tabProject.remove($(this).attr('data-id'));
				});
			}
		}
	},
	projectModal : function(ind){
		$.ajax({
			type: "GET",
			url: 'project/modale/',
			success: function(msg)
			{	
				$('body').append('<div id="projectModalDisplay" style="display:none">'+msg+'</div>');
				$('#projectModalDisplay').dialog({
				    autoOpen: true,
				    show: {effect: "blind", duration: 1000 }, 
				    hide: {effect: "explode", duration: 1000 },
				    modal: true,
				    height: 400,
					width: 600
				});
				myProject = new project(tabProject.tab[ind]);
				$("#modalProjectName").text(myProject.name);
				$("#modalProjectStatus").text(myProject.status);
				$("#modalProjectProgress").text(myProject.progress);
				$("#modalProjectprojectManagerName").text(myProject.projectManagerName);
				$("#modalProjectDescription").text(myProject.description);
				$('#projectModalDisplay').on( "dialogclose", function() {
					$('#projectModalDisplay').remove();
				} );
			},
			error: function(){
	            noty({timeout: 3000,text: "Un problème est apparu, l'action n'a pas été sauvegardée",type: 'error'});
	        } 
		});
	},
	projectAddMe : function(id,name){
		msg = 'Souhaitez-vous vous inviter au projet '+name;
		$('body').append('<div id="projectAddMe" style="display:none">'+msg+'</div>');
		$( "#projectAddMe").dialog({
			show: {effect: "blind", duration: 1000 }, 
			hide: {effect: "explode", duration: 1000 },
			resizable: false,
			height:140,
			modal: true,
			buttons: {
				"Confirmer": function() {
					$.ajax({
					   type: "POST",
					   url: "project/candidate/"+id,
					   success: function(){
					      noty({timeout: 3000,text: "L'invitation a été envoyée",type: 'success'});
					   },
					   error: function(){
				            noty({timeout: 3000,text: "Un problème est apparu, l'action n'a pas été sauvegardée",type: 'error'});
				       },
					});
					$( this ).dialog( "close" );
				},
				"Refuser": function() {
					$( this ).dialog( "close" );
				}
			}
		});
	}
};





/********************************	GESTION UTILISATEUR	***************************************/
var tabUser = {
	tab:[],
	init : function(){
		$.ajax({
			type: "GET",
			url: "user/json/all",
			dataType: "JSON",
			success: function(json)
			{
				for(var i in json)
				{
					tabUser.tab.push(new user(json[i]));
				}

				$('#selectDashboardUserYearName').val("CDI09");
				$('#inputDashboardUserActive').prop('checked', true);
				
				$('.searchUserText').keyup(function(){tabUser.displayUser();});
				$('.searchUserSelect').change(function(){tabUser.displayUser();});
				$('#inputDashboardUserActive').click(function(){tabUser.displayUser();});
				tabUser.displayUser();
			},
			error: function(){
	            noty({timeout: 3000,text: "Un problème est apparu, l'action n'a pas été sauvegardée",type: 'error'});
	        } 
		});
	},
	addUser:function(e){
		this.tab.push(e);
	},
	remove : function(e){
		var idUserDelete = e;
		$( "#dialog-confirm" ).dialog({
			resizable: false,
			height:140,
			modal: true,
			buttons: {
				"Supprimer cet utilisateur": function() {
					$( this ).dialog( "close" );
					var tabTempt = [];
					for (key in tabUser.tab) {
						if(tabUser.tab[key].id != idUserDelete)
						{
							tabTempt.push(tabUser.tab[key]);
						}
					}
					tabUser.tab = tabTempt;
					tabUser.displayUser();
					$.ajax({
						type: "DELETE",
						url: "user/"+idUserDelete,
						success: function()
						{
							noty({timeout: 3000,text: "L'utilisateur a été supprimer",type: 'success'});
						},
						error: function(){
			                noty({timeout: 3000,text: "Un problème est apparu, l'action n'a pas été sauvegardée",type: 'error'});
			            } 
					});
				},
				"Annuler": function() {
					$( this ).dialog( "close" );
				}
			}
		});
	},
	displayUser : function(){
		$(".displayUserTemp").remove();
		for (key in tabUser.tab) {
			var bool = true;
			var s=tabUser.tab[key].firstName.toLowerCase();
			if($('#inputDashboardUserFirstName').val() != '')
			{
				if(s.indexOf($('#inputDashboardUserFirstName').val().toLowerCase()) == -1)
				{
					bool = false;
				}	
			}
			var s=tabUser.tab[key].lastName.toLowerCase();
			if($('#inputDashboardUserLastName').val() != '')
			{
				if(s.indexOf($('#inputDashboardUserLastName').val().toLowerCase()) == -1)
				{
					bool = false;
				}	
			}
			var s=tabUser.tab[key].yearName;
			if($('#selectDashboardUserYearName').val() != '')
			{
				if(s.indexOf($('#selectDashboardUserYearName').val()) == -1)
				{
					bool = false;
				}	
			}
			if($('#inputDashboardUserActive').is(':checked'))
			{
				if(tabUser.tab[key].availability == false)
				{
					bool = false;
				}	
			}
			if(bool)
			{
				$("#dashboardUser").append('<tr class="displayUserTemp" id="displayUserTemp'+tabUser.tab[key].id+'">');
				$('#displayUserTemp'+tabUser.tab[key].id).append($('<td>').text(tabUser.tab[key].firstName));
				$('#displayUserTemp'+tabUser.tab[key].id).append($('<td>').text(tabUser.tab[key].lastName));
				$('#displayUserTemp'+tabUser.tab[key].id).append($('<td>').text(tabUser.tab[key].yearName));
				if(tabUser.tab[key].availability)
				{
					$('#displayUserTemp'+tabUser.tab[key].id).append($('<td style="text-align:center">').html('<img src="img/approve.png" width="15px" class="">'));	
				}
				else
				{
					$('#displayUserTemp'+tabUser.tab[key].id).append($('<td>').text(''));	
				}
				$('#displayUserTemp'+tabUser.tab[key].id).append($('<td style="text-align:center" class="tdAction">').html('<img src="img/zoom.png" class="cursorPointer userModalDisplay" style="width:20px" title="Visualiser cet utilisateur" data-ind="'+key+'"><img src="img/update.png" style="width:20px" class="cursorPointer UpdateUser" data-id="'+this.tab[key].id+'" title="" ><img src="img/close.png" style="width:20px" class="cursorPointer deleteUser" data-id="'+this.tab[key].id+'" title="Supprimer cet utilisateur" >'));
				
				$('.userModalDisplay').click(function(){tabUser.userModalDisplay($(this).attr('data-ind'));});
				$('.UpdateUser').click(function(){location.href='./user/'+$(this).attr('data-id');});
				$(".deleteUser").click(function(){
					tabUser.remove($(this).attr('data-id'));
				});
			}
		}
	},
	userModalDisplay : function(ind)
	{
		
		$.ajax({
			type: "GET",
			url: "user/modale/",
			success: function(msg)
			{
				$('body').append('<div id="userModalDisplay" style="display:none">'+msg+'</div>')
				$("#userModalDisplay").dialog({
				    autoOpen: true,
				    show: {effect: "blind", duration: 1000 }, 
				    hide: {effect: "explode", duration: 1000 },
				    modal: true,
				    height: 400,
					width: 600
				});
				$('#userModalDisplay').on( "dialogclose", function() {
					$("#userModalDisplay").remove();
				} );

				//mettre les infos depuis tabUser.tab[ind].
			}
		});
	}
};
