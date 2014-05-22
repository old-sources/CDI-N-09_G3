function project(arg)
{
    this.members = [];
    var options = arg||{};
    this.id = options.id;
    this.name = options.name;
    this.projectManager = options.projectManager;
    this.projectManagerName = options.projectManagerName;
    this.status = options.status;
    this.statusName = options.statusName;
    this.description = options.description;
    this.isMyProject = options.isMyProject;
    this.progress = options.progress;
    this.wikiManager = options.wikiManager;
    this.wikiMember = options.wikiMember;
    this.members = options.members;
    this.active = options.active;
    
}


function user(arg)
{
    var options = arg||{};
    this.id = options.userId;
    this.firstName = options.firstName;
    this.lastName = options.lastName;
    this.availability = options.availability;
    this.availabilityName = options.availabilityName;
    this.adress = options.adress;
    this.postCode = options.postCode;
    this.town = options.town;
    this.mail = options.mail;
    this.phoneNumber = options.phoneNumber;
    this.year = options.year.yearId;
    this.yearName = options.year.yearName;
    this.skills = options.skills;
    this.notifications = options.notifications;
}



//affichage des notifications
$(document).ready(function(){
	

	 $.ajax({
        type: "GET",
        url: "notification/"+idUser,
        dataType: "JSON",
        success: function(JSON){
            for(var i in JSON)
            {
                $("#noteModal ul").append("<li>"+JSON[i].html+"</li>");   
            }
            i++;
            $('#noteModal').attr('title',i +' notifications');
            $('#openNote').text(i +' notifications');
        },
        error: function(msg){
            noty({timeout: 3000,text: "Un problème est apparu, l'action n'a pas été sauvegardée",type: 'error'});
        }   
    });
   /*jsonNotification = [{
        html : '<li> <em>Le 7/04/2014<em> <b>Gérard Bouchard</b> souhaite vous inviter à son projet "Dessiner un chaton en JEE sans ORM"<div class="center"><input type="button" value="Accepter"> <input type="button" value="Refuser"></div> </li>',
        projet : 1,
        skill : 3,
        status : 'candidature'},
        {html : '<li> <em>Le 8/04/2014<em> <b>Projet Skills</b> Votre candidature est en cours.</li>',
        projet : 1,
        skill : 3,
        status : 'invitation'},
        {html : '<li> <em>Le 9/04/2014<em> <b>ORM hibernate</b> Cette compétence a été refusée par l\'administrateur <div class="center"><input type="button" value="Supprimer la notification"></div> </li>',
        projet : 1,
        skill : 3,
        status : 'competence'}
        ];
    for(var i in jsonNotification)
    {
        $("#noteModal ul").append(jsonNotification[i].html);    
    }
    i++;
    $('#noteModal').attr('title',i +' notifications');
    $('#openNote').text(i +' notifications');*/
    

	$("#noteModal").dialog({
		autoOpen: false,
		show: {
		effect: "blind", duration: 1000 }, 
		hide: {effect: "explode", duration: 1000 }, 
		modal: true,
		buttons: {Ok: function() {$( this ).dialog( "close" ); } }, 
		height: 400,
		width: 600
	});
	$( "#openNote" ).click(function() {
      $( "#noteModal" ).dialog( "open" );
    });
});